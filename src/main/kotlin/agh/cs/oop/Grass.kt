package agh.cs.oop

class Grass(position: Vector2d)  : IElement{
    override var position: Vector2d = position
        private set
    override fun toString(): String = "*"
}