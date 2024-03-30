package com.example.standardtwo

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.standardtwo.databinding.FragmentDonutListBinding

class DonutListFragment : Fragment() {

    private lateinit var binding: FragmentDonutListBinding

    private lateinit var donutList : ArrayList<DonutDataModel>
    private lateinit var donutAdapter : DonutAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // 뷰바인딩
        binding = FragmentDonutListBinding.inflate(inflater, container, false)


        // 리스트 초기화
        donutList = ArrayList()

        // donutList에 데이터추가
        donutList.add(DonutDataModel(R.drawable.donut1, "Little chicken", "R$ 9,99"))
        donutList.add(DonutDataModel(R.drawable.donut2, "Strawberry donut", "R$ 9,89"))
        donutList.add(DonutDataModel(R.drawable.donut3, "Almond donut", "R$ 9,79"))
        donutList.add(DonutDataModel(R.drawable.donut4, "Chocolate donut", "R$ 9,95"))
        donutList.add(DonutDataModel(R.drawable.donut5, "Strawberry donut", "R$ 9,93"))
        donutList.add(DonutDataModel(R.drawable.donut6, "Strawberry donut", "R$ 9,96"))


        donutAdapter = DonutAdapter(donutList)
        binding.rv.adapter = donutAdapter     // 리사이클러뷰와 어뎁터 연결


        // 아이템 클릭시
        donutAdapter.onItemClick = {
            val intent = Intent(context, DonutDetailActivity::class.java)
            startActivity(intent)
        }


        // 한줄에 아이템 2개씩
        binding.rv.layoutManager = GridLayoutManager(context,2)


        return binding.root

    }


}