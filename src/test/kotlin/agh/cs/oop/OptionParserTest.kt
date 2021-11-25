package agh.cs.oop

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class OptionParserTest {

    @Test
    fun `parse test`() {
        assertFalse(listOf(OptionsParser.parse("")).equals(listOf<Any>()))

        assertEquals(
            listOf<MoveDirection>(
                MoveDirection.LEFT,
                MoveDirection.RIGHT,
                MoveDirection.BACKWARD,
                MoveDirection.FORWARD
            ),
            OptionsParser.parse("l r b f").toList()
        )
        assertEquals(listOf(MoveDirection.LEFT), OptionsParser.parse("l"))

        val essa_message = "e s s a"
        assertFailsWith(IllegalArgumentException::class, message="This should parse as good as elem inside was: $essa_message") {
            OptionsParser.parse(essa_message)
        }
    }
}
