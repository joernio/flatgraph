package io.shiftleft.codepropertygraph.generated.v2.nodes

import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait ImportEMT
    extends AnyRef
    with AstNodeEMT
    with HasExplicitAsEMT
    with HasImportedAsEMT
    with HasImportedEntityEMT
    with HasIsExplicitEMT
    with HasIsWildcardEMT

trait ImportBase extends AbstractNode with AstNodeBase with StaticType[ImportEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    this.explicitAs.foreach { p => res.put("EXPLICIT_AS", p) }
    this.importedAs.foreach { p => res.put("IMPORTED_AS", p) }
    this.importedEntity.foreach { p => res.put("IMPORTED_ENTITY", p) }
    this.isExplicit.foreach { p => res.put("IS_EXPLICIT", p) }
    this.isWildcard.foreach { p => res.put("IS_WILDCARD", p) }
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    res.put("ORDER", this.order)
    res
  }
}

object Import {
  val Label = "IMPORT"
  object PropertyKinds {
    val Code           = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.CODE
    val ColumnNumber   = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.COLUMN_NUMBER
    val ExplicitAs     = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.EXPLICIT_AS
    val ImportedAs     = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.IMPORTED_AS
    val ImportedEntity = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.IMPORTED_ENTITY
    val IsExplicit     = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.IS_EXPLICIT
    val IsWildcard     = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.IS_WILDCARD
    val LineNumber     = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.LINE_NUMBER
    val Order          = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.ORDER
  }
}

class Import(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 17.toShort, seq_4762)
    with ImportBase
    with AstNode
    with StaticType[ImportEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0 => "code"
      case 1 => "columnNumber"
      case 2 => "explicitAs"
      case 3 => "importedAs"
      case 4 => "importedEntity"
      case 5 => "isExplicit"
      case 6 => "isWildcard"
      case 7 => "lineNumber"
      case 8 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.code
      case 1 => this.columnNumber
      case 2 => this.explicitAs
      case 3 => this.importedAs
      case 4 => this.importedEntity
      case 5 => this.isExplicit
      case 6 => this.isWildcard
      case 7 => this.lineNumber
      case 8 => this.order
      case _ => null
    }

  override def productPrefix = "Import"
  override def productArity  = 9

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Import]
}

object NewImport { def apply(): NewImport = new NewImport }
class NewImport extends NewNode(17.toShort) with ImportBase {
  type RelatedStored = Import
  override def label: String                           = "IMPORT"
  var code: String                                     = "<empty>": String
  var columnNumber: Option[Int]                        = None
  var explicitAs: Option[Boolean]                      = None
  var importedAs: Option[String]                       = None
  var importedEntity: Option[String]                   = None
  var isExplicit: Option[Boolean]                      = None
  var isWildcard: Option[Boolean]                      = None
  var lineNumber: Option[Int]                          = None
  var order: Int                                       = -1: Int
  def code(value: String): this.type                   = { this.code = value; this }
  def columnNumber(value: Int): this.type              = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type      = { this.columnNumber = value; this }
  def explicitAs(value: Boolean): this.type            = { this.explicitAs = Option(value); this }
  def explicitAs(value: Option[Boolean]): this.type    = { this.explicitAs = value; this }
  def importedAs(value: Option[String]): this.type     = { this.importedAs = value; this }
  def importedAs(value: String): this.type             = { this.importedAs = Option(value); this }
  def importedEntity(value: Option[String]): this.type = { this.importedEntity = value; this }
  def importedEntity(value: String): this.type         = { this.importedEntity = Option(value); this }
  def isExplicit(value: Boolean): this.type            = { this.isExplicit = Option(value); this }
  def isExplicit(value: Option[Boolean]): this.type    = { this.isExplicit = value; this }
  def isWildcard(value: Boolean): this.type            = { this.isWildcard = Option(value); this }
  def isWildcard(value: Option[Boolean]): this.type    = { this.isWildcard = value; this }
  def lineNumber(value: Int): this.type                = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type        = { this.lineNumber = value; this }
  def order(value: Int): this.type                     = { this.order = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    if (explicitAs.nonEmpty) interface.insertProperty(this, 20, this.explicitAs)
    if (importedAs.nonEmpty) interface.insertProperty(this, 24, this.importedAs)
    if (importedEntity.nonEmpty) interface.insertProperty(this, 25, this.importedEntity)
    if (isExplicit.nonEmpty) interface.insertProperty(this, 28, this.isExplicit)
    if (isWildcard.nonEmpty) interface.insertProperty(this, 31, this.isWildcard)
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    interface.insertProperty(this, 41, Iterator(this.order))
  }

  override def productElementName(n: Int): String =
    n match {
      case 0 => "code"
      case 1 => "columnNumber"
      case 2 => "explicitAs"
      case 3 => "importedAs"
      case 4 => "importedEntity"
      case 5 => "isExplicit"
      case 6 => "isWildcard"
      case 7 => "lineNumber"
      case 8 => "order"
      case _ => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0 => this.code
      case 1 => this.columnNumber
      case 2 => this.explicitAs
      case 3 => this.importedAs
      case 4 => this.importedEntity
      case 5 => this.isExplicit
      case 6 => this.isWildcard
      case 7 => this.lineNumber
      case 8 => this.order
      case _ => null
    }

  override def productPrefix                = "NewImport"
  override def productArity                 = 9
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewImport]
}
