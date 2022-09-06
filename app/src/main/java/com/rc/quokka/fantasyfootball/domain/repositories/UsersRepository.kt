package com.rc.quokka.fantasyfootball.domain.repositories

import com.rc.quokka.fantasyfootball.domain.model.*

interface UsersRepository {
    suspend fun signupUser(data: SignupData): Result<SignupResponse>
    suspend fun signinUser(data: SigninData): Result<SigninResponse>
    suspend fun confirmCode(data: ConfirmCodeData): Result<ConfirmResponse>
    suspend fun getCurrentUser(): Result<User>
}
