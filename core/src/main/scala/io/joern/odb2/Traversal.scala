package io.joern.odb2

import scala.reflect.ClassTag

object Traversal {

  extension[A, Iter[A] <: IterableOnce[A]] (iter: Iter[A]) {

    /** casts all elements to given type
     * note: this can lead to casting errors
     *
     * @see {{{collectAll}}} as a safe alternative
     */
    // TODO reimplement  @Doc(info = "casts all elements to given type")
    def cast[B]: Iter[B] =
      iter.asInstanceOf[Iter[B]]

    /** collects all elements of the given class (beware of type-erasure) */
    // TODO reimplement   @Doc(info = "collects all elements of the provided class (beware of type-erasure)")
    def collectAll[B](implicit ev: ClassTag[B]): Iter[B] =
      iter.iterator.filter(ev.runtimeClass.isInstance).asInstanceOf[Iter[B]]
  }

}
