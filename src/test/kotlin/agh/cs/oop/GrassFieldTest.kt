package agh.cs.oop

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.sqrt
import kotlin.test.assertFailsWith
import kotlin.random.Random

internal class GrassFieldTest {
    /**
     * Gets first object it will find in a map
     */
    fun getGrass(map: GrassField, maxi: Int): Vector2d {
        for (i in 0 until maxi) {
            for (j in 0 until maxi) {
                if (Vector2d(i,j) in map) return Vector2d(i,j)
            }
        }
        throw Exception("No grass in this map :(")
    }

    @Test
    fun `init test`() {
        var n = 1
        val map = GrassField(n)
        var maxi: Int = sqrt((10 * n).toDouble()).toInt()

        var counter = 0
        for (i in 0 until maxi) {
            for (j in 0 until maxi) {
                if (Vector2d(i,j) in map) counter++
            }
        }

        print(map)
        assertEquals(n, counter)
    }

    @Test
    fun canMoveTo() {
        val map = GrassField(10)

        assertTrue(map.place(Animal(map, Vector2d(1, 1))))
        assertFalse(map.canMoveTo(Vector2d(1, 1)))

        assertTrue(map.canMoveTo(Vector2d(1, 2)))
    }

    @Test
    fun `place on grass`() {
        val n = 1
        val map = GrassField(n)
        var maxi: Int = sqrt((10 * n).toDouble()).toInt()


        val position: Vector2d = getGrass(map, maxi)
        assertTrue(map.place(Animal(map, position)))
    }

    @Test
    fun place() {
        val map = GrassField(10)

        var animal_1_1 = Animal(map = map, position = Vector2d(1, 1))
        assertTrue(map.place(animal_1_1), "Coudn't place animal")

        var animal_1_1__2 = Animal(map = map, position = Vector2d(1, 1))

        assertFailsWith(IllegalArgumentException::class, message="Added animal even though other animal was in there") {
            map.place(animal_1_1__2)
        }
    }

    @Test
    fun `in operator`() {
        val map = GrassField(10)

        var animal_1_1 = Animal(map = map, position = Vector2d(1, 1))
        map.place(animal_1_1)
        assertTrue(Vector2d(1,1) in map,"Smth terribly wrong")
        assertFalse(Vector2d(-10,-10) in map, "There's shouldn't be anything")
    }

    @Test
    fun objectAt() {
        val map = GrassField(10)
        val grass_pos = getGrass(map, sqrt(10 * 10.toDouble()).toInt())

        var animal_1 = Animal(map = map, position = grass_pos)
        map.place(animal_1)
        assertEquals(map[grass_pos], animal_1)
    }

    @Test
    fun `integration test of moveAnimal`() {
        val map = GrassField(10)

        val animal_stationary_1_1 = Animal(map, Vector2d(1, 1))
        assertTrue(map.place(animal_stationary_1_1))
        val animal_moving = Animal(map, Vector2d(1, 0))
        assertTrue(map.place(animal_moving))

        animal_moving.move(MoveDirection.FORWARD)

        assertTrue(map[animal_moving.position] == animal_moving)

        animal_moving.move(MoveDirection.RIGHT)
        animal_moving.move(MoveDirection.FORWARD)
        animal_moving.move(MoveDirection.LEFT)
        animal_moving.move(MoveDirection.BACKWARD)

        print(map)
        assertTrue(Vector2d(2,-1) in map)

    }
}
