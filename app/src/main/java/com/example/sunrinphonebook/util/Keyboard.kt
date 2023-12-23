package com.example.sunrinphonebook.util

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager

class Keyboard {
    fun hideKeyboard(activity : Activity) {
        val inputMethodManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        activity.currentFocus?.let {
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }
}