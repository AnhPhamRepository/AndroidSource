package com.tientienstudio.guideclashofclans

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.tientienstudio.guideclashofclans.model.Character


class CharacterDetailActivity : ForNKBoActivity() {

    override fun getTag(): String {
        return CharacterDetailActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)
        var character = intent.getSerializableExtra("CHARACTER") as Character
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        title = character.name
        Glide.with(this).load(character.image)
            .into(findViewById(R.id.img))
        Glide.with(this).load(character.aimage)
            .into(findViewById(R.id.img_ability))
        findViewById<TextView>(R.id.txt_name).text = character.name
        if(character.sex.isNullOrEmpty()){
            findViewById<TextView>(R.id.txt_sex).visibility = View.GONE
        }else{
            findViewById<TextView>(R.id.txt_sex).text = "Sex - " + character.sex
        }
        if(character.sex.isNullOrEmpty()){
            findViewById<TextView>(R.id.txt_age).visibility = View.GONE
        }else{
            findViewById<TextView>(R.id.txt_age).text = "Age - " + character.age
        }
        if(character.sex.isNullOrEmpty()){
            findViewById<TextView>(R.id.txt_birthday).visibility = View.GONE
        }else{
            findViewById<TextView>(R.id.txt_birthday).text = "Birthday - " + character.birthDate
        }
        findViewById<TextView>(R.id.txt_info).text = character.info
        findViewById<TextView>(R.id.txt_info).movementMethod = ScrollingMovementMethod()
        if(character.ability != null){
            findViewById<TextView>(R.id.txt_ability_name).text = character.ability?.name ?: ""
            findViewById<TextView>(R.id.txt_ability_des).text = character.ability?.desc ?: ""
        }else{
            findViewById<View>(R.id.rl_ability).visibility = View.GONE
            findViewById<View>(R.id.txt_ssa).visibility = View.GONE
        }
        findViewById<TextView>(R.id.txt_level1).text = character.level?.get(0) ?: ""
        if(character.levelName != null && character.levelName!!.isNotEmpty()){
            findViewById<TextView>(R.id.txt_title_level1).text = character.levelName?.get(0) ?: ""
        }
        if(character.level?.size!! > 1) {
            findViewById<TextView>(R.id.txt_level2).text = character.level?.get(1) ?: ""
            if(character.levelName != null && character.levelName!!.size > 1){
                findViewById<TextView>(R.id.txt_title_level2).text = character.levelName?.get(1) ?: ""
            }
        }else{
            findViewById<LinearLayout>(R.id.ll_level2).visibility = View.GONE
        }
        if(character.level?.size!! > 2){
            findViewById<TextView>(R.id.txt_level3).text = character.level?.get(2) ?: ""
            if(character.levelName != null && character.levelName!!.size > 2){
                findViewById<TextView>(R.id.txt_title_level3).text = character.levelName?.get(2) ?: ""
            }
        }else{
            findViewById<LinearLayout>(R.id.ll_level3).visibility = View.GONE
        }
        if(character.level?.size!! > 3){
            findViewById<TextView>(R.id.txt_level4).text = character.level?.get(3) ?: ""
            if(character.levelName != null && character.levelName!!.size > 3){
                findViewById<TextView>(R.id.txt_title_level4).text = character.levelName?.get(3) ?: ""
            }
        }else{
            findViewById<LinearLayout>(R.id.ll_level4).visibility = View.GONE
        }
        if(character.level?.size!! > 4){
            findViewById<TextView>(R.id.txt_level5).text = character.level?.get(4) ?: ""
            if(character.levelName != null && character.levelName!!.size > 4){
                findViewById<TextView>(R.id.txt_title_level5).text = character.levelName?.get(4) ?: ""
            }
        }else{
            findViewById<LinearLayout>(R.id.ll_level5).visibility = View.GONE
        }
        if(character.level?.size!! > 5){
            findViewById<TextView>(R.id.txt_level6).text = character.level?.get(5) ?: ""
            if(character.levelName != null && character.levelName!!.size > 5){
                findViewById<TextView>(R.id.txt_title_level6).text = character.levelName?.get(5) ?: ""
            }
        }else{
            findViewById<LinearLayout>(R.id.ll_level6).visibility = View.GONE
        }
        if(character.level?.size!! > 6){
            findViewById<TextView>(R.id.txt_level7).text = character.level?.get(6) ?: ""
            if(character.levelName != null && character.levelName!!.size > 6){
                findViewById<TextView>(R.id.txt_title_level7).text = character.levelName?.get(6) ?: ""
            }
        }else{
            findViewById<LinearLayout>(R.id.ll_level7).visibility = View.GONE
        }
        if(character.level?.size!! > 7){
            findViewById<TextView>(R.id.txt_level8).text = character.level?.get(7) ?: ""
            if(character.levelName != null && character.levelName!!.size > 7){
                findViewById<TextView>(R.id.txt_title_level8).text = character.levelName?.get(7) ?: ""
            }
        }else{
            findViewById<LinearLayout>(R.id.ll_level8).visibility = View.GONE
        }
        loadAds()
    }

    private fun loadAds(){
        when (main.ads_type){
            "fan" ->{
                loadBanner(main.fan.banner3)
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