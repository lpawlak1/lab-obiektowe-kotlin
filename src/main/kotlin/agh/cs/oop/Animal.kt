package agh.cs.oop

open class Animal {
    var position: Vector2d = Vector2d(2,2)
        private set(value) {field = value}

    var direction: MapDirection = MapDirection.NORTH
        private set(value) {field = value}



    override fun toString(): String {
        return "Animal(position=$position, direction=$direction)"
    }

    fun move(moveDirection: MoveDirection){
        when(moveDirection){
            MoveDirection.FORWARD -> {
                val newPosition = position.add(direction.toUnitVector())

                if (canMoveTo(newPosition))
                    position = newPosition
            }
            MoveDirection.BACKWARD -> {
                val newPosition = position.add(direction.toUnitVector().opposite())

                if (canMoveTo(newPosition))
                    position = newPosition
            }

            MoveDirection.RIGHT -> direction = direction.next()
            MoveDirection.LEFT -> direction = direction.previous()
        }
    }

    private fun canMoveTo(newPosition: Vector2d): Boolean {
        return newPosition.follows(Vector2d(0,0)) && newPosition.precedes(Vector2d(4,4))
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Animal

        if (position != other.position) return false
        if (direction != other.direction) return false

        return true
    }

    override fun hashCode(): Int {
        var result = position.hashCode()
        result = 31 * result + direction.hashCode()
        return result
    }


}