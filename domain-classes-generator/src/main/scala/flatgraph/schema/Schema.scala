package flatgraph.schema

import flatgraph.schema.Helpers._
import flatgraph.schema.Property.Default

import scala.collection.mutable

/** @param basePackage:
  *   specific for your domain, e.g. `com.example.mydomain`
  * @param additionalTraversalsPackages:
  *   additional packages that contain your traversals - used for `.help` to find @Doc annotations via reflection
  */
class Schema(
  val domainShortName: String,
  val basePackage: String,
  val additionalTraversalsPackages: Seq[String],
  val properties: Seq[Property[?]],
  val anyNode: AnyNodeType,
  val nodeBaseTypes: Seq[NodeBaseType],
  val nodeTypes: Seq[NodeType],
  val edgeTypes: Seq[EdgeType],
  val constantsByCategory: Map[String, Seq[Constant[?]]],
  val protoOptions: Option[ProtoOptions],
  val noWarnList: Set[(AbstractNodeType, Property[?])]
) {

  /** nodeTypes and nodeBaseTypes combined */
  lazy val allNodeTypes: Seq[AbstractNodeType] =
    nodeTypes ++ nodeBaseTypes

  /** properties that are used in node types */
  def nodeProperties: Seq[Property[?]] =
    properties.filter(property => (nodeTypes ++ nodeBaseTypes).exists(_.properties.contains(property)))

  /** properties that are used in edge types */
  def edgeProperties: Seq[Property[?]] =
    properties.filter(property => edgeTypes.exists(_.property == Option(property)))
}

abstract class AbstractNodeType(val name: String, val comment: Option[String], val schemaInfo: SchemaInfo)
    extends HasClassName
    with HasSchemaInfo {
  protected val _extendz: mutable.Set[NodeBaseType]     = mutable.Set.empty
  protected val _outEdges: mutable.Set[AdjacentNode]    = mutable.Set.empty
  protected val _inEdges: mutable.Set[AdjacentNode]     = mutable.Set.empty
  protected val _markerTraits: mutable.Set[MarkerTrait] = mutable.Set.empty
  protected val _properties: mutable.Set[Property[?]]   = mutable.Set.empty

  /** all node types that extend this node */
  def subtypes(allNodes: Set[AbstractNodeType]): Set[AbstractNodeType]

  private var _starterName: Option[String] = Some(camelCase(name))

  /** the name for the generated node starter. Custom names can be assigned to prevent compile errors for e.g. `type`. Generation of
    * node-starter can be suppressed by passing null, or by calling `withoutStarter()`.
    */
  def starterName: Option[String]          = _starterName
  def starterName(name: String): this.type = { this._starterName = Option(name); this }
  def withoutStarter(): this.type          = starterName(null)

  def addProperty(additional: Property[?]): this.type = {
    _properties.add(additional)
    this
  }

  def addProperties(additional: Property[?]*): this.type = {
    additional.foreach(addProperty)
    this
  }

  /** properties (including potentially inherited properties) */
  def properties: Seq[Property[?]] = {
    val entireClassHierarchy = this +: extendzRecursively
    entireClassHierarchy.flatMap(_.propertiesWithoutInheritance).distinct.sortBy(_.name.toLowerCase)
  }

  def propertiesWithoutInheritance: Seq[Property[?]] =
    _properties.toSeq.sortBy(_.name.toLowerCase)

  def extendz(additional: NodeBaseType*): this.type = {
    additional.foreach(_extendz.add)
    this
  }

  def extendz: Seq[NodeBaseType] =
    _extendz.toSeq.sortBy(_.name)

  def extendzRecursively: Seq[NodeBaseType] = {
    val results       = Seq.newBuilder[NodeBaseType]
    val extendsLevel1 = extendz
    results ++= extendsLevel1
    results ++= extendsLevel1.flatMap(_.extendzRecursively)
    results.result().distinct
  }

  /** note: allowing to define one outEdge for ONE inNode only - if you are looking for Union Types, please use NodeBaseTypes
    */
  def addOutEdge(
    edge: EdgeType,
    inNode: AbstractNodeType,
    cardinalityOut: EdgeType.Cardinality = EdgeType.Cardinality.List,
    cardinalityIn: EdgeType.Cardinality = EdgeType.Cardinality.List,
    stepNameOut: String = "",
    stepNameOutDoc: String = "",
    stepNameIn: String = "",
    stepNameInDoc: String = ""
  ): this.type = {
    _outEdges.add(AdjacentNode(edge, inNode, cardinalityOut, stringToOption(stepNameOut), stringToOption(stepNameOutDoc)))
    inNode._inEdges.add(AdjacentNode(edge, this, cardinalityIn, stringToOption(stepNameIn), stringToOption(stepNameInDoc)))
    this
  }

  def addInEdge(
    edge: EdgeType,
    outNode: AbstractNodeType,
    cardinalityIn: EdgeType.Cardinality = EdgeType.Cardinality.List,
    cardinalityOut: EdgeType.Cardinality = EdgeType.Cardinality.List,
    stepNameIn: String = "",
    stepNameInDoc: String = "",
    stepNameOut: String = "",
    stepNameOutDoc: String = ""
  ): this.type = {
    _inEdges.add(AdjacentNode(edge, outNode, cardinalityIn, stringToOption(stepNameIn), stringToOption(stepNameInDoc)))
    outNode._outEdges.add(AdjacentNode(edge, this, cardinalityOut, stringToOption(stepNameOut), stringToOption(stepNameOutDoc)))
    this
  }

  def outEdges: Seq[AdjacentNode] =
    _outEdges.toSeq

  def inEdges: Seq[AdjacentNode] =
    _inEdges.toSeq

  def edges(direction: Direction.Value): Seq[AdjacentNode] =
    direction match {
      case Direction.IN  => inEdges
      case Direction.OUT => outEdges
    }

  def edges: Seq[AdjacentNode] =
    outEdges ++ inEdges

  def addMarkerTrait(name: String): this.type = {
    _markerTraits.add(MarkerTrait(name))
    this
  }

  def markerTraits: Seq[MarkerTrait] =
    _markerTraits.toSeq
}

