package gameoflife

import javax.swing.Timer
import java.awt.event.ActionListener
import java.awt.event.ActionEvent

class GameOfLife : ActionListener {
    val cols = 100
    val rows = 60
    val ui = UI()
    val timer = Timer(500, this)
    var state = State(rows, cols)

    fun start() {
        ui.createWindow(rows, cols)
        state.randomize()
        timer.start()
    }

    public override fun actionPerformed(e: ActionEvent) {
        state = state.simulate()
        ui.update(state.aliveGrid)
        timer.restart()
    }
}

fun main(args: Array<String>): Unit {
    val game = GameOfLife()
    game.start()
}
