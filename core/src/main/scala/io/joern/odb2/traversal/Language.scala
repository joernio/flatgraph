package io.joern.odb2.traversal

import io.joern.odb2.{Accessors, Edge, GNode}

import scala.collection.immutable.ArraySeq
import scala.collection.mutable
import scala.reflect.ClassTag

object Language extends Language

trait Language extends GNodeTraversal {

  // given [A]: Conversion[IterableOnce[A], Iterator[A]] =
  // iterable => iterable.iterator

  implicit def iterableOnceToIterator[A](iterableOnce: IterableOnce[A]): Iterator[A] =
    iterableOnce.iterator

  extension [A](iterator: Iterator[A]) {

    /** Execute the traversal and convert the result to a list - shorthand for `toList` */
    // TODO reimplement @Doc(info = "Execute the traversal and convert the result to a list - shorthand for `toList`")
    def l: List[A] = iterator.toList

    /** group elements and count how often they appear */
    // TODO reimplement @Doc(info = "group elements and count how often they appear")
    def groupCount[B >: A]: Map[B, Int] =
      groupCount(identity[A])

    /** group elements by a given transformation function and count how often the results appear */
    // TODO reimplement @Doc(info = "group elements by a given transformation function and count how often the results appear")
    def groupCount[B](by: A => B): Map[B, Int] = {
      val counts = mutable.Map.empty[B, Int].withDefaultValue(0)
      iterator.foreach { a =>
        val b        = by(a)
        val newValue = counts(b) + 1
        counts.update(b, newValue)
      }
      counts.to(Map)
    }

    def groupBy[K](f: A => K): Map[K, List[A]]                                       = l.groupBy(f)
    def groupMap[K, B](key: A => K)(f: A => B): Map[K, List[B]]                      = l.groupMap(key)(f)
    def groupMapReduce[K, B](key: A => K)(f: A => B)(reduce: (B, B) => B): Map[K, B] = l.groupMapReduce(key)(f)(reduce)

    /** Execute the traversal and return a mutable.Set (better performance than `immutableSet` and has stable iterator order)
      */
    def toSetMutable[B >: A]: mutable.LinkedHashSet[B] = mutable.LinkedHashSet.from(iterator)

    /** Execute the traversal and convert the result to an immutable Set. */

    def toSetImmutable[B >: A]: Set[B] = iterator.toSet

    /** Execute the traversal without returning anything */
    // TODO reimplement @Doc(info = "Execute the traversal without returning anything")
    def iterate(): Unit =
      while (iterator.hasNext) iterator.next()

    def countTrav: Iterator[Int] =
      Iterator.single(iterator.size)

    def head: A = iterator.next()

    def headOption: Option[A] = iterator.nextOption()

    def last: A = {
      iterator.hasNext
      var res = iterator.next()
      while (iterator.hasNext) res = iterator.next()
      res
    }

    def lastOption: Option[A] =
      if (iterator.hasNext) Some(last) else None

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

    /** Deduplicate elements of this traversal - a.k.a. distinct, unique, ... */
    // TODO reimplement  @Doc(info = "deduplicate elements of this traversal - a.k.a. distinct, unique, ...")
    def dedup: Iterator[A] =
      iterator.distinct

    /** deduplicate elements of this traversal by a given function */
    // TODO reimplement  @Doc(info = "deduplicate elements of this traversal by a given function")
    def dedupBy(fun: A => Any): Iterator[A] =
      iterator.distinctBy(fun)

    /** sort elements by their natural order */
    // TODO reimplement  @Doc(info = "sort elements by their natural order")
    def sorted[B >: A](implicit ord: Ordering[B]): Seq[B] = {
      (iterator.to(ArraySeq.untagged): ArraySeq[B]).sorted
    }

    /** sort elements by the value of the given transformation function */
    // TODO reimplement  @Doc(info = "sort elements by the value of the given transformation function")
    def sortBy[B](f: A => B)(implicit ord: Ordering[B]): Seq[A] =
      iterator.to(ArraySeq.untagged).sortBy(f)

