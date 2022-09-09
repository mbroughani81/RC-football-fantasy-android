package com.rc.quokka.fantasyfootball.domain.repositories

import com.rc.quokka.fantasyfootball.domain.model.*

interface UsersRepository {
    suspend fun signupUser(data: SignupData): Result<SignupVerdict>
    suspend fun signinUser(data: SigninData): Result<SigninVerdict>
}
