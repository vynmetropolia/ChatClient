package com.example.chatclientvyn

class ChatController(view : View) : Controller {
    private val view = view

    override fun receiveMessage(msg: String) {
        println("##### SERVER ##### $msg")
        view.showMessage(msg)
    }

    override fun sendMessage(msg: String) {
        val sender = Sender(msg)
        val thread = Thread(sender)
        thread.start()
    }

    override fun setReceiver() {
        val receiver = Receiver(this)
        val thread = Thread(receiver)
        thread.start()
    }

    override fun quit() {

    }
}