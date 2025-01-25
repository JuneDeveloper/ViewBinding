package com.example.viewbinding.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewbinding.R
import com.example.viewbinding.databinding.FragmentChatBinding
import com.example.viewbinding.databinding.FragmentMainBinding

class ChatFragment : Fragment(R.layout.fragment_chat) {
    private var _binding:FragmentChatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textChatTV.text = "Чат открыт..."
        binding.sendChatBTN.setOnClickListener {
            binding.textChatTV.append("\n\n${binding.inputTextChatET.text}")
            binding.inputTextChatET.text.clear()
        }
        binding.backChatBTN.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.first_fragment,MainFragment()).commit()
        }
    }
}