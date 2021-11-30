package agh.cs.oop

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

internal class SimulationEngineTest {
    @Test
    fun `GrassField integration`() {
        val args = "f b r l f f r r f f f f f f f f"
        val directions: Iterable<MoveDirection> = OptionsParser.parse(args)
        val map: AbstractorWorldMap = GrassField(10)
        val positions = listOf(Vector2d(2, 2), Vector2d(3, 4))

        for (elem in positions) {
            map.place(Animal(map = map, position = elem))
        }

        val engine: IEngine = SimulationEngine(directions, map)
        engine.run()
        print(map.toString())
        assertTrue(Vector2d(3,7) in map)
        assertTrue(Vector2d(2,-1) in map)
    }

    @Test
    fun `Rectangular map integration`() {
        val args = "f b r l f f r r f f f f f f f f"
        val directions: Iterable<MoveDirection> = OptionsParser.parse(args)
        val map: AbstractorWorldMap = RectangularMap(10, 5)
        val positions = listOf(Vector2d(2, 2), Vector2d(3, 4))

        for (elem in positions) {
            map.place(Animal(map = map, position = elem))
        }

        val engine: IEngine = SimulationEngine(directions, map)
        engine.run()
        print(map.toString())
        assertTrue(Vector2d(3,4) in map)
        assertTrue(Vector2d(2,0) in map)
        assertFalse(Vector2d(2,2) in map)
        assertFalse(Vector2d(2,4) in map)
        assertFalse(Vector2d(5,6) in map)
        assertFalse(Vector2d(8,7) in map)
        assertFalse(Vector2d(8,7) in map)
    }

    @Test
    fun `no animals`() {
        val mockMap: IWorldMap = mock()
        val mockDirection: Iterable<MoveDirection> = listOf<MoveDirection>()

        whenever(mockMap.animals()).thenReturn(emptyList())

        val engine = SimulationEngine(mockDirection, mockMap)
        assertThrows<Exception> {
            engine.run()
        }
    }
}
