package com.example.applockapp.presentation.lock

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.applockapp.R
import com.example.applockapp.data.preference.AppPreferences
import com.example.applockapp.presentation.password.PasswordViewModel
import com.example.applockapp.service.AppLockAccessibilityService
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textview.MaterialTextView

class LockScreenActivity : AppCompatActivity(), View.OnClickListener {

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
    private lateinit var tvPasswordFirst: MaterialTextView
    private lateinit var tvPasswordSecond: MaterialTextView
    private lateinit var tvPasswordThird: MaterialTextView
    private lateinit var tvPasswordFourth: MaterialTextView
    private lateinit var llRoot: LinearLayout

    private var currentPassword = ""
    private lateinit var appPassword: String
    private lateinit var viewModel: PasswordViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lock_screen)
        viewModel = ViewModelProvider(this)[PasswordViewModel::class.java]
        val appPreferences = AppPreferences(this)
        appPassword = appPreferences.password



        findViewFromId()
        onClicks()
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

        tvPasswordFirst = findViewById(R.id.tv_password_first)
        tvPasswordSecond = findViewById(R.id.tv_password_second)
        tvPasswordThird = findViewById(R.id.tv_password_third)
        tvPasswordFourth = findViewById(R.id.tv_password_fourth)

        llRoot = findViewById(R.id.ll_root_view_lock)
    }

    private fun onClicks() {
        btnOne.setOnClickListener(this)
        btnTwo.setOnClickListener(this)
        btnThree.setOnClickListener(this)
        btnFour.setOnClickListener(this)
        btnFive.setOnClickListener(this)
        btnSix.setOnClickListener(this)
        btnSeven.setOnClickListener(this)
        btnEight.setOnClickListener(this)
        btnNine.setOnClickListener(this)
        btnZero.setOnClickListener(this)
        btnClear.setOnClickListener(this)
        btnOk.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_one -> {
                currentPassword += "1"
                setCountStar(currentPassword)
            }

            R.id.btn_two -> {
                currentPassword += "2"
                setCountStar(currentPassword)
            }

            R.id.btn_three -> {
                currentPassword += "3"
                setCountStar(currentPassword)
            }

            R.id.btn_four -> {
                currentPassword += "4"
                setCountStar(currentPassword)
            }

            R.id.btn_five -> {
                currentPassword += "5"
                setCountStar(currentPassword)
            }

            R.id.btn_six -> {
                currentPassword += "6"
                setCountStar(currentPassword)
            }

            R.id.btn_seven -> {
                currentPassword += "7"
                setCountStar(currentPassword)
            }

            R.id.btn_eight -> {
                currentPassword += "8"
                setCountStar(currentPassword)
            }

            R.id.btn_nine -> {
                currentPassword += "9"
                setCountStar(currentPassword)
            }

            R.id.btn_zero -> {
                currentPassword += "0"
                setCountStar(currentPassword)
            }

            R.id.btn_clear -> {
                currentPassword = ""
                setCountStar(currentPassword)
            }

            R.id.btn_ok -> {


                if (currentPassword == appPassword) {
                    Snackbar.make(
                        llRoot, "Correct password", Snackbar.LENGTH_LONG
                    ).show()
                    AppLockAccessibilityService.isCurrentOpenToUsingPackage = true
                    finish()

                } else {
                    Snackbar.make(
                        llRoot, "Wrong password", Snackbar.LENGTH_LONG
                    ).show()
                }
                setCountStar(currentPassword)
            }

        }
    }

    private fun setCountStar(password: String) {

        when (password.length) {
            0 -> {
                tvPasswordFirst.text = ""
                tvPasswordSecond.text = ""
                tvPasswordThird.text = ""
                tvPasswordFourth.text = ""
            }

            1 -> {
                tvPasswordFirst.text = "*"
                tvPasswordSecond.text = ""
                tvPasswordThird.text = ""
                tvPasswordFourth.text = ""
            }

            2 -> {
                tvPasswordFirst.text = "*"
                tvPasswordSecond.text = "*"
                tvPasswordThird.text = ""
                tvPasswordFourth.text = ""
            }

            3 -> {
                tvPasswordFirst.text = "*"
                tvPasswordSecond.text = "*"
                tvPasswordThird.text = "*"
                tvPasswordFourth.text = ""
            }

            4 -> {
                tvPasswordFirst.text = "*"
                tvPasswordSecond.text = "*"
                tvPasswordThird.text = "*"
                tvPasswordFourth.text = "*"
            }

        }
    }
}