package com.example.telephonbook.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.telephonbook.MainActivity
import com.example.telephonbook.MainViewModel
import com.example.telephonbook.adapter.Chatadapter
import com.example.telephonbook.data.model.Chat
import com.example.telephonbook.data.model.Person
import com.example.telephonbook.databinding.FragmentChatBinding


class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding
    //   var personList: MutableList<Person> = mutableListOf(Person(1,"Alex","2222"))
    private lateinit var personList:MutableList<Person>
    private lateinit var messagesList: MutableList<Chat>

    private val chatViewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        //  binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,container,true)

        binding = FragmentChatBinding.inflate(inflater)

        personList = (activity as MainActivity).personenList
        messagesList = (activity as MainActivity).personenList[3].chatList



        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.chatMaterialToolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }



        val oldText = requireArguments().getString("oldText", "")
        val namePerson = requireArguments().getString("namePerson", "No Name")
        val imageId = requireArguments().getInt("imagePerson",0)
        val position = requireArguments().getInt("position",0)


        chatViewModel.initializeChat(position)

        val chatadapter = Chatadapter(messagesList)

        binding.chatRecycler.adapter = chatadapter
        //   binding.chatRecycler.setHasFixedSize(true)

        chatViewModel.msg.observe(
            viewLifecycleOwner,
            Observer {
                Log.d("HomeFragment", "Observer BANG! Liste: $it")
                chatadapter.submitList(it)
            }
        )

        val persID = chatViewModel.person.value?.find { it.name == namePerson}
        binding.chatMaterialToolbar.title = persID?.name


        binding.sendFAB.setOnClickListener {
            val newText = binding.chatInputView.text.toString()

            chatViewModel.newMessage(newText)






            }

    }
}