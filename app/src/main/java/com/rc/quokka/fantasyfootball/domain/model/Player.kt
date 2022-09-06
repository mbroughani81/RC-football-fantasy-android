package com.rc.quokka.fantasyfootball.domain.model

data class Player(val id: String, val name: String, val role: PlayerRole, val rating: Int, val price: Float)

val NoGKPlayer = Player("-1", "-1", PlayerRole.GoalKeeper, -1, 0f)
val NoDEFPlayer = Player("-1", "-1", PlayerRole.Defender, -1, 0f)
val NoMIDPlayer = Player("-1", "-1", PlayerRole.Midfielder, -1, 0f)
val NoATTPlayer = Player("-1", "-1", PlayerRole.Attacker, -1, 0f)

enum class PlayerRole {
    GoalKeeper,
    Defender,
    Midfielder,
    Attacker
}
//
//data class PlayersList(
//    val GKPlayers: List<Player>,
//    val DEFPlayers: List<Player>,
//    val MIDPlayers: List<Player>,
//    val ATTPlayers: List<Player>
//)
