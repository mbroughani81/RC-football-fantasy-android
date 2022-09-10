package com.rc.quokka.fantasyfootball.domain.repositories

import com.rc.quokka.fantasyfootball.domain.model.*
import kotlinx.coroutines.flow.Flow

interface PlayersRepository {
    suspend fun getPlayers(
        data: GetPlayerData = GetPlayerData(
            filter = PlayerFilter.All,
            pageNumber = 1
        )
    ): List<Player>

    suspend fun clearPost(post: Post)

    suspend fun fillPost(post: Post, player: Player)

    suspend fun observerUserPosts(): Flow<List<Post>>
}