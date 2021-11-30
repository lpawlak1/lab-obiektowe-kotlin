package agh.cs.oop

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class RectangularMapTest {

    lateinit var map: RectangularMap

    @BeforeEach
    fun prepare() {
        map = RectangularMap(3, 3)
    }

    @Test
    fun canMoveTo() {
        map.place(Animal(map, Vector2d(1, 1)))
        assertFalse(map.canMoveTo(Vector2d(1, 1)))
        assertTrue(map.canMoveTo(Vector2d(1, 2)))

    }

    @Test
    fun place() {
        var animal_1_1 = Animal(map = map, position = Vector2d(1, 1))
        assertTrue(map.place(animal_1_1), "Coudn't place animal")

        var animal_1_1__2 = Animal(map = map, position = Vector2d(1, 1))
        assertFailsWith(IllegalArgumentException::class, message="Added animal even though other animal was in there") {
            map.place(animal_1_1__2)
        }
    }

    @Test
    fun isOccupied() {
        var animal_1_1 = Animal(map = map, position = Vector2d(1, 1))
        map.place(animal_1_1)
        assertTrue(Vector2d(1,1) in map,"Smth terribly wrong")
        assertFalse(Vector2d(2,4) in map, "There's shouldn't be any objects")
    }

    @Test
    fun objectAt() {
        var animal_1_1 = Animal(map = map, position = Vector2d(1, 1))
        map.place(animal_1_1)
        assertEquals(map[Vector2d(1,1)], animal_1_1)
    }

    /**
     * Depends on Animal, this.isOccupied
     */
    @Test
    fun `integration test of moveAnimal`() {
        val animal_stationary_1_1 = Animal(map, Vector2d(1, 1))
        assertTrue(map.place(animal_stationary_1_1))
        val animal_moving = Animal(map, Vector2d(1, 0))
        assertTrue(map.place(animal_moving))

        animal_moving.move(MoveDirection.FORWARD)

        assertTrue(map[animal_moving.position] == animal_moving)

        animal_moving.move(MoveDirection.RIGHT)
        animal_moving.move(MoveDirection.FORWARD)
        animal_moving.move(MoveDirection.LEFT)
        animal_moving.move(MoveDirection.BACKWARD) //Out of range for move

        print(map)
        assertTrue(Vector2d(2,0) in map)
    }
}
