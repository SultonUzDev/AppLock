package com.example.applockapp.presentation.lock

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.applockapp.R
import com.google.android.material.button.MaterialButton

class LockScreenActivity : AppCompatActivity() {

    private lateinit var btnOne: MaterialButton
    private lateinit var btnTwo: MaterialButton
    private lateinit var btnThree: MaterialButton
    private lateinit var btnFour: MaterialButton
    private lateinit var btnFive: MaterialButton
    private lateinit var btnSix: MaterialButton
    private lateinit var btnSeven: MaterialButton
    private lateinit var btnEight: MaterialButton
    private lateinit var btnNine: MaterialButton
    private lateinit var btnZero: MaterialButton
    private lateinit var btnClear: MaterialButton
    private lateinit var btnOk: MaterialButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lock_screen)

        findViewFromId()
    }

    private fun findViewFromId() {
        btnOne = findViewById(R.id.btn_one)
        btnTwo = findViewById(R.id.btn_two)
        btnThree = findViewById(R.id.btn_three)
        btnFour = findViewById(R.id.btn_four)
        btnFive = findViewById(R.id.btn_five)
        btnSix = findViewById(R.id.btn_six)
        btnSeven = findViewById(R.id.btn_seven)
        btnEight = findViewById(R.id.btn_eight)
        btnNine = findViewById(R.id.btn_nine)
        btnZero = findViewById(R.id.btn_zero)
        btnClear = findViewById(R.id.btn_clear)
        btnOk = findViewById(R.id.btn_ok)

    }
}