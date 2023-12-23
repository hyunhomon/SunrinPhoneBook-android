package com.example.sunrinphonebook.start.model

import android.text.SpannableStringBuilder
import androidx.annotation.DrawableRes

data class Start(
    @DrawableRes
    val img: Int,
    val text : SpannableStringBuilder
)
