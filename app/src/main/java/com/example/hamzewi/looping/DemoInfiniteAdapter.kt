package com.example.hamzewi.looping


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


import com.asksira.loopingviewpager.LoopingPagerAdapter
import com.bumptech.glide.Glide

import java.util.ArrayList

class DemoInfiniteAdapter(context: Context, itemList: ArrayList<String>, isInfinite: Boolean) : LoopingPagerAdapter<String>(context, itemList, isInfinite) {

    override fun getItemViewType(listPosition: Int): Int {
        return if (itemList[listPosition] === "0") VIEW_TYPE_SPECIAL else VIEW_TYPE_NORMAL
    }

    override fun inflateView(viewType: Int, container: ViewGroup, listPosition: Int): View {
        return if (viewType == VIEW_TYPE_SPECIAL) LayoutInflater.from(context).inflate(R.layout.item_special, container, false) else LayoutInflater.from(context).inflate(R.layout.item_pager, container, false)
    }

    override fun bindView(convertView: View, listPosition: Int, viewType: Int) {
        if (viewType == VIEW_TYPE_SPECIAL) return
        val imageView = convertView.findViewById<View>(R.id.image) as ImageView
        Glide.with(context).load(itemList[listPosition]).into(imageView)
    }

    companion object {

        private val VIEW_TYPE_NORMAL = 100
        private val VIEW_TYPE_SPECIAL = 101
    }


}
