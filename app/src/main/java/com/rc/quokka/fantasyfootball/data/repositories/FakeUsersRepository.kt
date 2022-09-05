package com.rc.quokka.fantasyfootball.data.repositories

import com.rc.quokka.fantasyfootball.domain.model.*
import com.rc.quokka.fantasyfootball.domain.repositories.UsersRepository
import kotlinx.coroutines.delay

class FakeUsersRepository : UsersRepository {
    override suspend fun signupUser(data: SignupData): Result<SignupResponse> {
        delay(2000L)
        if (data.username == "mb") {
            return Result.success(SignupResponse.SignupError("username is taken"))
        } else {
            return Result.success(SignupResponse.SignupSuccessful)
        }
    }

    override suspend fun signinUser(data: SigninData): Result<SigninResponse> {
        delay(2000L)
        if (data.password != "1381") {
            return Result.success(SigninResponse.SigninError("username is taken"))
        } else {
            return Result.success(SigninResponse.SigninSuccessful(User(username = "mb")))
        }
    }

    override suspend fun confirmCode(data: ConfirmCodeData): Result<ConfirmResponse> {
        delay(2000L)
        if (data.code != "1234") {
            return Result.success(ConfirmResponse.ConfirmError)
        } else {
            return Result.success(ConfirmResponse.ConfirmSuccessful)
        }
    }

    override suspend fun getCurrentUser(): Result<User> {
        delay(2000L)
        return Result.success(User(username = "mb"))
    }
}