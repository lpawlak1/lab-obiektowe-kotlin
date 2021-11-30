package agh.cs.oop


abstract class AbstractorWorldMap : IWorldMap, IObserver<Vector2d> {

    override fun observePosition(old: Vector2d, new: Vector2d) {
        objectsMap.remove(old)?.let {
            objectsMap.put(new, it)
        }
    }

    private val objectsMap: HashMap<Vector2d, IElement> = hashMapOf()
    protected val mapBoundary: MapBoundary = MapBoundary()

    protected abstract val visualizer: MapVisualizer

    override fun canMoveTo(position: Vector2d): Boolean {
        return !objectsMap.containsKey(position)
    }

    override fun place(animal: Animal): Boolean {
        if (canMoveTo(animal.position)) {
            objectsMap[animal.position] = animal
            animal.addObserver(this::observePosition)
            animal.addObserver(this.mapBoundary::observePosition)
            return true
        }
        throw IllegalArgumentException("$animal can't be placed")
    }

    override fun isOccupied(position: Vector2d): Boolean {
        return objectsMap.containsKey(position)
    }

    override fun objectAt(position: Vector2d): Any? {
        return objectsMap[position]
    }

    override fun toString(): String {
        return visualizer.draw(mapBoundary.lowerLeft(), mapBoundary.upperRight())
    }

    operator fun contains(obj : Any?) : Boolean{
        return  (obj is IElement && this.isOccupied(obj.position))
                ||
                (obj is Vector2d && this.isOccupied(obj))
    }

    operator fun get(obj: Any?) : Any? {
        if (obj !is Vector2d)
            return null

        return this.objectAt(obj)
    }

    /**
     * In this implementation animals shouldn't be used in many cases as its O(n),
     * where n is number of [Animal]s on map
     * Used as instead of (is -> as) coz [IElement]s in [AbstractorWorldMap] is always [Animal], nothing else
     */
    override fun animals(): List<Animal> {
        return objectsMap.values.toList().map { it as Animal }
    }
}
