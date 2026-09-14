package testdomains.hierarchical.traversals

import testdomains.hierarchical.nodes
import testdomains.hierarchical.accessors.languagebootstrap.*

final class TraversalNodeyBase[NodeType <: nodes.NodeYBase](val traversal: Iterator[NodeType]) extends AnyVal {}
