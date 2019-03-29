package edu.gatech.cs2340.spacetraderredux.ui.mappane

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import edu.gatech.cs2340.spacetraderredux.R
import kotlinx.android.synthetic.main.activity_solar_system_specification.*
import kotlinx.android.synthetic.main.activity_trade_specification.*

class SolarSystemSpecification : AppCompatActivity() {
    private lateinit var mapActivity: MapActivity
    private lateinit var presenter: MapPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solar_system_specification)
        presenter = (parent as MapActivity).presenter
        var bundle = intent.getBundleExtra("information")
        labelSolarSystemConfirmation.text = "Trade: " + bundle.getString("name") + " at: (" + bundle.getInt("x") + ", " + bundle.getInt("y") + ")"
        distance.text = bundle.getInt("distance").toString()
        fuelCost.text = bundle.getInt("fuelCost").toString();
        remainingFuel.text = bundle.getInt("remainingFuel").toString();

    }

    fun travel(view: View) {
        //presenter.onTravel()
        val activityChangeIntent = Intent(this@SolarSystemSpecification, MapActivity::class.java)
        this@SolarSystemSpecification.startActivity(activityChangeIntent)
    }

    fun cancel(view: View) {
        val activityChangeIntent = Intent(this@SolarSystemSpecification, MapActivity::class.java)
        this@SolarSystemSpecification.startActivity(activityChangeIntent)
    }
}
