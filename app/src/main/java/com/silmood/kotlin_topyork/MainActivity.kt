package com.silmood.kotlin_topyork

import android.support.v4.app.Fragment

class MainActivity : FragmentContainerActivity() {

    override fun createFragment(): Fragment {
        return TopStoriesFragment()
    }

    override fun getLayout(): Int {
        return R.layout.activity_fragment
    }
}
