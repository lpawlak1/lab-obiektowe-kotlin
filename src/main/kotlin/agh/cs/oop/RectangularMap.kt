package agh.cs.oop

import java.util.*

class RectangularMap(private val width: Int, private val height: Int) : IWorldMap {
    private val animalList: LinkedList<Animal> = LinkedList()

    override fun canMoveTo(position: Vector2d): Boolean {
        return !animalList.any { it.position == position }
                && position.x >= 0
                && position.x < width
                && position.y >= 0
                && position.y < height
    }

    override fun place(animal: Animal): Boolean {
        if (!animalList.any { it.position == animal.position }){
            animalList.add(animal)
            return true
        }
        return false
    }

    override fun isOccupied(position: Vector2d): Boolean {
        return animalList.any { it.position == position}
    }

    override fun objectAt(position: Vector2d): Any? {
        return animalList.firstOrNull { it.position == position }
    }

    override fun animals(): List<Animal> {
        return this.animalList
    }

    override fun toString(): String {
        return MapVisualizer(this).draw(Vector2d(0, 0), Vector2d(width, height))
    }

}