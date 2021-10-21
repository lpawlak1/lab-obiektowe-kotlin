package agh.cs.oop

class Animal {
    private var position: Vector2d = Vector2d(2,2)
    private var direction: MapDirection = MapDirection.NORTH

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


}