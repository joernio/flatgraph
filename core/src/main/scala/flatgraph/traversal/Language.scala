package flatgraph.traversal

import flatgraph.help.{Doc, Traversal}
import flatgraph.{Accessors, Edge, GNode, MultiPropertyKey, OptionalPropertyKey, PropertyKey, Schema, SinglePropertyKey}

import scala.annotation.implicitNotFound
import scala.collection.immutable.ArraySeq
import scala.collection.{Iterator, mutable}
import scala.reflect.ClassTag

object language extends language

trait language {
  implicit def iterableOnceToIterator[A](iter: IterableOnce[A]): Iterator[A] =
    iter.iterator

  implicit def iterableToGenericSteps[A](iter: IterableOnce[A]): GenericSteps[A] =
    new GenericSteps[A](iter.iterator)

  implicit def gNodeToNodeMethods(node: GNode): NodeMethods =
    new NodeMethods(node)

  implicit def iterableToNodeSteps[A <: GNode](iter: IterableOnce[A]): NodeSteps[A] =
    new NodeSteps[A](iter.iterator)

  implicit def iterableToEdgeSteps[A <: Edge](iter: IterableOnce[A]): EdgeSteps[A] =
    new EdgeSteps[A](iter.iterator)

  implicit def iteratorToNumericSteps[A: Numeric](iter: IterableOnce[A]): NumericSteps[A] =
    new NumericSteps[A](iter)
}

@Traversal(elementType = classOf[AnyRef])
class GenericSteps[A](iterator: Iterator[A]) extends AnyVal {

  /** Execute the traversal and convert the result to a list - shorthand for `toList` */
  @Doc(info = "Execute the traversal and convert the result to a list - shorthand for `toList`")
  def l: List[A] = iterator.toList

  /** group elements and count how often they appear */
  @Doc(info = "group elements and count how often they appear")
  def groupCount[B >: A]: Map[B, Int] =
    groupCount(identity[A])

  /** group elements by a given transformation function and count how often the results appear */
  @Doc(info = "group elements by a given transformation function and count how often the results appear")
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
  @Doc(info = "Execute the traversal without returning anything")
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
  @Doc(info = "casts all elements to given type")
  def cast[B]: Iterator[B] =
    iterator.asInstanceOf[Iterator[B]]

  /** collects all elements of the given class (beware of type-erasure) */
  @Doc(info = "collects all elements of the provided class (beware of type-erasure)")
  def collectAll[B](implicit ev: ClassTag[B]): Iterator[B] =
    iterator.filter(ev.runtimeClass.isInstance).asInstanceOf[Iterator[B]]

  /** Deduplicate elements of this traversal - a.k.a. distinct, unique, ... */
  @Doc(info = "deduplicate elements of this traversal - a.k.a. distinct, unique, ...")
  def dedup: Iterator[A] =
    iterator.distinct

  /** deduplicate elements of this traversal by a given function */
  @Doc(info = "deduplicate elements of this traversal by a given function")
  def dedupBy(fun: A => Any): Iterator[A] =
    iterator.distinctBy(fun)

  /** sort elements by their natural order */
  @Doc(info = "sort elements by their natural order")
  def sorted[B >: A](implicit ord: Ordering[B]): Seq[B] = {
    (iterator.to(ArraySeq.untagged): ArraySeq[B]).sorted
  }

  /** sort elements by the value of the given transformation function */
  @Doc(info = "sort elements by the value of the given transformation function")
  def sortBy[B](f: A => B)(implicit ord: Ordering[B]): Seq[A] =
    iterator.to(ArraySeq.untagged).sortBy(f)

  /** filters out everything that is _not_ the given value */
  @Doc(info = "filters out everything that is _not_ the given value")
  def is[B >: A](value: B): Iterator[A] =
    iterator.filter(_ == value)

  /** filters out all elements that are _not_ in the provided set */
  @Doc(info = "filters out all elements that are _not_ in the provided set")
  def within[B >: A](values: Set[B]): Iterator[A] =
    iterator.filter(values.contains)

