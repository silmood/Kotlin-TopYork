package com.silmood.kotlin_topyork

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.fragment_top_stories.*

/**
 * Created by Pedro Hernández on 04/2016.
 */
class TopStoriesFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View? = container?.inflate(R.layout.fragment_top_stories)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        list_top_stories.setHasFixedSize(true)
        list_top_stories.layoutManager = LinearLayoutManager(context)
    }
}