    /** Print help/documentation based on the current elementType `A`. Relies on all step extensions being annotated with \@Traversal / @Doc
      * Note that this works independently of tab completion and implicit conversions in scope - it will simply list all documented steps in
      * the classpath
      */
    // TODO reimplement  @Doc(info = "print help/documentation based on the current elementType `A`.")
//    def help[B >: A](implicit elementType: ClassTag[B], searchPackages: DocSearchPackages): String =
//      new TraversalHelp(searchPackages).forElementSpecificSteps(elementType.runtimeClass, verbose = false)

    // TODO reimplement  @Doc(info = "print verbose help/documentation based on the current elementType `A`.")
//    def helpVerbose[B >: A](implicit elementType: ClassTag[B], searchPackages: DocSearchPackages): String =
//      new TraversalHelp(searchPackages).forElementSpecificSteps(elementType.runtimeClass, verbose = true)

    /** filters out everything that is _not_ the given value */
    // TODO reimplement @Doc(info = "filters out everything that is _not_ the given value")
    def is[B >: A](value: B): Iterator[A] =
      iterator.filter(_ == value)

    /** filters out all elements that are _not_ in the provided set */
    // TODO reimplement @Doc(info = "filters out all elements that are _not_ in the provided set")
    def within[B >: A](values: Set[B]): Iterator[A] =
      iterator.filter(values.contains)

    /** filters out all elements that _are_ in the provided set */
    // TODO reimplement @Doc(info = "filters out all elements that _are_ in the provided set")
    def without[B >: A](values: Set[B]): Iterator[A] =
      iterator.filterNot(values.contains)

    /** perform side effect without changing the contents of the traversal */
    // TODO reimplement @Doc(info = "perform side effect without changing the contents of the traversal")
    def sideEffect(fun: A => _): Iterator[A] =
      iterator match {
        // TODO bring back PathAwareTraversal?
//        case pathAwareTraversal: PathAwareTraversal[A] => pathAwareTraversal._sideEffect(fun)
        case _ =>
          iterator.map { a =>
            fun(a); a
          }
      }

    /** perform side effect without changing the contents of the traversal will only apply the partialFunction if it is defined for the
      * given input - analogous to `collect`
      */
    // TODO reimplement @Doc(info = "perform side effect without changing the contents of the traversal")
    def sideEffectPF(pf: PartialFunction[A, _]): Iterator[A] =
      sideEffect(pf.lift)

    /** only preserves elements if the provided traversal has at least one result */
    // TODO reimplement @Doc(info = "only preserves elements if the provided traversal has at least one result")
    def where(trav: Iterator[A] => Iterator[_]): Iterator[A] =
      iterator.filter { (a: A) =>
        trav(Iterator.single(a)).hasNext
      }

    /** only preserves elements if the provided traversal does _not_ have any results */
    // TODO reimplement @Doc(info = "only preserves elements if the provided traversal does _not_ have any results")
    def whereNot(trav: Iterator[A] => Iterator[_]): Iterator[A] =
      iterator.filter { (a: A) =>
        !trav(Iterator.single(a)).hasNext
      }

    /** only preserves elements if the provided traversal does _not_ have any results - alias for whereNot */
    // TODO reimplement @Doc(info = "only preserves elements if the provided traversal does _not_ have any results - alias for whereNot")
    def not(trav: Iterator[A] => Iterator[_]): Iterator[A] =
      whereNot(trav)

    /** only preserves elements for which _at least one of_ the given traversals has at least one result Works for arbitrary amount of 'OR'
      * traversals.
      *
      * @example
      *   {{{.or(_.label("someLabel"), _.has("someProperty"))}}}
      */
    // TODO reimplement @Doc(info = "only preserves elements for which _at least one of_ the given traversals has at least one result")
    def or(traversals: (Iterator[A] => Iterator[_])*): Iterator[A] = {
      iterator.filter { (a: A) =>
        traversals.exists { trav =>
          trav(Iterator.single(a)).hasNext
        }
      }
    }

