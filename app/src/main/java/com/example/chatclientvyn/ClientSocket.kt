package com.example.chatclientvyn

import java.io.IOException
import java.net.InetAddress
import java.net.Socket

object ClientSocket {
    private const val address = "172.20.10.8" // my hotspot IP address
    private const val host = 30001
    lateinit var clientSocket : Socket

    fun init() {
        try {
            clientSocket = Socket(InetAddress.getByName(address), host)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}