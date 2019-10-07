package com.example.chatclientvyn

import android.content.Intent
import android.os.Bundle
import android.provider.DocumentsContract.EXTRA_INFO
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity(), com.example.chatclientvyn.View{
    private lateinit var controller : ChatController

    fun submitUsername(view: View) {
        val setUsernameText = findViewById<EditText>(R.id.setUsernameText)
        if (setUsernameText.text.isNotEmpty()) {
            val username = setUsernameText.text.toString()
            if (username.contains(" ") || username.startsWith(":")) { // validate username
                Toast.makeText(applicationContext, "Username can not have whitespace or start with colon", Toast.LENGTH_SHORT).show()
            } else {
                controller.sendMessage("$username")
                User.username = username  // Set username
                val intent = Intent(this, ChatBoxActivity::class.java).apply {
                    putExtra(EXTRA_INFO, username)
                }
                // go to chat screen after setting username
                startActivity(intent)
                finish()
            }
        } else {
            Toast.makeText(applicationContext, "You must set your username to use this chat app", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        // initiate a controller to set username later on
        controller = ChatController(this)

        Thread {
            ClientSocket.init()
        }.start()

    }
}
