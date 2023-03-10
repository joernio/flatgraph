package io.shiftleft.codepropertygraph.generated.nodes
import io.joern.odb2
trait AstNodeBase extends AbstractNode
// new properties: CODE, COLUMN_NUMBER, LINE_NUMBER, ORDER
// inherited properties:
// inherited interfaces:
// implementing nodes: ANNOTATION, ANNOTATION_LITERAL, ANNOTATION_PARAMETER, ANNOTATION_PARAMETER_ASSIGN, ARRAY_INITIALIZER, BLOCK, CALL, COMMENT, CONTROL_STRUCTURE, FIELD_IDENTIFIER, FILE, IDENTIFIER, IMPORT, JUMP_LABEL, JUMP_TARGET, LITERAL, LOCAL, MEMBER, METHOD, METHOD_PARAMETER_IN, METHOD_PARAMETER_OUT, METHOD_REF, METHOD_RETURN, MODIFIER, NAMESPACE, NAMESPACE_BLOCK, RETURN, TEMPLATE_DOM, TYPE_ARGUMENT, TYPE_DECL, TYPE_PARAMETER, TYPE_REF, UNKNOWN
trait AstNode extends StoredNode with AstNodeBase {
  def code: String
  def columnNumber: Option[Int]
  def lineNumber: Option[Int]
  def order: Int
}

trait AstNodeNew extends NewNode with AstNodeBase

trait CallReprBase extends AbstractNode with CfgNodeBase
// new properties: NAME, SIGNATURE
// inherited properties: overflowdb.schema.Property@221af3c0, overflowdb.schema.Property@23a5fd2, overflowdb.schema.Property@62bd765, overflowdb.schema.Property@19dc67c2
// inherited interfaces: AST_NODE
// implementing nodes: CALL
trait CallRepr extends StoredNode with CallReprBase with CfgNode {
  def name: String
  def signature: String
}

trait CallReprNew extends NewNode with CallReprBase with CfgNodeNew

trait CfgNodeBase extends AbstractNode with AstNodeBase
// new properties:
// inherited properties: overflowdb.schema.Property@221af3c0, overflowdb.schema.Property@23a5fd2, overflowdb.schema.Property@62bd765, overflowdb.schema.Property@19dc67c2
// inherited interfaces:
// implementing nodes: ANNOTATION, ANNOTATION_LITERAL, ARRAY_INITIALIZER, BLOCK, CALL, CONTROL_STRUCTURE, FIELD_IDENTIFIER, IDENTIFIER, JUMP_TARGET, LITERAL, METHOD, METHOD_PARAMETER_IN, METHOD_PARAMETER_OUT, METHOD_REF, METHOD_RETURN, RETURN, TEMPLATE_DOM, TYPE_REF, UNKNOWN
trait CfgNode extends StoredNode with CfgNodeBase with AstNode {}

trait CfgNodeNew extends NewNode with CfgNodeBase with AstNodeNew

trait DeclarationBase extends AbstractNode
// new properties: NAME
// inherited properties:
// inherited interfaces:
// implementing nodes: LOCAL, MEMBER, METHOD, METHOD_PARAMETER_IN, METHOD_PARAMETER_OUT
trait Declaration extends StoredNode with DeclarationBase {
  def name: String
}

trait DeclarationNew extends NewNode with DeclarationBase

trait ExpressionBase extends AbstractNode with CfgNodeBase
// new properties: ARGUMENT_INDEX, ARGUMENT_NAME
// inherited properties: overflowdb.schema.Property@221af3c0, overflowdb.schema.Property@23a5fd2, overflowdb.schema.Property@62bd765, overflowdb.schema.Property@19dc67c2
// inherited interfaces: AST_NODE
// implementing nodes: ANNOTATION, ANNOTATION_LITERAL, ARRAY_INITIALIZER, BLOCK, CALL, CONTROL_STRUCTURE, FIELD_IDENTIFIER, IDENTIFIER, LITERAL, METHOD_REF, RETURN, TEMPLATE_DOM, TYPE_REF, UNKNOWN
trait Expression extends StoredNode with ExpressionBase with CfgNode {
  def argumentIndex: Int
  def argumentName: Option[String]
}

trait ExpressionNew extends NewNode with ExpressionBase with AstNodeNew with CfgNodeNew
