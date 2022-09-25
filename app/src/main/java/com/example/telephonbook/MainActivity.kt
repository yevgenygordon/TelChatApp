package com.example.telephonbook

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.getSystemService
import androidx.databinding.DataBindingUtil
import com.example.telephonbook.adapter.Itemadapter
import com.example.telephonbook.data.DataSource
import com.example.telephonbook.data.model.Chat
import com.example.telephonbook.data.model.Person
import com.example.telephonbook.databinding.ActivityMainBinding
import com.example.telephonbook.databinding.FragmentDetailBinding
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
  //  private lateinit var personList: MutableList<Person>

    val personenList:MutableList<Person> = DataSource().loadPerson()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main,)









    }





}