package agh.cs.oop

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class AnimalTest {
    private lateinit var ez: Animal
    @BeforeEach
    fun animalFactory() {
        ez = Animal()
    }

    @Test
    fun moveTest() {
// Prawo i lewo
        ez!!.move(MoveDirection.LEFT)
        ez!!.move(MoveDirection.RIGHT)
        Assertions.assertEquals(ez, Animal())
        ez!!.move(MoveDirection.RIGHT)
        Assertions.assertEquals(ez.direction, MapDirection.EAST)
        ez!!.move(MoveDirection.FORWARD)
        Assertions.assertEquals(ez.position, Vector2d(3, 2))
    }

    @Test
    fun validationOfMovesTest() {
        for (i in 0..9) {
            ez!!.move(MoveDirection.FORWARD)
        }
        Assertions.assertEquals(Vector2d(2, 4), ez.position)
    }

    @Test
    fun validationOfOptionParser() {
        val tab = arrayOfNulls<String>(7)
        tab[0] = "f"
        tab[1] = "f"
        tab[2] = "b"
        tab[3] = "r"
        tab[4] = "f"
        tab[5] = "l"
        tab[6] = "b"
        val elems: Iterable<MoveDirection> = OptionsParser.parse(tab.joinToString(separator=" "))
        val animal = Animal()
        for (elem in elems) {
            animal.move(elem)
        }
        Assertions.assertEquals(animal.direction, MapDirection.NORTH)
        Assertions.assertEquals(animal.position, Vector2d(3, 2))
    }

    @Test
    fun isAt() {
        assertTrue(Animal(Vector2d(2,3)).isAt(Vector2d(2,3)))
        assertFalse(Animal(Vector2d(3,9)).isAt(Vector2d(2,3)))
    }
}
