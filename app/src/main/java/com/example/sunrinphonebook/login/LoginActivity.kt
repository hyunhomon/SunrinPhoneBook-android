package com.example.sunrinphonebook.login

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import com.example.sunrinphonebook.Application.Companion.keyboard
import com.example.sunrinphonebook.databinding.ActivityLoginBinding
import com.example.sunrinphonebook.login.model.Login

class LoginActivity : AppCompatActivity() {
    private var mBinding : ActivityLoginBinding? = null
    private val binding : ActivityLoginBinding get() = requireNotNull(mBinding)

    private var registerString : SpannableStringBuilder? = null

    private var user : Login? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initView() {
        with(binding) {
            registerString = SpannableStringBuilder("계정이 없으신가요? 회원가입")
            registerString!!.setSpan(ForegroundColorSpan(Color.parseColor("#FFF05923")), 11, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

            root.setOnClickListener() { keyboard.hideKeyboard(this@LoginActivity) }

            etPhone.addTextChangedListener(PhoneTextWatcher)
            etPw.addTextChangedListener(PwTextWatcher)

            btnLogin.setOnClickListener() { auth() }
            tvRegister.apply {
                setText(registerString)
                setOnClickListener() { register() }
            }
        }
    }

    private val PhoneTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { }

        override fun afterTextChanged(s: Editable?) {
            with(binding) {
                if(s!!.isEmpty())
                    etlPhone.setError("공백 입력은 불가능합니다.")
                else if(s != null) {
                    if(s.length!! > 11)
                        etlPhone.setError("전화번호를 알맞게 입력해주세요.")
                    else
                        etlPhone.setError(null)
                }
            }
        }
    }

    private val PwTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { }

        override fun afterTextChanged(s: Editable?) {
            //
        }
    }

    private fun auth() {
        //
    }

    private fun register() {
        //
    }

    override fun onStart() {
        super.onStart()

        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}