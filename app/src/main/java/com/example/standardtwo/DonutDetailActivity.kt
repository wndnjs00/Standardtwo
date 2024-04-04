package com.example.standardtwo

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


class DonutDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_donut_detail)


        val detail_title = findViewById<TextView>(R.id.title)
        val detail_price = findViewById<TextView>(R.id.price)
        val detail_image = findViewById<ImageView>(R.id.donut_img)

        val empty_heart = findViewById<ImageView>(R.id.heart1)
        val full_heart = findViewById<ImageView>(R.id.heart2)

        val no_btn = findViewById<ImageView>(R.id.noBtn)



        // bundle을 사용해서 DonutListFragment에서 보낸  데이터 받아오기
        val bundle = intent.extras
        val title = bundle?.getString("title")
        val price = bundle?.getString("price")
        val image = bundle?.getInt("image")


        // 레이아웃과 title,price,image 데이터를 연결
        detail_title.text = title
        detail_price.text = price

        Glide.with(this)
            .load(image)
            .into(detail_image)

//        if (image != null) {
//            detail_image.setImageResource(image)
//        }


        // 빈하트 클릭시
        empty_heart.setOnClickListener {
            empty_heart.visibility = View.GONE      // 빈하트 안보이게
            full_heart.visibility = View.VISIBLE    // 채워진하트 보이게
        }

        // 채워진하트 클릭시
        full_heart.setOnClickListener {
            empty_heart.visibility = View.VISIBLE
            full_heart.visibility = View.GONE
        }

        // 엑스버튼 클릭시
        no_btn.setOnClickListener {
            finish()
        }

    }


}