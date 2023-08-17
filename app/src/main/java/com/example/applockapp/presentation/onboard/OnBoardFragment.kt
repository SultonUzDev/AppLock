package com.example.applockapp.presentation.onboard

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.applockapp.R
import com.example.applockapp.service.AppLockAccessibilityService
import com.google.android.material.button.MaterialButton

class OnBoardFragment : Fragment() {
    private lateinit var btnGrantPermission: MaterialButton
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = inflater.inflate(R.layout.fragment_on_board, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnGrantPermission = view.findViewById(R.id.btn_grant_permission)
        btnGrantPermission.setOnClickListener {
            if (!AppLockAccessibilityService.isRunService) {
                startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
            } else {
                findNavController().navigate(R.id.action_onBoardFragment_to_mainFragment)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (AppLockAccessibilityService.isRunService) btnGrantPermission.text =
            requireContext().getString(R.string.next)
        else btnGrantPermission.text =
            requireContext().getString(R.string.grant_accessibility_service_for_us)
    }

}