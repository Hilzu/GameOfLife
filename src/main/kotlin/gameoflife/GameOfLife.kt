package gameoflife

import javax.swing.Timer
import java.awt.event.ActionListener
import java.awt.event.ActionEvent

class GameOfLife : ActionListener {
    val ui = UI(this)
    val timer = Timer(500, this)
    var state = State.reaktorState()

    fun create() {
        ui.createWindow(state.height, state.width)
        ui.update(state.aliveGrid)
    }

    fun play() {
        timer.restart()
    }

    fun pause() {
        timer.stop()
    }

    public override fun actionPerformed(e: ActionEvent) {
        state = state.stateAfterInteraction()
        ui.update(state.aliveGrid)
        timer.restart()
    }
}

fun main(args: Array<String>) {
    val game = GameOfLife()
    game.create()
}