class NodeType(name: String, comment: Option[String], schemaInfo: SchemaInfo)
    extends AbstractNodeType(name, comment, schemaInfo)
    with HasOptionalProtoId {
  protected val _containedNodes: mutable.Set[ContainedNode] = mutable.Set.empty

  private var _primaryKey: Option[Property[?]] = None

  def primaryKey(p: Property[?]): this.type = {
    this._primaryKey = Option(p)
    this
  }

  def primaryKey: Option[Property[?]] = this._primaryKey

  lazy val classNameDb = s"${className}Db"

  /** all node types that extend this node */
  override def subtypes(allNodes: Set[AbstractNodeType]) = Set.empty

  def containedNodes: Seq[ContainedNode] =
    _containedNodes.toSeq.sortBy(_.localName.toLowerCase)

  def addContainedNode(node: AbstractNodeType, localName: String, cardinality: Property.Cardinality, comment: String = ""): NodeType = {
    _containedNodes.add(ContainedNode(node, localName, cardinality, stringToOption(comment)))
    this
  }

  override def toString = s"NodeType($name)"
}

/** root node trait for all nodes - use if you want to be explicitly unspecific */
class AnyNodeType
    extends NodeBaseType(
      name = "AnyNode",
      comment = Some("generic node base trait - use if you want to be explicitly unspecific"),
      SchemaInfo.Unknown
    ) {
  override val className = DefaultNodeTypes.StoredNodeClassname

  /** all node types extend this node */
  override def subtypes(allNodes: Set[AbstractNodeType]): Set[AbstractNodeType] =
    allNodes

  override def toString: String = name
}

class NodeBaseType(name: String, comment: Option[String], schemaInfo: SchemaInfo) extends AbstractNodeType(name, comment, schemaInfo) {

  /** all node types that extend this node */
  override def subtypes(allNodes: Set[AbstractNodeType]) =
    allNodes.filter { candidate =>
      candidate.extendzRecursively.contains(this)
    }

  override def toString = s"NodeBaseType($name)"
}

case class AdjacentNode(
  viaEdge: EdgeType,
  neighbor: AbstractNodeType,
  cardinality: EdgeType.Cardinality,
  customStepName: Option[String] = None,
  customStepDoc: Option[String] = None
)

case class ContainedNode(nodeType: AbstractNodeType, localName: String, cardinality: Property.Cardinality, comment: Option[String]) {
  lazy val classNameForStoredNode = nodeType.className
}

/** An empty trait without any implementation, e.g. to mark a semantic relationship between certain types */
case class MarkerTrait(name: String)

class EdgeType(val name: String, val comment: Option[String], val schemaInfo: SchemaInfo)
    extends HasClassName
    with HasOptionalProtoId
    with HasSchemaInfo {
  protected var _property: Option[Property[?]] = None

  override def toString = s"EdgeType($name)"

  def property: Option[Property[?]] = _property

  def withProperty(property: Property[?]): this.type = {
    _property = Option(property)
    this
  }

  @deprecated("use `withProperty` instead, edges can only have one property max", since = "0.0.49")
  def addProperty(property: Property[?]): this.type =
    withProperty(property)
}

object EdgeType {
  sealed abstract class Cardinality
  object Cardinality {
    case object One       extends Cardinality
    case object ZeroOrOne extends Cardinality
    case object List      extends Cardinality
  }
}

