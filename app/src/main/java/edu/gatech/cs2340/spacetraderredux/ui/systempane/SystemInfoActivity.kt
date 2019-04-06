package edu.gatech.cs2340.spacetraderredux.ui.systempane

import android.content.Intent

import android.view.View
import android.widget.TextView
import android.widget.Toast


import edu.gatech.cs2340.spacetraderredux.R
import edu.gatech.cs2340.spacetraderredux.di.presenters.DaggerSystemInfoComponent
import edu.gatech.cs2340.spacetraderredux.domain.entities.Politics
import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.PlanetName
import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.SolarSystemName
import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.SpecialEvent
import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.TechLevel
import edu.gatech.cs2340.spacetraderredux.ui.mappane.MapActivity
import edu.gatech.cs2340.spacetraderredux.ui.cargopane.CargoActivity
import edu.gatech.cs2340.spacetraderredux.ui.common.App
import edu.gatech.cs2340.spacetraderredux.ui.common.BaseActivity
import edu.gatech.cs2340.spacetraderredux.ui.tradepane.TradeActivity
import kotlinx.android.synthetic.main.activity_system_info.*

class SystemInfoActivity : BaseActivity<SystemInfoPresenter>(), SystemInfoView {

    override fun displayInfo(solarSystem: SolarSystemName, planetName: PlanetName,
                             techLevel: TechLevel, politics: Politics, specialEvent: SpecialEvent) {
        systemNameText.text = solarSystem.displayName
        planetNameText.text = planetName.toString()
        techLevelText.text = techLevel.toString()
        politicsText.text = politics.toString()
        specialEventText.text = "This system is currently under $specialEvent!"
    }

    override fun getLayout(): Int = R.layout.activity_system_info
    override fun initInjector() {
        DaggerSystemInfoComponent.builder()
                .appComponent((application as App).applicationComponent)
                .build()
                .inject(this)
    }

    fun systemInfoClick(view: View) {
        Toast.makeText(this@SystemInfoActivity, "Already on System Info page!",
                Toast.LENGTH_SHORT).show()
    }

    fun cargoClick(view: View) {
        val activityChangeIntent = Intent(this@SystemInfoActivity, CargoActivity::class.java)
        activityChangeIntent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        startActivityIfNeeded(activityChangeIntent, 0)
    }

    fun tradeableClick(view: View) {
        val activityChangeIntent = Intent(this@SystemInfoActivity, TradeActivity::class.java)
        activityChangeIntent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        startActivityIfNeeded(activityChangeIntent, 0)
    }

    fun solarClick(view: View) {
        val activityChangeIntent = Intent(this@SystemInfoActivity, MapActivity::class.java)
        activityChangeIntent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        startActivityIfNeeded(activityChangeIntent, 0)
    }

    override fun onResume() {
        super.onResume()
        presenter.initialise()
    }
}
