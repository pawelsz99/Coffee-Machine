var id = 0

class Player(val id: Int, val name: String, val hp: Int) {
    companion object {
        fun create(name: String): Player {
            var player = Player(id, name, 100)
            id++
            return player
        }
    }


}