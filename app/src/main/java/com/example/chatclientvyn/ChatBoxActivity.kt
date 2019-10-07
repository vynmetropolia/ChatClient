package com.example.chatclientvyn

import android.content.Intent
import android.os.Bundle
import android.provider.DocumentsContract.EXTRA_INFO
import android.text.TextUtils
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_chat_box.*

class ChatBoxActivity : AppCompatActivity(), com.example.chatclientvyn.View {
    private lateinit var controller : ChatController
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_box)

        controller = ChatController(this).apply { setReceiver() }

        var username : String?
        if (intent.getStringExtra(EXTRA_INFO) != null) { // coming from login
            username = intent.getStringExtra(EXTRA_INFO)
        } else { // user returns to app
            username = User.username
            controller.sendMessage(" $username")
        }

        messageRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerAdapter(this, username!!)
        messageRecyclerView.adapter = adapter
    }

    override fun showMessage(msg: String) {
        if (msg.startsWith("[Message]")) {
            runOnUiThread {
                adapter.addMessage(msg.replace("[Message]", ""))
                adapter.notifyItemInserted(adapter.itemCount)
                messageRecyclerView.smoothScrollToPosition(adapter.itemCount - 1)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_quit -> {
            handleQuit()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        handleQuit()
    }

    fun sendMessage(view: View) {
        val message : String = messageInput.text.toString()
        when {
            TextUtils.isEmpty(message) -> // check empty message
                Toast.makeText(applicationContext, "Type in your message to send.", Toast.LENGTH_SHORT).show()
            message.startsWith(":") -> // prevent commands
                Toast.makeText(applicationContext, "Please send your messages without special prefix characters", Toast.LENGTH_SHORT).show()
            else -> {
                controller.sendMessage(message)
                messageInput.text.clear()
            }
        }
    }

    private fun handleQuit() {
        User.username = null
        controller.quit()
    }
}
