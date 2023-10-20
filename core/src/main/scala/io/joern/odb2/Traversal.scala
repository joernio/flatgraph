package io.joern.odb2

import scala.reflect.ClassTag

object Traversal extends Traversal

trait Traversal {

  given Conversion[IterableOnce[?], Iterator[?]] =
    iterable => iterable.iterator

  extension [A](iterator: Iterator[A]) {

    /** casts all elements to given type note: this can lead to casting errors
      *
      * @see
      *   {{{collectAll}}} as a safe alternative
      */
    // TODO reimplement  @Doc(info = "casts all elements to given type")
    def cast[B]: Iterator[B] =
      iterator.asInstanceOf[Iterator[B]]

    /** collects all elements of the given class (beware of type-erasure) */
    // TODO reimplement   @Doc(info = "collects all elements of the provided class (beware of type-erasure)")
    def collectAll[B](implicit ev: ClassTag[B]): Iterator[B] =
      iterator.filter(ev.runtimeClass.isInstance).asInstanceOf[Iterator[B]]
  }

}
