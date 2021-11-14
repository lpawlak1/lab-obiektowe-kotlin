package agh.cs.oop


abstract class AbstractorWorldMap : IWorldMap {
    fun observePosition(old: Vector2d, new: Vector2d): Unit {
        lowerLeftVector = lowerLeftVector.lowerLeft(new)
        upperRightVector = upperRightVector.upperRight(new)

        objectsMap.remove(old)?.let {
            objectsMap.put(new, it)
        }
    }

    protected val objectsMap: HashMap<Vector2d, IElement> = hashMapOf()

    protected var lowerLeftVector = Vector2d(2,2)
    protected var upperRightVector = Vector2d(2,2)

    protected abstract val visualizer: MapVisualizer

    override fun canMoveTo(position: Vector2d): Boolean {
        return !objectsMap.containsKey(position)
    }

    override fun place(animal: Animal): Boolean {
        if (canMoveTo(animal.position)) {
            objectsMap[animal.position] = animal
            animal.moveObservers.add(this::observePosition)
            return true
        }
        return false
    }

    override fun isOccupied(position: Vector2d): Boolean {
        return objectsMap.containsKey(position)
    }

    override fun objectAt(position: Vector2d): Any? {
        return objectsMap[position]
    }

    override fun toString(): String {
        return visualizer.draw(lowerLeftVector, upperRightVector)
    }

    /**
     * In this implementation animals shouldn't be used in many cases as its O(n),
     * where n is number of Animals on map
     * Used as instead of (is -> as) coz IElements in AbstractorWorldMap is always Animal, nothing else
     */
    override fun animals(): List<Animal> {
        return objectsMap.values.toList().map { it as Animal }
    }

}