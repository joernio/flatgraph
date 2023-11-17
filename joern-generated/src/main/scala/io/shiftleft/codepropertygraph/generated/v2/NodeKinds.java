package io.shiftleft.codepropertygraph.generated.v2;

import java.util.HashSet;
import java.util.Set;

public class NodeKinds {

/** A method annotation.
The semantics of the FULL_NAME property on this node differ from the usual FULL_NAME
semantics in the sense that FULL_NAME describes the represented annotation class/interface
itself and not the ANNOTATION node. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int ANNOTATION = 0;

/** A literal value assigned to an ANNOTATION_PARAMETER */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int ANNOTATION_LITERAL = 1;

/** Formal annotation parameter */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int ANNOTATION_PARAMETER = 2;

/** Assignment of annotation argument to annotation parameter */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int ANNOTATION_PARAMETER_ASSIGN = 3;

/** Initialization construct for arrays */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int ARRAY_INITIALIZER = 4;

/** `BINDING` nodes represent name-signature pairs that can be resolved at a
type declaration (`TYPE_DECL`). They are connected to `TYPE_DECL` nodes via
incoming `BINDS` edges. The bound method is either associated with an outgoing
`REF` edge to a `METHOD` or with the `METHOD_FULL_NAME` property. The `REF` edge
if present has priority. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int BINDING = 5;

/** This node represents a compound statement. Compound statements are used in many languages to allow
grouping a sequence of statements. For example, in C and Java, compound statements
are statements enclosed by curly braces. Function/Method bodies are compound
statements. We do not use the term "compound statement" because "statement" would
imply that the block does not yield a value upon evaluation, that is, that it is
not an expression. This is true in languages such as C and Java, but not for languages
such as Scala where the value of the block is given by that of the last expression it
contains. In fact, the Scala grammar uses the term "BlockExpr" (short for
"block expression") to describe what in the CPG we call "Block". */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int BLOCK = 6;

/** A (function/method/procedure) call. The `METHOD_FULL_NAME` property is the name of the
invoked method (the callee) while the `TYPE_FULL_NAME` is its return type, and
therefore, the return type of the call when viewing it as an expression. For
languages like Javascript, it is common that we may know the (short-) name
of the invoked method, but we do not know at compile time which method
will actually be invoked, e.g., because it depends on a dynamic import.
In this case, we leave `METHOD_FULL_NAME` blank but at least fill out `NAME`,
which contains the method's (short-) name and `SIGNATURE`, which contains
any information we may have about the types of arguments and return value. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int CALL = 7;

/** Represents the binding of a LOCAL or METHOD_PARAMETER_IN into the closure of a method */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int CLOSURE_BINDING = 8;

/** A source code comment */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int COMMENT = 9;

/** This node type represent a configuration file, where `NAME` is the name
of the file and `content` is its content. The exact representation of the
name is left undefined and can be chosen as required by consumers of
the corresponding configuration files. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int CONFIG_FILE = 10;

/** This node represents a control structure as introduced by control structure
statements as well as conditional and unconditional jumps. Its type is stored in the
`CONTROL_STRUCTURE_TYPE` field to be one of several pre-defined types. These types
 are used in the construction of the control flow layer, making it possible to
 generate the control flow layer from the abstract syntax tree layer automatically.

In addition to the `CONTROL_STRUCTURE_TYPE` field, the `PARSER_TYPE_NAME` field
MAY be used by frontends to store the name of the control structure as emitted by
the parser or disassembler, however, the value of this field is not relevant
for construction of the control flow layer. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int CONTROL_STRUCTURE = 11;

/** This node represents a dependency */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int DEPENDENCY = 12;

/** This node represents the field accessed in a field access, e.g., in
`a.b`, it represents `b`. The field name as it occurs in the code is
stored in the `CODE` field. This may mean that the `CODE` field holds
an expression. The `CANONICAL_NAME` field MAY contain the same value is
the `CODE` field but SHOULD contain the normalized name that results
from evaluating `CODE` as an expression if such an evaluation is
possible for the language frontend. The objective is to store an identifier
in `CANONICAL_NAME` that is the same for two nodes iff they refer to the
same field, regardless of whether they use the same expression to reference
it. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int FIELD_IDENTIFIER = 13;

/** File nodes represent source files or a shared objects from which the CPG
was generated. File nodes serve as indices, that is, they allow looking up all
elements of the code by file.

For each file, the graph MUST contain exactly one File node.
As file nodes are root nodes of abstract syntax tress, they are AstNodes and
their order field is set to 0. This is because they have no sibling nodes,
not because they are the first node of the AST.

Each CPG MUST contain a special file node with name set to
`<unknown>`. This node is a placeholder used in cases where a file cannot be
determined at compile time. As an example, consider external library functions.
As their code is not available on CPG construction, the file name is unknown.

File nodes MUST NOT be created by the language frontend. Instead, the language
frontend is assumed to fill out the `FILENAME` field wherever possible,
allowing File nodes to be created automatically upon first loading the CPG. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int FILE = 14;

/** Finding nodes may be used to store analysis results in the graph
that are to be exposed to an end-user, e.g., information about
potential vulnerabilities or dangerous programming practices.
A Finding node may contain an abitrary list of key value pairs
that characterize the finding, as well as a list of nodes that
serve as evidence for the finding. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int FINDING = 15;

/** This node represents an identifier as used when referring to a variable by name.
It holds the identifier's name in the `NAME` field and its fully-qualified type
name in `TYPE_FULL_NAME`. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int IDENTIFIER = 16;

/** Declarative import as it is found in statically typed languages like Java.
This kind of node is not supposed to be used for imports in dynamically typed
languages like Javascript. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int IMPORT = 17;

/** A jump label specifies the label and thus the JUMP_TARGET of control structures
BREAK and CONTINUE. The `NAME` field holds the name of the label while the
`PARSER_TYPE_NAME` field holds the name of language construct that this jump
label is created from, e.g., "Label". */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int JUMP_LABEL = 18;

/** A jump target is any location in the code that has been specifically marked
as the target of a jump, e.g., via a label. The `NAME` field holds the name of
the label while the `PARSER_TYPE_NAME` field holds the name of language construct
that this jump target is created from, e.g., "Label". */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int JUMP_TARGET = 19;

/** This node represents a key value pair, where both the key and the value are strings. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int KEY_VALUE_PAIR = 20;

/** This node represents a literal such as an integer or string constant. Literals
are symbols included in the code in verbatim form and which are immutable.
The `TYPE_FULL_NAME` field stores the literal's fully-qualified type name,
e.g., `java.lang.Integer`. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int LITERAL = 21;

/** This node represents a local variable. Its fully qualified type name is stored
in the `TYPE_FULL_NAME` field and its name in the `NAME` field. The `CODE` field
contains the entire local variable declaration without initialization, e.g., for
`int x = 10;`, it contains `int x`. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int LOCAL = 22;

/** A location node summarizes a source code location. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int LOCATION = 23;

/** This node represents a type member of a class, struct or union, e.g., for the
 type declaration `class Foo{ int i ; }`, it represents the declaration of the
 variable `i`. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int MEMBER = 24;

/** This node contains the CPG meta data. Exactly one node of this type
MUST exist per CPG. The `HASH` property MAY contain a hash value calculated
over the source files this CPG was generated from. The `VERSION` MUST be
set to the version of the specification ("1.1"). The language field indicates
which language frontend was used to generate the CPG and the list property
`OVERLAYS` specifies which overlays have been applied to the CPG. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int META_DATA = 25;

/** Programming languages offer many closely-related concepts for describing blocks
of code that can be executed with input parameters and return output parameters,
possibly causing side effects. In the CPG specification, we refer to all of these
concepts (procedures, functions, methods, etc.) as methods. A single METHOD node
must exist for each method found in the source program.

The `FULL_NAME` field specifies the method's fully-qualified name, including
information about the namespace it is contained in if applicable, the name field
is the function's short name. The field `IS_EXTERNAL` indicates whether it was
possible to identify a method body for the method. This is true for methods that
are defined in the source program, and false for methods that are dynamically
linked to the program, that is, methods that exist in an external dependency.

Line and column number information is specified in the optional fields
`LINE_NUMBER`, `COLUMN_NUMBER`, `LINE_NUMBER_END`, and `COLUMN_NUMBER_END` and
the name of the source file is specified in `FILENAME`. An optional hash value
MAY be calculated over the function contents and included in the `HASH` field.
The optional `OFFSET` and `OFFSET_END` specify the start
and exclusive end position of the code belonging to a method within the corresponding
`FILE` nodes `CONTENT` property.

Finally, the fully qualified name of the program constructs that the method
is immediately contained in is stored in the `AST_PARENT_FULL_NAME` field
and its type is indicated in the `AST_PARENT_TYPE` field to be one of
`METHOD`, `TYPE_DECL` or `NAMESPACE_BLOCK`. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int METHOD = 26;

/** This node represents a formal input parameter. The field `NAME` contains its
name, while the field `TYPE_FULL_NAME` contains the fully qualified type name. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int METHOD_PARAMETER_IN = 27;

/** This node represents a formal output parameter. Corresponding output parameters
for input parameters MUST NOT be created by the frontend as they are automatically
created upon first loading the CPG. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int METHOD_PARAMETER_OUT = 28;

/** This node represents a reference to a method/function/procedure as it
appears when a method is passed as an argument in a call. The `METHOD_FULL_NAME`
field holds the fully-qualified name of the referenced method and the
`TYPE_FULL_NAME` holds its fully-qualified type name. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int METHOD_REF = 29;

/** This node represents an (unnamed) formal method return parameter. It carries its
fully qualified type name in `TYPE_FULL_NAME`. The `CODE` field MAY be set freely,
e.g., to the constant `RET`, however, subsequent layer creators MUST NOT depend
on this value. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int METHOD_RETURN = 30;

/** This field represents a (language-dependent) modifier such as `static`, `private`
or `public`. Unlike most other AST nodes, it is NOT an expression, that is, it
cannot be evaluated and cannot be passed as an argument in function calls. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int MODIFIER = 31;

/** This node represents a namespace. Similar to FILE nodes, NAMESPACE nodes
serve as indices that allow all definitions inside a namespace to be
obtained by following outgoing edges from a NAMESPACE node.

NAMESPACE nodes MUST NOT be created by language frontends. Instead,
they are generated from NAMESPACE_BLOCK nodes automatically upon
first loading of the CPG. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int NAMESPACE = 32;

/** A reference to a namespace.
We borrow the concept of a "namespace block" from C++, that is, a namespace block
is a block of code that has been placed in the same namespace by a programmer.
This block may be introduced via a `package` statement in Java or
a `namespace{ }` statement in C++.

The `FULL_NAME` field contains a unique identifier to represent the namespace block
itself not just the namespace it references. So in addition to the namespace name
it can be useful to use the containing file name to derive a unique identifier.

The `NAME` field contains the namespace name in a human-readable format.
The name should be given in dot-separated form where a dot indicates
that the right hand side is a sub namespace of the left hand side, e.g.,
`foo.bar` denotes the namespace `bar` contained in the namespace `foo`. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int NAMESPACE_BLOCK = 33;

/** This node represents a return instruction, e.g., `return x`. Note that it does
NOT represent a formal return parameter as formal return parameters are
represented via `METHOD_RETURN` nodes. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int RETURN = 34;

/** This node represents a tag. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int TAG = 35;

/** This node contains an arbitrary node and an associated tag node. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int TAG_NODE_PAIR = 36;

/** This node represents a DOM node used in template languages, e.g., JSX/TSX */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int TEMPLATE_DOM = 37;

/** This node represents a type instance, that is, a concrete instantiation
of a type declaration. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int TYPE = 38;

/** An (actual) type argument as used to instantiate a parametrized type, in the
same way an (actual) arguments provides concrete values for a parameter
at method call sites. As it true for arguments, the method is not expected
to  interpret the type argument. It MUST however store its code in the
`CODE` field. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int TYPE_ARGUMENT = 39;

/** This node represents a type declaration as for example given by a class-, struct-,
or union declaration. In contrast to a `TYPE` node, this node does not represent a
concrete instantiation of a type, e.g., for the parametrized type `List[T]`, it represents
`List[T]`, but not `List[Integer]` where `Integer` is a concrete type.

The language frontend MUST create type declarations for all types declared in the
source program and MAY provide type declarations for types that are not declared
but referenced by the source program. If a declaration is present in the source
program, the field `IS_EXTERNAL` is set to `false`. Otherwise, it is set to `true`.

The `FULL_NAME` field specifies the type's fully-qualified name, including
information about the namespace it is contained in if applicable, the name field
is the type's short name. Line and column number information is specified in the
optional fields `LINE_NUMBER`, `COLUMN_NUMBER`, `LINE_NUMBER_END`, and
`COLUMN_NUMBER_END` and the name of the source file is specified in `FILENAME`.

Base types can be specified via the `INHERITS_FROM_TYPE_FULL_NAME` list, where
each entry contains the fully-qualified name of a base type. If the type is
known to be an alias of another type (as for example introduced via the C
`typedef` statement), the name of the alias is stored in `ALIAS_TYPE_FULL_NAME`.

Finally, the fully qualified name of the program constructs that the type declaration
is immediately contained in is stored in the `AST_PARENT_FULL_NAME` field
and its type is indicated in the `AST_PARENT_TYPE` field to be one of
`METHOD`, `TYPE_DECL` or `NAMESPACE_BLOCK`. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int TYPE_DECL = 40;

/** This node represents a formal type parameter, that is, the type parameter
as given in a type-parametrized method or type declaration. Examples for
languages that support type parameters are Java (via Generics) and C++
(via templates). Apart from the standard fields of AST nodes, the type
parameter carries only a `NAME` field that holds the parameters name. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int TYPE_PARAMETER = 41;

/** Reference to a type/class */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int TYPE_REF = 42;

/** Any AST node that the frontend would like to include in the AST but for
which no suitable AST node is specified in the CPG specification may be
included using a node of type `UNKNOWN`. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int UNKNOWN = 43;


}