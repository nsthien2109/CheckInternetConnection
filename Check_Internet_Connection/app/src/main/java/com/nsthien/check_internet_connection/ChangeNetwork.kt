package com.nsthien.check_internet_connection

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import java.lang.Exception
import kotlinx.android.synthetic.main.activity_main.*


class ChangeNetwork : BroadcastReceiver() {
    private var inter : String? = ""
    override fun onReceive(context: Context, intent: Intent) {
        isOnline(context)
    }

    public fun isOnline(context: Context): String? {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    inter = "Connected CELLULAR"
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    inter = "Connected WIFI"
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    inter = "Connected ETHERNET"
                }
            }else{
                inter = "No Connect"
            }
        }
        return inter
    }
}