package com.example.telephonbook.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.telephonbook.R
import com.example.telephonbook.data.model.Chat
import com.example.telephonbook.data.model.Person
import com.example.telephonbook.ui.DetailFragmentDirections
import com.example.telephonbook.ui.HomeFragmentDirections


/**
 * Der Item Adapter weist den views im ViewHolder den Inhalt zu
 */
class Chatadapter(
    private var dataset: MutableList<Chat>,
) : RecyclerView.Adapter<Chatadapter.ChatViewHolder>() {

    /**
     * der ViewHolder umfasst die View uns stellt einen Listeneintrag dar
     */
    inner class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // TODO findViewById holen   -----------------


        val chatText: TextView = itemView.findViewById(R.id.chatField_textView)

    }


    fun submitList(list: MutableList<Chat>) {
        dataset = list

        // updatet nur das neueste Element der Liste damit es auch schön animiert wird
        notifyItemInserted(0)
      //  notifyDataSetChanged()
    }




    /**
     * hier werden neue ViewHolder erstellt
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {

        // das itemLayout wird gebaut

        val chatadapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.chat_item,parent,false)

        // und in einem ViewHolder zurückgegeben
        return ChatViewHolder(chatadapterLayout)


    }

    /**
     * hier findet der Recyclingprozess statt
     * die vom ViewHolder bereitgestellten Parameter erhalten die Information des Listeneintrags
     */
    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chatItem = dataset[position]

        holder.chatText.text = chatItem.chatMessage





    }



    /**
     * damit der LayoutManager weiß, wie lang die Liste ist
     */
    override fun getItemCount(): Int {
        return dataset.size
    }




}