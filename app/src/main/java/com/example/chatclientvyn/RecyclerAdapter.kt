package com.example.chatclientvyn

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(val context: Context, val myUsername: String) : RecyclerView.Adapter<MessageHolder>() {
    private val messages : ArrayList<Message> = ArrayList()

    fun addMessage(msg: String) {
        val msgValues = msg.split(":")
        val message = Message(msgValues[0].trim(), msgValues[1].trim())
        messages.add(message)
    }

    override fun getItemCount(): Int {
        return messages.count()
    }

    override fun onBindViewHolder(p0: MessageHolder, p1: Int) {
        val message = messages.get(p1)
        p0.bindMessage(message)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MessageHolder {
        return if (p1 == 1) {
            MessageHolder(LayoutInflater.from(context).inflate(R.layout.type_1_message, p0, false), p1)
        } else {
            MessageHolder(LayoutInflater.from(context).inflate(R.layout.type_0_message, p0, false), p1)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val message = messages.get(position)
        return if (message.username == myUsername) {
            1
        } else 0
    }
}