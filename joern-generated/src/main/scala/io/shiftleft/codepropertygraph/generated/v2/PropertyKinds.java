package io.shiftleft.codepropertygraph.generated.v2;

import java.util.HashSet;
import java.util.Set;

public class PropertyKinds {

/** This property holds the fully qualified name of the type that the node is
a type alias of. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int ALIAS_TYPE_FULL_NAME = Integer.valueOf(0).intValue();

/** AST-children of CALL nodes have an argument index, that is used to match
call-site arguments with callee parameters. Explicit parameters are numbered
from 1 to N, while index 0 is reserved for implicit self / this parameter.
CALLs without implicit parameter therefore have arguments starting with index 1.
AST-children of BLOCK nodes may have an argument index as well; in this case,
the last argument index determines the return expression of a BLOCK expression.
If the `PARAMETER_NAME` field is set, then the `ARGUMENT_INDEX` field is
ignored. It is suggested to set it to -1. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int ARGUMENT_INDEX = Integer.valueOf(1).intValue();

/** For calls involving named parameters, the `ARGUMENT_NAME` field holds the
name of the parameter initialized by the expression. For all other calls,
this field is unset. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int ARGUMENT_NAME = Integer.valueOf(2).intValue();

/** This field holds the FULL_NAME of the AST parent of an entity. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int AST_PARENT_FULL_NAME = Integer.valueOf(3).intValue();

/** The type of the AST parent. Since this is only used in some parts of the graph,
the list does not include all possible parents by intention.
Possible parents: METHOD, TYPE_DECL, NAMESPACE_BLOCK. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int AST_PARENT_TYPE = Integer.valueOf(4).intValue();

/** This field holds the canonical name of a `FIELD_IDENTIFIER`. It is typically
identical to the CODE field, but canonicalized according to source language
semantics. Human readable names are preferable. `FIELD_IDENTIFIER` nodes must
share identical `CANONICAL_NAME` if and
only if they alias, e.g., in C-style unions (if the aliasing relationship is
unknown or there are partial overlaps, then one must make a reasonable guess,
and trade off between false negatives and false positives). */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int CANONICAL_NAME = Integer.valueOf(5).intValue();



/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int CLASS_NAME = Integer.valueOf(6).intValue();



/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int CLASS_SHORT_NAME = Integer.valueOf(7).intValue();

/** Identifier which uniquely describes a CLOSURE_BINDING. This property is used to match captured LOCAL nodes with the corresponding CLOSURE_BINDING nodes */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int CLOSURE_BINDING_ID = Integer.valueOf(8).intValue();

/** The original name of the (potentially mangled) captured variable */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int CLOSURE_ORIGINAL_NAME = Integer.valueOf(9).intValue();

/** This field holds the code snippet that the node represents. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int CODE = Integer.valueOf(10).intValue();

/** This optional fields provides the column number of the program construct
represented by the node. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int COLUMN_NUMBER = Integer.valueOf(11).intValue();

/** This optional fields provides the column number at which the program construct
represented by the node ends. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int COLUMN_NUMBER_END = Integer.valueOf(12).intValue();

/** References to other nodes. This is not a real property; it exists here for the sake of proto serialization only. valueType and cardinality are meaningless. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int CONTAINED_REF = Integer.valueOf(13).intValue();

/** Certain files, e.g., configuration files, may be included in the CPG as-is.
For such files, the `CONTENT` field contains the files content. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int CONTENT = Integer.valueOf(14).intValue();

/** The `CONTROL_STRUCTURE_TYPE` field indicates which kind of control structure
a `CONTROL_STRUCTURE` node represents. The available types are the following:
 BREAK, CONTINUE, DO, WHILE, FOR, GOTO, IF, ELSE, TRY, THROW and SWITCH. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int CONTROL_STRUCTURE_TYPE = Integer.valueOf(15).intValue();

/** The group ID for a dependency */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int DEPENDENCY_GROUP_ID = Integer.valueOf(16).intValue();

/** This field holds the dispatch type of a call, which is either `STATIC_DISPATCH` or
`DYNAMIC_DISPATCH`. For statically dispatched method calls, the call target is known
at compile time while for dynamically dispatched calls, it can only be determined at
runtime as it may depend on the type of an object (as is the case for virtual method
calls) or calculation of an offset. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int DISPATCH_TYPE = Integer.valueOf(17).intValue();

/** Type hint for the dynamic type. These are observed to be verifiable at runtime. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int DYNAMIC_TYPE_HINT_FULL_NAME = Integer.valueOf(18).intValue();

/** For formal method input parameters, output parameters, and return parameters,
this field holds the evaluation strategy, which is one of the following:
1) `BY_REFERENCE` indicates that the parameter is passed by reference, 2)
`BY_VALUE` indicates that it is passed by value, that is, a copy is made,
3) `BY_SHARING` the parameter is a pointer/reference and it is shared with
the caller/callee. While a copy of the pointer is made, a copy of the object
that it points to is not made. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int EVALUATION_STRATEGY = Integer.valueOf(19).intValue();

/** Specifies whether the IMPORTED_AS property was explicitly present in the code.
For languages like Java which do not allow a renaming during import this is
always false. For e.g. Kotlin it depends on the existence of the "as" keyword. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int EXPLICIT_AS = Integer.valueOf(20).intValue();

/** The path of the source file this node was generated from, relative to the root
path in the meta data node. This field must be set but may be set to the value `<unknown>` to
indicate that no source file can be associated with the node, e.g., because the node represents
an entity known to exist because it is referenced, but for which the file that is is declared in
is unknown. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int FILENAME = Integer.valueOf(21).intValue();

/** This is the fully-qualified name of an entity, e.g., the fully-qualified
name of a method or type. The details of what constitutes a fully-qualified
name are language specific. This field SHOULD be human readable. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int FULL_NAME = Integer.valueOf(22).intValue();

/** This property contains a hash value in the form of a string.
Hashes can be used to summarize data, e.g., to summarize the
contents of source files or sub graphs. Such summaries are useful
to determine whether code has already been analyzed in incremental
analysis pipelines. This property is optional to allow its calculation
to be deferred or skipped if the hash is not needed. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int HASH = Integer.valueOf(23).intValue();

/** The identifier under which the import can be accessed in the importing context.
For a Java import this is always identical to the class name. But e.g. for a
Kotlin import like "import java.nio.ByteBuffer as BBuffer" this would be "BBuffer".
This property is ignored if IS_WILDCARD is true. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int IMPORTED_AS = Integer.valueOf(24).intValue();

/** The identifying string of the imported entity.
For a Java import like "import java.nio.ByteBuffer;" this would be "java.nio.ByteBuffer". */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int IMPORTED_ENTITY = Integer.valueOf(25).intValue();

/** Specifies an index, e.g., for a parameter or argument.
 Explicit parameters are numbered from 1 to N, while index 0 is reserved for implicit
 self / this parameter. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int INDEX = Integer.valueOf(26).intValue();

/** The static types a TYPE_DECL inherits from. This property is matched against the
FULL_NAME of TYPE nodes and thus it is required to have at least one TYPE node
for each TYPE_FULL_NAME */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int INHERITS_FROM_TYPE_FULL_NAME = Integer.valueOf(27).intValue();

/** Specifies whether this is an explicit import.
Most languages have implicit default imports of some standard library elements
and this flag is used to distinguish those from explicit imports found in the
code base. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int IS_EXPLICIT = Integer.valueOf(28).intValue();

/** Indicates that the construct (METHOD or TYPE_DECL) is external, that is,
it is referenced but not defined in the code (applies both to insular
parsing and to library functions where we have header files only) */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int IS_EXTERNAL = Integer.valueOf(29).intValue();

/** Specifies whether a parameter is the variadic argument handling parameter of
a variadic method. Only one parameter of a method is allowed to have this
property set to true. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int IS_VARIADIC = Integer.valueOf(30).intValue();

/** Specifies whether this is a wildcard import.
For a Java import like "import java.nio.*;" IS_WILDCARD would be "true" and
IMPORTED_ENTITY would be "java.nio".
For wildcard imports the IMPORTED_AS property is ignored. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int IS_WILDCARD = Integer.valueOf(31).intValue();

/** This property denotes a key of a key-value pair. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int KEY = Integer.valueOf(32).intValue();

/** This field indicates which CPG language frontend generated the CPG.
Frontend developers may freely choose a value that describes their frontend
so long as it is not used by an existing frontend. Reserved values are to date:
C, LLVM, GHIDRA, PHP. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int LANGUAGE = Integer.valueOf(33).intValue();

/** This optional field provides the line number of the program construct
represented by the node. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int LINE_NUMBER = Integer.valueOf(34).intValue();

/** This optional fields provides the line number at which the program construct
represented by the node ends. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int LINE_NUMBER_END = Integer.valueOf(35).intValue();

/** The FULL_NAME of a method. Used to link CALL and METHOD nodes. It is required
to have exactly one METHOD node for each METHOD_FULL_NAME */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int METHOD_FULL_NAME = Integer.valueOf(36).intValue();



/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int METHOD_SHORT_NAME = Integer.valueOf(37).intValue();

/** The modifier type is a free-form string. The following are known modifier types:
`STATIC`, `PUBLIC`, `PROTECTED`, `PRIVATE`, `ABSTRACT`, `NATIVE`, `CONSTRUCTOR`, `VIRTUAL`. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int MODIFIER_TYPE = Integer.valueOf(38).intValue();

/** Name of represented object, e.g., method name (e.g. "run") */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int NAME = Integer.valueOf(39).intValue();



/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int NODE_LABEL = Integer.valueOf(40).intValue();

/** Start offset into the CONTENT property of the corresponding FILE node.
The offset is measure in characters so parts of the content can easily
be accessed via `content.substring(offset, offsetEnd)`.
E.g. for METHOD nodes this start offset points to the start of the methods
source code in the string holding the source code of the entire file. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int OFFSET = Integer.valueOf(41).intValue();

/** End offset (exclusive) into the CONTENT property of the corresponding FILE node.
The end offset is measure in characters so parts of the content can easily
be accessed via `content.substring(offset, offsetEnd)`.
E.g. for METHOD nodes this end offset points to the first code position which is
not part of the method. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int OFFSET_END = Integer.valueOf(42).intValue();

/** This integer indicates the position of the node among
its siblings in the AST. The left-most child has an
order of 0. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int ORDER = Integer.valueOf(43).intValue();

/** The field contains the names of the overlays applied to this CPG, in order of their
application. Names are free-form strings, that is, this specification does not
dictate them but rather requires tool producers and consumers to communicate them
between each other. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int OVERLAYS = Integer.valueOf(44).intValue();



/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int PACKAGE_NAME = Integer.valueOf(45).intValue();

/** AST node type name emitted by parser. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int PARSER_TYPE_NAME = Integer.valueOf(46).intValue();

/** Similar to `DYNAMIC_TYPE_HINT_FULL_NAME`, but that this makes no guarantee that types within this property are correct. This property is used to capture observations between node interactions during a 'may-analysis'. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int POSSIBLE_TYPES = Integer.valueOf(47).intValue();

/** The path to the root directory of the source/binary this CPG is generated from. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int ROOT = Integer.valueOf(48).intValue();

/** The method signature encodes the types of parameters in a string.
The string SHOULD be human readable and suitable for differentiating methods
with different parameter types sufficiently to allow for resolving of
function overloading. The present specification does not enforce a strict
format for the signature, that is, it can be chosen by the frontend
implementor to fit the source language. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int SIGNATURE = Integer.valueOf(49).intValue();



/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int SYMBOL = Integer.valueOf(50).intValue();

/** The static type decl of a TYPE. This property is matched against the FULL_NAME
of TYPE_DECL nodes. It is required to have exactly one TYPE_DECL for each
different TYPE_DECL_FULL_NAME */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int TYPE_DECL_FULL_NAME = Integer.valueOf(51).intValue();

/** This field contains the fully-qualified static type name of the program
construct represented by a node. It is the name of an instantiated type, e.g.,
`java.util.List<Integer>`, rather than `java.util.List[T]`. If the type
cannot be determined, this field should be set to the empty string. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int TYPE_FULL_NAME = Integer.valueOf(52).intValue();

/** This property denotes a string value as used in a key-value pair. */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int VALUE = Integer.valueOf(53).intValue();

/** A version, given as a string. Used, for example, in the META_DATA node to
indicate which version of the CPG spec this CPG conforms to */

/* implementation note: we want to ensure that javac does not inline the final value, so that downstream
 * projects have the ability to run with newly generated domain classes
 * see https://stackoverflow.com/a/3524336/452762 */
public static final int VERSION = Integer.valueOf(54).intValue();


}