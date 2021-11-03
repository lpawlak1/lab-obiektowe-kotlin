package agh.cs.oop

import kotlin.math.max
import kotlin.math.min


data class Vector2d (val x:Int, val y:Int) {

    override fun toString(): String {
        return "($x,$y)"
    }

    fun precedes(other: Vector2d): Boolean {
        return x <= other.x && y <= other.y
    }

    fun follows(other: Vector2d): Boolean {
        return x >= other.x && y >= other.y
    }

    fun upperRight(other: Vector2d): Vector2d {
        return Vector2d(max(x,other.x), max(y,other.y))
    }

    fun lowerLeft(other: Vector2d): Vector2d {
        return Vector2d(min(x,other.x), min(y,other.y))
    }

    fun add(other: Vector2d): Vector2d {
        return Vector2d(x + other.x, y + other.y)
    }

    fun substract(other: Vector2d): Vector2d {
        return Vector2d(x - other.x, y - other.y)
    }

    fun opposite(): Vector2d {
        return Vector2d(x * -1, y * -1)
    }
}