    /** only preserves elements for which _all of_ the given traversals have at least one result Works for arbitrary amount of 'AND'
      * traversals.
      *
      * @example
      *   {{{.and(_.label("someLabel"), _.has("someProperty"))}}}
      */
    // TODO reimplement @Doc(info = "only preserves elements for which _all of_ the given traversals have at least one result")
    def and(traversals: (Iterator[A] => Iterator[_])*): Iterator[A] = {
      iterator.filter { (a: A) =>
        traversals.forall { trav =>
          trav(Iterator.single(a)).hasNext
        }
      }
    }

    /** union step from the current point
      *
      * @param traversals
      *   to be executed from here, results are being aggregated/summed/unioned
      * @example
      *   {{{.union(_.out, _.in)}}}
      */
    // TODO reimplement @Doc(info = "union/sum/aggregate/join given traversals from the current point")
    def union[B](traversals: (Iterator[A] => Iterator[B])*): Iterator[B] = iterator match {
      // TODO bring back PathAwareTraversal?
//      case pathAwareTraversal: PathAwareTraversal[A] => pathAwareTraversal._union(traversals: _*)
      case _ =>
        iterator.flatMap { (a: A) =>
          traversals.flatMap(_.apply(Iterator.single(a)))
        }
    }

    /** Branch step: based on the current element, match on something given a traversal, and provide resulting traversals based on the
      * matched element. Allows to implement conditional semantics: if, if/else, if/elseif, if/elseif/else, ...
      *
      * @param on
      *   Traversal to get to what you want to match on
      * @tparam BranchOn
      *   required to be >: Null because the implementation is using `null` as the default value. I didn't find a better way to implement
      *   all semantics with the niceties of PartialFunction, and also yolo...
      * @param options
      *   PartialFunction from the matched element to the resulting traversal
      * @tparam NewEnd
      *   The element type of the resulting traversal
      * @example
      *   {{{
      * .choose(_.property(Name)) {
      *   case "L1" => _.out
      *   case "R1" => _.repeat(_.out)(_.maxDepth(3))
      *   case _ => _.in
      * }
      *   }}}
      * @see
      *   LogicalStepsTests
      */
    // TODO reimplement @Doc(info = "allows to implement conditional semantics: if, if/else, if/elseif, if/elseif/else, ...")
    def choose[BranchOn >: Null, NewEnd](
      on: Iterator[A] => Iterator[BranchOn]
    )(options: PartialFunction[BranchOn, Iterator[A] => Iterator[NewEnd]]): Iterator[NewEnd] = iterator match {
      // TODO bring back PathAwareTraversal?
//      case pathAwareTraversal: PathAwareTraversal[A] => pathAwareTraversal._choose[BranchOn, NewEnd](on)(options)
      case _ =>
        iterator.flatMap { (a: A) =>
          val branchOnValue: BranchOn = on(Iterator.single(a)).nextOption().getOrElse(null)
          options
            .applyOrElse(branchOnValue, (failState: BranchOn) => ((unused: Iterator[A]) => Iterator.empty[NewEnd]))
            .apply(Iterator.single(a))
        }
    }

    // TODO reimplement @Doc(info = "evaluates the provided traversals in order and returns the first traversal that emits at least one element" )
    def coalesce[NewEnd](options: (Iterator[A] => Iterator[NewEnd])*): Iterator[NewEnd] = iterator match {
      // TODO bring back PathAwareTraversal?
//      case pathAwareTraversal: PathAwareTraversal[A] => pathAwareTraversal._coalesce(options: _*)
      case _ =>
        iterator.flatMap { (a: A) =>
          options.iterator
            .map(_.apply(Iterator.single(a)))
            .collectFirst {
              case option if option.nonEmpty => option
            }
            .getOrElse(Iterator.empty)
        }
    }

