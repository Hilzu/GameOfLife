package gameoflife

import java.util.LinkedList
import java.util.Random

class State(val height: Int, val width: Int) {

    val aliveGrid = Array<Array<Boolean>>(height, {
        Array<Boolean>(width, { false })
    })

    fun randomize(seed: Long = 1) {
        val random = Random(seed)
        for (row in aliveGrid.indices) {
            for (col in aliveGrid[row].indices) {
                aliveGrid[row][col] = random.nextBoolean()
            }
        }
    }

    fun isValidCell(row: Int, col: Int) =
            if (row < 0 || col < 0 || row >= height || col >= width)
                false
            else
                true

    fun getNeighbours(row: Int, col: Int): List<Boolean> {
        val neighboursList = LinkedList<Boolean>()
        // Left
        neighboursList.add(if (isValidCell(row - 1, col)) aliveGrid[row - 1][col] else false)
        // Upper Left
        neighboursList.add(if (isValidCell(row - 1, col - 1)) aliveGrid[row - 1][col - 1] else false)
        // Up
        neighboursList.add(if (isValidCell(row, col - 1)) aliveGrid[row][col - 1] else false)
        // Upper Right
        neighboursList.add(if (isValidCell(row - 1, col + 1)) aliveGrid[row - 1][col + 1] else false)
        // Right
        neighboursList.add(if (isValidCell(row, col + 1)) aliveGrid[row][col + 1] else false)
        // Lower Right
        neighboursList.add(if (isValidCell(row + 1, col + 1)) aliveGrid[row + 1][col + 1] else false)
        // Down
        neighboursList.add(if (isValidCell(row + 1, col)) aliveGrid[row + 1][col] else false)
        // Lower Left
        neighboursList.add(if (isValidCell(row + 1, col - 1)) aliveGrid[row + 1][col - 1] else false)

        return neighboursList
    }

    fun aliveNeighbours(row: Int, col: Int): Int {
        val neighbours = getNeighbours(row, col)
        var aliveAmount = 0
        for (neighbour in neighbours) {
            if (neighbour) aliveAmount++
        }
        return aliveAmount
    }

    fun interact(row: Int, col: Int): Boolean {
        val aliveNeighbours = aliveNeighbours(row, col)
        val alive = aliveGrid[row][col]
        if (alive) {
            if (aliveNeighbours < 2) {
                return false
            } else if (aliveNeighbours < 4) {
                return true
            } else {
                return false
            }
        } else {
            if (aliveNeighbours == 3) {
                return true
            } else {
                return false
            }
        }
    }

    fun simulate(): State {
        val newState = State(height, width)
        for (row in aliveGrid.indices) {
            for (col in aliveGrid[row].indices) {
                newState.aliveGrid[row][col] = interact(row, col)
            }
        }
        return newState
    }

    fun toString(): String {
        val stringBuilder = StringBuilder()
        for (row in aliveGrid.indices) {
            for (col in aliveGrid[row].indices) {
                val alive = aliveGrid[row][col]
                stringBuilder.append(if (alive) "X" else "-")
            }
            stringBuilder.append("\n")
        }
        return stringBuilder.toString()
    }
}