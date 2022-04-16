package chapter4

import java.io.Serializable

interface State: Serializable

interface View {
    fun getCurrentstate() : State
    fun restoreState(state: State) {}
}


class Button2 : View {
    override fun getCurrentstate(): State = ButtonState()
    override fun restoreState(state: State) { }
    inner class ButtonState : State { }
}

fun main() {
    val c = Button2().ButtonState()
}

