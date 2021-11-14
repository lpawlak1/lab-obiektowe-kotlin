package agh.cs.oop

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GrassTest {

    @Test
    fun getPosition() {
        var grass_2_2 = Grass(Vector2d(2, 2))
        assertEquals(grass_2_2.position, Vector2d(2, 2))
        var grass_3_5 = Grass(Vector2d(3, 5))
        assertEquals(grass_3_5.position, Vector2d(3, 5))
    }

    @Test
    fun testToString() {
        assertEquals(Grass(Vector2d(3, 3)).toString(), "*")
    }
}