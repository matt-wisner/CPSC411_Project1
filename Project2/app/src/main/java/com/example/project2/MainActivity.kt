package com.example.project2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.loopj.android.http.AsyncHttpClient

class MainActivity : AppCompatActivity() {

    lateinit var newClaim : PartialClaim
    lateinit var cService : ClaimService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fldRowGenerator = ObjAddScreen(this)
        val allView = fldRowGenerator.generate()
        setContentView(allView)
        //
        val bView : Button = findViewById(R.id.add_btn)
        bView.setOnClickListener{
            val cView : EditText = findViewById(R.id.claim_title)
            val dView : EditText = findViewById(R.id.claim_date)
            val sView : TextView = findViewById(R.id.status_info)

            //check if data was inputted
            if(cView.text.toString() != "" && dView.text.toString() != ""){
                //create partial claim with values from text boxes
                newClaim = PartialClaim(cView.text.toString(),
                        dView.text.toString())
                //add the claim to the db
                cService = ClaimService.getInstance(this)
                cService.addClaim(newClaim)

                //if(cSuccess == 1){
                //    sView.text = "Claim ${newClaim.title} was successfully created!"
                //}
                //else{
                //    sView.text = "Claim ${newClaim.title} failed to be created!"
                //}

                cView.setText("")
                dView.setText("")
                //Log.d("Claim", "${newClaim.title}")
            }else{
                sView.text = "Please input values for title and date"
            }
        }
    }
}