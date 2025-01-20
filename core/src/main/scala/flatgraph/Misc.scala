package flatgraph

import java.util.concurrent

object Misc {

  @volatile var _overrideExecutor: concurrent.ExecutorService => concurrent.ExecutorService = defaultExecutorProvider

  def force_singlethreaded(): Unit = {
    // this one is magic -- it can get garbage collected, no manual shutdown required!
    this._overrideExecutor = (something: concurrent.ExecutorService) => concurrent.Executors.newSingleThreadExecutor()
  }

  def defaultExecutorProvider(current: concurrent.ExecutorService): concurrent.ExecutorService = {
    current match {
      case null =>
        java.lang.Thread.currentThread() match {
          case fjt: concurrent.ForkJoinWorkerThread => fjt.getPool
          case _                                    => concurrent.ForkJoinPool.commonPool()
        }
      case explicit: concurrent.ExecutorService => explicit
    }
  }

  def maybeOverrideExecutor(current: concurrent.ExecutorService): concurrent.ExecutorService = this._overrideExecutor.apply(current)
}
