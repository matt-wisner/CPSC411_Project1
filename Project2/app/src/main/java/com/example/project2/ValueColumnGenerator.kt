package com.example.project2

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import java.text.SimpleDateFormat
import java.util.*

class ValueColumnGenerator (val ctx : Context) {
    fun generate() : LinearLayout {
        val layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.WHITE)
        //
        val vParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        vParams.topMargin = 5
        var value = EditText(ctx)
        value.id = R.id.claim_title
        value.setHint("Enter claim title")
        layoutObj.addView(value, vParams)
        value = EditText(ctx)
        value.id = R.id.claim_date
        val sdf = SimpleDateFormat("yyyy M-dd")
        val currentDate = sdf.format(Date())
        value.setHint(currentDate)
        layoutObj.addView(value, vParams)

        return layoutObj
    }
}