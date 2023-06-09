package com.rc.quokka.fantasyfootball.data.datasources

import android.util.Log
import com.rc.quokka.fantasyfootball.data.auth.FantasyToken
import com.rc.quokka.fantasyfootball.data.mappers.PlayerMapper
import com.rc.quokka.fantasyfootball.data.mappers.UserPlayerMapper
import com.rc.quokka.fantasyfootball.domain.model.*
import com.squareup.moshi.Json
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

private const val BASE_URL =
    "http://178.216.248.36:8000"
//    "http://192.168.203.35:3000"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface PlayerApiService {
    @GET("/player/all")
    suspend fun getPlayers(
        @Header("Authorization") token: String,
        @Query("limit") limit: Int,
        @Query("page") page: Int
    ): List<PlayerDto>

    @POST("user/add-player")
//    @POST("checkbody")
    suspend fun addPlayer(
        @Header("Authorization") token: String,
        @Body data: AddPlayerDataDto
    )

    @POST("user/remove-player")
    suspend fun removePlayer(
        @Header("Authorization") token: String,
        @Body data: DeletePlayerDataDto
    )

    @GET("user/get-players")
    suspend fun getUserPlayers(@Header("Authorization") token: String): List<UserPlayerDto>

    @GET("user/get-wallet")
    suspend fun getUserMoney(@Header("Authorization") token: String): Map<String, String>

    @GET("user/players-info")
    suspend fun getUserPlayersInfo(@Header("Authorization")token: String): UserPlayerCountDto

    @GET()
    suspend fun getWeekInfo()

}

object FantasyFootballPlayersApi {
    val retrofitService: PlayerApiService by lazy {
        retrofit.create(PlayerApiService::class.java)
    }
}

data class UserPlayerCountDto (
    @Json(name = "selected_players_count") val selectedPlayersCount: Int,
    @Json(name = "max_players_count") val maxPlayersCount: Int
    )

data class AddPlayerDataDto(
    @Json(name = "playerId") val playerId: Int,
    @Json(name = "squadPlace") val squadPlace: String
)

data class DeletePlayerDataDto(
    @Json(name = "playerId") val playerId: Int,
    @Json(name = "squadPlace") val squadPlace: String
)

data class PlayerDto(
    @Json(name = "player_id") val playerId: String,
    @Json(name = "first_name") val firstName: String,
    @Json(name = "last_name") val lastName: String,
    @Json(name = "web_name") val webName: String,
    @Json(name = "photo") val photo: String,
    @Json(name = "position_id") val positionId: Int,
    @Json(name = "team_id") val teamId: Int,
    @Json(name = "price") val price: Float,
    @Json(name = "score") val score: Int
)

data class UserPlayerDto(
    @Json(name = "player_id") val playerId: String,
    @Json(name = "first_name") val firstName: String,
    @Json(name = "last_name") val lastName: String,
    @Json(name = "web_name") val webName: String,
    @Json(name = "photo") val photo: String,
    @Json(name = "position_id") val positionId: Int,
    @Json(name = "squad_place") val squadPlace: Int,
    @Json(name = "team_id") val teamId: Int,
    @Json(name = "price") val price: Float,
    @Json(name = "score") val score: Int
)

class PlayersApiDataSource {
    suspend fun getPlayers(token: Token, getPlayerData: GetPlayerData): List<Player> {
        val mapper = PlayerMapper()
        try {
            return FantasyFootballPlayersApi.retrofitService.getPlayers(
                "Bearer ${token.token}",
                page = getPlayerData.pageNumber,
                limit = getPlayerData.limit
            )
                .map { mapper.toDomain(it) }
        } catch (e: Exception) {
            Log.d("PlayersApiDataSource", e.toString())
            return emptyList()
        }
    }

    suspend fun getUserPlayersInfo(token: Token): UserPlayerCountDto {
        try {
            val userPlayerCountDto = FantasyFootballPlayersApi.retrofitService.getUserPlayersInfo("Bearer ${token.token}")
//            val mp = FantasyFootballPlayersApi.retrofitService.getUserPlayersInfo("Bearer ${token.token}")
//            return mp.get("remaining_player")!!
            return userPlayerCountDto
        } catch (e: Exception) {
//            Log.d("try", e.toString())
//            return "0"
            return UserPlayerCountDto(0, 0)
        }
    }

    suspend fun getUserMoney(token: Token): String {
        try {
            val mp = FantasyFootballPlayersApi.retrofitService.getUserMoney("Bearer ${token.token}")
            return mp.get("wallet")!!
        } catch (e: Exception) {
            Log.d("getUserMoney", e.toString())
            return "0"
        }
    }

    suspend fun getUserPosts(token: Token): List<Post> {
        val mapper = UserPlayerMapper()
        try {
            return FantasyFootballPlayersApi.retrofitService.getUserPlayers("Bearer ${token.token}")
                .map { mapper.toDomain(it) }
        } catch (e: Exception) {
            Log.d("PlayersApiDataSource", e.toString())
            return emptyList()
        }
    }

    suspend fun addPlayer(token: Token, post: Post, player: Player) {
        try {
            val squadPlace = when (post.player.role) {
                PlayerRole.GoalKeeper -> {
                    post.pos
                }
                PlayerRole.Defender -> {
                    post.pos + 2
                }
                PlayerRole.Midfielder -> {
                    post.pos + 7
                }
                PlayerRole.Attacker -> {
                    post.pos + 12
                }
            }
            FantasyFootballPlayersApi.retrofitService.addPlayer(
                "Bearer ${token.token}",
                AddPlayerDataDto(player.id.toInt(), squadPlace.toString())
            )
        } catch (e: Exception) {
        }
    }

    suspend fun removePlayer(token: Token, post: Post) {
        try {
            val squadPlace = when (post.player.role) {
                PlayerRole.GoalKeeper -> {
                    post.pos
                }
                PlayerRole.Defender -> {
                    post.pos + 2
                }
                PlayerRole.Midfielder -> {
                    post.pos + 7
                }
                PlayerRole.Attacker -> {
                    post.pos + 12
                }
            }
            FantasyFootballPlayersApi.retrofitService.removePlayer(
                token = "Bearer ${token.token}",
                DeletePlayerDataDto(post.player.id.toInt(), squadPlace.toString())
            )
        } catch (e: Exception) {
        }
    }
}
