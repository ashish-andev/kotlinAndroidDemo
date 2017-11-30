package com.ashish.kotlinandroiddemo.broadcastrec

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * Created by digismart on 30/11/17.
 */
class ChargingRec : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "ChargingRec" + intent?.action, Toast.LENGTH_SHORT).show()
    }

}