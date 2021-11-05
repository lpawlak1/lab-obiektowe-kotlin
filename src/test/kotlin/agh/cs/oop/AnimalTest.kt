package agh.cs.oop

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class AnimalTest {

    @Test
    fun moveTest() {
        val mockMap : IWorldMap = mock()
        whenever(mockMap.canMoveTo(any())).thenReturn(true)

        val ez = Animal(position = Vector2d(2,2), map = mockMap)

        ez.move(MoveDirection.LEFT)
        Assertions.assertEquals(ez.direction, MapDirection.WEST)
        ez.move(MoveDirection.RIGHT)
        Assertions.assertEquals(ez, Animal(mockMap, Vector2d(2,2)))
        ez.move(MoveDirection.RIGHT)
        Assertions.assertEquals(ez.direction, MapDirection.EAST)
        ez.move(MoveDirection.FORWARD)
        Assertions.assertEquals(ez.position, Vector2d(3, 2))
    }

    @Test
    fun isAt() {
        val mockMap : IWorldMap = mock()
        whenever(mockMap.canMoveTo(any())).thenReturn(true)

        assertTrue(Animal(mockMap, Vector2d(2,3)).isAt(Vector2d(2,3)))
        assertFalse(Animal(mockMap, Vector2d(3,9)).isAt(Vector2d(2,3)))
    }
}
