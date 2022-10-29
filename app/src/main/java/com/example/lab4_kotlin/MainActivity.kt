package com.example.lab4_kotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab4_kotlin.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChoice.setOnClickListener{
            handlechoice()
        }

    }
    private fun handlechoice(){
        startActivityForResult(Intent(this,Main2Activity::class.java),1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.let {
            if (requestCode == 1) {
                if (resultCode == 101) {
                    val b = data.extras
                    val str1 = b!!.getString("drink")
                    val str2 = b.getString("sugar")
                    val str3 = b.getString("ice")
                    binding.tvMeal.text=
                        String.format(
                            "飲料：%s\n\n甜度：%s\n\n冰塊：%s\n\n",
                            str1, str2, str3
                        )

                }
            }
        }
    }
}