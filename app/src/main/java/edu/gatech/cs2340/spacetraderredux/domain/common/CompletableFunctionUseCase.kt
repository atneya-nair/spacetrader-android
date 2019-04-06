package edu.gatech.cs2340.spacetraderredux.domain.common

import io.reactivex.*
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function

abstract class CompletableFunctionUseCase<T, in SingleParams, in FunctionParams>(
        private val subscribeScheduler: Scheduler,
        private val postExecutionScheduler: Scheduler) {

    private val disposables: CompositeDisposable = CompositeDisposable()

    abstract fun buildUseCaseSingle(params: SingleParams?): Single<T>

    abstract fun transform(t: T, params: FunctionParams?): T

    abstract fun buildOnCompletableSuccess(t: T): Completable

    fun execute(observer: CompletableObserver, sparams: SingleParams? = null,
                fparams: FunctionParams? = null) {
        val observable: Completable = this.buildUseCaseSingle(sparams)
                .subscribeOn(subscribeScheduler)
                .map { t -> transform(t, fparams)}
                .flatMapCompletable { t -> buildOnCompletableSuccess(t) }
                .observeOn(postExecutionScheduler)

        (observable.subscribeWith(observer) as? Disposable)?.let {
            disposables.add(it)
        }
    }
    fun dispose() {
        disposables.clear()
    }
}