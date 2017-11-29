package com.ashish.kotlinandroiddemo.fragment

import android.content.Context
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ashish.kotlinandroiddemo.R
import kotlinx.android.synthetic.main.fragment_three.*

/**
 * A placeholder fragment containing a simple view.
 */
class MyFragment3 : Fragment() {

    var activity: FragDemoActivity? = null
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activity = context as FragDemoActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_three, container, false)
    }
}
