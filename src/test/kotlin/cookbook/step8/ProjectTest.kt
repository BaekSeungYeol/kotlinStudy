package cookbook.step8

import com.google.gson.Gson
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ProjectTest {

    @Test
    fun `use map delegate for Project`() {
        val project = Project(
            mutableMapOf(
                "name" to "Learn Kotlin",
                "priority" to 5,
                "completed" to true
            )
        )

        assertAll(
            { assertEquals("Learn Kotlin", project.name) },
            { assertEquals(5, project.priority) },
            { assertTrue(project.completed) }
        )
    }

    private fun getMapFromJSON() =
        Gson().fromJson<MutableMap<String,Any?>>(
            """{ "name":"Learn Kotlin", "priority":5, "completed":true}""",
            MutableMap::class.java
        )

    @Test
    fun `create project from map parsed from JSON string`() {
        val project = Project(getMapFromJSON())
        assertAll(
            { assertEquals("Learn Kotlin", project.name) },
            { assertEquals(5, project.priority) },
            { assertTrue(project.completed) }
        )
    }
}