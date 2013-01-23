package gameoflife

import java.awt.*
import java.util.ArrayList
import javax.swing.*

class UI {
    val cells: ArrayList<JLabel> = ArrayList<JLabel>()
    val cellSize = 20
    val aliveColor = Color.BLACK
    val deadColor = Color.WHITE

    fun createWindow(height: Int, width: Int) {
        val frame = JFrame("Game of Life")
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        val gridPanel = JPanel(GridLayout(height, width))
        gridPanel.setPreferredSize(Dimension(width * cellSize, height * cellSize))
        for (i in 1..(height * width)) {
            val cell = JLabel(" ")
            //            cell.setBackground(aliveColor)
            cell.setSize(cellSize, cellSize)
            cell.setOpaque(true)
            cells.add(cell)
            gridPanel.add(cell)
        }
        frame.add(gridPanel)
        frame.pack()
        frame.setVisible(true)
    }

    fun updateWindow(aliveGrid: Array<Array<Boolean>>) {
        for (row in aliveGrid.indices) {
            for (col in aliveGrid[row].indices) {
                val cell = cells.get(row * aliveGrid[0].size + col)
                val alive = aliveGrid[row][col]
                if (alive)
                    cell.setBackground(aliveColor)
                else
                    cell.setBackground(deadColor)
            }
        }
    }
}