package com.rc.quokka.fantasyfootball.domain.model

data class SignupData(
    val firstName: String,
    val lastName: String,
    val email: String,
    val country: String,
    val username: String,
    val password: String
)

data class SigninData(
    val username: String,
    val password: String
)

data class ConfirmCodeData(
    val code: String
)

sealed class SigninVerdict {
    data class SigninSuccessful(val token: Token) : SigninVerdict()
    data class SigninFailed(val error: String) : SigninVerdict()
}

sealed class SignupVerdict {
    object SignupSuccessful : SignupVerdict()
    data class SignupFailed(val error: String) : SignupVerdict()
}