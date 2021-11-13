package agh.cs.oop

abstract class AbstractorWorldMap : IWorldMap {
    protected val objectList: MutableList<IElement> = emptyList<IElement>().toMutableList()

    protected abstract val visualizer: MapVisualizer

    override fun canMoveTo(position: Vector2d): Boolean {
        return objectList.none { it.javaClass == Animal::class.java && it.position == position }
    }

    override fun place(animal: Animal): Boolean {
        if (canMoveTo(animal.position)) {
            objectList.add(animal)
            return true
        }
        return false
    }

    override fun isOccupied(position: Vector2d): Boolean {
        return objectList.any{ it.position == position}
    }

    override fun objectAt(position: Vector2d): Any? {
        return objectList.firstOrNull { it.position == position }
    }

    override fun toString(): String {
        val minX = objectList.minOfWithOrNull({ e1 : Int, e2: Int -> e1.compareTo(e2)},{ e -> e.position.x}) ?: 2
        val minY = objectList.minOfWithOrNull({ e1 : Int, e2: Int -> e1.compareTo(e2)},{ e -> e.position.y}) ?: 2

        val maxX = objectList.maxOfWithOrNull({ e1 : Int, e2: Int -> e1.compareTo(e2)},{ e -> e.position.x}) ?: 2
        val maxY = objectList.maxOfWithOrNull({ e1 : Int, e2: Int -> e1.compareTo(e2)},{ e -> e.position.y}) ?: 2

        return visualizer.draw(Vector2d(minX, minY), Vector2d(maxX, maxY))
    }

    /**
     * In this implementation animals shouldn't be used in many cases as its O(n),
     * where n is number of objects on map
     */
    override fun animals(): List<Animal> {
        return this.objectList.filterIsInstance(Animal::class.java)
    }

}