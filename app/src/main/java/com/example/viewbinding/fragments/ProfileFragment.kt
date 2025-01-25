package com.example.viewbinding.fragments

import android.annotation.SuppressLint
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewbinding.utils.MyAdapter
import com.example.viewbinding.model.Person
import com.example.viewbinding.R
import com.example.viewbinding.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private var _binding:FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val listPerson = mutableListOf<Person>()
    private val GALLERY_REQUEST = 1
    private var selectImage: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MyAdapter(listPerson)
        binding.recycleViewRV.adapter = adapter

        getImage()

        binding.saveProfileBTN.setOnClickListener {
            val person = Person(
                binding.nameRecycleViewET.text.toString(),
                binding.surnameRecycleViewET.text.toString(),
                binding.ageRecycleViewET.text.toString(),
                binding.phoneRecycleViewET.text.toString())
            listPerson.add(person)
            adapter.notifyDataSetChanged()
        }
    }

    private fun getImage() {
        binding.imageProfileIV.setOnClickListener {
            val photo = Intent(Intent.ACTION_PICK)
            photo.type = "image/*"
            startActivityForResult(photo,GALLERY_REQUEST)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            GALLERY_REQUEST -> {
                if (resultCode == RESULT_OK ){
                    selectImage = data?.data
                    binding.imageProfileIV.setImageURI(selectImage)
                }
            }
        }
    }
}