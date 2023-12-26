package kr.dagger.nuyhoostmdb.core.domain.usecase.base

abstract class BaseUseCaseSuspend<in Params, out T> {

	abstract suspend fun execute(params: Params): T
}