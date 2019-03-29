package edu.gatech.cs2340.spacetraderredux.ui.mappane

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import edu.gatech.cs2340.spacetraderredux.R

class SolarSystemSpecification : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solar_system_specification)
    }

    fun cancel(view: View) {
        val activityChangeIntent = Intent(this@SolarSystemSpecification, SolarSystem::class.java)
        this@SolarSystemSpecification.startActivity(activityChangeIntent)
    }
}
