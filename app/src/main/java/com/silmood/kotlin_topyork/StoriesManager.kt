package com.silmood.kotlin_topyork

import rx.Observable

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
* Created by Pedro Hernández on 05/2016.
*/
class StoriesManager {

    fun getNews(): Observable<List<TopStory>> {
        return Observable.create {
            subscriber ->

            val news = mutableListOf<TopStory>()
            for (i in 1..10){
                news.add(TopStory("Title $i", "Abstract $i", "Section $i","SubSection $i", "Author $i" ))
            }
            //TODO: API call

            subscriber.onNext(news)
            subscriber.onCompleted()

        }
    }
}