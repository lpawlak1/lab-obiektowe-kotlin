package agh.cs.oop

class Animal(private val map: IWorldMap) {
    constructor(map: IWorldMap, position: Vector2d) : this(map = map) {
        this.position = position
    }

    var position: Vector2d = Vector2d(2, 2)
        private set

    var direction: MapDirection = MapDirection.NORTH
        private set

    fun isAt(position: Vector2d): Boolean = this.position == position

    private fun canMoveTo(newPosition: Vector2d): Boolean = this.map.canMoveTo(newPosition)

    override fun toString(): String = this.direction.toString()

    fun move(moveDirection: MoveDirection) {
        when (moveDirection) {
            MoveDirection.FORWARD -> {
                val newPosition = position + direction.toUnitVector()

                if (canMoveTo(newPosition))
                    position = newPosition
            }
            MoveDirection.BACKWARD -> {
                val newPosition = position - direction.toUnitVector()

                if (canMoveTo(newPosition))
                    position = newPosition
            }

            MoveDirection.RIGHT -> direction = direction.next()
            MoveDirection.LEFT -> direction = direction.previous()
        }
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