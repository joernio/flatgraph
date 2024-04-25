package flatgraph.testdomains.gratefuldead.accessors
import flatgraph.testdomains.gratefuldead.nodes
import scala.collection.immutable.IndexedSeq

object Lang extends ConcreteStoredConversions

object Accessors {
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
