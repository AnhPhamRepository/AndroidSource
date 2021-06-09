package com.tientienstudio.guideclashofclans

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.tientienstudio.guideclashofclans.fragment.MapFragment

class MapActivity : ForNKBoActivity() {

    override fun getTag(): String {
        return MapActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val fragment = MapFragment().apply {
            arguments = Bundle().apply {
                putSerializable("MAIN", main)
            }
        }

        supportFragmentManager.beginTransaction()
            .add(R.id.item_detail_container, fragment)
            .commit()
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        title = getString(R.string.maps)
        loadAds()
    }

    private fun loadAds(){
        when (main.ads_type){
            "fan" ->{
                loadBanner(main.fan.banner6)
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