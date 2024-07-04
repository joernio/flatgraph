package testdomains.hierarchical.traversals

import testdomains.hierarchical.nodes
import testdomains.hierarchical.accessors.languagebootstrap.*

final class TraversalNodexBase[NodeType <: nodes.NodeXBase](val traversal: Iterator[NodeType]) extends AnyVal {}
