package com.tientienstudio.guideclashofclans

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tientienstudio.guideclashofclans.model.Guide

class GuideActivity : ForNKBoActivity() {

    override fun getTag(): String {
        return GuideActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        title = getString(R.string.tips)

        setupRecyclerView(findViewById(R.id.item_list))
        loadAds()
    }

    private fun loadAds(){
        when (main.ads_type){
            "fan" ->{
                loadBanner(main.fan.banner7)
                loadIns(main.fan.ins4)
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

    private fun openSelectItem(item: Guide){
        val intent = Intent(this@GuideActivity, GuideDetailActivity::class.java).apply {
            putExtra("GUIDE", item)
            putExtra("MAIN", main)
        }
        startActivity(intent)
        showInsAds()
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

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = SimpleItemRecyclerViewAdapter(
            this,
            main.guides!!,
            object : SimpleItemRecyclerViewAdapter.GuideItemListener {
                override fun onItemClick(item: Guide) {
                    openSelectItem(item)
                }
            }
        )
    }

    class SimpleItemRecyclerViewAdapter(
        private val context: Context,
        private val values: List<Guide>,
        private val mListener: GuideItemListener
    ) :
        RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {

        private val onClickListener: View.OnClickListener

        init {
            onClickListener = View.OnClickListener { v ->
                mListener.onItemClick(v.tag as Guide)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.guide_list_content, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = values[position]
            holder.idView.text = item.title
            Glide.with(context).load(item.image)
                .into(holder.image)
            with(holder.itemView) {
                tag = item
                setOnClickListener(onClickListener)
            }
        }

        override fun getItemCount() = values.size

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val idView: TextView = view.findViewById(R.id.id_text)
            val image: ImageView = view.findViewById(R.id.image)
        }


        interface GuideItemListener {
            fun onItemClick(selectedItem: Guide)
        }
    }
}