package gameoflife

import java.awt.*
import java.util.ArrayList
import javax.swing.*

class UI {
    val cellPanel = CellPanel()

    fun createWindow(height: Int, width: Int) {
        val frame = JFrame("Game of Life")
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        cellPanel.setPreferredSize(Dimension(width * cellPanel.cellSize, height * cellPanel.cellSize))
        frame.add(cellPanel)
        frame.pack()
        frame.setVisible(true)
    }

    fun update(aliveGrid: Array<Array<Boolean>>) {
        cellPanel.updateCells(aliveGrid)
        cellPanel.repaint()
    }
}