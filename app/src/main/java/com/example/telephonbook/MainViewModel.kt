package com.example.telephonbook


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.telephonbook.data.DataSource
import com.example.telephonbook.data.model.Person
import com.example.telephonbook.data.model.Chat


class MainViewModel : ViewModel() {

    val repository = DataSource()

    private lateinit var _currentMessage: Person
    val currentMessage: Person
        get() = _currentMessage

    private var _position = 0
    val position: Int
        get() = _position

    private var _person = MutableLiveData<List<Person>>(repository.loadPerson())
    val person: LiveData<List<Person>>
        get() = _person

    private val _msg = MutableLiveData<MutableList<Chat>>()
    val msg: LiveData<MutableList<Chat>>
        get() = _msg





    // findet aktuellen Kontakt über Index und speichert diesen in die Variable
    // und lädt den Chatverlauf in die LiveData
    fun initializeChat(index: Int) {
        if (_person.value != null) {

            _currentMessage = _person.value!!.get(_position)
        }
        _msg.value = _currentMessage.chatList
    }






     fun newMessage(text: String) {
        val newMessage = Chat(text)


        _msg.value?.add(0,newMessage)
        _msg.value = msg.value
    }





}
