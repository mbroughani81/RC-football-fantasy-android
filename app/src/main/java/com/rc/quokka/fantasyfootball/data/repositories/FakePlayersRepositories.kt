package com.rc.quokka.fantasyfootball.data.repositories

import android.util.Log
import com.rc.quokka.fantasyfootball.domain.model.*
import com.rc.quokka.fantasyfootball.domain.repositories.PlayersRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

class FakePlayersRepositories : PlayersRepository {

    var userPosts = MutableStateFlow(listOf<Post>())

    init {
        userPosts.value = fakeUsersPostsList
    }

    override suspend fun getPlayers(getPlayerData: GetPlayerData): List<Player> {
        delay(3000)
        Log.d("FakePlayersRepositories", "HERE")
        return fakeAllPlayers
    }


    override suspend fun clearPost(post: Post) {
        delay(3000)
        val newPostsList: List<Post> = userPosts.value.map { it ->
            var res: Post = it
            if (it.player.id == post.player.id) {
                if (post.player.role == PlayerRole.GoalKeeper) {
                    res = Post(it.pos, NoGKPlayer)
                }
                if (post.player.role == PlayerRole.Defender) {
                    res = Post(it.pos, NoDEFPlayer)
                }
                if (post.player.role == PlayerRole.Midfielder) {
                    res = Post(it.pos, NoMIDPlayer)
                }
                if (post.player.role == PlayerRole.Attacker) {
                    res = Post(it.pos, NoATTPlayer)
                }
            }
            res
        }

        userPosts.value = newPostsList
    }

    override suspend fun fillPost(post: Post, player: Player) {
        delay(3000)

        val newPostsList = userPosts.value.map {
            if (it == post) {
                Post(it.pos, player)
            } else {
                it
            }
        }

        userPosts.value = newPostsList
    }

    override suspend fun observerUserPosts(): Flow<List<Post>> = userPosts
    override suspend fun observerUserMoney(): Flow<String> {
        TODO("Not yet implemented")
    }

    override suspend fun observerUserRemainingPlayersCount(): Flow<String> {
        TODO("Not yet implemented")
    }
}

private val fakeAllPlayers: List<Player> =
    listOf(
        Player("gk1", "gk1", PlayerRole.GoalKeeper, 0, 0f),
        Player("gk2", "gk2", PlayerRole.GoalKeeper, 0, 0f),
        Player("gk3", "gk3", PlayerRole.GoalKeeper, 0, 0f),
        Player("gk4", "gk4", PlayerRole.GoalKeeper, 0, 0f),
        Player("gk5", "gk5", PlayerRole.GoalKeeper, 0, 0f),
        Player("gk6", "gk6", PlayerRole.GoalKeeper, 0, 0f),
        Player("def1", "def1", PlayerRole.Defender, 0, 0f),
        Player("def2", "def2", PlayerRole.Defender, 0, 0f),
        Player("def3", "def3", PlayerRole.Defender, 0, 0f),
        Player("def4", "def4", PlayerRole.Defender, 0, 0f),
        Player("def5", "def5", PlayerRole.Defender, 0, 0f),
        Player("mid1", "mid1", PlayerRole.Midfielder, 0, 0f),
        Player("mid2", "mid2", PlayerRole.Midfielder, 0, 0f),
        Player("mid3", "mid3", PlayerRole.Midfielder, 0, 0f),
        Player("mid4", "mid4", PlayerRole.Midfielder, 0, 0f),
        Player("mid5", "mid5", PlayerRole.Midfielder, 0, 0f),
        Player("att1", "att1", PlayerRole.Attacker, 0, 0f),
        Player("att2", "att2", PlayerRole.Attacker, 0, 0f),
        Player("att3", "att3", PlayerRole.Attacker, 0, 0f),
        Player("att4", "att4", PlayerRole.Attacker, 0, 0f),
    )

private val fakeUsersPostsList = mutableListOf(
    Post(pos = 1, player = Player("gk1", "gk1", PlayerRole.GoalKeeper, 0, 0f)),
    Post(pos = 2, player = NoGKPlayer),
    Post(pos = 1, player = Player("def1", "def1", PlayerRole.Defender, 0, 0f)),
    Post(pos = 2, player = Player("def2", "def2", PlayerRole.Defender, 0, 0f)),
    Post(pos = 3, player = NoDEFPlayer),
    Post(pos = 4, player = Player("def3", "def3", PlayerRole.Defender, 0, 0f)),
    Post(pos = 5, player = NoDEFPlayer),
    Post(pos = 1, player = Player("mid1", "mid1", PlayerRole.Midfielder, 0, 0f)),
    Post(pos = 2, player = Player("mid2", "mid2", PlayerRole.Midfielder, 0, 0f)),
    Post(pos = 3, player = NoMIDPlayer),
    Post(pos = 4, player = Player("mid3", "mid3", PlayerRole.Midfielder, 0, 0f)),
    Post(pos = 5, player = NoMIDPlayer),
    Post(pos = 1, player = Player("att1", "att1", PlayerRole.Attacker, 0, 0f)),
    Post(pos = 2, player = NoATTPlayer),
    Post(pos = 3, player = NoATTPlayer)
)
