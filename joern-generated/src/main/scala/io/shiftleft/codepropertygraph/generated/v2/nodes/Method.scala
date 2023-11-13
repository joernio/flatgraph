package io.shiftleft.codepropertygraph.generated.v2.nodes

import io.joern.odb2
import io.shiftleft.codepropertygraph.generated.v2.Language.*
import scala.collection.immutable.{IndexedSeq, ArraySeq}

trait MethodEMT
    extends AnyRef
    with CfgNodeEMT
    with DeclarationEMT
    with HasAstParentFullNameEMT
    with HasAstParentTypeEMT
    with HasColumnNumberEndEMT
    with HasFilenameEMT
    with HasFullNameEMT
    with HasHashEMT
    with HasIsExternalEMT
    with HasLineNumberEndEMT
    with HasSignatureEMT

trait MethodBase extends AbstractNode with CfgNodeBase with DeclarationBase with StaticType[MethodEMT] {

  override def propertiesMap: java.util.Map[String, Any] = {
    import io.shiftleft.codepropertygraph.generated.v2.accessors.Lang.*
    val res = new java.util.HashMap[String, Any]()
    res.put("AST_PARENT_FULL_NAME", this.astParentFullName)
    res.put("AST_PARENT_TYPE", this.astParentType)
    res.put("CODE", this.code)
    this.columnNumber.foreach { p => res.put("COLUMN_NUMBER", p) }
    this.columnNumberEnd.foreach { p => res.put("COLUMN_NUMBER_END", p) }
    res.put("FILENAME", this.filename)
    res.put("FULL_NAME", this.fullName)
    this.hash.foreach { p => res.put("HASH", p) }
    res.put("IS_EXTERNAL", this.isExternal)
    this.lineNumber.foreach { p => res.put("LINE_NUMBER", p) }
    this.lineNumberEnd.foreach { p => res.put("LINE_NUMBER_END", p) }
    res.put("NAME", this.name)
    res.put("ORDER", this.order)
    res.put("SIGNATURE", this.signature)
    res
  }
}

object Method {
  val Label = "METHOD"
  object PropertyKinds {
    val AstParentFullName = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.AST_PARENT_FULL_NAME
    val AstParentType     = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.AST_PARENT_TYPE
    val Code              = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.CODE
    val ColumnNumber      = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.COLUMN_NUMBER
    val ColumnNumberEnd   = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.COLUMN_NUMBER_END
    val Filename          = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.FILENAME
    val FullName          = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.FULL_NAME
    val Hash              = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.HASH
    val IsExternal        = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.IS_EXTERNAL
    val LineNumber        = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.LINE_NUMBER
    val LineNumberEnd     = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.LINE_NUMBER_END
    val Name              = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.NAME
    val Order             = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.ORDER
    val Signature         = io.shiftleft.codepropertygraph.generated.v2.PropertyKinds.SIGNATURE
  }
}

class Method(graph_4762: odb2.Graph, seq_4762: Int)
    extends StoredNode(graph_4762, 26.toShort, seq_4762)
    with MethodBase
    with CfgNode
    with Declaration
    with StaticType[MethodEMT] {

  override def productElementName(n: Int): String =
    n match {
      case 0  => "astParentFullName"
      case 1  => "astParentType"
      case 2  => "code"
      case 3  => "columnNumber"
      case 4  => "columnNumberEnd"
      case 5  => "filename"
      case 6  => "fullName"
      case 7  => "hash"
      case 8  => "isExternal"
      case 9  => "lineNumber"
      case 10 => "lineNumberEnd"
      case 11 => "name"
      case 12 => "order"
      case 13 => "signature"
      case _  => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0  => this.astParentFullName
      case 1  => this.astParentType
      case 2  => this.code
      case 3  => this.columnNumber
      case 4  => this.columnNumberEnd
      case 5  => this.filename
      case 6  => this.fullName
      case 7  => this.hash
      case 8  => this.isExternal
      case 9  => this.lineNumber
      case 10 => this.lineNumberEnd
      case 11 => this.name
      case 12 => this.order
      case 13 => this.signature
      case _  => null
    }

  override def productPrefix = "Method"
  override def productArity  = 14

  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[Method]
}

