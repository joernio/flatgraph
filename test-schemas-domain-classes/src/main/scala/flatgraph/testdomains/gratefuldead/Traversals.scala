package flatgraph.testdomains.gratefuldead.traversals
import flatgraph.testdomains.gratefuldead.nodes

object Lang extends ConcreteStoredConversions

object Accessors {
  import flatgraph.testdomains.gratefuldead.accessors.Lang.*

  /* accessors for concrete stored nodes start */

  /* accessors for concrete stored nodes end */

  /* accessors for base nodes start */

  /* accessors for base nodes end */
}
trait ConcreteStoredConversions extends ConcreteBaseConversions {
  import Accessors.*

}

trait ConcreteBaseConversions {
  import Accessors.*

}
