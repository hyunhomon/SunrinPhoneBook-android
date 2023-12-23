package com.example.sunrinphonebook.start

import android.os.Bundle
import android.text.SpannableStringBuilder
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.sunrinphonebook.R
import com.example.sunrinphonebook.databinding.ActivityStartBinding
import com.example.sunrinphonebook.start.model.Start
import com.google.android.material.tabs.TabLayoutMediator

class StartActivity : AppCompatActivity() {
    private var mBinding : ActivityStartBinding? = null
    private val binding : ActivityStartBinding get() = requireNotNull(mBinding)

    private var adapter : StartAdapter? = null

    private var list = mutableListOf(
        Start(R.drawable.ic_3d_phone, SpannableStringBuilder("전화번호 따기 실패했을때\n선린 전화번호부에서")),
        Start(R.drawable.ic_3d_lamp, SpannableStringBuilder("연락처를 편리하게\n저장하고 찾기")),
        Start(R.drawable.ic_3d_rocket, SpannableStringBuilder("친구신청 하고\n연락처 확인하기"))
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun btn(pos: Int) {
        with(binding) {
            btn.apply {
                if(pos == 2) {
                    setText("시작하기")
                    setOnClickListener() {
                        //
                    }
                } else {
                    setText("다음")
                    setOnClickListener() {
                        vp.setCurrentItem(pos+1, true)
                    }
                }
            }
        }
    }

    private val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(pos: Int) {
            super.onPageSelected(pos)
            btn(pos)
        }
    }

    private fun initViewPager() {
        with(binding) {
            adapter = StartAdapter()
            adapter!!.submitList(list)
            vp.apply {
                adapter = this@StartActivity.adapter
                registerOnPageChangeCallback(pageChangeCallback)
            }

            TabLayoutMediator(tl, vp) { tab, pos ->
                tab.setIcon(R.drawable.bg_start_indicator)
            }.attach()
        }
    }

    override fun onStart() {
        super.onStart()

        initViewPager()
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}