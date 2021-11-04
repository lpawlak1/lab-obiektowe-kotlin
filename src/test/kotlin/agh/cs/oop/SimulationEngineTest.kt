package agh.cs.oop

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SimulationEngineTest {

    @Test
    fun run() {
        val args = "f b r l f f r r f f f f f f f f"
        val directions: Iterable<MoveDirection> = OptionsParser.parse(args)
        val map: IWorldMap = RectangularMap(10, 5)
        val positions = listOf(Vector2d(2, 2), Vector2d(3, 4))

        for (elem in positions) {
            map.place(Animal(map = map, position = elem))
        }

        val engine: IEngine = SimulationEngine(directions, map)
        engine.run()
        print(map.toString())
        assertTrue(map.isOccupied(Vector2d(3,4)))
        assertTrue(map.isOccupied(Vector2d(2,0)))
        assertFalse(map.isOccupied(Vector2d(2,2)))
        assertFalse(map.isOccupied(Vector2d(2,4)))
        assertFalse(map.isOccupied(Vector2d(5,6)))
        assertFalse(map.isOccupied(Vector2d(8,7)))
        assertFalse(map.isOccupied(Vector2d(8,7)))
    }
}