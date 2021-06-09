package com.tientienstudio.guideclashofclans

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.tientienstudio.guideclashofclans.model.Guide

class GuideDetailActivity : ForNKBoActivity() {

    override fun getTag(): String {
        return GuideDetailActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide_detail)
        var guide = intent.getSerializableExtra("GUIDE") as Guide
        Glide.with(this).load(guide.image)
            .into(findViewById(R.id.img))
        findViewById<TextView>(R.id.txt).text = guide.content
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        title = guide.title
        loadAds()
    }

    private fun loadAds(){
        when (main.ads_type){
            "fan" ->{
                loadBanner(main.fan.banner8)
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