package com.example.applockapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applockapp.R
import com.example.applockapp.data.db.App

class AppAdapter : RecyclerView.Adapter<AppAdapter.AppViewHolder>() {
    private var apps = emptyList<App>()

    interface OnSetStatusButtonClickListener {
        fun onStatusButtonClickListener(app: App)
    }

    private lateinit var onStatusButtonClickListener: OnSetStatusButtonClickListener


    inner class AppViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {
        fun bindTo(app: App) {
            val tvName = v.findViewById<AppCompatTextView>(R.id.tv_name)
            val imbLock = v.findViewById<AppCompatImageButton>(R.id.imb_lock)
            var isLocked = app.locked

            tvName.text = app.appName
            imbLock.setImageResource(
                if (app.locked) {
                    R.drawable.ic_lock
                } else {
                    R.drawable.ic_unlock
                }
            )
            imbLock.setOnClickListener {
                if (isLocked) {
                    onStatusButtonClickListener.onStatusButtonClickListener(
                        app = App(
                            id = app.id,
                            packageName = app.packageName,
                            appName = app.appName,
                            locked = false
                        )
                    )
                    imbLock.setImageResource(R.drawable.ic_unlock)
                    isLocked = false
                } else {
                    onStatusButtonClickListener.onStatusButtonClickListener(
                        app = App(
                            id = app.id,
                            packageName = app.packageName,
                            appName = app.appName,
                            locked = true
                        )
                    )
                    imbLock.setImageResource(R.drawable.ic_lock)
                    isLocked = true
                }
            }

        }

    }


    fun setOnStatusButtonClickListener(mOnSetStatusButtonClickListener: OnSetStatusButtonClickListener) {
        this.onStatusButtonClickListener = mOnSetStatusButtonClickListener
    }

    fun setData(mApps: List<App>) {
        apps = mApps
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_apps, parent, false)
        return AppViewHolder(v)
    }

    override fun getItemCount(): Int = apps.size
    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        holder.bindTo(apps[position])
    }

}