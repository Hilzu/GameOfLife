package gameoflife

fun main(args: Array<String>): Unit {
    val ui = UI()
    ui.createWindow(25, 25)
    var state = State(25, 25)
    state.randomize()

    while (true) {
        state = state.simulate()
        ui.updateWindow(state.aliveGrid)
        Thread.sleep(500)
    }
}
