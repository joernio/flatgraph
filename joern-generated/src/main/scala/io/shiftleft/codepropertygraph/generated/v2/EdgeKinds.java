package io.shiftleft.codepropertygraph.generated.v2;

import java.util.HashSet;
import java.util.Set;

public class EdgeKinds {

/** This edge represents an alias relation between a type declaration and a type.
The language frontend MUST NOT create `ALIAS_OF` edges as they are created
automatically based on `ALIAS_TYPE_FULL_NAME` fields when the CPG is first loaded. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int ALIAS_OF = 0;

/** Argument edges connect call sites (node type `CALL`) to their arguments
(node type `EXPRESSION`) as well as `RETURN` nodes to the expressions
that return. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int ARGUMENT = 1;

/** This edge connects a parent node to its child in the syntax tree. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int AST = 2;

/** This edge connects a type declaration (`TYPE_DECL`) with a binding node (`BINDING`) and
indicates that the type declaration has the binding represented by the binding node, in
other words, there is a (name, signature) pair that can be resolved for the type
declaration as stored in the binding node. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int BINDS = 3;

/** This edge connects type arguments to type parameters to indicate
that the type argument is used to instantiate the type parameter. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int BINDS_TO = 4;

/** This edge connects call sites, i.e., nodes with the type `CALL`, to the
method node that represent the method they invoke. The frontend MAY create
`CALL` edges but is not required to do so. Instead, of the `METHOD_FULL_NAME`
field of the `CALL` node is set correctly, `CALL` edges are created
automatically as the CPG is first loaded. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int CALL = 5;

/** Represents the capturing of a variable into a closure */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int CAPTURE = 6;

/** Connection between a captured LOCAL and the corresponding CLOSURE_BINDING */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int CAPTURED_BY = 7;

/** A CDG edge expresses that the destination node is control dependent on the source node. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int CDG = 8;

/** This edge indicates control flow from the source to the destination node. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int CFG = 9;

/** The edge connects control structure nodes to the expressions that holds their conditions. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int CONDITION = 10;

/** This edge connects a node to the method that contains it. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int CONTAINS = 11;

/** This edge indicates that the source node immediately dominates the destination node. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int DOMINATE = 12;

/** This edge connects a node to its evaluation type. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int EVAL_TYPE = 13;

/** Edge from imports to dependencies */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int IMPORTS = 14;

/** Inheritance relation between a type declaration and a type. This edge MUST NOT
 be created by the language frontend as it is automatically created from
 `INHERITS_FROM_TYPE_FULL_NAME` fields then the CPG is first loaded. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int INHERITS_FROM = 15;

/** Edge from CALL statement in the AST to the IMPORT.
￼        |We use this edge to traverse from the logical representation of the IMPORT
￼        |to the corresponding import statement in the AST.
￼        | */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int IS_CALL_FOR_IMPORT = 16;

/** This edge connects a method input parameter to the corresponding
method output parameter. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int PARAMETER_LINK = 17;

/** This edge indicates that the source node immediately post dominates the destination node. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int POST_DOMINATE = 18;

/** A reaching definition edge indicates that a variable produced at the source node reaches
the destination node without being reassigned on the way. The `VARIABLE` property indicates
which variable is propagated. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int REACHING_DEF = 19;

/** Similar to `ARGUMENT` edges, `RECEIVER` edges connect call sites
to their receiver arguments. A receiver argument is the object on
which a method operates, that is, it is the expression that is
assigned to the `this` pointer as control is transferred to the method. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int RECEIVER = 20;

/** This edge indicates that the source node is an identifier that denotes
access to the destination node. For example, an identifier may reference
a local variable. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int REF = 21;

/** This edge connects a node to the node that represents its source file. These
edges MUST not be created by the language frontend but are automatically
created based on `FILENAME` fields. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int SOURCE_FILE = 22;

/** Edges from nodes to the tags they are tagged by. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int TAGGED_BY = 23;


}