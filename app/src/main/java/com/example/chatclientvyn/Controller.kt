package com.example.chatclientvyn

interface Controller {
    fun receiveMessage(msg: String) {}
    fun sendMessage(msg: String) {}
    fun setReceiver() {}
    fun quit() {}
}