package agh.cs.oop

class SimulationEngine(private val moveArray: Iterable<MoveDirection>, private val map: IWorldMap) : IEngine {

    override fun run() {
        val animals = map.animals()
        if (animals.isEmpty()) {
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