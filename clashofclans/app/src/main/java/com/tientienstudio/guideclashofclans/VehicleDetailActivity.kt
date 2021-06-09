package com.tientienstudio.guideclashofclans

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.akexorcist.roundcornerprogressbar.TextRoundCornerProgressBar
import com.bumptech.glide.Glide
import com.tientienstudio.guideclashofclans.model.Vehicle

class VehicleDetailActivity : ForNKBoActivity() {

    override fun getTag(): String {
        return VehicleDetailActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_detail)
        var vehicle = intent.getSerializableExtra("VEHICLE") as Vehicle
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        title = vehicle.name
        Glide.with(this).load(vehicle.image)
            .into(findViewById(R.id.img))
        findViewById<TextView>(R.id.txt_info).text = vehicle.desc
        var pbProperty1 = findViewById<TextRoundCornerProgressBar>(R.id.pb_property1)
        var pbProperty2 = findViewById<TextRoundCornerProgressBar>(R.id.pb_property2)
        var pbProperty3 = findViewById<TextRoundCornerProgressBar>(R.id.pb_property3)
        var pbProperty4 = findViewById<TextRoundCornerProgressBar>(R.id.pb_property4)
        pbProperty1.progress = vehicle.property1?.toFloat()!!
        pbProperty2.progress = vehicle.property2?.toFloat()!!
        pbProperty3.progress = vehicle.property3?.toFloat()!!
        pbProperty4.progress = vehicle.property4?.toFloat()!!
        pbProperty1.progressText = vehicle.property1.toString()
        pbProperty2.progressText = vehicle.property2.toString()
        pbProperty3.progressText = vehicle.property3.toString()
        pbProperty4.progressText = vehicle.property4.toString()
        loadAds()
    }

    private fun loadAds(){
        when (main.ads_type){
            "fan" ->{
                loadBanner(main.fan.banner10)
            }
            "unt"->{
                loadBannerUnity()
            }
            "ane" ->{
                loadBannerAN(main.ane.banner1)
            }
            "sta"->{
                loadBannerSA()
            }
            "mop"->{
                loadBannerMop(main.mop.banner1)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // handle arrow click here
        if (item.itemId === android.R.id.home) {
            finish() // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        finish()
    }
}