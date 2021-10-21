package agh.cs.oop

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Vector2dTest {
    lateinit var vector1: Vector2d
    lateinit var vector2: Vector2d
    lateinit var vector3: Vector2d

    @BeforeEach
    fun vectorsFactory() {
        vector1 = Vector2d(2, 2)
        vector2 = Vector2d(2, 2)
        vector3 = Vector2d(1, 2)
    }

    @Test
    fun equalsTest() {
        assertTrue(vector1.equals(vector2))
        assertFalse(vector1.equals(vector3))
    }

    @Test
    fun toStringTest() {
        assertEquals("(2,2)", vector1.toString())
        assertEquals("(1,2)", vector3.toString())
    }

    @Test
    fun followsTest() {
        assertTrue(vector1.follows(vector3))
        assertTrue(vector1.follows(vector2))
        assertFalse(vector3.follows(vector1))
    }

    @Test
    fun precedesTest() {
        assertFalse(vector1.precedes(vector3))
        assertTrue(vector1.precedes(vector2))
        assertTrue(vector3.precedes(vector1))
    }

    @Test
    fun upperRight() {
        assertEquals(vector2, vector1.upperRight(vector3))
        assertEquals(Vector2d(3, 2), vector1.upperRight(Vector2d(3, 2)))
    }

    @Test
    fun lowerLeft() {
        assertEquals(vector2, vector1.lowerLeft(vector2))
        assertEquals(
            Vector2d(-1, 2),
            vector1.lowerLeft(Vector2d(-1, 9))
        )
    }

    @Test
    fun addTest() {
        assertEquals(vector2, vector3.add(Vector2d(1, 0)))
        assertEquals(Vector2d(-1, -5), vector3.add(Vector2d(-2, -7)))
    }

    @Test
    fun subtractTest() {
        assertEquals(vector2, vector3.substract(Vector2d(-1, 0)))
        assertEquals(Vector2d(-1, -5), vector3.substract(Vector2d(2, 7)))
    }

    @Test
    fun oppositeTest() {
        assertEquals(Vector2d(-2, -2), vector1.opposite())
        assertEquals(Vector2d(-1, -2), vector3.opposite())
    }
}
