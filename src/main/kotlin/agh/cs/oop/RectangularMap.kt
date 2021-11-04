package agh.cs.oop

import java.util.*

class RectangularMap(private val width: Int, private val height: Int) : IWorldMap {
    private val animal_list: LinkedList<Animal> = LinkedList();

    override fun canMoveTo(position: Vector2d?): Boolean {
        position as Vector2d
        return !animal_list.any { it.position == position }
                && position.x >= 0
                && position.x < width
                && position.y >= 0
                && position.y < height
    }

    override fun place(animal: Animal?): Boolean {
        if (animal is Animal && !animal_list.any { it.position == animal.position }){
            animal_list.add(animal)
            return true
        }
        return false
    }

    override fun isOccupied(position: Vector2d?): Boolean {
        return position is Vector2d && animal_list.any { it.position == position}
    }

    override fun objectAt(position: Vector2d?): Any? {
        position is Vector2d
        return animal_list.firstOrNull { it.position == position }
    }

    override fun toString(): String {
        return MapVisualizer(this).draw(Vector2d(0, 0), Vector2d(width, height))
    }

}