package com.example.telephonbook.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.telephonbook.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView (

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val name = requireArguments().getString("namePerson","No Name")
        val tel = requireArguments().getString("telPerson","No Number")
        val imageId = requireArguments().getInt("imagePerson",0)
        val position = requireArguments().getInt("position",0)


        binding.personNameDetailText.text = name
        binding.telNumberDetailText.text = tel
        binding.personEditimage.setImageResource(imageId)
        binding.detaillMaterialToolbar.title = name
        binding.toolbarImageView.setImageResource(imageId)

        binding.chatFAB.setOnClickListener {

              findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToChatFragment(
                  imageId,
                  name,
                  oldText = "",
                  position = position
              ))

        }


        binding.detaillMaterialToolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }



    }

}