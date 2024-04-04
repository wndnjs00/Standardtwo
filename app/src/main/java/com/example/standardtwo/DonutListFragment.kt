package com.example.standardtwo

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.standardtwo.databinding.FragmentDonutListBinding

class DonutListFragment : Fragment() {

    private lateinit var binding: FragmentDonutListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // 뷰바인딩
        binding = FragmentDonutListBinding.inflate(inflater, container, false)

        // 리스트 초기화
        val List = donutList(resources)









        val donutAdapter = DonutAdapter(List)
        binding.rv.adapter = donutAdapter     // 리사이클러뷰와 어뎁터 연결


        // 리스트 아이템 클릭시
        donutAdapter.onItemClick = {
            val intent = Intent(context, DonutDetailActivity::class.java)

            // DonutDetailActivity로 image, title, price 정보 넘겨주기
            intent.putExtra("image", it.image)
            intent.putExtra("title", it.title)
            intent.putExtra("price", it.price)

            startActivity(intent)
        }


        // 한줄에 아이템 2개씩
        binding.rv.layoutManager = GridLayoutManager(context,2)


        return binding.root

    }


    fun donutList(resources: Resources) : ArrayList<DonutDataModel>{

        return arrayListOf(
            DonutDataModel(
                image = R.drawable.donut1,
                title = "Little chicken",
                price = "R$ 9,99"
            ),
            DonutDataModel(
                image = R.drawable.donut2,
                title = "Strawberry donut",
                price = "R$ 9,89"
            ),
            DonutDataModel(
                image = R.drawable.donut3,
                title = "Almond donut",
                price = "R$ 9,79"
            ),
            DonutDataModel(
                image = R.drawable.donut4,
                title = "Chocolate donut",
                price = "R$ 9,95"
            ),
            DonutDataModel(
                image = R.drawable.donut5,
                title = "Strawberry donut",
                price = "R$ 9,93"
            ),
            DonutDataModel(
                image = R.drawable.donut6,
                title = "Strawberry donut",
                price = "R$ 9,96"
            ),
        )
    }

}