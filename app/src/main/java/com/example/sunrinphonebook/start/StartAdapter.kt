package com.example.sunrinphonebook.start

import android.graphics.Color
import android.text.Spannable
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sunrinphonebook.databinding.FragmentStartBinding
import com.example.sunrinphonebook.start.model.Start

class StartAdapter : ListAdapter<Start, StartAdapter.ViewHolder>(DiffCallback) {
    private fun initList(item: Start, pos: Int) {
        var start : Int = 0
        var end : Int = 0

        if(pos == 0) {
            start = 13
            end = 22
        } else if(pos == 1) {
            start = 5
            end = 9
        } else if(pos == 2) {
            start = 0
            end = 4
        }

        item.text.setSpan(
            ForegroundColorSpan(Color.parseColor("#FFF05923")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentStartBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        val item : Start = getItem(pos)

        initList(item, pos)
        holder.bind(item)
    }

    inner class ViewHolder(private val binding : FragmentStartBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : Start) {
            with(binding) {
                iv.setImageResource(item.img)
                tv.setText(item.text)
            }
        }
    }

    private object DiffCallback : DiffUtil.ItemCallback<Start>() {
        override fun areItemsTheSame(oldItem: Start, newItem: Start): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Start, newItem: Start): Boolean {
            return oldItem.img == newItem.img
        }
    }
}