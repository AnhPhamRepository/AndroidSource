package com.tientienstudio.guideclashofclans.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tientienstudio.guideclashofclans.R
import com.tientienstudio.guideclashofclans.adapter.MapAdapter
import com.tientienstudio.guideclashofclans.model.Main


class MapFragment : Fragment() {
    private lateinit var mapAdapter: MapAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var main: Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey("MAIN")) {
                 main = it.getSerializable("MAIN") as Main
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_map, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mapAdapter = MapAdapter(this, main.maps!!)
        viewPager = view.findViewById(R.id.pager)
        viewPager.adapter = mapAdapter
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = main.maps?.get(position)?.name
        }.attach()
    }
}