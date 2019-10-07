package com.example.chatclientvyn

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.type_0_message.view.*
import kotlinx.android.synthetic.main.type_1_message.view.*

class MessageHolder(view: View, type: Int) : RecyclerView.ViewHolder(view) {
    private var message : TextView = if (type == 1) view.type1Message else view.type0Message
    private var username : TextView? = view.otherUsername

    fun bindMessage(msg: Message) {
        message.text = msg.msg
        username?.text = msg.username
    }
}