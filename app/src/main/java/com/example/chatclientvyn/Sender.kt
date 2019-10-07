package com.example.chatclientvyn

import java.io.PrintStream

class Sender(msg: String) : Runnable {
    private val message = msg

    override fun run() {
        val socket = ClientSocket.clientSocket
        if (socket != null) {
            val outputStream = PrintStream(socket.getOutputStream(), true)
            outputStream.println(message)
        }
    }
}