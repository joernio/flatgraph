package testdomains.hierarchical.traversals

import testdomains.hierarchical.nodes
import testdomains.hierarchical.accessors.languagebootstrap.*

final class Traversal_NodeYBase[NodeType <: nodes.NodeYBase](val traversal: Iterator[NodeType]) extends AnyVal {}
