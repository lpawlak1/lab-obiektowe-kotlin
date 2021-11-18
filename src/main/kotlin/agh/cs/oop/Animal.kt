package agh.cs.oop

import java.util.*
import kotlin.properties.Delegates

class Animal(private val map: IWorldMap) : IElement {
    val moveObservers = mutableListOf<(Vector2d, Vector2d) -> Unit>()

    override var position: Vector2d by Delegates.observable(Vector2d(2, 2)) { _, o, i ->
        for (it in moveObservers) it(o, i)
    }
        private set

    constructor(map: IWorldMap, position: Vector2d) : this(map = map) {
        this.position = position
    }


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

    override fun equals(other: Any?): Boolean =
        other is Animal && position == other.position && direction == other.direction

    override fun hashCode(): Int =
        Objects.hash(position, direction)

}