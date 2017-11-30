package com.ashish.kotlinandroiddemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.ashish.kotlinandroiddemo.broadcastrec.BroadcastDemoActivity
import com.ashish.kotlinandroiddemo.fragment.FragDemoActivity
import com.ashish.kotlinandroiddemo.http.HttpDemoActivity
import com.ashish.kotlinandroiddemo.login.LoginActivity
import com.ashish.kotlinandroiddemo.viewpager.ViewPagerActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView.adapter = ListExampleAdapter(this)
        listView.setOnItemClickListener { parent, view, position, id ->
            when (position) {
                0 -> startActivity(Intent(this, LoginActivity::class.java))
                1 -> startActivity(Intent(this, FragDemoActivity::class.java))
                2 -> startActivity(Intent(this, HttpDemoActivity::class.java))
                3 -> startActivity(Intent(this, BroadcastDemoActivity::class.java))
                4 -> startActivity(Intent(this, ViewPagerActivity::class.java))
            }
            //Toast.makeText(this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private class ListExampleAdapter(context: Context) : BaseAdapter() {
        internal var sList = arrayOf("Login", "Fragment", "Http", "Broadcast rec", "View Pager")
        private val mInflator: LayoutInflater

        init {
            this.mInflator = LayoutInflater.from(context)
        }

        override fun getCount(): Int {
            return sList.size
        }

        override fun getItem(position: Int): String {
            return sList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
            val view: View?
            val vh: ListRowHolder
            if (convertView == null) {
                view = this.mInflator.inflate(R.layout.list_row, parent, false)
                vh = ListRowHolder(view)
                view.tag = vh
            } else {
                view = convertView
                vh = view.tag as ListRowHolder
            }

            vh.label.text = sList[position]
            return view
        }
    }

    private class ListRowHolder(row: View?) {
        val label: TextView

        init {
            this.label = row?.findViewById<TextView>(R.id.label) as TextView
        }
    }
}
