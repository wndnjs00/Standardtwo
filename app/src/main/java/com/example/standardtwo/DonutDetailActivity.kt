package com.example.standardtwo

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import org.w3c.dom.Text


class DonutDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_donut_detail)


        val detail_title = findViewById<TextView>(R.id.title)
        val detail_price = findViewById<TextView>(R.id.price)
        val detail_image = findViewById<ImageView>(R.id.donut_img)


//        val title = intent.getStringExtra("title")
//        val price = intent.getStringExtra("price")
//        val image = intent.getStringExtra("image")

        // bundle을 사용해서 데이터 받아오기
        val bundle = intent.extras
        val title = bundle?.getString("title")
        val price = bundle?.getString("price")
        val image = bundle?.getInt("image")


        // title,price,image 데이터와 레이아웃을 연결
        detail_title.text = title
        detail_price.text = price

        Glide.with(this)
            .load(image)
            .into(detail_image)

//        detail_image.setImageResource(image)



    }
}