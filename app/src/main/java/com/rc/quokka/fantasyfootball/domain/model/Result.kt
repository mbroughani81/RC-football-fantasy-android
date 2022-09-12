package com.rc.quokka.fantasyfootball.domain.model

import androidx.compose.runtime.snapshots.SnapshotApplyResult

import com.rc.quokka.fantasyfootball.domain.model.Result.Success
import com.rc.quokka.fantasyfootball.domain.model.Result.Error

sealed class Result<out R> {
    data class Success<out T>(val value: T) : Result<T>()
    data class Error(val cause: Throwable) : Result<Nothing>()
}

inline fun <T> Result(block: () -> T): Result<T> = try {
    Success(block())
} catch (t: Throwable) {
    Error(t)
}

fun <T> Result<T>.requireValue(): T = when (this) {
    is Success -> value
    is Error -> throw cause
}
