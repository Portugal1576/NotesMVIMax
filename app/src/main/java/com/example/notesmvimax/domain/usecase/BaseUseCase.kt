package com.example.notesmvimax.domain.usecase

abstract class BaseUseCase<T> {
    abstract suspend fun invoke(): T
}