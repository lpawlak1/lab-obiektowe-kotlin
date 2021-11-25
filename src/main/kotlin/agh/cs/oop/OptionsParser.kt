package agh.cs.oop

class OptionsParser {
    companion object {
        fun parse(message: String): Iterable<MoveDirection> {
            return message
                .split(' ')
                .filter { it != "" }
                .map {
                    when (it.lowercase()) {
                        "f", "forward" -> MoveDirection.FORWARD
                        "b", "backward" -> MoveDirection.BACKWARD
                        "r", "right" -> MoveDirection.RIGHT
                        "l", "left" -> MoveDirection.LEFT
                        else -> {
                            throw IllegalArgumentException("$it is not legal move specification")
                        }
                    }
                }
                .filterIsInstance<MoveDirection>()
        }
    }
}
