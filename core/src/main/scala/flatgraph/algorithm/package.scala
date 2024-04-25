package flatgraph

package object algorithm {

  trait GetParents[A] {
    def apply(a: A): Set[A]
  }

}
