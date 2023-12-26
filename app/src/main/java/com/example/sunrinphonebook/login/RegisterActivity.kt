package com.example.sunrinphonebook.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sunrinphonebook.R
import com.example.sunrinphonebook.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private var mBinding : ActivityRegisterBinding? = null
    private val binding : ActivityRegisterBinding get() = requireNotNull(mBinding)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}