package com.rc.quokka.fantasyfootball.data.datasources

import android.util.Log
import com.rc.quokka.fantasyfootball.domain.model.SigninData
import com.rc.quokka.fantasyfootball.domain.model.SigninVerdict
import com.rc.quokka.fantasyfootball.domain.model.SignupData
import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.json.JSONObject
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

private const val BASE_URL =
    "http://178.216.248.36:8001"
//    "http://192.168.1.103:3000"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface UserApiService {
    @POST("user/login")
    suspend fun login(@Body data: SigninDataDto): Map<String, String>

    @POST("user/signup")
    suspend fun signup(@Body data: SignupDataDto): Map<String, String>
}

data class SigninDataDto(val username: String, val password: String)

data class SignupDataDto(
    val username: String,
    val password: String,
    val fullname: String,
    val email: String,
    val birthday: String
)

sealed class SigninResponse {
    data class SigninResponseSuccessful(val token: String) : SigninResponse()
    data class SigninResponseUnsuccessful(val error: String) : SigninResponse()
}

sealed class SignupResponse {
    object SignupResponseSuccessful : SignupResponse()
    data class SignupResponseUnsuccessful(val error: String) : SignupResponse()
}

object FantasyFootballUsersApi {
    val retrofitService: UserApiService by lazy {
        retrofit.create(UserApiService::class.java)
    }
}

class UsersApiDataSource {
    suspend fun signup(data: SignupData): SignupResponse {
        try {
            val mp = FantasyFootballUsersApi.retrofitService.signup(
                SignupDataDto(
                    username = data.username,
                    password = data.password,
                    fullname = data.firstName + " " + data.lastName,
                    email = data.email,
                    birthday = ""
                )
            )
            Log.d("signup", mp.toString())
            return SignupResponse.SignupResponseSuccessful
        } catch (e: Exception) {
            return SignupResponse.SignupResponseUnsuccessful("-1")
        }
    }

    suspend fun login(data: SigninData): SigninResponse {
        try {
            val mp = FantasyFootballUsersApi.retrofitService.login(
                SigninDataDto(
                    data.username,
                    data.password
                )
            )
            Log.d("login", mp.toString())
            return SigninResponse.SigninResponseSuccessful(mp.get("token")!!)
        } catch (e: Exception) {
            return SigninResponse.SigninResponseUnsuccessful("-1")
        }
    }
}