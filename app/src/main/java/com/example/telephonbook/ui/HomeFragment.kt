package com.example.telephonbook.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.telephonbook.MainActivity
import com.example.telephonbook.R
import com.example.telephonbook.adapter.Itemadapter
import com.example.telephonbook.data.DataSource
import com.example.telephonbook.data.model.Chat
import com.example.telephonbook.data.model.Person
import com.example.telephonbook.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
  //   var personList: MutableList<Person> = mutableListOf(Person(1,"Alex","2222"))
private lateinit var personList:MutableList<Person>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



      //  binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,container,true)

        binding = FragmentHomeBinding.inflate(inflater)

    personList = (activity as MainActivity).personenList

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val persList:MutableList<Person> = personList

        persList.sortBy {
            it.name
        }


        // in activity
        // binding.dogRecycler.adapter = DogAdapter(this, dogList)
        binding.oneItemRecycle.adapter = Itemadapter(persList)
        binding.oneItemRecycle.setHasFixedSize(true)



        binding.oneItemRecycle.adapter?.notifyItemRangeChanged(0,persList.size)


        binding.oneItemRecycle.adapter = Itemadapter(persList)

        binding.btnInsert2.setOnClickListener {
            addPerson()
        }


        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.oneItemRecycle)
    }




    private fun addPerson() {
        var newNameText = binding.inputName.text.toString()
        var newTelText = binding.inputTelefon.text.toString()
        var imageInt: Int = 0


        val x = (0..8).random()

        when (x){
            0 -> {imageInt = R.drawable.image0}
            1 -> {imageInt = R.drawable.image1}
            2 -> {imageInt = R.drawable.image2}
            3 -> {imageInt = R.drawable.image3}
            4 -> {imageInt = R.drawable.image4}
            5 -> {imageInt = R.drawable.image5}
            6 -> {imageInt = R.drawable.image6}
            7 -> {imageInt = R.drawable.image7}
            8 -> {imageInt = R.drawable.image8}

        }



        if (newNameText != "") {

            val newPerson = Person(imageInt,newNameText,newTelText, mutableListOf(Chat()))

            personList.add(newPerson)
//

            personList.sortBy { it.name }

            Log.d("MainActivity", "Kontakt: $newPerson")

            binding.oneItemRecycle.adapter?.notifyItemInserted(0)
            binding.oneItemRecycle.adapter?.notifyItemRangeChanged(0,personList.size)
            binding.oneItemRecycle.adapter?.notifyItemInserted(personList.size - 1)
            binding.oneItemRecycle.adapter?.notifyDataSetChanged()

            binding.inputName.setText("")
            binding.inputTelefon.setText("")
        //   Toast.makeText(this, "Kontakt wurde hinzugefügt", Toast.LENGTH_SHORT).show()


            // um softkeyboard nach bedarf auszublenden
          //  val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
          //  imm.hideSoftInputFromWindow(binding.inputName.getWindowToken(), 0)


          //  val itm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
          //  itm.hideSoftInputFromWindow(binding.inputTelefon.getWindowToken(),0)

        }


        else {
           // Toast.makeText(this, "bitte schreibe zuerst Name oder Telefon", Toast.LENGTH_SHORT).show()
        }
    }



}
