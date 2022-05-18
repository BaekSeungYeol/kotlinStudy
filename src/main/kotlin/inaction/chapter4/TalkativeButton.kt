package inaction.chapter4

internal open class TalkativeButton : Focusable{
    fun yell() = println("Hey!")
    fun whisper() = println("Let's talk!")
}

internal fun TalkativeButton.giveSpeech() {
    yell()
    whisper()
}

