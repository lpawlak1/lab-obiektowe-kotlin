package agh.cs.oop.lab1

fun main(args: Array<String>) {
    println("start")
    run(arrayOf("f", "b", "l", "r", "ssdklfjladsf"))
    run2(arrayOf(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST))
    println("koniec")
}

fun run(str: Array<String>) {
    // Wersja 1
    println("Zwierze idzie do przodu")
    for (i in 0 until str.size - 1) {
        print(str[i])
        print(", ")
    }
    print(str.last())
    println()

    //Wersja 2
    for (item in str) {
        val a = when (item) {
            "f" -> "idzie do przodu"
            "b" -> "idzie do tyłu"
            "l" -> "skręca w lewo"
            "r" -> "skręca prawo"
            else -> ""
        }
        if (a != "")
            println("Zwierze $a")
    }

}

fun run2(tab: Array<Direction>) {
    //Wersja 3
    for (elem in tab) {
        println("Zwierze idzie w kierunku (ang) ${elem.realName}")
    }
}

enum class Direction(val realName: String) {
    NORTH("North"), SOUTH("South"), WEST("West"), EAST("East")
}