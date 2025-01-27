package flatgraph.misc

import java.util.concurrent

object Misc {

  @volatile var _overrideExecutor: Option[concurrent.ExecutorService] => concurrent.ExecutorService = defaultExecutorProvider

  def force_singlethreaded(): Unit = {
    // This one is magic -- it can get garbage collected, no manual shutdown required!
    // Unfortunately this behavior is apparently not documented officially :(
    // But that is the behavior on java8 and java23 and, presumably, everywhere we care about:
    // https://github.com/openjdk/jdk8u/blob/1a6e3a5ea32d5c671cb46a590046f16426089921/jdk/src/share/classes/java/util/concurrent/Executors.java#L170
    // https://github.com/openjdk/jdk23u/blob/9101cc14972ce6bdeb966e67bcacc8b693c37d0a/src/java.base/share/classes/java/util/concurrent/Executors.java#L192
    this._overrideExecutor = (something: Option[concurrent.ExecutorService]) => concurrent.Executors.newSingleThreadExecutor()
  }

  def defaultExecutorProvider(requested: Option[concurrent.ExecutorService]): concurrent.ExecutorService = requested.getOrElse {
    java.lang.Thread.currentThread() match {
      case fjt: concurrent.ForkJoinWorkerThread => fjt.getPool
      case _                                    => concurrent.ForkJoinPool.commonPool()
    }
  }

  def maybeOverrideExecutor(requested: Option[concurrent.ExecutorService]): concurrent.ExecutorService =
    this._overrideExecutor.apply(requested)
}
