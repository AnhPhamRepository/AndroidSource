package com.tientienstudio.guideclashofclans.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bumptech.glide.Glide
import com.tientienstudio.guideclashofclans.R
import com.tientienstudio.guideclashofclans.model.Map

class MapAdapter(val fragment: Fragment,val maps: List<Map>) : FragmentStateAdapter(fragment) {

    override fun getItemCount() : Int{
        return maps.size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = DemoObjectFragment(fragment.context!!)
        fragment.arguments = Bundle().apply {
            putSerializable(ARG_OBJECT, maps[position])
        }
        return fragment
    }

    class DemoObjectFragment(val mContext: Context) : Fragment() {

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            return inflater.inflate(R.layout.fragment_collection_object, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
                val textView: TextView = view.findViewById(R.id.txt)
                val imageView: ImageView = view.findViewById(R.id.img)
                var map = getSerializable(ARG_OBJECT) as Map
                Glide.with(mContext).load(map.image)
                    .into(imageView)
                textView.text = map.desc
                //findViewById<TextView>(R.id.txt).text = guide.content
            }
        }
    }

    companion object {
        private const val ARG_OBJECT = "object"
    }
}