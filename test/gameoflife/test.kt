package gameoflife

import java.util.ArrayList
import org.junit.*
import org.junit.Assert.*

class TestSuite {

    fun createRowFromString(str: String): Array<Boolean> {
        val row = ArrayList<Boolean>()
        for (char in str) {
            if (char == 'X') row.add(true)
            else row.add(false)
        }
        return Array<Boolean>(row.size(), { row.get(it) })
    }

    val testState = State(10, 10)

    Before fun before() {
        testState.aliveGrid[0] = createRowFromString("XX      XX")
        testState.aliveGrid[1] = createRowFromString("X         ")
        testState.aliveGrid[2] = createRowFromString("          ")
        testState.aliveGrid[3] = createRowFromString("          ")
        testState.aliveGrid[4] = createRowFromString("          ")
        testState.aliveGrid[5] = createRowFromString("          ")
        testState.aliveGrid[6] = createRowFromString("          ")
        testState.aliveGrid[7] = createRowFromString("          ")
        testState.aliveGrid[8] = createRowFromString("XX        ")
        testState.aliveGrid[9] = createRowFromString("XXX       ")
    }

    Test fun isValidCellTest1() {
        val state = State(10, 10)
        assertFalse(state.isValidCell(-1, 0))
    }

    Test fun isValidCellTest2() {
        val state = State(10, 10)
        assertFalse(state.isValidCell(0, -1))
    }

    Test fun isValidCellTest3() {
        val state = State(10, 10)
        assertFalse(state.isValidCell(10, 0))
    }

    Test fun isValidCellTest4() {
        val state = State(10, 10)
        assertFalse(state.isValidCell(0, 10))
    }

    Test fun isValidCellTest5() {
        val state = State(10, 10)
        assertTrue(state.isValidCell(4, 6))
    }

    Test fun isValidCellTest6() {
        val state = State(10, 10)
        assertFalse(state.isValidCell(10, 10))
    }

    Test fun interactTest1() {
        assertTrue(testState.interact(0, 0))
    }

    Test fun interactTest2() {
        assertTrue(testState.interact(0, 1))
    }

    Test fun interactTest3() {
        assertTrue(testState.interact(1, 0))
    }

    Test fun interactTest4() {
        assertTrue(testState.interact(1, 1))
    }

    Test fun interactTest5() {
        assertFalse(testState.interact(0, 2))
    }

    Test fun interactTest6() {
        assertFalse(testState.interact(0, 9))
    }

    Test fun interactTest7() {
        assertFalse(testState.interact(9, 1))
    }

    Test fun aliveNeighboursTest1() {
        assertEquals(2, testState.aliveNeighbours(0, 0));
    }

    Test fun aliveNeighboursTest2() {
        assertEquals(4, testState.aliveNeighbours(8, 1));
    }

    Test fun aliveNeighboursTest3() {
        assertEquals(0, testState.aliveNeighbours(4, 4));
    }

    Test fun aliveNeighboursTest4() {
        assertEquals(4, testState.aliveNeighbours(9, 1));
    }

}