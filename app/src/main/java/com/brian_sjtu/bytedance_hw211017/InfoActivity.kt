package com.brian_sjtu.bytedance_hw211017

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.brian_sjtu.bytedance_hw211017.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var itemId = 0
        intent.extras?.let { itemId = it.getInt("itemId", 0) }
        binding.infoText.text = HWApp.DataSet.getDetail(itemId)
        binding.infoImage.setImageDrawable(HWApp.DataSet.getImage(itemId))
    }
}
