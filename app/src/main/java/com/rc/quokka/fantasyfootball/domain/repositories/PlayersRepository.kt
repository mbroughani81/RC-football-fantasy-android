package com.rc.quokka.fantasyfootball.domain.repositories

import com.rc.quokka.fantasyfootball.domain.model.Player
import com.rc.quokka.fantasyfootball.domain.model.PlayerRole
import com.rc.quokka.fantasyfootball.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface PlayersRepository {
    suspend fun getPlayers(): List<Player>
    
    suspend fun clearPost(post: Post)

    suspend fun fillPost(post: Post, player: Player)

    fun observerUserPosts(): Flow<List<Post>>
}