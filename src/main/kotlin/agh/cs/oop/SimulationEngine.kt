package agh.cs.oop

class SimulationEngine : IEngine {
    private val moveArray: Iterable<MoveDirection>
    private val map: IWorldMap
    private val vectors: Iterable<Vector2d>

    constructor(moveArray: Iterable<MoveDirection>, map: IWorldMap, vectors: Collection<Vector2d>) {
        this.moveArray = moveArray
        this.map = map
        this.vectors = vectors
    }

    override fun run() {
        var animals: MutableList<Animal> = mutableListOf<Animal>()
        for (elem in this.vectors) {
            val anim = Animal(map = map, position = elem)
            if (map.place(anim))
                animals.add(anim)
        }

        if (animals.size == 0) {
            throw Exception("Error in animal size (0), maybe wrong vectors")
        }

        var iter = animals.iterator()
        for (currentMove in moveArray) {
            if (!iter.hasNext()) {
                iter = animals.iterator()
            }
            val currentAnimal: Animal = iter.next()
            currentAnimal.move(currentMove)
        }
    }
}