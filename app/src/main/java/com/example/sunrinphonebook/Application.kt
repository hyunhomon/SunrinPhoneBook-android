package com.example.sunrinphonebook

import android.app.Application
import com.example.sunrinphonebook.util.Keyboard
import com.example.sunrinphonebook.util.PopUp
import com.example.sunrinphonebook.util.Preference

class Application : Application() {
    companion object {
        lateinit var keyboard: Keyboard
        lateinit var popup: PopUp
        lateinit var pref: Preference
    }

    override fun onCreate() {
        super.onCreate()

        keyboard = Keyboard()
        popup = PopUp(applicationContext)
        pref = Preference(applicationContext, "pref")
    }
}