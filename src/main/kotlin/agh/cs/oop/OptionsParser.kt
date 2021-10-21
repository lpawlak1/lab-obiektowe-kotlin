package agh.cs.oop

class OptionsParser {
    companion object {
        fun parse(message: String): Iterable<MoveDirection> {
            return message
                .split(' ')
                .map {
                    when (it.lowercase()[0]){
                        'f' -> MoveDirection.FORWARD
                        'b' -> MoveDirection.BACKWARD
                        'r' -> MoveDirection.RIGHT
                        'l' -> MoveDirection.LEFT
                        else -> {}
                    }
                }
                .filterIsInstance<MoveDirection>()
        }
    }
}