    // TODO reimplement @Doc(info = "enable path tracking - prerequisite for path/simplePath steps")
    // TODO bring back PathAwareTraversal?
//    def enablePathTracking: PathAwareTraversal[A] =
//      iterator match {
//        case pathAwareTraversal: PathAwareTraversal[_] => throw new RuntimeException("path tracking is already enabled")
//        case _ => new PathAwareTraversal[A](iterator.map { a => (a, Vector.empty) })
//      }

    // TODO reimplement @Doc(info = "enable path tracking - prerequisite for path/simplePath steps")
//    def discardPathTracking: Iterator[A] =
//      iterator match {
//        case pathAwareTraversal: PathAwareTraversal[A] => pathAwareTraversal.wrapped.map { _._1 }
//        case _                                         => iterator
//      }

//    def isPathTracking: Boolean = iterator.isInstanceOf[PathAwareTraversal[_]]

    /** retrieve entire path that has been traversed thus far prerequisite: enablePathTracking has been called previously
      *
      * @example
      *   {{{
      *  myTraversal.enablePathTracking.out.out.path.toList
      *   }}}
      *   TODO would be nice to preserve the types of the elements, at least if they have a common supertype
      */
    // TODO reimplement @Doc(info = "retrieve entire path that has been traversed thus far")
    def path: Iterator[Vector[Any]] = iterator match {
      // TODO bring back PathAwareTraversal?
//      case tracked: PathAwareTraversal[A] =>
//        tracked.wrapped.map { case (a, p) =>
//          p.appended(a)
//        }
      case _ =>
        throw new AssertionError(
          "path tracking not enabled, please make sure you have a `PathAwareTraversal`, e.g. via `Traversal.enablePathTracking`"
        )
    } // fixme: I think ClassCastException is the correct result when the user forgot to enable path tracking. But a better error message to go along with it would be nice.

    def simplePath: Iterator[A] = iterator match {
      // TODO bring back PathAwareTraversal?
//      case tracked: PathAwareTraversal[A] =>
//        new PathAwareTraversal(tracked.wrapped.filter { case (a, p) =>
//          mutable.Set.from(p).addOne(a).size == 1 + p.size
//        })
      case _ =>
        throw new AssertionError(
          "path tracking not enabled, please make sure you have a `PathAwareTraversal`, e.g. via `Traversal.enablePathTracking`"
        )
    }

    /** Repeat the given traversal
      *
      * By default it will continue repeating until there's no more results, not emit anything along the way, and use depth first search.
      *
      * The @param behaviourBuilder allows you to configure end conditions (until|whilst|maxDepth), whether it should emit elements it
      * passes by, and which search algorithm to use (depth-first or breadth-first).
      *
      * Search algorithm: Depth First Search (DFS) vs Breadth First Search (BFS): DFS means the repeat step will go deep before wide. BFS
      * does the opposite: wide before deep. For example, given the graph {{{L3 <- L2 <- L1 <- Center -> R1 -> R2 -> R3 -> R4}}} DFS will
      * iterate the nodes in the order: {{{Center, L1, L2, L3, R1, R2, R3, R4}}} BFS will iterate the nodes in the order:
      * {{{Center, L1, R1, R1, R2, L3, R3, R4}}}
      *
      * @example
      *   {{{
      * .repeat(_.out)                            // repeat until there's no more elements, emit nothing, use DFS
      * .repeat(_.out)(_.maxDepth(3))                            // perform exactly three repeat iterations
      * .repeat(_.out)(_.until(_.property(Name).endsWith("2")))  // repeat until the 'Name' property ends with '2'
      * .repeat(_.out)(_.emit)                                   // emit everything along the way
      * .repeat(_.out)(_.emit.breadthFirstSearch)                // emit everything, use BFS
      * .repeat(_.out)(_.emit(_.property(Name).startsWith("L"))) // emit if the 'Name' property starts with 'L'
      *   }}}
      * @note
      *   this works for domain-specific steps as well as generic graph steps - for details please take a look at the examples in
      *   RepeatTraversalTests: both '''.followedBy''' and '''.out''' work.
      * @see
      *   RepeatTraversalTests for more detail and examples for all of the above.
      */
    // @Doc(info = "repeat the given traversal")
    // TODO bring back repeat step
    def repeat[B >: A](
      repeatTraversal: Iterator[A] => Iterator[B]
    )(implicit behaviourBuilder: RepeatBehaviour.Builder[B] => RepeatBehaviour.Builder[B] = RepeatBehaviour.noop[B] _): Iterator[B] = {
      val behaviour = behaviourBuilder(new RepeatBehaviour.Builder[B]).build
      val _repeatTraversal =
        repeatTraversal
          .asInstanceOf[Iterator[B] => Iterator[B]] // this cast usually :tm: safe, because `B` is a supertype of `A`
      iterator match {
//        case tracked: PathAwareTraversal[A] =>
//          val step = PathAwareRepeatStep(_repeatTraversal, behaviour)
//          new PathAwareTraversal(tracked.wrapped.flatMap { case (a, p) =>
//            step.apply(a).wrapped.map { case (aa, pp) => (aa, p ++ pp) }
//          })
        case _ => iterator.flatMap(RepeatStep(_repeatTraversal, behaviour))
      }
    }
  }