object NewMethod { def apply(): NewMethod = new NewMethod }
class NewMethod extends NewNode(26.toShort) with MethodBase {
  type RelatedStored = Method
  override def label: String                         = "METHOD"
  var astParentFullName: String                      = "<empty>": String
  var astParentType: String                          = "<empty>": String
  var code: String                                   = "<empty>": String
  var columnNumber: Option[Int]                      = None
  var columnNumberEnd: Option[Int]                   = None
  var filename: String                               = "<empty>": String
  var fullName: String                               = "<empty>": String
  var hash: Option[String]                           = None
  var isExternal: Boolean                            = false: Boolean
  var lineNumber: Option[Int]                        = None
  var lineNumberEnd: Option[Int]                     = None
  var name: String                                   = "<empty>": String
  var order: Int                                     = -1: Int
  var signature: String                              = "": String
  def astParentFullName(value: String): this.type    = { this.astParentFullName = value; this }
  def astParentType(value: String): this.type        = { this.astParentType = value; this }
  def code(value: String): this.type                 = { this.code = value; this }
  def columnNumber(value: Int): this.type            = { this.columnNumber = Option(value); this }
  def columnNumber(value: Option[Int]): this.type    = { this.columnNumber = value; this }
  def columnNumberEnd(value: Int): this.type         = { this.columnNumberEnd = Option(value); this }
  def columnNumberEnd(value: Option[Int]): this.type = { this.columnNumberEnd = value; this }
  def filename(value: String): this.type             = { this.filename = value; this }
  def fullName(value: String): this.type             = { this.fullName = value; this }
  def hash(value: Option[String]): this.type         = { this.hash = value; this }
  def hash(value: String): this.type                 = { this.hash = Option(value); this }
  def isExternal(value: Boolean): this.type          = { this.isExternal = value; this }
  def lineNumber(value: Int): this.type              = { this.lineNumber = Option(value); this }
  def lineNumber(value: Option[Int]): this.type      = { this.lineNumber = value; this }
  def lineNumberEnd(value: Int): this.type           = { this.lineNumberEnd = Option(value); this }
  def lineNumberEnd(value: Option[Int]): this.type   = { this.lineNumberEnd = value; this }
  def name(value: String): this.type                 = { this.name = value; this }
  def order(value: Int): this.type                   = { this.order = value; this }
  def signature(value: String): this.type            = { this.signature = value; this }
  override def flattenProperties(interface: odb2.BatchedUpdateInterface): Unit = {
    interface.insertProperty(this, 3, Iterator(this.astParentFullName))
    interface.insertProperty(this, 4, Iterator(this.astParentType))
    interface.insertProperty(this, 10, Iterator(this.code))
    if (columnNumber.nonEmpty) interface.insertProperty(this, 11, this.columnNumber)
    if (columnNumberEnd.nonEmpty) interface.insertProperty(this, 12, this.columnNumberEnd)
    interface.insertProperty(this, 21, Iterator(this.filename))
    interface.insertProperty(this, 22, Iterator(this.fullName))
    if (hash.nonEmpty) interface.insertProperty(this, 23, this.hash)
    interface.insertProperty(this, 29, Iterator(this.isExternal))
    if (lineNumber.nonEmpty) interface.insertProperty(this, 34, this.lineNumber)
    if (lineNumberEnd.nonEmpty) interface.insertProperty(this, 35, this.lineNumberEnd)
    interface.insertProperty(this, 39, Iterator(this.name))
    interface.insertProperty(this, 41, Iterator(this.order))
    interface.insertProperty(this, 47, Iterator(this.signature))
  }

  override def productElementName(n: Int): String =
    n match {
      case 0  => "astParentFullName"
      case 1  => "astParentType"
      case 2  => "code"
      case 3  => "columnNumber"
      case 4  => "columnNumberEnd"
      case 5  => "filename"
      case 6  => "fullName"
      case 7  => "hash"
      case 8  => "isExternal"
      case 9  => "lineNumber"
      case 10 => "lineNumberEnd"
      case 11 => "name"
      case 12 => "order"
      case 13 => "signature"
      case _  => ""
    }

  override def productElement(n: Int): Any =
    n match {
      case 0  => this.astParentFullName
      case 1  => this.astParentType
      case 2  => this.code
      case 3  => this.columnNumber
      case 4  => this.columnNumberEnd
      case 5  => this.filename
      case 6  => this.fullName
      case 7  => this.hash
      case 8  => this.isExternal
      case 9  => this.lineNumber
      case 10 => this.lineNumberEnd
      case 11 => this.name
      case 12 => this.order
      case 13 => this.signature
      case _  => null
    }

  override def productPrefix                = "NewMethod"
  override def productArity                 = 14
  override def canEqual(that: Any): Boolean = that != null && that.isInstanceOf[NewMethod]
}
