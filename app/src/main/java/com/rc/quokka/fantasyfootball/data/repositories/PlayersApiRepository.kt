package com.rc.quokka.fantasyfootball.data.repositories

import com.rc.quokka.fantasyfootball.data.datasources.PlayersApiDataSource
import com.rc.quokka.fantasyfootball.domain.model.Player
import com.rc.quokka.fantasyfootball.domain.model.Post
import com.rc.quokka.fantasyfootball.domain.repositories.PlayersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

//
//class PlayersApiRepository(val playersApiDataSource: PlayersApiDataSource = PlayersApiDataSource()) :
//    PlayersRepository {
//
//    private val fakeRepo = FakePlayersRepositories()
//
//    override suspend fun getPlayers(): List<Player> = withContext(Dispatchers.IO) {
//        playersApiDataSource.getPlayers()
//    }
//
//
//    override suspend fun deletePlayer(player: Player) {
//        fakeRepo.deletePlayer(player)
//    }
//
//    override suspend fun addPlayer(player: Player, pos: Int) {
//        fakeRepo.addPlayer(player, pos)
//    }
//
//    override fun observerUserPlayers(): Flow<List<Player>> {
//        return fakeRepo.observerUserPlayers()
//    }
//}

class PlayersApiRepository(val playersApiDataSource: PlayersApiDataSource = PlayersApiDataSource()) :
    PlayersRepository {

    private val fakeRepo = FakePlayersRepositories()

    override suspend fun getPlayers(): List<Player> = withContext(Dispatchers.IO) {
        playersApiDataSource.getPlayers()
    }

    override suspend fun clearPost(post: Post) {
        fakeRepo.clearPost(post)
    }

    override suspend fun fillPost(post: Post, player: Player) {
        fakeRepo.fillPost(post, player)
    }

    override fun observerUserPosts(): Flow<List<Post>> {
        return fakeRepo.observerUserPosts()
    }
}
