package com.example.telephonbook.data.model

import com.example.telephonbook.R
import kotlin.random.Random

data class Person(
    val imageResource: Int,
    val name: String,
    val telephonNumber: String,
    val chatList:MutableList<Chat>



)
