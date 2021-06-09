package com.tientienstudio.guideclashofclans

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.tientienstudio.guideclashofclans.model.Main
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONObject

class SplashActivity : FragmentActivity(), ErrorDialogFragment.NoticeDialogListener, InfoDialogFragment.NoticeDialogListener {
    private lateinit var main: Main
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        getConfigurationData()
    }

    private fun getConfigurationData() {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val queue = Volley.newRequestQueue(this@SplashActivity)
// Request a string response from the provided URL.

                val stringRequest = JsonObjectRequest(
                    Request.Method.GET, getString(R.string.data_link), null,
                    { response ->
                        handlingUI(response)
                    },
                    {
                        handlingUIError()
                    })

// Add the request to the RequestQueue.
                queue.add(stringRequest)
            } catch (exception: Exception) {
                handlingUIError()
                Log.e("Retrofit Exception", exception.toString())
            }
        }
    }

    private fun handlingUIError() {
        GlobalScope.launch(Dispatchers.Main) {
            confirmFireMissiles()
        }
    }

    private fun handlingUI(response: JSONObject) {
        GlobalScope.launch(Dispatchers.Main) {
            main = Gson().fromJson(response.toString(), Main::class.java)
            if(!main.aln.isNullOrEmpty()){
                val newFragment: DialogFragment = InfoDialogFragment()
                newFragment.show(supportFragmentManager, null)
            }else{
                openMainActivity()
            }
        }
    }

    private fun openMainActivity() {
        val intent = Intent(this@SplashActivity, MainActivity::class.java).apply {
            putExtra("MAIN", main)
        }
        startActivity(intent)
        finish()
    }

    private fun confirmFireMissiles() {
        val newFragment: DialogFragment = ErrorDialogFragment()
        newFragment.show(supportFragmentManager, null)
    }

    override fun onDialogTryAgainClick() {
        getConfigurationData()
    }

    override fun onDialogOkClick() {
        openAlnActivity()
    }

    private fun openAlnActivity() {
        var intent = Intent(
            "android.intent.action.VIEW",
            Uri.parse(main.aln)
        )
        startActivity(intent)
    }

    override fun onDialogNoClick() {
        if(main.is_force_aln){
            openAlnActivity()
        }else{
            openMainActivity()
        }
    }

    override fun onDialogCancelClick() {
        finish()
    }

    override fun onBackPressed() {
        // your code.
    }
}