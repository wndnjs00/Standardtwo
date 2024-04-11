package com.example.standardtwo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.standardtwo.databinding.DonutListItemBinding


// 리사이클러뷰 상속받음
class DonutAdapter(private val donutList : ArrayList<DonutDataModel>)
    : RecyclerView.Adapter<DonutAdapter.DonutViewHolder>(){


    // 아이템 클릭을 위한 인터페이스 선언
    interface ItemClick{
        fun onClick(view : View, position: Int)
    }

    var itemClick : ItemClick? = null



    // 화면(레이아웃 연결) - 바인딩 사용해서
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonutViewHolder {

        val view = DonutListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
            itemClick?.onClick(it, position)
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


    // 바인딩을 사용해서 id연결
    inner class DonutViewHolder(binding : DonutListItemBinding) : RecyclerView.ViewHolder(binding.root){

        // 레이아웃 id 가져옴
        val image = binding.donut1
        val title = binding.itemTitle
        val price = binding.itemPrice

        val empty_heart1 = binding.itemHeart
        val full_heart1 = binding.itemHeart2

    }


}
