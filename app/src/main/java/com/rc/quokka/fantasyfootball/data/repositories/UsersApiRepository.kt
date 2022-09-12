package com.rc.quokka.fantasyfootball.data.repositories

import android.util.Log
import com.rc.quokka.fantasyfootball.data.auth.FantasyToken
import com.rc.quokka.fantasyfootball.data.datasources.ConfirmCodeResponse
import com.rc.quokka.fantasyfootball.data.datasources.SigninResponse
import com.rc.quokka.fantasyfootball.data.datasources.SignupResponse
import com.rc.quokka.fantasyfootball.data.datasources.UsersApiDataSource
import com.rc.quokka.fantasyfootball.domain.model.*
import com.rc.quokka.fantasyfootball.domain.repositories.UsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class UsersApiRepository(val usersApiDataSource: UsersApiDataSource = UsersApiDataSource()) :
    UsersRepository {
    override suspend fun signupUser(data: SignupData): Result<SignupVerdict> =
        withContext(Dispatchers.IO) {
            val response = usersApiDataSource.signup(data = data)

            when (response) {
                is SignupResponse.SignupResponseSuccessful -> {
                    Log.d("SignupResponse", "successful")
                    Result.Success(SignupVerdict.SignupSuccessful)
                }
                is SignupResponse.SignupResponseUnsuccessful -> {
                    Log.d("SignupResponse", "failed")
                    Result.Success(SignupVerdict.SignupFailed(response.error))
                }
            }
        }

    override suspend fun signinUser(data: SigninData): Result<SigninVerdict> =
        withContext(Dispatchers.IO) {
            val response = usersApiDataSource.login(data = data)
            when (response) {
                is SigninResponse.SigninResponseSuccessful -> {
                    val token = Token(response.token)
                    FantasyToken.token = token
                    Result.Success(SigninVerdict.SigninSuccessful(token))
                }
                is SigninResponse.SigninResponseUnsuccessful -> {
                    Result.Success(SigninVerdict.SigninFailed(response.error))
                }
            }
        }

    override suspend fun confirmCode(data: ConfirmCodeData): Result<ConfirmCodeVerdict> =
        withContext(Dispatchers.IO) {
            val response = usersApiDataSource.confirm(data = data)
            when(response) {
                is ConfirmCodeResponse.ConfirmCodeResponseSuccessful -> {
                    Result.Success(ConfirmCodeVerdict.ConfirmCodeSuccessful)
                }
                is ConfirmCodeResponse.ConfirmCodeResponseUnsuccessful -> {
                    Result.Success(ConfirmCodeVerdict.ConfirmCodeFailed("-1"))
                }
            }
        }
}