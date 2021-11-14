package agh.cs.oop

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MapDirectionTest {

    @Test
    fun next() {
        assertEquals(MapDirection.NORTH.next(), MapDirection.EAST)
        assertEquals(MapDirection.EAST.next(), MapDirection.SOUTH)
        assertEquals(MapDirection.SOUTH.next(), MapDirection.WEST)
        assertEquals(MapDirection.WEST.next(), MapDirection.NORTH)
    }

    @Test
    fun `siema mordo`() {
        assertEquals(MapDirection.EAST.previous(), MapDirection.NORTH)
        assertEquals(MapDirection.SOUTH.previous(), MapDirection.EAST)
        assertEquals(MapDirection.WEST.previous(), MapDirection.SOUTH)
        assertEquals(MapDirection.NORTH.previous(), MapDirection.WEST)
    }

    @Test
    fun toUnitVector() {
        assertEquals(Vector2d(0, 1), MapDirection.NORTH.toUnitVector())
        assertEquals(Vector2d(1, 0), MapDirection.EAST.toUnitVector())
        assertEquals(Vector2d(-1, 0), MapDirection.WEST.toUnitVector())
        assertEquals(Vector2d(0, -1), MapDirection.SOUTH.toUnitVector())
    }

    @Test
    fun `to string`() {
        assertEquals("^", MapDirection.NORTH.toString())
        assertEquals(">", MapDirection.EAST.toString())
        assertEquals("<", MapDirection.WEST.toString())
        assertEquals("v", MapDirection.SOUTH.toString())
    }
}