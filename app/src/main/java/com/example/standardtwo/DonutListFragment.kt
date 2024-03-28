package com.example.standardtwo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.standardtwo.databinding.FragmentDonutListBinding

class DonutListFragment : Fragment() {

    lateinit var binding: FragmentDonutListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDonutListBinding.inflate(inflater, container, false)


        return binding.root
    }


}