package com.flashcards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //This makes it so that the when moving between fragments, there's a back button now.
        //Nav Host Fragment is the ID I gave to the fragment in the activity_main.xml
        NavigationUI.setupActionBarWithNavController(this, findNavController(R.id.nav_host_fragment))
    }

    //Makes it so that the back arrow actually goes back now.
    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp()
    }
}
