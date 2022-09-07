package com.rc.quokka.fantasyfootball.data.datasources

import com.rc.quokka.fantasyfootball.data.mappers.PlayerMapper
import com.rc.quokka.fantasyfootball.domain.model.Player
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL =
    "http://192.168.43.104:8080"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface PlayerApiService {
    @GET("player/all")
    suspend fun getPlayers(): List<PlayerDto>
}

object FantasyFootballApi {
    val retrofitService: PlayerApiService by lazy {
        retrofit.create(PlayerApiService::class.java)
    }
}

data class PlayerDto(
    val playerId: String,
    val firstName: String,
    val lastName: String,
    val webName: String,
    val photo: String,
    val positionId: Int,
    val teamId: Int,
    val price: Float,
    val score: Int
)

class PlayersApiDataSource {
    suspend fun getPlayers(): List<Player> {
        val mapper = PlayerMapper()
        return FantasyFootballApi.retrofitService.getPlayers().map{ mapper.toDomain(it) }
    }
}