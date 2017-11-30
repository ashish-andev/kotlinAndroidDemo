package com.ashish.kotlinandroiddemo.http

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ashish.kotlinandroiddemo.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_celeb.view.*

/**
 * Created by digismart on 30/11/17.
 */
class CelebAdapter(val context: Context, val celebs: ArrayList<Celeb>) : RecyclerView.Adapter<CelebAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CelebAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_celeb, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: CelebAdapter.ViewHolder, position: Int) {
        holder.bindItems(celebs[position])
    }

    override fun getItemCount(): Int {
        return celebs.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(celeb: Celeb) {
            itemView.textName.text = celeb.name
            itemView.textPrice.text = "$${celeb.price}"
//            itemView.imageView.setImageResource(user.image)
            val url = "https://celebritybucks.com/images/celebs/full/${celeb.id}.jpg"
            println(url)
            Glide.with(context)
                    .load(url)
                    .crossFade()
                    .placeholder(R.mipmap.ic_launcher)
                    .into(itemView.imageView)

        }
    }

}