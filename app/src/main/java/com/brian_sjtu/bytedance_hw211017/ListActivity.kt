package com.brian_sjtu.bytedance_hw211017

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brian_sjtu.bytedance_hw211017.databinding.ActivityListBinding
import com.brian_sjtu.bytedance_hw211017.databinding.LayoutRvitemBinding

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        HWApp.DataSet.setup(applicationContext)
        binding.recyclerView.adapter = RVAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    inner class RVAdapter : RecyclerView.Adapter<RVAdapter.RVHolder>() {

        inner class RVHolder(private val binding: LayoutRvitemBinding) : RecyclerView.ViewHolder(binding.root) {
            private var itemId: Int = 0
            init {
                binding.itemTitle.setOnClickListener {
                    val intent = Intent(this@ListActivity, InfoActivity::class.java)
                    intent.putExtra("itemId", itemId)
                    startActivity(intent)
                }
            }

            fun bind(id: Int) {
                itemId = id
                binding.itemTitle.text = HWApp.DataSet.getTitle(itemId)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVHolder {
            return RVHolder(
                LayoutRvitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }

        override fun onBindViewHolder(holder: RVHolder, position: Int) {
            holder.bind(position)
        }

        override fun getItemCount(): Int {
            return HWApp.DataSet.getSize()
        }
    }
}
