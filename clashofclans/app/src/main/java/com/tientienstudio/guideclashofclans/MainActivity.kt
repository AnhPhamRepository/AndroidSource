package com.tientienstudio.guideclashofclans

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide

class MainActivity : ForNKBoActivity(), View.OnClickListener {

    override fun getTag(): String {
        return MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main.characters?.let {
            Glide.with(this).load(it[(it.indices).random()]?.image)
            .into(findViewById(R.id.img1))
        }
        main.weapons?.let {
            Glide.with(this).load(it[(it.indices).random()]?.image)
                .into(findViewById(R.id.img2))
        }
        main.maps?.let {
            Glide.with(this).load(it[(it.indices).random()]?.image)
                .into(findViewById(R.id.img3))
        }
        main.guides?.let {
            Glide.with(this).load(it[(it.indices).random()]?.image)
                .into(findViewById(R.id.img4))
        }
        main.vehicles?.let {
            Glide.with(this).load(it[(it.indices).random()]?.image)
                .into(findViewById(R.id.img5))
        }
        findViewById<View>(R.id.ll1).setOnClickListener(this)
        findViewById<View>(R.id.ll2).setOnClickListener(this)
        findViewById<View>(R.id.ll3).setOnClickListener(this)
        findViewById<View>(R.id.ll4).setOnClickListener(this)
        findViewById<View>(R.id.ll5).setOnClickListener(this)
        findViewById<View>(R.id.ll6).setOnClickListener(this)
        loadAds()
    }

    private fun loadAds(){
        when (main.ads_type){
            "fan" ->{
                loadBanner(main.fan.banner1)
                loadIns(main.fan.ins1)
            }
            "unt"->{
                loadBannerUnity()
                loadInsUnity()
            }
            "ane" ->{
                loadBannerAN(main.ane.banner1)
                loadInsAN(main.ane.ins1)
            }
            "sta"->{
                loadBannerSA()
                loadInsSA()
            }
            "mop"->{
                loadBannerMop(main.mop.banner1)
                loadInsMop(main.mop.ins1)
            }
        }
    }

    override fun onBackPressed() {
    }

    override fun onClick(v: View?) {
        var intent : Intent? = null
        when (v?.id) {
            R.id.ll1 -> {
                intent = Intent(this@MainActivity, CharacterActivity::class.java).apply {
                    putExtra("MAIN", main)
                }
            }
            R.id.ll2 -> {
                intent = Intent(this@MainActivity, WeaponActivity::class.java).apply {
                    putExtra("MAIN", main)
                }
            }
            R.id.ll3 -> {
                intent = Intent(this@MainActivity, MapActivity::class.java).apply {
                    putExtra("MAIN", main)
                }
            }
            R.id.ll4 -> {
                intent = Intent(this@MainActivity, GuideActivity::class.java).apply {
                    putExtra("MAIN", main)
                }
            }
            R.id.ll5 -> {
                intent = Intent(this@MainActivity, VehicleActivity::class.java).apply {
                    putExtra("MAIN", main)
                }
            }
            R.id.ll6 -> {
                intent = Intent(
                        "android.intent.action.VIEW",
                        Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                    )
            }
        }
        startActivity(intent)
        showInsAds()
    }
}