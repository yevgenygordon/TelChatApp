package com.example.telephonbook.adapter



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.telephonbook.R
import com.example.telephonbook.data.model.Person
import com.example.telephonbook.ui.HomeFragmentDirections


/**
 * Der Item Adapter weist den views im ViewHolder den Inhalt zu
 */
class Itemadapter(
    private val dataset: MutableList<Person>
) : RecyclerView.Adapter<Itemadapter.ItemViewHolder>() {

    /**
     * der ViewHolder umfasst die View uns stellt einen Listeneintrag dar
     */
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // TODO findViewById holen   -----------------

        val personImage: ImageView = itemView.findViewById(R.id.Person_imageView)
        val personName: TextView = itemView.findViewById(R.id.personName_textView)
        val perspnTelNumber: TextView = itemView.findViewById(R.id.telNumber_textView)
        val btnDelete: ImageView = itemView.findViewById(R.id.btn_delete_person)

    }

    /**
     * hier werden neue ViewHolder erstellt
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        // das itemLayout wird gebaut
        // TODO Schreibe hier deinen Code -------------------

        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.one_item,parent,false)

        // und in einem ViewHolder zurückgegeben
        return ItemViewHolder(adapterLayout)


    }

    /**
     * hier findet der Recyclingprozess statt
     * die vom ViewHolder bereitgestellten Parameter erhalten die Information des Listeneintrags
     */


    /**
     * damit der LayoutManager weiß, wie lang die Liste ist
     */
    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val personItem = dataset[position]


        holder.personName.text = personItem.name
        holder.perspnTelNumber.text = personItem.telephonNumber
        holder.personImage.setImageResource(personItem.imageResource)

        holder.btnDelete.setOnClickListener {

           dataset.remove(personItem)
            dataset.sortBy { it.name }
            notifyDataSetChanged()

        }


        holder.personImage.setOnClickListener {


            holder.itemView.findNavController()
                .navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                    personItem.imageResource,
                    personItem.name,
                    personItem.telephonNumber,
                    position
                ))

        }



    }
}
