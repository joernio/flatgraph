package io.shiftleft.codepropertygraph.generated.nodes
import io.joern.odb2
trait AstNodeBase extends AbstractNode
 // new properties: CODE, COLUMN_NUMBER, LINE_NUMBER, ORDER
 // inherited properties: 
 // inherited interfaces: 
 // implementing nodes: ANNOTATION, ANNOTATION_LITERAL, ANNOTATION_PARAMETER, ANNOTATION_PARAMETER_ASSIGN, ARRAY_INITIALIZER, BLOCK, CALL, COMMENT, CONTROL_STRUCTURE, FIELD_IDENTIFIER, FILE, IDENTIFIER, IMPLICIT_CALL, IMPORT, JUMP_LABEL, JUMP_TARGET, LITERAL, LOCAL, MEMBER, METHOD, METHOD_INST, METHOD_PARAMETER_IN, METHOD_PARAMETER_OUT, METHOD_REF, METHOD_RETURN, MODIFIER, NAMESPACE, NAMESPACE_BLOCK, POST_EXECUTION_CALL, RETURN, TEMPLATE_DOM, TYPE_ARGUMENT, TYPE_DECL, TYPE_PARAMETER, TYPE_REF, UNKNOWN
trait AstNode extends StoredNode with AstNodeBase {
def code: String
def columnNumber: Option[Int]
def lineNumber: Option[Int]
def order: Int
}

trait AstNodeNew extends NewNode with AstNodeBase


trait CallReprBase extends AbstractNode with CfgNodeBase
 // new properties: NAME, SIGNATURE
 // inherited properties: overflowdb.schema.Property@551bdc27, overflowdb.schema.Property@6b1274d2, overflowdb.schema.Property@8909f18, overflowdb.schema.Property@78047b92, overflowdb.schema.Property@58fdd99, overflowdb.schema.Property@dd3b207
 // inherited interfaces: AST_NODE, TRACKING_POINT
 // implementing nodes: CALL, IMPLICIT_CALL, POST_EXECUTION_CALL
trait CallRepr extends StoredNode with CallReprBase with CfgNode {
def name: String
def signature: String
}

trait CallReprNew extends NewNode with CallReprBase with CfgNodeNew


trait CfgNodeBase extends AbstractNode with AstNodeBase with TrackingPointBase
 // new properties: DEPTH_FIRST_ORDER, INTERNAL_FLAGS
 // inherited properties: overflowdb.schema.Property@551bdc27, overflowdb.schema.Property@6b1274d2, overflowdb.schema.Property@58fdd99, overflowdb.schema.Property@dd3b207
 // inherited interfaces: 
 // implementing nodes: ANNOTATION, ANNOTATION_LITERAL, ARRAY_INITIALIZER, BLOCK, CALL, CONTROL_STRUCTURE, FIELD_IDENTIFIER, IDENTIFIER, IMPLICIT_CALL, JUMP_TARGET, LITERAL, METHOD, METHOD_PARAMETER_IN, METHOD_PARAMETER_OUT, METHOD_REF, METHOD_RETURN, POST_EXECUTION_CALL, RETURN, TEMPLATE_DOM, TYPE_REF, UNKNOWN
trait CfgNode extends StoredNode with CfgNodeBase with AstNode with TrackingPoint {
def depthFirstOrder: Int
def internalFlags: Int
}

trait CfgNodeNew extends NewNode with CfgNodeBase with TrackingPointNew with AstNodeNew


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
 // inherited properties: overflowdb.schema.Property@551bdc27, overflowdb.schema.Property@6b1274d2, overflowdb.schema.Property@8909f18, overflowdb.schema.Property@78047b92, overflowdb.schema.Property@58fdd99, overflowdb.schema.Property@dd3b207
 // inherited interfaces: AST_NODE, TRACKING_POINT
 // implementing nodes: ANNOTATION, ANNOTATION_LITERAL, ARRAY_INITIALIZER, BLOCK, CALL, CONTROL_STRUCTURE, FIELD_IDENTIFIER, IDENTIFIER, LITERAL, METHOD_REF, RETURN, TEMPLATE_DOM, TYPE_REF, UNKNOWN
trait Expression extends StoredNode with ExpressionBase with CfgNode {
def argumentIndex: Int
def argumentName: Option[String]
}

trait ExpressionNew extends NewNode with ExpressionBase with CfgNodeNew with TrackingPointNew with AstNodeNew


trait LocalLikeBase extends AbstractNode
 // new properties: NAME
 // inherited properties: 
 // inherited interfaces: 
 // implementing nodes: IDENTIFIER, LOCAL, METHOD_PARAMETER_IN
trait LocalLike extends StoredNode with LocalLikeBase {
def name: String
}

trait LocalLikeNew extends NewNode with LocalLikeBase


trait TrackingPointBase extends AbstractNode with TrackingPointMarker
 // new properties: CODE
 // inherited properties: 
 // inherited interfaces: 
 // implementing nodes: ANNOTATION, ANNOTATION_LITERAL, ARRAY_INITIALIZER, BLOCK, CALL, CONFIG_FILE, CONTROL_STRUCTURE, DOM_NODE, FIELD_IDENTIFIER, IDENTIFIER, IMPLICIT_CALL, JUMP_TARGET, LITERAL, METHOD, METHOD_PARAMETER_IN, METHOD_PARAMETER_OUT, METHOD_REF, METHOD_RETURN, POST_EXECUTION_CALL, RETURN, TEMPLATE_DOM, TYPE_REF, UNKNOWN
trait TrackingPoint extends StoredNode with TrackingPointBase with TrackingPointMarker {
def code: String
}

trait TrackingPointNew extends NewNode with TrackingPointBase with TrackingPointMarker


