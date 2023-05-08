package effective.item27

import javax.naming.Context

interface MessageDisplay {
    fun show(
        message: String,
        duration: MessageLength = MessageLength.LONG
    )
}

class ToastDisplay(val context: Context) : MessageDisplay {

    override fun show(message: String, duration: MessageLength) {
        val toastDuration = when(duration) {
            MessageLength.SHORT -> MessageLength.SHORT
            MessageLength.LONG -> MessageLength.LONG
        }

        // Toast.makeText(context,message,toastDuration)
        //     .show()
    }
}

enum class MessageLength { SHORT, LONG }