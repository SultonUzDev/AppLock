package com.example.applockapp.helper

import android.annotation.SuppressLint


@SuppressLint("SetTextI18n")
fun String.getPasswordSizeInfo(): String {
    when (this.length) {
        in 0..0 -> {
            return "No password has been set yet"
        }

        in 1..3 -> {
            return "Password is too short"
        }

        in 4..4 -> {
            return "Good password"
        }

        else -> {
            return "The password does not meet the requirement"

        }
    }
}

fun String.isPasswordSizeEnough(): Boolean = (this.length in 4..6)

//fun MaterialTextView.setCountStar(s: String) {
//    when (s.length) {
//        0 -> this.text = ""
//        1 -> this.text = "*"
//        2 -> this.text = "*"
//        3 -> this.text = "*"
//        4 -> this.text = "*"
//    }
//
//
//}