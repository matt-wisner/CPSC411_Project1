package com.example.project2

import android.provider.Telephony
import android.util.Log
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity

class ClaimService(val ctx : MainActivity) {

    lateinit var pClaim : PartialClaim

    companion object {
        private var cService : ClaimService? = null

        fun getInstance(act : MainActivity) : ClaimService {
            if(cService == null) {
                cService = ClaimService(act)
            }

            return cService!!
        }
    }

    inner class addServiceRespHandler : AsyncHttpResponseHandler() {
        override fun onSuccess(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?
        ) {
            if (responseBody != null) {
                val respStr = String(responseBody)
                Log.d("Claim Service", "The add claim response : ${respStr}")
                val cView : TextView = ctx.findViewById(R.id.status_info)
                cView.text = "Claim ${pClaim.title} was successfully created."
            }
        }

        override fun onFailure(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?,
            error: Throwable?
        ) {
            val cView : TextView = ctx.findViewById(R.id.status_info)
            cView.text = "Claim ${pClaim.title} failed to be created."
        }
    }

    fun addClaim(pObj : PartialClaim) {
        val client = AsyncHttpClient()
        val requestUrl = "http://<ip-address here>/ClaimService/add"
        // 1. Convert the pObj into JSON string
        val pJsonString= Gson().toJson(pObj)
        // 2. Send the post request
        val entity = StringEntity(pJsonString)

        pClaim = pObj

        // cxt is an Android Application Context object
        client.post(ctx, requestUrl, entity,"application/json", addServiceRespHandler())
    }

}