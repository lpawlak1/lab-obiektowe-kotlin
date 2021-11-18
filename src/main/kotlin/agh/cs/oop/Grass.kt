package agh.cs.oop

/**
 * One of 2 available objects implementing IElement right now, has final [position]
 */
class Grass(position: Vector2d) : IElement {

    /**
     * Position of Grass, final
     */
    override val position: Vector2d = position

    /**
     * Representation of Grass is always *
     */
    override fun toString(): String = "*"
}