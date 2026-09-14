package testdomains.empty.accessors
import testdomains.empty.nodes
import scala.collection.immutable.IndexedSeq

/** not supposed to be used directly by users, hence the `bootstrap` in the name */
object languagebootstrap extends ConcreteStoredConversions

object Accessors {
  /* accessors for concrete stored nodes start */

  /* accessors for concrete stored nodes end */

  /* accessors for base nodes start */

  /* accessors for base nodes end */
}

import Accessors.*
trait ConcreteStoredConversions extends ConcreteBaseConversions {}

trait ConcreteBaseConversions {}
