package flatgraph

import java.util.concurrent

object Misc {

  @volatile var _overrideExecutor: Option[concurrent.ExecutorService] => concurrent.ExecutorService = defaultExecutorProvider

  def force_singlethreaded(): Unit = {
    // this one is magic -- it can get garbage collected, no manual shutdown required!
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
