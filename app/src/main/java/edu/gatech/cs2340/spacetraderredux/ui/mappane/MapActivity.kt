package edu.gatech.cs2340.spacetraderredux.ui.mappane

import android.content.Intent
import android.os.Bundle
import android.view.View
import edu.gatech.cs2340.spacetraderredux.R
import edu.gatech.cs2340.spacetraderredux.ui.common.BaseActivity

class MapActivity : BaseActivity<MapPresenter>(), MapView {

    override fun getLayout(): Int = R.layout.activity_solar_system

    override fun initInjector() {
        //TODO  (create dagger modules)
    }

    override fun initialiseView() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solar_system)
        var viewModel = SolarSystemViewModel()
        viewModel.initPlanetLocations(this, findViewById(R.id.solarSystemLayout))
        for (i in 0..viewModel.solarSystemArray.size - 1) {
            viewModel.solarSystemArray[i]?.setOnClickListener(object : View.OnClickListener{
                override fun onClick(v: View?) {
                    val intent = Intent(this@MapActivity, SolarSystemSpecification::class.java)
                    this@MapActivity.startActivity(intent)
                }
            })
        }
    }

}
