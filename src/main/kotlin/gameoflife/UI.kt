package gameoflife

import java.awt.*
import java.util.ArrayList
import javax.swing.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class UI(val gameOfLife: GameOfLife) : ActionListener {
    val frame = JFrame("Game of Life")
    val mainPanel = JPanel()
    val cellPanel = CellPanel()
    val controlPanel = JPanel()
    val playButton = JButton("Play")
    val pauseButton = JButton("Pause")

    fun createWindow(cellRows: Int, cellCols: Int) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

        mainPanel.setLayout(BoxLayout(mainPanel, BoxLayout.PAGE_AXIS))

        cellPanel.setPreferredSize(Dimension(cellCols * cellPanel.cellSize, cellRows * cellPanel.cellSize))

        controlPanel.setPreferredSize(Dimension(400, 50))
        controlPanel.setLayout(GridLayout(0, 4))
        controlPanel.setBorder(BorderFactory.createTitledBorder("Controls"))

        playButton.setActionCommand("play")
        playButton.addActionListener(this)
        pauseButton.setActionCommand("pause")
        pauseButton.addActionListener(this)

        controlPanel.add(playButton)
        controlPanel.add(pauseButton)

        mainPanel.add(Box.createRigidArea(Dimension(0, 0)))
        mainPanel.add(cellPanel)
        mainPanel.add(Box.createRigidArea(Dimension(0, 10)))
        mainPanel.add(controlPanel)

        frame.add(mainPanel)
        frame.pack()
        frame.setVisible(true)
    }

    override fun actionPerformed(e: ActionEvent) {
        when (e.getActionCommand()) {
            "pause" -> gameOfLife.pause()
            "play" -> gameOfLife.play()
            else -> throw IllegalArgumentException("Unknow actionCommand: ${e.getActionCommand()}")
        }

    }

    fun update(aliveGrid: Array<Array<Boolean>>) {
        cellPanel.updateCells(aliveGrid)
        cellPanel.repaint()
    }
}