  /** filters out all elements that _are_ in the provided set */
  @Doc(info = "filters out all elements that _are_ in the provided set")
  def without[B >: A](values: Set[B]): Iterator[A] =
    iterator.filterNot(values.contains)

  /** perform side effect without changing the contents of the traversal */
  @Doc(info = "perform side effect without changing the contents of the traversal")
  def sideEffect(fun: A => ?): Iterator[A] =
    iterator match {
      case pathAwareTraversal: PathAwareTraversal[?] =>
        pathAwareTraversal.asInstanceOf[PathAwareTraversal[A]]._sideEffect(fun)
      case _ =>
        iterator.map { a =>
          fun(a)
          a
        }
    }

  /** perform side effect without changing the contents of the traversal will only apply the partialFunction if it is defined for the given
    * input - analogous to `collect`
    */
  @Doc(info = "perform side effect without changing the contents of the traversal")
  def sideEffectPF(pf: PartialFunction[A, ?]): Iterator[A] =
    sideEffect(pf.lift)

  /** only preserves elements if the provided traversal has at least one result */
  @Doc(info = "only preserves elements if the provided traversal has at least one result")
  def where(trav: Iterator[A] => Iterator[?]): Iterator[A] =
    iterator.filter { (a: A) =>
      trav(Iterator.single(a)).hasNext
    }

  /** only preserves elements if the provided traversal does _not_ have any results */
  @Doc(info = "only preserves elements if the provided traversal does _not_ have any results")
  def whereNot(trav: Iterator[A] => Iterator[?]): Iterator[A] =
    iterator.filter { (a: A) =>
      !trav(Iterator.single(a)).hasNext
    }

  /** only preserves elements if the provided traversal does _not_ have any results - alias for whereNot */
  @Doc(info = "only preserves elements if the provided traversal does _not_ have any results - alias for whereNot")
  def not(trav: Iterator[A] => Iterator[?]): Iterator[A] =
    whereNot(trav)

