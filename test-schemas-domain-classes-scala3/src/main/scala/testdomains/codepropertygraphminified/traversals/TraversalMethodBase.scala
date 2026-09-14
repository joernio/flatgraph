package testdomains.codepropertygraphminified.traversals

import testdomains.codepropertygraphminified.nodes
import testdomains.codepropertygraphminified.accessors.languagebootstrap.*

final class TraversalMethodBase[NodeType <: nodes.MethodBase](val traversal: Iterator[NodeType]) extends AnyVal {}
