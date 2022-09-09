package com.rc.quokka.fantasyfootball.data.repositories

import com.rc.quokka.fantasyfootball.domain.model.*
import com.rc.quokka.fantasyfootball.domain.repositories.UsersRepository
import kotlinx.coroutines.delay

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

    //    override suspend fun signupUser(data: SignupData): Result<SignupResponse> {
//        delay(2000L)
//        if (data.username == "mb") {
//            return Result.Success(SignupResponse.SignupError("username is taken"))
//        } else {
//            return Result.Success(SignupResponse.SignupSuccessful)
//        }
//    }
//
//    override suspend fun signinUser(data: SigninData): Result<SigninResponse> {
//        appUsers.forEach {
//            delay(500)
//            if (it.first == data.username && it.second == data.password) {
//                return Result.Success(SigninResponse.SigninSuccessful(User(it.first)))
//            }
//        }
//        return Result.Success(SigninResponse.SigninError("user not fount"))
//    }
//
//    override suspend fun confirmCode(data: ConfirmCodeData): Result<ConfirmResponse> {
//        delay(2000L)
//        if (data.code != "1234") {
//            return Result.Success(ConfirmResponse.ConfirmError)
//        } else {
//            return Result.Success(ConfirmResponse.ConfirmSuccessful)
//        }
//    }
//
//    override suspend fun getCurrentUser(): Result<User> {
//        delay(2000L)
//        return Result.Success(User(username = "mb"))
//    }
}