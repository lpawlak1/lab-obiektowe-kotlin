package agh.cs.oop

import java.util.*
import kotlin.properties.Delegates

/**
 * Instead of making IPositionChangeObserver in Kotlin we can create typealias telling what function should be sent.
 * Here is func that takes [Vector2d] twice (being before and after change) and returns [Unit]
 */
typealias PositionObserverFunc = (Vector2d, Vector2d) -> Unit

class Animal(private val map: IWorldMap) : IElement {
    constructor(map: IWorldMap, position: Vector2d) : this(map = map) {
        this.position = position
    }

    private val moveObservers = mutableListOf<PositionObserverFunc>()

    override var position: Vector2d by Delegates.observable(Vector2d(2, 2)) { _, o, i ->
        for (it in moveObservers) it(o, i)
    }
        private set
    fun addObserver(funkcja: PositionObserverFunc): Boolean = this.moveObservers.add(funkcja)
    fun removeObserver(funkcja: PositionObserverFunc): Boolean = this.moveObservers.remove(funkcja)

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