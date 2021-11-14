package agh.cs.oop

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

internal class OptionParserTest {

    @Test
    fun `parse test`() {
        assertFalse(listOf(OptionsParser.parse("e s s a")).equals(listOf<Any>()))
        assertEquals(
            listOf<MoveDirection>(
                MoveDirection.LEFT,
                MoveDirection.RIGHT,
                MoveDirection.BACKWARD,
                MoveDirection.FORWARD
            ),
            OptionsParser.parse("l r b f ll").toList()
        )
        assertEquals(listOf(MoveDirection.LEFT), OptionsParser.parse(" l   t "))
    }
}