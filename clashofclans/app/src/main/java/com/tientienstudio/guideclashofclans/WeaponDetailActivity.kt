package com.tientienstudio.guideclashofclans

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.akexorcist.roundcornerprogressbar.TextRoundCornerProgressBar
import com.bumptech.glide.Glide
import com.tientienstudio.guideclashofclans.model.Weapon

class WeaponDetailActivity : ForNKBoActivity() {

    override fun getTag(): String {
        return WeaponDetailActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weapon_detail)
        var weapon = intent.getSerializableExtra("WEAPON") as Weapon
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        title = weapon.name
        Glide.with(this).load(weapon.image)
            .into(findViewById(R.id.img))
        findViewById<TextView>(R.id.txt_bullet).text = "Bullets - " + weapon.dan
        findViewById<TextView>(R.id.txt_type).text = weapon.type
        findViewById<TextView>(R.id.txt_info).text = weapon.desc
        findViewById<TextView>(R.id.txt_atrr1).text = weapon.attribute?.get(0) ?: ""
        findViewById<TextView>(R.id.txt_atrr2).text = weapon.attribute?.get(1) ?: ""
        var pbProperty1 = findViewById<TextRoundCornerProgressBar>(R.id.pb_property1)
        var pbProperty2 = findViewById<TextRoundCornerProgressBar>(R.id.pb_property2)
        var pbProperty3 = findViewById<TextRoundCornerProgressBar>(R.id.pb_property3)
        var pbProperty4 = findViewById<TextRoundCornerProgressBar>(R.id.pb_property4)
        var pbProperty5 = findViewById<TextRoundCornerProgressBar>(R.id.pb_property5)
        var pbProperty6 = findViewById<TextRoundCornerProgressBar>(R.id.pb_property6)
        pbProperty1.progress = weapon.property1?.toFloat()!!
        pbProperty2.progress = weapon.property2?.toFloat()!!
        pbProperty3.progress = weapon.property3?.toFloat()!!
        pbProperty4.progress = weapon.property4?.toFloat()!!
        pbProperty5.progress = weapon.property5?.toFloat()!!
        pbProperty6.progress = weapon.property6?.toFloat()!!
        pbProperty1.progressText = weapon.property1.toString()
        pbProperty2.progressText = weapon.property2.toString()
        pbProperty3.progressText = weapon.property3.toString()
        pbProperty4.progressText = weapon.property4.toString()
        pbProperty5.progressText = weapon.property5.toString()
        pbProperty6.progressText = weapon.property6.toString()
        loadAds()
    }

    private fun loadAds(){
        when (main.ads_type){
            "fan" ->{
                loadBanner(main.fan.banner5)
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