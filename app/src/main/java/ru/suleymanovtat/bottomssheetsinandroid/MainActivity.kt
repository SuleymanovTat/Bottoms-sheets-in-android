package ru.suleymanovtat.bottomssheetsinandroid

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottomsheet_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet)
        open.setOnClickListener({
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
            heading.setText("Welcome")
            heading.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.colorPrimary))
        })

        collapse.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            heading.text = "Collapsed"
            heading.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.colorAccent))
        }

        hide.setOnClickListener { bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN }

        bottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    heading.text = "Collapsed"
                    heading.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.colorAccent))
                } else if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    heading.text = "Welcome"
                    heading.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.colorPrimary))
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })
    }
}
