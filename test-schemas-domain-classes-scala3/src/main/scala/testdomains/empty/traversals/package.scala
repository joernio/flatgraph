package testdomains.empty

import scala.language.implicitConversions
import testdomains.empty.nodes

package object traversals {

  /** not supposed to be used directly by users, hence the `bootstrap` in the name */
  object languagebootstrap extends ConcreteStoredConversions

  trait ConcreteStoredConversions extends ConcreteBaseConversions {}

  trait ConcreteBaseConversions {}
}
