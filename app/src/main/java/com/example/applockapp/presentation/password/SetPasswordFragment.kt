package com.example.applockapp.presentation.password

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.applockapp.R
import com.example.applockapp.helper.getPasswordSizeInfo
import com.example.applockapp.helper.isPasswordSizeEnough
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textview.MaterialTextView

class SetPasswordFragment : Fragment(), View.OnClickListener {
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

    private lateinit var viewModel: PasswordViewModel
    private lateinit var password: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_set_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[PasswordViewModel::class.java]
        password = viewModel.appPreferences.password

        findById(view)
        onClicks()

        setCountStar(password)
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


    private fun findById(view: View) {
        btnOne = view.findViewById(R.id.btn_one)
        btnTwo = view.findViewById(R.id.btn_two)
        btnThree = view.findViewById(R.id.btn_three)
        btnFour = view.findViewById(R.id.btn_four)
        btnFive = view.findViewById(R.id.btn_five)
        btnSix = view.findViewById(R.id.btn_six)
        btnSeven = view.findViewById(R.id.btn_seven)
        btnEight = view.findViewById(R.id.btn_eight)
        btnNine = view.findViewById(R.id.btn_nine)
        btnZero = view.findViewById(R.id.btn_zero)
        btnClear = view.findViewById(R.id.btn_clear)
        btnOk = view.findViewById(R.id.btn_ok)

        tvPasswordFirst = view.findViewById(R.id.tv_password_first)
        tvPasswordSecond = view.findViewById(R.id.tv_password_second)
        tvPasswordThird = view.findViewById(R.id.tv_password_third)
        tvPasswordFourth = view.findViewById(R.id.tv_password_fourth)
        llRoot = view.findViewById(R.id.ll_root)
    }


    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_one -> {
                password += "1"
                setCountStar(password)
            }

            R.id.btn_two -> {
                password += "2"
                setCountStar(password)
            }

            R.id.btn_three -> {
                password += "3"
                setCountStar(password)
            }

            R.id.btn_four -> {
                password += "4"
                setCountStar(password)
            }

            R.id.btn_five -> {
                password += "5"
                setCountStar(password)
            }

            R.id.btn_six -> {
                password += "6"
                setCountStar(password)
            }

            R.id.btn_seven -> {
                password += "7"
                setCountStar(password)
            }

            R.id.btn_eight -> {
                password += "8"
                setCountStar(password)
            }

            R.id.btn_nine -> {
                password += "9"
                setCountStar(password)
            }

            R.id.btn_zero -> {
                password += "0"
                setCountStar(password)
            }

            R.id.btn_clear -> {
                password = ""
                setCountStar(password)
            }

            R.id.btn_ok -> {
                if (password.isPasswordSizeEnough()) {
                    viewModel.setPassword(password)
                    findNavController().navigateUp()
                } else {
                    Snackbar.make(
                        llRoot, password.getPasswordSizeInfo(), Snackbar.LENGTH_LONG
                    ).show()
                }
                setCountStar(password)
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