package com.rc.quokka.fantasyfootball.data.repositories

import com.rc.quokka.fantasyfootball.domain.model.*
import com.rc.quokka.fantasyfootball.domain.repositories.UsersRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow

val appUsers: List<Pair<String, String>> =
    listOf(Pair("a1", "p1"), Pair("a2", "p2"), Pair("a3", "p3"))

class FakeUsersRepository : UsersRepository {
    override suspend fun signupUser(data: SignupData): Result<SignupVerdict> {
        TODO("Not yet implemented")
    }

    override suspend fun signinUser(data: SigninData): Result<SigninVerdict> {
        appUsers.forEach {
            delay(500)
            if (it.first == data.username && it.second == data.password) {
                return Result.Success(SigninVerdict.SigninSuccessful(Token("1234")))
            }
        }
        return Result.Success(SigninVerdict.SigninFailed("user not fount"))
    }

    override suspend fun confirmCode(data: ConfirmCodeData): Result<ConfirmCodeVerdict> {
        TODO("Not yet implemented")
    }
}