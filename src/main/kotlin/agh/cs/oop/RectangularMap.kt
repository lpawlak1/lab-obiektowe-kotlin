package agh.cs.oop

class RectangularMap(private val width: Int, private val height: Int) : IWorldMap {
    private val mutable_map: HashMap<Vector2d, Animal> = HashMap()

    override fun canMoveTo(position: Vector2d?): Boolean {
        position as Vector2d
        return !mutable_map.contains(position)
                && position.x >= 0
                && position.x < width
                && position.y >= 0
                && position.y < height
    }

    override fun place(animal: Animal?): Boolean {
        if (animal is Animal && !mutable_map.containsKey(animal.position)) {
            mutable_map[animal.position] = animal
            return true
        }
        return false
    }

    override fun isOccupied(position: Vector2d?): Boolean {
        return position is Vector2d && mutable_map.containsKey(position)
    }

    override fun objectAt(position: Vector2d?): Any? {
        position is Vector2d
        return this.mutable_map.getOrDefault(position, null)
    }

    /**
     * Added this function to effortlessly move animals in hashmap
     * @param oldPosition is position that animal was
     * @param animal is object of animal to be moved
     */
    override fun moveAnimal(oldPosition: Vector2d, animal: Animal) {
        this.mutable_map.remove(oldPosition)
        this.mutable_map[animal.position] = animal
    }

    override fun toString(): String {
        return MapVisualizer(this).draw(Vector2d(0, 0), Vector2d(width, height))
    }

}