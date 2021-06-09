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
import com.tientienstudio.guideclashofclans.model.Character
import java.lang.Exception

class CharacterActivity : ForNKBoActivity() {

    override fun getTag(): String {
        return CharacterActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        title = getString(R.string.characters)

        setupRecyclerView(findViewById(R.id.item_list))
        loadAds()
    }

    private fun loadAds(){
        when (main.ads_type){
            "fan" ->{
                loadBanner(main.fan.banner2)
                loadIns(main.fan.ins2)
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

    private fun openSelectItem(item: Character){
        val intent = Intent(this@CharacterActivity, CharacterDetailActivity::class.java).apply {
            putExtra("CHARACTER", item)
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
        recyclerView.adapter =
            SimpleItemRecyclerViewAdapter(
                this,
                main.characters!!,
                object :
                    SimpleItemRecyclerViewAdapter.GuideItemListener {
                    override fun onItemClick(item: Character) {
                        openSelectItem(item)
                    }
                }
            )
    }

    class SimpleItemRecyclerViewAdapter(
        private val context: Context,
        private val values: List<Character>,
        private val mListener: GuideItemListener
    ) :
        RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {

        private val onClickListener: View.OnClickListener

        init {
            onClickListener = View.OnClickListener { v ->
                mListener.onItemClick(v.tag as Character)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleItemRecyclerViewAdapter.ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_content, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: SimpleItemRecyclerViewAdapter.ViewHolder, position: Int) {
            val item = values[position]
            holder.idView.text = item.name
            try{
                if(item.level?.size ?: 0 > 0){
                    holder.idDes1.text = item.levelName!![0] +" - "+ item.level!![0]
                }
                if(item.level?.size ?: 0 > 1){
                    holder.idDes2.text = item.levelName!![1] +" - "+ item.level!![1]
                }
            }catch (e: Exception){}
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
            val idDes1: TextView = view.findViewById(R.id.id_des1)
            val idDes2: TextView = view.findViewById(R.id.id_des2)
            val image: ImageView = view.findViewById(R.id.image)
        }


        interface GuideItemListener {
            fun onItemClick(selectedItem: Character)
        }
    }
}