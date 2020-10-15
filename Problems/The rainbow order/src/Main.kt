import java.util.*

enum class Rainbow(val color: String) {
    RED("red"),
    ORANGE("orange"),
    YELLOW("yellow"),
    GREEN("green"),
    BLUE("blue"),
    INDIGO("indigo"),
    VIOLET("violet")
}

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    // put your code here
    val colorName = input.next().toUpperCase()
    val color = Rainbow.valueOf(colorName)

    println(color.ordinal + 1)

}