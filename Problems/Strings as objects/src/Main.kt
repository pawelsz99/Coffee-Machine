fun main() {
    var input = readLine()!!
    // write code here
    when {
        input.isEmpty() -> {
            println("")
        }

        input.first() == 'i' -> {
            input = input.drop(1)
            println(input.toInt() + 1)
        }
        input.first() == 's' -> {
            input = input.drop(1)
            println(input.reversed())
        }
        else -> {
            println(input)
        }
    }
}