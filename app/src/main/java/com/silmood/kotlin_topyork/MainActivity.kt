package com.silmood.kotlin_topyork

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val toolbar: Toolbar? = findViewById(R.id.toolbar) as Toolbar

        if(toolbar != null) {
            toolbar.setNavigationIcon(R.drawable.ic_t_logo)
            setSupportActionBar(toolbar)
        }

        val fragment: Fragment? = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if(fragment == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, TopStoriesFragment())
                .commit()
        }
    }

}