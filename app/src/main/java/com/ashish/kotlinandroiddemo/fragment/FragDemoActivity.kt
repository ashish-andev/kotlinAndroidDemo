package com.ashish.kotlinandroiddemo.fragment

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.ashish.kotlinandroiddemo.R

import kotlinx.android.synthetic.main.activity_frag_demo.*

class FragDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frag_demo)

        setFragment(MyFragment1(), false)
    }


    fun setFragment(fragment: Fragment, addToBackStack: Boolean) {
        try {
            val ft = supportFragmentManager.beginTransaction()
            if (addToBackStack) {
                ft.addToBackStack(fragment.javaClass.name)
                ft.add(R.id.container, fragment)
            } else {
                ft.replace(R.id.container, fragment)
            }
            ft.commitAllowingStateLoss()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun popBackAndSetFragment(fragment: Fragment, addToBackStack: Boolean) {
        try {
            val fm = supportFragmentManager
            if (fm.backStackEntryCount > 0) {
                fm.popBackStack()
            }
            setFragment(fragment, addToBackStack)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}
