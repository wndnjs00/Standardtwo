package com.example.standardtwo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.standardtwo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 뷰바인딩 사용(초기화해줌)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 버튼 클릭시
        binding.button.setOnClickListener {
            // frameLayout에 DonutListFragment연결
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, DonutListFragment())
                .commit()
        }


    }
}