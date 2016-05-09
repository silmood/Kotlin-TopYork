package com.silmood.kotlin_topyork

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_top_story.view.*

/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 * Created by Pedro Hernández on 04/2016.
 */
class TopStoriesAdapter() : RecyclerView.Adapter<TopStoriesAdapter.ViewHolder>() {

    private val stories by lazy {
        mutableListOf<TopStory>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder? {
        val view = parent.inflate(R.layout.item_top_story)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return stories.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindItem(stories[position])
    }

    fun addStories(stories: List<TopStory>){
        this.stories.addAll(stories)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        fun bindItem(story: TopStory){
            itemView.label_title.text = story.title;
            itemView.label_by_line.text = story.author;
            itemView.label_section.text = story.section;
            itemView.label_sub_section.text = story.subSection;
        }
    }
}