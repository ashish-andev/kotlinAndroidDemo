package com.ashish.kotlinandroiddemo.login

import android.os.Bundle
import android.preference.PreferenceManager
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.ashish.kotlinandroiddemo.R
import kotlinx.android.synthetic.main.activity_login.*

import kotlinx.android.synthetic.main.activity_login_detail.*
import kotlinx.android.synthetic.main.content_login_detail.*

class LoginDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_detail)
        setSupportActionBar(toolbar)

        val mob = intent.getStringExtra("mob")
        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")

        textView.setText("Mobile : $mob\nEmail : $email\nPassword : $password")
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        button.setOnClickListener { view ->
            val prefs = PreferenceManager.getDefaultSharedPreferences(this).edit()
            prefs.clear()
            prefs.apply()
            finish()
        }
    }

}
