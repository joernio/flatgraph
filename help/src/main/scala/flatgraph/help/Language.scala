package flatgraph.help

import Table.AvailableWidthProvider

import scala.annotation.implicitNotFound
import scala.reflect.ClassTag

object language extends language

trait language {
  implicit def iterableToHelpSteps[A](iter: IterableOnce[A]): HelpSteps[A] =
    new HelpSteps[A](iter.iterator)
}

@Traversal(elementType = classOf[AnyRef])
class HelpSteps[A](iterator: Iterator[A]) extends AnyVal {

  /** Print help/documentation based on the current elementType `A`. Relies on all step extensions being annotated with \@Traversal / @Doc
    * Note that this works independently of tab completion and implicit conversions in scope - it will simply list all documented steps in
    * the classpath
    */
  @Doc(info = "print help/documentation based on the current elementType `A`.")
  @implicitNotFound("""If you're using flatgraph purely without a schema and associated generated domain classes, you can
      |start with `given DocSearchPackages = DocSearchPackages.default`.
      |If you have generated domain classes, use `given DocSearchPackages = MyDomain.defaultDocSearchPackage`.
      |If you have additional custom extension steps that specify help texts via @Doc annotations, use `given DocSearchPackages = MyDomain.defaultDocSearchPackage.withAdditionalPackage("my.custom.package)"`
      |""".stripMargin)
  def help[B >: A](implicit
    elementType: ClassTag[B],
    searchPackages: DocSearchPackages,
    availableWidthProvider: AvailableWidthProvider
  ): String =
    new TraversalHelp(searchPackages).forElementSpecificSteps(elementType.runtimeClass, verbose = false)

  @Doc(info = "print verbose help/documentation based on the current elementType `A`.")
  @implicitNotFound("""If you're using flatgraph purely without a schema and associated generated domain classes, you can
      |start with `given DocSearchPackages = DocSearchPackages.default`.
      |If you have generated domain classes, use `given DocSearchPackages = MyDomain.defaultDocSearchPackage`.
      |If you have additional custom extension steps that specify help texts via @Doc annotations, use `given DocSearchPackages = MyDomain.defaultDocSearchPackage.withAdditionalPackage("my.custom.package)"`
      |""".stripMargin)
  def helpVerbose[B >: A](implicit
    elementType: ClassTag[B],
    searchPackages: DocSearchPackages,
    availableWidthProvider: AvailableWidthProvider
  ): String =
    new TraversalHelp(searchPackages).forElementSpecificSteps(elementType.runtimeClass, verbose = true)

}
