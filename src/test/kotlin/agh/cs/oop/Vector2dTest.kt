package agh.cs.oop

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class Vector2dTest {
    lateinit var vector_2_2: Vector2d
    lateinit var vector_2_2a: Vector2d
    lateinit var vector_1_2: Vector2d

    @BeforeEach
    fun vectorsFactory() {
        vector_2_2 = Vector2d(2, 2)
        vector_2_2a = Vector2d(2, 2)
        vector_1_2 = Vector2d(1, 2)
    }

    @Test
    fun equalsTest() {
        assertEquals(vector_2_2, vector_2_2a)
        assertNotEquals(vector_2_2, vector_1_2)
    }

    @Test
    fun toStringTest() {
        assertEquals("(2,2)", vector_2_2.toString())
        assertEquals("(1,2)", vector_1_2.toString())
    }

    @Test
    fun followsTest() {
        assertTrue(vector_2_2.follows(vector_1_2))
        assertTrue(vector_2_2.follows(vector_2_2a))
        assertFalse(vector_1_2.follows(vector_2_2))
    }

    @Test
    fun precedesTest() {
        assertFalse(vector_2_2.precedes(vector_1_2))
        assertTrue(vector_2_2.precedes(vector_2_2a))
        assertTrue(vector_1_2.precedes(vector_2_2))
    }

    @Test
    fun upperRight() {
        assertEquals(vector_2_2a, vector_2_2.upperRight(vector_1_2))
        assertEquals(Vector2d(3, 2), vector_2_2.upperRight(Vector2d(3, 2)))
    }

    @Test
    fun lowerLeft() {
        assertEquals(vector_2_2a, vector_2_2.lowerLeft(vector_2_2a))
        assertEquals(
            Vector2d(-1, 2),
            vector_2_2.lowerLeft(Vector2d(-1, 9))
        )
    }

    @Test
    fun addTest() {
        assertEquals(vector_2_2a, vector_1_2 + Vector2d(1, 0))
        assertEquals(Vector2d(-1, -5), vector_1_2 + Vector2d(-2, -7))
    }

    @Test
    fun subtractTest() {
        assertEquals(vector_2_2a, vector_1_2 -Vector2d(-1, 0))
        assertEquals(Vector2d(-1, -5), vector_1_2 - Vector2d(2, 7))
    }

    @Test
    fun oppositeTest() {
        assertEquals(Vector2d(-2, -2), vector_2_2.opposite())
        assertEquals(Vector2d(-1, -2), vector_1_2.opposite())
    }
}
