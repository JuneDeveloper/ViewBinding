package com.example.viewbinding.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.example.viewbinding.R
import com.example.viewbinding.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private var _binding:FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    @SuppressLint("CommitTransaction", "ResourceType")
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardHomeCV.setOnClickListener {
            binding.linearMainFragment
                .startAnimation(AnimationUtils.loadAnimation(context,R.anim.animation_home))
        }
        binding.cardChatCV.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.first_fragment, ChatFragment())
                .commit()
        }
        binding.cardSettingCV.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.first_fragment, SettingFragment())
                .commit()
        }
        binding.cardProfileCV.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.first_fragment, ProfileFragment())
                .commit()
            parentFragmentManager.saveBackStack("profile")
        }
        binding.cardWeatherCV.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.first_fragment, GalleryFragment())
                .commit()
        }
        binding.cardLogoutCV.setOnClickListener {
            activity?.finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}