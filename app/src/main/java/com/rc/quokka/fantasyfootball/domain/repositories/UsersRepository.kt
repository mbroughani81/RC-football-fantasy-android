package com.rc.quokka.fantasyfootball.domain.repositories

import com.rc.quokka.fantasyfootball.domain.model.*
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    suspend fun signupUser(data: SignupData): Result<SignupVerdict>
    suspend fun signinUser(data: SigninData): Result<SigninVerdict>
    suspend fun confirmCode(data: ConfirmCodeData): Result<ConfirmCodeVerdict>
}
