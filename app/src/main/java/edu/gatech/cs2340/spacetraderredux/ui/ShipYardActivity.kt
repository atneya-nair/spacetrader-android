package edu.gatech.cs2340.spacetraderredux.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import edu.gatech.cs2340.spacetraderredux.R
import edu.gatech.cs2340.spacetraderredux.ui.cargopane.CargoActivity
import edu.gatech.cs2340.spacetraderredux.ui.mappane.MapActivity
import edu.gatech.cs2340.spacetraderredux.ui.systempane.SystemInfoActivity
import edu.gatech.cs2340.spacetraderredux.ui.tradepane.TradeActivity

class ShipYardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ship_yard)
        val tabText = findViewById<View>(R.id.labelTabName) as TextView
        tabText.text = "Ship Yard"
    }

    fun refuelClick(view: View) {

    }

    fun repairClick(view: View) {

    }

    fun systemInfoClick(view: View) {
        val activityChangeIntent = Intent(this@ShipYardActivity, SystemInfoActivity::class.java)
        activityChangeIntent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        startActivityIfNeeded(activityChangeIntent, 0)

    }

    fun cargoClick(view: View) {
        val activityChangeIntent = Intent(this@ShipYardActivity, CargoActivity::class.java)
        activityChangeIntent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        startActivityIfNeeded(activityChangeIntent, 0)
    }

    fun tradeableClick(view: View) {
        val activityChangeIntent = Intent(this@ShipYardActivity, TradeActivity::class.java)
        activityChangeIntent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        startActivityIfNeeded(activityChangeIntent, 0)
    }

    fun yardClick(view: View) {
        Toast.makeText(this@ShipYardActivity, "Already on Cargo page!", Toast.LENGTH_SHORT).show()
    }

    fun solarClick(view: View) {
        val activityChangeIntent = Intent(this@ShipYardActivity, MapActivity::class.java)
        activityChangeIntent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        startActivityIfNeeded(activityChangeIntent, 0)
    }
}
