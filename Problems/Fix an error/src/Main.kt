class Player(val id: Int, val name: String) {


    companion object {
        val role = "playable character"

        fun getInfo(player: Player) = "${player.id}, ${player.name}, $role"
    }


}

fun getPlayerInfo(player: Player) = Player.getInfo(player)