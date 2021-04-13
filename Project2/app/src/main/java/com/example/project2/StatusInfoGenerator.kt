package com.example.project2

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class StatusInfoGenerator (val ctx : Context) {
    lateinit var layoutObj : LinearLayout
    fun generate() : LinearLayout {

        val layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.HORIZONTAL
        layoutObj.setBackgroundColor(Color.WHITE)
        val lbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        lbParams.weight = 1.0F
        lbParams.topMargin = 5
        var lbl = TextView(ctx)
        lbl.text = "Status:"
        lbl.gravity = Gravity.CENTER
        lbl.setBackgroundColor(Color.WHITE)
        layoutObj.addView(lbl, lbParams)

        val lbParams2 = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        lbParams2.weight = 15.0F
        lbParams2.topMargin = 5
        lbl = TextView(ctx)
        lbl.text = "<Status Message>"
        lbl.id = R.id.status_info
        lbl.gravity = Gravity.CENTER
        lbl.setBackgroundColor(Color.WHITE)
        layoutObj.addView(lbl, lbParams2)

        return layoutObj
    }
}