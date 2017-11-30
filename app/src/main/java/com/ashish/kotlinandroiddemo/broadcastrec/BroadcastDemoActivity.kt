package com.ashish.kotlinandroiddemo.broadcastrec

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ashish.kotlinandroiddemo.R

class BroadcastDemoActivity : AppCompatActivity() {

    var chargingRec: ChargingRec? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_demo)
        chargingRec = ChargingRec()
    }

    override fun onStart() {
        super.onStart()
        val ifilter = IntentFilter()
        ifilter.addAction(Intent.ACTION_POWER_CONNECTED)
        ifilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        registerReceiver(chargingRec, ifilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(chargingRec)
    }

    class ChargingRec : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context, "BroadcastDemoActivity.ChargingRec" + intent?.action, Toast.LENGTH_SHORT).show()
        }

    }
}