  extension (node: GNode) {

    /** follow _all_ OUT edges to their adjacent nodes */
    def out: Iterator[GNode] = Accessors.getNeighborsOut(node)

    /** follow _all_ IN edges to their adjacent nodes */
    def in: Iterator[GNode] = Accessors.getNeighborsIn(node)

    /** follow the given OUT edge(s) to their adjacent nodes */
    def out(edgeLabel: String): Iterator[GNode] =
      Accessors.getNeighborsOut(node, edgeKind = edgeKind(edgeLabel))

    /** follow the given IN edge(s) to their adjacent nodes */
    def in(edgeLabel: String): Iterator[GNode] =
      Accessors.getNeighborsIn(node, edgeKind = edgeKind(edgeLabel))

    /** lookup the given OUT edge(s) */
    def outE(edgeLabel: String): Iterator[Edge] =
      Accessors.getEdgesOut(node, edgeKind = edgeKind(edgeLabel))

    /** lookup the given IN edge(s) */
    def inE(edgeLabel: String): Iterator[Edge] =
      Accessors.getEdgesIn(node, edgeKind = edgeKind(edgeLabel))

    def propertyOption[@specialized T: ClassTag](name: String): Option[T] = {
      val propertyKind = node.graph.schema.getPropertyKindByLabel(name)
      Accessors.getNodePropertyOption(node.graph, node.nodeKind, propertyKind, node.seq())
    }

    private def edgeKind(edgeLabel: String): Int =
      node.graph.schema.getEdgeKindByLabel(edgeLabel)
  }

  extension (iterator: Iterator[GNode]) {

    /** follow _all_ OUT edges to their adjacent nodes */
    def out: Iterator[GNode] = iterator.flatMap(Accessors.getNeighborsOut)

    /** follow _all_ IN edges to their adjacent nodes */
    def in: Iterator[GNode] = iterator.flatMap(Accessors.getNeighborsIn)

    /** follow the given OUT edge(s) to their adjacent nodes */
    def out(edgeLabel: String): Iterator[GNode] = iterator.flatMap(_.out(edgeLabel))

    /** follow the given IN edge(s) to their adjacent nodes */
    def in(edgeLabel: String): Iterator[GNode] = iterator.flatMap(_.in(edgeLabel))

    /** lookup the given OUT edge(s) */
    def outE(edgeLabel: String): Iterator[Edge] = iterator.flatMap(_.outE(edgeLabel))

    /** lookup the given IN edge(s) */
    def inE(edgeLabel: String): Iterator[Edge] = iterator.flatMap(_.inE(edgeLabel))

    def property[@specialized T: ClassTag](name: String): Iterator[T] =
      iterator.flatMap(_.propertyOption[T](name))

  }

}
