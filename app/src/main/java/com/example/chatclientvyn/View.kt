package com.example.chatclientvyn


interface View {
    fun showMessage(msg: String) {}
    fun showError(errorMsg: String) {}
}