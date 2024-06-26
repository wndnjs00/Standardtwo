package com.example.standardtwo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


// 리사이클러뷰 상속받음
class DonutAdapter(private val donutList : ArrayList<DonutDataModel>)
    : RecyclerView.Adapter<DonutAdapter.DonutViewHolder>(){

        var onItemClick : ((DonutDataModel) -> Unit)? = null


    class DonutViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        // 레이아웃 id 가져옴
//        val image : ImageView = itemView.findViewById(R.id.donut1)        // 이렇게 써도됨
        val image = itemView.findViewById<ImageView>(R.id.donut1)
        val title = itemView.findViewById<TextView>(R.id.item_title)
        val price = itemView.findViewById<TextView>(R.id.item_price)

        val empty_heart1 = itemView.findViewById<ImageView>(R.id.item_heart)
        val full_heart1 = itemView.findViewById<ImageView>(R.id.item_heart2)

    }


    // 화면(레이아웃 연결)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonutViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.donut_list_item, parent, false)
        return DonutViewHolder(view)
    }


    // 개수 리턴
    override fun getItemCount(): Int {
        return donutList.size
    }


    // 데이터 연결
    override fun onBindViewHolder(holder: DonutViewHolder, position: Int) {

        val donut = donutList[position]

        // 레이아웃과 데이터모델 연결
        holder.title.text = donut.title
        holder.price.text = donut.price
        holder.image.setImageResource(donut.image)


        // 리사이클러뷰 아이템 클릭시
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(donut)
        }


        // 리사이클러뷰 아이템 빈하트 클릭시
        holder.empty_heart1.setOnClickListener {
            holder.empty_heart1.visibility = View.GONE
            holder.full_heart1.visibility = View.VISIBLE
        }

        // 채워진하트 클릭시
        holder.full_heart1.setOnClickListener {
            holder.empty_heart1.visibility = View.VISIBLE
            holder.full_heart1.visibility = View.GONE
        }

    }

}