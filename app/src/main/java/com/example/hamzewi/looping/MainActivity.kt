package com.example.hamzewi.looping


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView

import com.asksira.loopingviewpager.LoopingViewPager
import com.rd.PageIndicatorView

import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    internal lateinit var viewPager: LoopingViewPager
    internal lateinit var adapter: DemoInfiniteAdapter
    internal lateinit var indicatorView: PageIndicatorView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewpager)
        indicatorView = findViewById(R.id.indicator)



        adapter = DemoInfiniteAdapter(this, createDummyItems(), true)
        viewPager.setAdapter(adapter)

        //Custom bind indicator
        indicatorView.setCount(viewPager.getIndicatorCount())
        viewPager.setIndicatorPageChangeListener(object : LoopingViewPager.IndicatorPageChangeListener {
            override fun onIndicatorProgress(selectingPosition: Int, progress: Float) {
                indicatorView.setProgress(selectingPosition, progress)
            }

            override fun onIndicatorPageChange(newIndicatorPosition: Int) {
                //                indicatorView.setSelection(newIndicatorPosition);
            }
        })
    }

    override fun onResume() {
        super.onResume()
        viewPager.resumeAutoScroll()
    }

    override fun onPause() {
        viewPager.pauseAutoScroll()
        super.onPause()
    }

    private fun createDummyItems(): ArrayList<String> {
        val items = ArrayList<String>()
        items.add(0, "https://www.stefproost.be/files/panden/property/photo/appartement-te-koop-in-residentie-michiel-westerlo-12810.jpg")
        items.add(1, "https://www.maximmobilier.fr/files/jpeg/big_visuel_le_nerval_large-614.jpg")
        items.add(2, "https://www.stefproost.be/files/panden/property/photo/appartement-te-koop-in-residentie-michiel-westerlo-12810.jpg")
        items.add(3, "https://www.stefproost.be/files/panden/property/photo/appartement-te-koop-in-residentie-michiel-westerlo-12810.jpg")
        items.add(4, "http://marceauimmo.staticlbi.com/original/images/biens/1/78793b99ed3060a58b833ea04b493953/21243765f7f2f834f1eda0c1a755a87d.jpg")
        items.add(5, "http://marceauimmo.staticlbi.com/original/images/biens/1/78793b99ed3060a58b833ea04b493953/21243765f7f2f834f1eda0c1a755a87d.jpg")
        return items
    }

}
