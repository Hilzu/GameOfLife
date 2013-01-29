package gameoflife

import javax.swing.JPanel
import java.awt.Graphics
import java.awt.Color

class CellPanel: JPanel() {
    var cells: Array<Array<Boolean>> = array()
    val aliveColor = Color.BLACK
    val deadColor = Color.WHITE
    val cellSize = 10

    fun updateCells(cells: Array<Array<Boolean>>) {
        this.cells = cells
    }

    override fun paintComponent(g: Graphics) {
        super<JPanel>.paintComponent(g)
        for (row in cells.indices) {
            for (col in cells[row].indices) {
                val alive = cells[row][col]
                if (alive) {
                    g.setColor(aliveColor)
                }  else {
                    g.setColor(deadColor)
                }
                g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize)
            }
        }
    }
}