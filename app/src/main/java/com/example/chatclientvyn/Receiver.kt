package com.example.chatclientvyn

import java.io.IOException
import java.util.*
import kotlin.NoSuchElementException

class Receiver(controller: ChatController) : Runnable {
    private val controller = controller

    override fun run() {
        try {
            val socket = ClientSocket.clientSocket
            if (socket != null) {
                val inputStream = socket.getInputStream()
                val scanner = Scanner(inputStream)
                while (scanner.hasNextLine()) {         // iterate till end
                    controller.receiveMessage(scanner.nextLine())
                }
            }
        } catch (e : IOException) {
            e.printStackTrace()
        } catch (e: NoSuchElementException) {
            e.printStackTrace()
        }
    }
}