package com.example.applockapp.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applockapp.R
import com.example.applockapp.data.apps.AppManager
import com.example.applockapp.data.db.App
import com.example.applockapp.data.preference.AppPreferences
import com.example.applockapp.helper.Resource
import com.example.applockapp.presentation.adapter.AppAdapter

class MainFragment : Fragment() {
    private lateinit var appManager: AppManager
    private lateinit var mainViewModel: MainViewModel

    private lateinit var appAdapter: AppAdapter
    private lateinit var rvApp: RecyclerView


    private lateinit var imbSetPassword: AppCompatImageButton
    private lateinit var rootView: RelativeLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        appAdapter = AppAdapter()

        appManager = AppManager(requireActivity())

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        rvApp = view.findViewById(R.id.rv_apps)
        rootView = view.findViewById(R.id.rv_root)
        imbSetPassword = view.findViewById(R.id.imb_set_password)

        imbSetPassword.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_setPasswordFragment)
        }




        addAppsToDb(appManager.getInstalledApp())
        setUpRecyclerView()
        initialize()


        val appPreferences = AppPreferences(requireContext())

        appAdapter.setOnStatusButtonClickListener(object :
            AppAdapter.OnSetStatusButtonClickListener {
            override fun onStatusButtonClickListener(app: App) {
                if (appPreferences.password.isNotEmpty())
                    mainViewModel.updateAppStatus(app)
                else findNavController().navigate(R.id.action_mainFragment_to_setPasswordFragment)
            }
        })
    }

    private fun initialize() {
        mainViewModel.getApps()
        mainViewModel.apps.observe(viewLifecycleOwner) { data ->
            when (data) {
                is Resource.Error -> {
                    Log.d("mlog", "Error :${data.message} ");
                }

                is Resource.Loading -> {
                    Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                }

                is Resource.Success -> {
                    appAdapter.setData(data.data!!)
                }
            }
        }

    }

    private fun setUpRecyclerView() {
        rvApp.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = appAdapter

        }

    }

    private fun addAppsToDb(apps: List<App>) {
        for (app in apps) {
            mainViewModel.insertApp(app)
        }
    }
}