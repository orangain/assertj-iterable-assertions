import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class IterableTest {
    private val list = listOf(0, 1, 1, 2, 3, 5)

    @Test
    fun testContainsAnyOf() {
        assertThat(list)
            .containsAnyOf(1)
            .containsAnyOf(4, 3, 2)
            //.containsAnyOf(4) // fail
            .containsAnyElementsOf(listOf(4, 3, 2))
            .doesNotContainAnyElementsOf(listOf(4, 6))
    }

    @Test
    fun testContains() {
        assertThat(list)
            .contains(1)
            .contains(5, 3, 2)
            //.contains(4, 3, 2) // fail
            .doesNotContain(4, 6)
            .doesNotContainAnyElementsOf(listOf(4, 6))
    }

    @Test
    fun testContainsOnly() {
        assertThat(list)
            .containsOnly(5, 3, 2, 1, 0)
        //.containsOnly(5, 3, 2) // fail
    }

    @Test
    fun testContainsExactlyInAnyOrder() {
        assertThat(list)
            .containsExactlyInAnyOrder(5, 3, 2, 1, 1, 0)
            //.containsExactlyInAnyOrder(5, 3, 2, 1, 0) // fail
            .containsExactlyInAnyOrderElementsOf(listOf(5, 3, 2, 1, 1, 0))
    }

    @Test
    fun testContainsExactly() {
        assertThat(list)
            .containsExactly(0, 1, 1, 2, 3, 5)
            //.containsExactly(5, 3, 2, 1, 1, 0) // fail
            .containsExactlyElementsOf(listOf(0, 1, 1, 2, 3, 5))
    }

    @Test
    fun testIsEqualTo() {
        assertThat(list)
            .isEqualTo(listOf(0, 1, 1, 2, 3, 5))
        //.isEqualTo(arrayOf(0, 1, 1, 2, 3, 5)) // fail
    }

    @Test
    fun testContainsSubsequence() {
        assertThat(list)
            .containsSubsequence(1, 1, 2, 5)
            //.containsSubsequence(3, 2, 1) // fail
            .doesNotContainSequence(3, 2, 1)
    }

    @Test
    fun testContainsSequence() {
        assertThat(list)
            .containsSequence(1, 1, 2, 3)
            //.containsSequence(1, 1, 2, 5) // fail
            .doesNotContainSequence(3, 2, 1)
    }

    @Test
    fun testContainsOnlyOnce() {
        assertThat(list)
            .containsOnlyOnce(0, 2, 3)
            //.containsOnlyOnce(1) // fail
            .containsOnlyOnceElementsOf(listOf(0, 2, 3))
    }
}