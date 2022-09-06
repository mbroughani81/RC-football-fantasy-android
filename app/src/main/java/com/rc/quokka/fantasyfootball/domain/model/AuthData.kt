package com.rc.quokka.fantasyfootball.domain.model

data class SignupData(
    val firstName: String,
    val latName: String,
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

sealed class SignupResponse {
    object SignupSuccessful : SignupResponse()
    data class SignupError(val message: String) : SignupResponse()
}

sealed class SigninResponse {
    data class SigninSuccessful(val user: User) : SigninResponse()
    data class SigninError(val message: String) : SigninResponse()
}

sealed class ConfirmResponse {
    object ConfirmSuccessful : ConfirmResponse()
    object ConfirmError : ConfirmResponse()
}
