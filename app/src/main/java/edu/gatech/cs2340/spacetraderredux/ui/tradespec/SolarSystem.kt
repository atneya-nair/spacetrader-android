package edu.gatech.cs2340.spacetraderredux.ui.tradespec

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import edu.gatech.cs2340.spacetraderredux.R

class SolarSystem : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solar_system)
        var viewModel = SolarSystemViewModel()
        viewModel.initPlanetLocations(this, findViewById(R.id.solarSystemLayout))
        for (i in 0..viewModel.solarSystemArray.size - 1) {
            viewModel.solarSystemArray[i]?.setOnClickListener(object : View.OnClickListener{
                override fun onClick(v: View?) {
                    val intent = Intent(this@SolarSystem, SolarSystemSpecification::class.java)
                    this@SolarSystem.startActivity(intent)
                }
            })
        }
    }

}
