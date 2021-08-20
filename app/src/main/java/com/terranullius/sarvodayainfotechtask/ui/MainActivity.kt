package com.terranullius.sarvodayainfotechtask.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.terranullius.sarvodayainfotechtask.R
import com.terranullius.sarvodayainfotechtask.ui.fragments.MainFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null){
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.frag_container, MainFragment())
            }
        }
    }
}