  /** only preserves elements for which _at least one of_ the given traversals has at least one result Works for arbitrary amount of 'OR'
    * traversals.
    *
    * @example
    *   {{{.or(_.label("someLabel"), _.has("someProperty"))}}}
    */
  @Doc(info = "only preserves elements for which _at least one of_ the given traversals has at least one result")
  def or(traversals: (Iterator[A] => Iterator[?])*): Iterator[A] = {
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
  @Doc(info = "only preserves elements for which _all of_ the given traversals have at least one result")
  def and(traversals: (Iterator[A] => Iterator[?])*): Iterator[A] = {
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
  @Doc(info = "union/sum/aggregate/join given traversals from the current point")
  def union[B](traversals: (Iterator[A] => Iterator[B])*): Iterator[B] = iterator match {
    case pathAwareTraversal: PathAwareTraversal[?] =>
      pathAwareTraversal.asInstanceOf[PathAwareTraversal[A]]._union(traversals*)
    case _ =>
      iterator.flatMap { (a: A) =>
        traversals.flatMap(_.apply(Iterator.single(a)))
      }
  }

  /** Branch step: based on the current element, match on something given a traversal, and provide resulting traversals based on the matched
    * element. Allows to implement conditional semantics: if, if/else, if/elseif, if/elseif/else, ...
    *
    * @param on
    *   Traversal to get to what you want to match on
    * @tparam BranchOn
    *   required to be >: Null because the implementation is using `null` as the default value. I didn't find a better way to implement all
    *   semantics with the niceties of PartialFunction, and also yolo...
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
  @Doc(info = "allows to implement conditional semantics: if, if/else, if/elseif, if/elseif/else, ...")
  def choose[BranchOn >: Null, NewEnd](
    on: Iterator[A] => Iterator[BranchOn]
  )(options: PartialFunction[BranchOn, Iterator[A] => Iterator[NewEnd]]): Iterator[NewEnd] = iterator match {
    case pathAwareTraversal: PathAwareTraversal[?] =>
      pathAwareTraversal.asInstanceOf[PathAwareTraversal[A]]._choose[BranchOn, NewEnd](on)(options)
    case _ =>
      iterator.flatMap { (a: A) =>
        val branchOnValue: BranchOn = on(Iterator.single(a)).nextOption().getOrElse(null)
        options
          .applyOrElse(branchOnValue, (failState: BranchOn) => ((unused: Iterator[A]) => Iterator.empty[NewEnd]))
          .apply(Iterator.single(a))
      }
  }

  @Doc(info = "evaluates the provided traversals in order and returns the first traversal that emits at least one element")
  def coalesce[NewEnd](options: (Iterator[A] => Iterator[NewEnd])*): Iterator[NewEnd] = iterator match {
    case pathAwareTraversal: PathAwareTraversal[?] =>
      pathAwareTraversal.asInstanceOf[PathAwareTraversal[A]]._coalesce(options*)
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

  @Doc(info = "enable path tracking - prerequisite for path/simplePath steps")
  def enablePathTracking: PathAwareTraversal[A] =
    iterator match {
      case pathAwareTraversal: PathAwareTraversal[_] => throw new RuntimeException("path tracking is already enabled")
      case _                                         => new PathAwareTraversal[A](iterator.map { a => (a, Vector.empty) })
    }

  @Doc(info = "enable path tracking - prerequisite for path/simplePath steps")
  def discardPathTracking: Iterator[A] =
    iterator match {
      case pathAwareTraversal: PathAwareTraversal[?] =>
        pathAwareTraversal.asInstanceOf[PathAwareTraversal[A]].wrapped.map(_._1)
      case _ =>
        iterator
    }

  def isPathTracking: Boolean =
    iterator.isInstanceOf[PathAwareTraversal[?]]

  /** retrieve entire path that has been traversed thus far prerequisite: enablePathTracking has been called previously
    *
    * @example
    *   {{{
    *  myTraversal.enablePathTracking.out.out.path.toList
    *   }}}
    *   TODO would be nice to preserve the types of the elements, at least if they have a common supertype
    */
  @Doc(info = "retrieve entire path that has been traversed thus far")
  def path: Iterator[Vector[Any]] = iterator match {
    case tracked: PathAwareTraversal[?] =>
      tracked.wrapped.map { case (a, p) =>
        p.appended(a)
      }
    case _ =>
      throw new AssertionError(
        "path tracking not enabled, please make sure you have a `PathAwareTraversal`, e.g. via `Traversal.enablePathTracking`"
      )
  } // fixme: I think ClassCastException is the correct result when the user forgot to enable path tracking. But a better error message to go along with it would be nice.

  def simplePath: Iterator[A] = iterator match {
    case tracked: PathAwareTraversal[?] =>
      new PathAwareTraversal(tracked.asInstanceOf[PathAwareTraversal[A]].wrapped.filter { case (a, p) =>
        mutable.Set.from(p).addOne(a).size == 1 + p.size
      })
    case _ =>
      throw new AssertionError(
        "path tracking not enabled, please make sure you have a `PathAwareTraversal`, e.g. via `Traversal.enablePathTracking`"
      )
  }

  /** Repeat the given traversal
    *
    * By default it will continue repeating until there's no more results, not emit anything along the way, and use depth first search.
    *
    * The @param behaviourBuilder allows you to configure end conditions (until|whilst|maxDepth), whether it should emit elements it passes
    * by, and which search algorithm to use (depth-first or breadth-first).
    *
    * Search algorithm: Depth First Search (DFS) vs Breadth First Search (BFS): DFS means the repeat step will go deep before wide. BFS does
    * the opposite: wide before deep. For example, given the graph {{{L3 <- L2 <- L1 <- Center -> R1 -> R2 -> R3 -> R4}}} DFS will iterate
    * the nodes in the order: {{{Center, L1, L2, L3, R1, R2, R3, R4}}} BFS will iterate the nodes in the order:
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
  @Doc(info = "repeat the given traversal")
  def repeat[B >: A](
    repeatTraversal: Iterator[A] => Iterator[B]
  )(implicit behaviourBuilder: RepeatBehaviour.Builder[B] => RepeatBehaviour.Builder[B] = RepeatBehaviour.noop[B]): Iterator[B] = {
    val behaviour = behaviourBuilder(new RepeatBehaviour.Builder[B]).build

    // this cast usually :tm: safe, because `B` is a supertype of `A`
    val _repeatTraversal = repeatTraversal.asInstanceOf[Iterator[B] => Iterator[B]]

    iterator match {
      case tracked: PathAwareTraversal[?] =>
        val step = PathAwareRepeatStep(_repeatTraversal, behaviour)
        new PathAwareTraversal(tracked.asInstanceOf[PathAwareTraversal[A]].wrapped.flatMap { case (a, p) =>
          step.apply(a).wrapped.map { case (aa, pp) => (aa, p ++ pp) }
        })
      case _ =>
        iterator.flatMap(RepeatStep(_repeatTraversal, behaviour))
    }
  }
}

class NodeMethods(node: GNode) extends AnyVal {
  import flatgraph.traversal.language.*

  /** follow _all_ OUT edges to their adjacent nodes */
  def out: Iterator[GNode] =
    Accessors.getNeighborsOut(node)

  /** follow _all_ IN edges to their adjacent nodes */
  def in: Iterator[GNode] =
    Accessors.getNeighborsIn(node)

  /** follow the given OUT edge(s) to their adjacent nodes */
  def out(edgeLabel: String): Iterator[GNode] =
    Accessors.getNeighborsOut(node, edgeKind = edgeKind(edgeLabel))

  /** follow the given IN edge(s) to their adjacent nodes */
  def in(edgeLabel: String): Iterator[GNode] =
    Accessors.getNeighborsIn(node, edgeKind = edgeKind(edgeLabel))

  /** follow _all_ OUT and IN edges to their adjacent nodes */
  def both: Iterator[GNode] =
    out ++ in

  /** follow the given IN and OUT edge(s) to their adjacent nodes */
  @Doc("follow the given OUT and IN edge(s) to their adjacent nodes")
  def both(edgeLabel: String): Iterator[GNode] =
    out(edgeLabel) ++ in(edgeLabel)

  /** follow all OUT edge(s) */
  def outE: Iterator[Edge] =
    Accessors.getEdgesOut(node)

  /** follow all IN edge(s) */
  def inE: Iterator[Edge] =
    Accessors.getEdgesIn(node)

  /** follow the given OUT edge(s) */
  def outE(edgeLabel: String): Iterator[Edge] =
    Accessors.getEdgesOut(node, edgeKind = edgeKind(edgeLabel))

  /** follow the given IN edge(s) */
  def inE(edgeLabel: String): Iterator[Edge] =
    Accessors.getEdgesIn(node, edgeKind = edgeKind(edgeLabel))

  /** follow _all_ OUT and IN edge(s) */
  @Doc("follow all OUT and IN edge(s)")
  def bothE: Iterator[Edge] =
    outE ++ inE

  /** follow the given OUT and IN edge(s) */
  @Doc("follow the given OUT and IN edge(s)")
  def bothE(edgeLabel: String): Iterator[Edge] =
    outE(edgeLabel) ++ inE(edgeLabel)

  // the "property" accessors have somewhat special behavior. They don't throw if the property is not present,
  // and they distinguish whether the property formally exists on the node-type as multi-valued thing.
  // the static info from the propertyKey is ignored.
  // this semantics may or may not be desirable -- but it is what odbv1 does, and these are compat anyway.
  // we don't really want to specialize here -- otherwise we can get nonsense like `null.asInstanceOf[Double]`

  def property[ValueType](propertyKey: SinglePropertyKey[ValueType]): ValueType =
    Accessors.getNodePropertySingle(node.graph, node.nodeKind, propertyKey.kind, node.seq(), propertyKey.default)

  def property[ValueType](propertyKey: OptionalPropertyKey[ValueType]): Option[ValueType] =
    Accessors.getNodePropertyOption(node.graph, node.nodeKind, propertyKey.kind, node.seq())

  def property[ValueType](propertyKey: MultiPropertyKey[ValueType]): IndexedSeq[ValueType] =
    Accessors.getNodePropertyMulti(node.graph, node.nodeKind, propertyKey.kind, node.seq())

  def propertyOption[ValueType](propertyKey: SinglePropertyKey[ValueType]): Option[ValueType] =
    Accessors.getNodePropertyOption(node.graph, node.nodeKind, propertyKey.kind, node.seq())

  def propertyOption[ValueType](propertyKey: OptionalPropertyKey[ValueType]): Option[ValueType] =
    Accessors.getNodePropertyOption(node.graph, node.nodeKind, propertyKey.kind, node.seq())

  // TODO this should rather return `None` for an undefined property, rather than `Some(Seq.empty)`, but we only want
  //  to make that change after joern's transition to flatgraph - see https://github.com/joernio/joern/pull/4382
  def propertyOption[ValueType](propertyKey: MultiPropertyKey[ValueType]): Option[IndexedSeq[ValueType]] =
    Option(Accessors.getNodePropertyMulti(node.graph, node.nodeKind, propertyKey.kind, node.seq()))

  /** lookup property value by name - warning, this may return `null` if property is unset */
  def property[ValueType >: Null](name: String): ValueType =
    propertyOption(name).orNull

  def propertyOption[ValueType](name: String): Option[ValueType] = {
    node.graph.schema.getPropertyKindByName(name) match {
      case Schema.UndefinedKind =>
        None
      case propertyKind =>
        Accessors.getNodePropertyOptionCompat(node, propertyKind).asInstanceOf[Option[ValueType]]
    }
  }

  def propertiesMap: java.util.Map[String, AnyRef] = {
    val ret    = new java.util.HashMap[String, AnyRef]()
    val schema = node.graph.schema
    schema.propertyKinds.foreach { propertyKind =>
      Accessors.getNodePropertyOptionCompat(node, propertyKind).foreach { value =>
        val key = schema.getPropertyLabel(node.nodeKind, propertyKind)
        ret.put(key, value)
      }
    }
    ret
  }

  private def edgeKind(edgeLabel: String): Int =
    node.graph.schema.getEdgeKindByLabel(edgeLabel)
}

@Traversal(elementType = classOf[GNode])
class NodeSteps[A <: GNode](traversal: Iterator[A]) extends AnyVal {
  import flatgraph.traversal.language.*

  /** `id` combines nodeKind and seq into a unique id Mostly for backwards compatibility with overflowdb v1 where nodes have a `id: Long`
    */
  def id: Iterator[Long] =
    traversal.map(_.id())

  /** filter by `id` */
  def id(value: Long): Iterator[A] =
    traversal.filter(_.id() == value)

  /** filter by `id`s */
  def id(values: Long*): Iterator[A] = {
    val valuesSet = values.toSet
    traversal.filter(node => valuesSet.contains(node.id()))
  }

  /** traverse to the node label */
  @Doc(info = "Traverse to the node label")
  def label: Iterator[String] =
    traversal.map(_.label())

  /** filter by the node label */
  def label(value: String): Iterator[A] =
    traversal.filter(_.label() == value)

  /** filter by the node labels */
  def label(values: String*): Iterator[A] = {
    val wanted = values.toSet
    traversal.filter(node => wanted.contains(node.label()))
  }

  /** alias for {{{label}}} */
  def hasLabel(value: String): Iterator[A] =
    label(value)

  /** alias for {{{label}}} */
  def hasLabel(values: String*): Iterator[A] =
    label(values*)

  /** filter by the node label (inverse) */
  def labelNot(value: String): Iterator[A] =
    traversal.filterNot(_.label() == value)

  /** filter by the node labels (inverse) */
  def labelNot(value1: String, valueN: String*): Iterator[A] = {
    val unwanted = (valueN :+ value1).toSet
    traversal.filterNot(node => unwanted.contains(node.label()))
  }

  /** Filter elements by existence of property (irrespective of value) */
  def has(name: String): Iterator[A] =
    traversal.filter(_.propertyOption(name).isDefined)

  /** Filter elements by (non-)existence of property (irrespective of value) */
  def hasNot(name: String): Iterator[A] =
    traversal.filterNot(_.propertyOption(name).isDefined)

  /** Filter elements by property value */
  def has(key: String, value: Any): Iterator[A] = {
    val wrappedValue = Option(value)
    traversal.filter(_.propertyOption(key) == wrappedValue)
  }

  /** Filter elements by property value */
  def hasNot(key: String, value: Any): Iterator[A] = {
    val wrappedValue = Option(value)
    traversal.filterNot(_.propertyOption(key) == wrappedValue)
  }

  /** follow _all_ OUT edges to their adjacent nodes */
  def out: Iterator[GNode] =
    traversal.flatMap(_.out)

  /** follow _all_ IN edges to their adjacent nodes */
  def in: Iterator[GNode] =
    traversal.flatMap(_.in)

  /** follow _all_ OUT and IN edges to their adjacent nodes */
  def both: Iterator[GNode] =
    traversal.flatMap(node => node.out ++ node.in)

  /** follow the given OUT edge(s) to their adjacent nodes */
  @Doc("follow the given OUT edge(s) to their adjacent nodes")
  def out(edgeLabel: String): Iterator[GNode] =
    traversal.flatMap(_.out(edgeLabel))

  /** follow the given IN edge(s) to their adjacent nodes */
  @Doc("follow the given IN edge(s) to their adjacent nodes")
  def in(edgeLabel: String): Iterator[GNode] =
    traversal.flatMap(_.in(edgeLabel))

  /** follow the given IN and OUT edge(s) to their adjacent nodes */
  @Doc("follow the given OUT and IN edge(s) to their adjacent nodes")
  def both(edgeLabel: String): Iterator[GNode] =
    traversal.flatMap(node => node.out(edgeLabel) ++ node.in(edgeLabel))

  /** follow all OUT edge(s) */
  def outE: Iterator[Edge] =
    traversal.flatMap(_.outE)

  /** follow all IN edge(s) */
  def inE: Iterator[Edge] =
    traversal.flatMap(_.inE)

  /** follow the given OUT edge(s) */
  def outE(edgeLabel: String): Iterator[Edge] =
    traversal.flatMap(_.outE(edgeLabel))

  /** follow the given IN edge(s) */
  def inE(edgeLabel: String): Iterator[Edge] =
    traversal.flatMap(_.inE(edgeLabel))

  /** follow _all_ IN and OUT edge(s) */
  @Doc("follow all given OUT and IN edge(s)")
  def bothE: Iterator[Edge] =
    traversal.flatMap(node => node.outE ++ node.inE)

  /** follow the given IN and OUT edge(s) */
  @Doc("follow the given OUT and IN edge(s)")
  def bothE(edgeLabel: String): Iterator[Edge] =
    traversal.flatMap(node => node.outE(edgeLabel) ++ node.inE(edgeLabel))

  @Doc("lookup a property value")
  def property[@specialized T](name: String): Iterator[T] =
    traversal.flatMap(_.propertyOption[T](name))

  def property[@specialized ValueType](propertyKey: PropertyKey[ValueType, ?]): Iterator[ValueType] =
    propertyKey match {
      case propertyKey: SinglePropertyKey[_]   => property(propertyKey)
      case propertyKey: OptionalPropertyKey[_] => property(propertyKey)
      case propertyKey: MultiPropertyKey[_]    => property(propertyKey)
    }

  def property[@specialized ValueType](propertyKey: SinglePropertyKey[ValueType]): Iterator[ValueType] =
    traversal.map(_.property(propertyKey))

  def property[@specialized ValueType](propertyKey: OptionalPropertyKey[ValueType]): Iterator[ValueType] =
    traversal.flatMap(_.property(propertyKey))

  def property[@specialized ValueType](propertyKey: MultiPropertyKey[ValueType]): Iterator[ValueType] =
    traversal.flatMap(_.property(propertyKey))

  def propertiesMap: Iterator[java.util.Map[String, AnyRef]] =
    traversal.map(_.propertiesMap)
}

@Traversal(elementType = classOf[Edge])
class EdgeSteps[A <: Edge](traversal: Iterator[A]) extends AnyVal {

  /** traverse to source node: [A] --- edge --> B
    */
  def src: Iterator[GNode] =
    traversal.map(_.src)

  /** traverse to destination node A --- edge --> [B] */
  def dst: Iterator[GNode] =
    traversal.map(_.dst)

}
