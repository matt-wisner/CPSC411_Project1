package com.example.project2

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class ObjAddScreen(val ctx : Context) {

    lateinit var layoutObj : LinearLayout
    fun generate() : LinearLayout {
        // 1. Create a LinearLayout Obj
        layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL

        // Add Header Message
        val lbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        lbParams.weight = 1.0F
        lbParams.topMargin = 5
        var lbl = TextView(ctx)
        lbl.text = "Please Enter Claim Information"
        lbl.textSize = 20F
        lbl.gravity = Gravity.CENTER
        lbl.setBackgroundColor(Color.WHITE)
        layoutObj.addView(lbl, lbParams)


        //2. Add ObjDetailSection
        val fldRowGenerator = InputSectionGenerator(ctx)
        val colView = fldRowGenerator.generate()
        layoutObj.addView(colView)

        //3. Add add Button
        val nLayout = LinearLayout(ctx)
        val nParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        nParams.gravity = Gravity.RIGHT
        nLayout.layoutParams = nParams
        nLayout.orientation = LinearLayout.HORIZONTAL
        nLayout.setBackgroundColor(Color.WHITE)
        //
        val nButton = Button(ctx)
        nButton.text = "Add"
        nButton.setId(R.id.add_btn)
        val nbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        nLayout.addView(nButton, nbParams)

        layoutObj.addView(nLayout)

        //add status label
        val statinfoGenerator = StatusInfoGenerator(ctx)
        val btmColView = statinfoGenerator.generate()
        layoutObj.addView(btmColView)



        return layoutObj
    }
}