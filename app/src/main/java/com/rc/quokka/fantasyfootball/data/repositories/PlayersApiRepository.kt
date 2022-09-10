package com.rc.quokka.fantasyfootball.data.repositories

import com.rc.quokka.fantasyfootball.data.datasources.PlayersApiDataSource
import com.rc.quokka.fantasyfootball.domain.model.*
import com.rc.quokka.fantasyfootball.domain.repositories.PlayersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext

class PlayersApiRepository(val playersApiDataSource: PlayersApiDataSource = PlayersApiDataSource()) :
    PlayersRepository {

    var userPosts = MutableStateFlow(
        listOf(
            Post(1, NoGKPlayer),
            Post(2, NoGKPlayer),
            Post(1, NoDEFPlayer),
            Post(2, NoDEFPlayer),
            Post(3, NoDEFPlayer),
            Post(4, NoDEFPlayer),
            Post(5, NoDEFPlayer),
            Post(1, NoMIDPlayer),
            Post(2, NoMIDPlayer),
            Post(3, NoMIDPlayer),
            Post(4, NoMIDPlayer),
            Post(5, NoMIDPlayer),
            Post(1, NoATTPlayer),
            Post(2, NoATTPlayer),
            Post(3, NoATTPlayer)
        )
    )

    override suspend fun getPlayers(getPlayerData: GetPlayerData): List<Player> = withContext(Dispatchers.IO) {
        playersApiDataSource.getPlayers()
    }

    override suspend fun clearPost(post: Post) {
        playersApiDataSource.removePlayer(post = post)
        updateUserPost()
    }

    override suspend fun fillPost(post: Post, player: Player) {
        if (post.player.role != player.role) {
            return
        }
        playersApiDataSource.addPlayer(post = post, player = player)
        updateUserPost()
    }

    override suspend fun observerUserPosts(): Flow<List<Post>> {
        updateUserPost()
        return userPosts
    }

    private suspend fun updateUserPost() {
        var updatedUserPosts = playersApiDataSource.getUserPosts().toMutableList()
        userPosts.value.forEach { userPost ->
            val sz = updatedUserPosts.filter { newUserPost ->
                newUserPost.pos == userPost.pos && newUserPost.player.role == userPost.player.role
            }.size

            if (sz == 0) {
                updatedUserPosts.add(Post(userPost.pos, userPost.player.toNoPlayer()))
            }
        }
        userPosts.value = updatedUserPosts
    }
}
