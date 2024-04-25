package flatgraph.traversal

import scala.collection.{IterableOnce, Iterator}

class PathAwareTraversal[A](val wrapped: Iterator[(A, Vector[Any])]) extends Iterator[A] {
  override def hasNext: Boolean = wrapped.hasNext

  override def next(): A = wrapped.next()._1

  override def map[B](f: A => B): PathAwareTraversal[B] = new PathAwareTraversal[B](wrapped.map { case (a, p) =>
    (f(a), p.appended(a))
  })

  override def flatMap[B](f: A => IterableOnce[B]): PathAwareTraversal[B] =
    new PathAwareTraversal[B](wrapped.flatMap { case (a, p) =>
      val ap = p.appended(a)
      f(a).iterator.map {
        (_, ap)
      }
    })

  override def distinctBy[B](f: A => B): PathAwareTraversal[A] = new PathAwareTraversal[A](wrapped.distinctBy { case (a, p) =>
    f(a)
  })

  override def collect[B](pf: PartialFunction[A, B]): PathAwareTraversal[B] = flatMap(pf.lift)

  override def filter(p: A => Boolean): PathAwareTraversal[A] = new PathAwareTraversal(wrapped.filter(ap => p(ap._1)))

  override def filterNot(p: A => Boolean): PathAwareTraversal[A] = new PathAwareTraversal(wrapped.filterNot(ap => p(ap._1)))

  override def duplicate: (Iterator[A], Iterator[A]) = {
    val tmp = wrapped.duplicate
    (new PathAwareTraversal(tmp._1), new PathAwareTraversal(tmp._2))
  }

  private[traversal] def _union[B](traversals: (Iterator[A] => Iterator[B])*): Iterator[B] =
    new PathAwareTraversal(wrapped.flatMap { case (a, p) =>
      traversals.iterator.flatMap { inner =>
        inner(new PathAwareTraversal(Iterator.single((a, p)))) match {
          case stillPathAware: PathAwareTraversal[?] => stillPathAware.asInstanceOf[PathAwareTraversal[B]].wrapped
          // do we really want to allow the following, or is it an error?
          case notPathAware => notPathAware.iterator.map { (b: B) => (b, p.appended(a)) }
        }
      }
    })

  private[traversal] def _choose[BranchOn >: Null, NewEnd](on: Iterator[A] => Iterator[BranchOn])(
    options: PartialFunction[BranchOn, Iterator[A] => Iterator[NewEnd]]
  ): Iterator[NewEnd] =
    new PathAwareTraversal(wrapped.flatMap { case (a, p) =>
      val branchOnValue: BranchOn = on(Iterator.single(a)).nextOption().getOrElse(null)
      options
        .applyOrElse(branchOnValue, (failState: BranchOn) => (unused: Iterator[A]) => Iterator.empty[NewEnd])
        .apply(new PathAwareTraversal(Iterator.single((a, p)))) match {
        case stillPathAware: PathAwareTraversal[?] => stillPathAware.asInstanceOf[PathAwareTraversal[NewEnd]].wrapped
        // do we really want to allow the following, or is it an error?
        case notPathAware => notPathAware.iterator.map { (b: NewEnd) => (b, p.appended(a)) }
      }
    })

  private[traversal] def _coalesce[NewEnd](options: (Iterator[A] => Iterator[NewEnd])*): Iterator[NewEnd] =
    new PathAwareTraversal(wrapped.flatMap { case (a, p) =>
      options.iterator
        .map { inner =>
          inner(new PathAwareTraversal(Iterator.single((a, p)))) match {
            case stillPathAware: PathAwareTraversal[?] => stillPathAware.asInstanceOf[PathAwareTraversal[NewEnd]].wrapped
            // do we really want to allow the following, or is it an error?
            case notPathAware => notPathAware.iterator.map { (b: NewEnd) => (b, p.appended(a)) }
          }
        }
        .find(_.nonEmpty)
        .getOrElse(Iterator.empty)
    })

  private[traversal] def _sideEffect(f: A => ?): PathAwareTraversal[A] = new PathAwareTraversal(wrapped.map { case (a, p) =>
    f(a); (a, p)
  })

}
