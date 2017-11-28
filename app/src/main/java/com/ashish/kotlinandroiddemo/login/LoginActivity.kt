package com.ashish.kotlinandroiddemo.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ashish.kotlinandroiddemo.R
import kotlinx.android.synthetic.main.activity_login.*
import android.preference.PreferenceManager
import android.widget.Toast


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val mobNUM = prefs.getString("mob", null)
        val emailId = prefs.getString("email", null)
        val pwd = prefs.getString("password", null)

        if (mobNUM != null && emailId != null && pwd != null) {
            val intent = Intent(this, LoginDetailActivity::class.java)
            intent.putExtra("mob", mobNUM)
            intent.putExtra("email", emailId)
            intent.putExtra("password", pwd)
            startActivity(intent)
            finish()
        }


        email_sign_in_button.setOnClickListener { signIn() }
    }

    fun signIn() {
        if (doValidation()) {
            val intent = Intent(this, LoginDetailActivity::class.java)
            intent.putExtra("mob", mobile.text.toString().trim())
            intent.putExtra("email", email.text.toString().trim())
            intent.putExtra("password", password.text.toString().trim())

            val prefs = PreferenceManager.getDefaultSharedPreferences(this).edit()
            prefs.putString("mob", mobile.text.toString().trim())
            prefs.putString("email", email.text.toString().trim())
            prefs.putString("password", password.text.toString().trim())
            prefs.apply()

            startActivity(intent)
            finish()
        }
    }

    fun doValidation(): Boolean {
        val mobNUM = mobile.text.toString().trim();
        val emailId = email.text.toString().trim();
        val pwd = password.text.toString().trim();

        if (mobNUM.length != 10) {
            Toast.makeText(this, "Please enter valid moobile number", Toast.LENGTH_SHORT).show()
            return false
        }

        if (emailId.length < 4) {
            Toast.makeText(this, "Please enter valid email", Toast.LENGTH_SHORT).show()
            return false
        }

        if (pwd.length < 6) {
            Toast.makeText(this, "Password should be of minimum 6 digit", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}
