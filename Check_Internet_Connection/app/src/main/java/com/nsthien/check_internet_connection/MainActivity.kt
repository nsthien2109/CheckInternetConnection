package com.nsthien.check_internet_connection

import android.content.BroadcastReceiver
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var network_rq : ChangeNetwork
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        network_rq = ChangeNetwork()
        tv_noti.setText(network_rq.isOnline(this))
        if(network_rq.isOnline(this) == "Connected CELLULAR"){
            img_inter.setImageResource(R.drawable.smartphone)
        }else if(network_rq.isOnline(this) == "Connected WIFI"){
            img_inter.setImageResource(R.drawable.wifi)
        } else if(network_rq.isOnline(this) == "Connected ETHERNET"){
            img_inter.setImageResource(R.drawable.ethernet)
        }else{
            img_inter.setImageResource(R.drawable.no_wifi)
        }
        registerBoard()

    }

    private fun registerBoard() {
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(network_rq, filter)
    }
}