class Property[A](val name: String, val valueType: Property.ValueType[A], val comment: Option[String] = None, val schemaInfo: SchemaInfo)
    extends HasClassName
    with HasOptionalProtoId
    with HasSchemaInfo {
  import Property.Cardinality
  protected var _cardinality: Cardinality = Cardinality.ZeroOrOne
  def cardinality: Cardinality            = _cardinality

  /** make this a mandatory property, which allows us to use primitives (better memory footprint, no GC, ...) */
  def mandatory(default: A): Property[A] = {
    _cardinality = Cardinality.One(Property.Default(default))
    this
  }

  def isMandatory: Boolean =
    cardinality.isInstanceOf[Cardinality.One[?]]

  def hasDefault: Boolean =
    default.isDefined

  def default: Option[Default[A]] =
    _cardinality match {
      case c: Cardinality.One[_] =>
        // casting is safe here because only `mandatory(A)` can set the value
        Option(c.default).map(_.asInstanceOf[Default[A]])
      case _ =>
        None
    }

  /** make this a list property, using a regular Sequence, with linear (slow) random access */
  def asList(): Property[A] = {
    _cardinality = Cardinality.List
    this
  }
}

object Property {

  sealed trait ValueType[A]
  object ValueType {
    object Boolean extends ValueType[Boolean]
    object String  extends ValueType[String]
    object Byte    extends ValueType[Byte]
    object Short   extends ValueType[Short]
    object Int     extends ValueType[Int]
    object Long    extends ValueType[Long]
    object Float   extends ValueType[Float]
    object Double  extends ValueType[Double]
    object List    extends ValueType[Seq[?]]
    object Char    extends ValueType[Char]
    object NodeRef extends ValueType[Any]
    object Unknown extends ValueType[Any]
  }

  sealed trait Cardinality
  object Cardinality {
    case object ZeroOrOne                  extends Cardinality
    case object List                       extends Cardinality
    case class One[A](default: Default[A]) extends Cardinality
  }

  case class Default[A](value: A)
}

class Constant[A](
  val name: String,
  val value: String,
  val valueType: Property.ValueType[A],
  val comment: Option[String],
  val schemaInfo: SchemaInfo
) extends HasOptionalProtoId
    with HasSchemaInfo {
  override def toString = s"Constant($name)"
}

object Constant {
  def apply[A](name: String, value: String, valueType: Property.ValueType[A], comment: String = "")(implicit
    schemaInfo: SchemaInfo = SchemaInfo.Unknown
  ): Constant[A] =
    new Constant[A](name, value, valueType, stringToOption(comment), schemaInfo)
}

case class NeighborInfoForEdge(edge: EdgeType, nodeInfos: Seq[NeighborInfoForNode], offsetPosition: Int)

case class NeighborInfoForNode(
  neighborNode: AbstractNodeType,
  edge: EdgeType,
  direction: Direction.Value,
  cardinality: EdgeType.Cardinality,
  isInherited: Boolean,
  customStepName: Option[String] = None,
  customStepDoc: Option[String] = None
) {

  /** handling some accidental complexity within the schema: if a relationship is defined on a base node and separately on a concrete node,
    * with different cardinalities, we need to use the highest cardinality
    */
  lazy val consolidatedCardinality: EdgeType.Cardinality = {
    val inheritedCardinalities = neighborNode.extendzRecursively.flatMap(_.inEdges).collect {
      case AdjacentNode(viaEdge, neighbor, cardinality, _, _) if viaEdge == edge && neighbor == neighborNode => cardinality
    }
    val allCardinalities = cardinality +: inheritedCardinalities
    allCardinalities.distinct.sortBy {
      case EdgeType.Cardinality.List      => 0
      case EdgeType.Cardinality.ZeroOrOne => 1
      case EdgeType.Cardinality.One       => 2
    }.head
  }

}

object Direction extends Enumeration {
  val IN, OUT = Value
  val all     = List(IN, OUT)
}

case class ProductElement(name: String, accessorSrc: String, index: Int)

case class ProtoOptions(
  pkg: String,
  javaOuterClassname: String,
  javaPackage: String,
  goPackage: String,
  csharpNamespace: String,
  uncommonProtoEnumNameMappings: Map[String, String] = Map.empty
)

trait HasClassName {
  def name: String
  def className = camelCaseCaps(name)
}

trait HasOptionalProtoId {
  protected var _protoId: Option[Int] = None

  def protoId(id: Int): this.type = {
    _protoId = Some(id)
    this
  }

  def protoId: Option[Int] = _protoId
}

trait HasSchemaInfo {
  def schemaInfo: SchemaInfo
}

/** carry extra information on where a schema element is being defined, e.g. when we want to be able to refer back that `node XYZ` was
  * defined in `BaseSchema`, e.g. for documentation
  */
case class SchemaInfo(definedIn: Option[Class[?]])
object SchemaInfo {
  val Unknown = SchemaInfo(None)

  def forClass(schemaClass: Class[?]): SchemaInfo =
    SchemaInfo(Option(schemaClass))
}
