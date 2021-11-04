package agh.cs.oop

class Animal {
    var position: Vector2d = Vector2d(2, 2)
        private set(e) {
            val oldPos: Vector2d = position
            field = e
        }

    var direction: MapDirection = MapDirection.NORTH
        private set

    private var map: IWorldMap? = null

    constructor(position: Vector2d) {
        this.position = position
    }

    constructor(map: IWorldMap) {
        this.map = map
    }

    constructor(position: Vector2d, map: IWorldMap) {
        this.position = position
        this.map = map
    }


    override fun toString(): String {
        return this.direction.toString()
    }

    fun move(moveDirection: MoveDirection) {
        when (moveDirection) {
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

    fun isAt(position: Vector2d): Boolean {
        return this.position == position
    }

    private fun canMoveTo(newPosition: Vector2d): Boolean {
        return if (this.map is IWorldMap)
            this.map!!.canMoveTo(newPosition)
        else
            newPosition.follows(Vector2d(0, 0)) && newPosition.precedes(Vector2d(4, 4))
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