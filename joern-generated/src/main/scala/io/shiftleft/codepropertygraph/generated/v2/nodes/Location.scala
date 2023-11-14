package io.shiftleft.codepropertygraph.generated.v2.nodes

import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait LocationEMT
    extends AnyRef
    with HasClassNameEMT
    with HasClassShortNameEMT
    with HasFilenameEMT
    with HasLineNumberEMT
    with HasMethodFullNameEMT
    with HasMethodShortNameEMT
    with HasNodeLabelEMT
    with HasPackageNameEMT
    with HasSymbolEMT

trait LocationBase extends AbstractNode with StaticType[LocationEMT] {
  def node: Option[AbstractNode]
  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("CLASS_NAME", this.className)
    res.put("CLASS_SHORT_NAME", this.classShortName)
    res.put("FILENAME", this.filename)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("METHOD_FULL_NAME", this.methodFullName)
    res.put("METHOD_SHORT_NAME", this.methodShortName)
    res.put("NODE_LABEL", this.nodeLabel)
    res.put("PACKAGE_NAME", this.packageName)
    res.put("SYMBOL", this.symbol)
    this.node.foreach { p => res.put("node", p) }
    res
  }
}

object Location {
  val Label = "LOCATION"
  object PropertyKinds {
    val ClassName       = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.CLASS_NAME
    val ClassShortName  = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.CLASS_SHORT_NAME
    val Filename        = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.FILENAME
    val LineNumber      = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.LINE_NUMBER
    val MethodFullName  = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.METHOD_FULL_NAME
    val MethodShortName = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.METHOD_SHORT_NAME
    val NodeLabel       = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.NODE_LABEL
    val PackageName     = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.PACKAGE_NAME
    val Symbol          = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.SYMBOL
  }
  object PropertyDefaults {
    val ClassName       = "<empty>"
    val ClassShortName  = "<empty>"
    val Filename        = "<empty>"
    val MethodFullName  = "<empty>"
    val MethodShortName = "<empty>"
    val NodeLabel       = "<empty>"
    val PackageName     = "<empty>"
    val Symbol          = "<empty>"
  }
}

class Location(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 23.toShort, seq_4762)
    with LocationBase
    with StaticType[LocationEMT] {
  def node: Option[StoredNode] = odb2.Accessors.getNodePropertyOption[StoredNode](graph, nodeKind, 53, seq)

  override def productElementName(n: Int): String =
    n match {
      case 0 => "className"
      case 1 => "classShortName"
      case 2 => "filename"
      case 3 => "lineNumber"
      case 4 => "methodFullName"
      case 5 => "methodShortName"
      case 6 => "nodeLabel"
      case 7 => "packageName"
      case 8 => "symbol"
      case 9 => "node"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.className
      case 1 => this.classShortName
      case 2 => this.filename
      case 3 => this.lineNumber
      case 4 => this.methodFullName
      case 5 => this.methodShortName
      case 6 => this.nodeLabel
      case 7 => this.packageName
      case 8 => this.symbol
      case 9 => this.node
      case _ => null
    }

  override def productPrefix = "Location"
  override def productArity  = 10

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Location]
}

object NewLocation { def apply(): NewLocation = new NewLocation }
class NewLocation extends NewNode(23.toShort) with LocationBase {
  type RelatedStored = Location
  override def label: String                       = "LOCATION"
  var className: String                            = "<empty>": String
  var classShortName: String                       = "<empty>": String
  var filename: String                             = "<empty>": String
  var lineNumber: Option[Int]                      = None
  var methodFullName: String                       = "<empty>": String
  var methodShortName: String                      = "<empty>": String
  var node: Option[AbstractNode]                   = None
  var nodeLabel: String                            = "<empty>": String
  var packageName: String                          = "<empty>": String
  var symbol: String                               = "<empty>": String
  def className(value: String): this.type          = { this.className = value; this }
  def classShortName(value: String): this.type     = { this.classShortName = value; this }
  def filename(value: String): this.type           = { this.filename = value; this }
  def lineNumber(value: Int): this.type            = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type    = { this.lineNumber = value; this }
  def methodFullName(value: String): this.type     = { this.methodFullName = value; this }
  def methodShortName(value: String): this.type    = { this.methodShortName = value; this }
  def node(value: AbstractNode): this.type         = { this.node = Option(value); this }
  def node(value: Option[AbstractNode]): this.type = { this.node = value; this }
  def nodeLabel(value: String): this.type          = { this.nodeLabel = value; this }
  def packageName(value: String): this.type        = { this.packageName = value; this }
  def symbol(value: String): this.type             = { this.symbol = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 6, Iterator(this.className))
    interface.insertProperty(this, 7, Iterator(this.classShortName))
    interface.insertProperty(this, 21, Iterator(this.filename))
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 36, Iterator(this.methodFullName))
    interface.insertProperty(this, 37, Iterator(this.methodShortName))
    interface.insertProperty(this, 40, Iterator(this.nodeLabel))
    interface.insertProperty(this, 43, Iterator(this.packageName))
    interface.insertProperty(this, 48, Iterator(this.symbol))
    if (node.nonEmpty) interface.insertProperty(this, 53, this.node)
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "className"
      case 1 => "classShortName"
      case 2 => "filename"
      case 3 => "lineNumber"
      case 4 => "methodFullName"
      case 5 => "methodShortName"
      case 6 => "nodeLabel"
      case 7 => "packageName"
      case 8 => "symbol"
      case 9 => "node"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.className
      case 1 => this.classShortName
      case 2 => this.filename
      case 3 => this.lineNumber
      case 4 => this.methodFullName
      case 5 => this.methodShortName
      case 6 => this.nodeLabel
      case 7 => this.packageName
      case 8 => this.symbol
      case 9 => this.node
      case _ => null
    }

  override def productPrefix                = "NewLocation"
  override def productArity                 = 10
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewLocation]
}
