package com.rc.quokka.fantasyfootball.data.datasources

import android.util.Log
import com.rc.quokka.fantasyfootball.data.mappers.PlayerMapper
import com.rc.quokka.fantasyfootball.data.mappers.UserPlayerMapper
import com.rc.quokka.fantasyfootball.domain.model.Player
import com.rc.quokka.fantasyfootball.domain.model.PlayerRole
import com.rc.quokka.fantasyfootball.domain.model.Post
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL =
    "http://192.168.43.41:3000"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface PlayerApiService {
    @GET("/player/all")
    suspend fun getPlayers(): List<PlayerDto>

    @GET("user/add_player")
    suspend fun addPlayer(@Query("playerId") playerId: Int, @Query("squadPlace") squadPlace: Int)

    @GET("user/remove_player")
    suspend fun removePlayer(@Query("squadPlace") squadPlace: Int)

    @GET("user/get_players")
    suspend fun getUserPlayers(): List<UserPlayerDto>

    @GET("user/get_remaining_money")
    suspend fun getUserMoney(): Int

    @GET()
    suspend fun getWeekInfo()

}

object FantasyFootballPlayersApi {
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

data class UserPlayerDto(
    val playerId: String,
    val firstName: String,
    val lastName: String,
    val webName: String,
    val photo: String,
    val positionId: Int,
    val squadPlace: Int,
    val teamId: Int,
    val price: Float,
    val score: Int
)

class PlayersApiDataSource {
    suspend fun getPlayers(): List<Player> {
        val mapper = PlayerMapper()
        try {
            return FantasyFootballPlayersApi.retrofitService.getPlayers().map { mapper.toDomain(it) }
        } catch (e: Exception) {
            Log.d("PlayersApiDataSource", e.toString())
            return emptyList()
        }
    }

    suspend fun getUserMoney(): Int {
        try {
            return FantasyFootballPlayersApi.retrofitService.getUserMoney()
        } catch (e: Exception) {
            return 0
        }
    }

    suspend fun getUserPosts(): List<Post> {
        val mapper = UserPlayerMapper()
        try {
            return FantasyFootballPlayersApi.retrofitService.getUserPlayers().map { mapper.toDomain(it) }
        } catch (e: Exception) {
            Log.d("PlayersApiDataSource", e.toString())
            return emptyList()
        }
    }

    suspend fun addPlayer(post: Post, player: Player) {
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
                playerId = player.id.toInt(),
                squadPlace = squadPlace
            )
        } catch (e: Exception) {

        }
    }

    suspend fun removePlayer(post: Post) {
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
            FantasyFootballPlayersApi.retrofitService.removePlayer(squadPlace)
        } catch (e: Exception) {

        }
    }
}
