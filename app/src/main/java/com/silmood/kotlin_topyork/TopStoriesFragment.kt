package com.silmood.kotlin_topyork

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_top_stories.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.concurrent.TimeUnit

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
 * Created by Pedro Hernández on ${MONTH}/${YEAR}.
 */
class TopStoriesFragment : Fragment() {

    private val storiesManager  by lazy { StoriesManager() }

    private val topStoriesList by lazy {
        list_top_stories.setHasFixedSize(true)
        list_top_stories.layoutManager = LinearLayoutManager(context)
        list_top_stories.adapter = TopStoriesAdapter()
        list_top_stories
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = container?.inflate(R.layout.fragment_top_stories)
        return view;
    }

    override fun onResume() {
        super.onResume()

        storiesManager.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (
                        {
                            topStories ->
                            (topStoriesList.adapter as TopStoriesAdapter).addStories(topStories)
                        },
                        {
                            error ->
                            Log.e(TopStoriesFragment::class.simpleName, error.message)
                        }
                )
    }

}