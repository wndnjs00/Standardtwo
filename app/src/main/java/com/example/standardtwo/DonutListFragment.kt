package com.example.standardtwo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.standardtwo.databinding.FragmentDonutListBinding

class DonutListFragment : Fragment() {

    lateinit var binding : FragmentDonutListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.fragment_donut_list, container, false)
        binding = FragmentDonutListBinding.inflate(inflater, container, false)


        binding.textView.setOnClickListener {
            
        }


        return binding.root
    }


}