package com.example.applockapp.helper

import android.annotation.SuppressLint
import android.graphics.Color
import com.google.android.material.textview.MaterialTextView


@SuppressLint("SetTextI18n")
fun MaterialTextView.getPasswordSizeInfo(s: String) {
    when (s.length) {
        in 0..0 -> {
            this.apply {
                text = "No password has been set yet"
                setTextColor(Color.parseColor("#4682A9"))
            }
        }

        in 1..3 -> {
            this.apply {
                text = "Password is too short"
                setTextColor(Color.parseColor("#F0B86E"))
            }
        }

        in 4..6 -> {
            this.apply {
                text = "Good password"
                setTextColor(Color.parseColor("#557A46"))
            }
        }

        else -> {
            this.apply {
                text = "Password is too long"
                setTextColor(Color.parseColor("#FE0000"))
            }

        }
    }
}

fun String.isPasswordSizeEnough(): Boolean = (this.length in 4..6)

fun MaterialTextView.setCountStar(s: String) {
    when (s.length) {
        0 -> this.text = ""
        1 -> this.text = "*"
        2 -> this.text = "**"
        3 -> this.text = "***"
        4 -> this.text = "****"
        5 -> this.text = "*****"
        6 -> this.text = "******"
    }


}