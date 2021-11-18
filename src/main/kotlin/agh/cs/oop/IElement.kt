package agh.cs.oop

/**
 * Interface aggregating objects that can be put on map and represented
 * [position] is val by default but can be overriden to var if needed
 */
interface IElement {
    val position: Vector2d
}