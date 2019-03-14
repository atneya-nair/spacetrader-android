package edu.gatech.cs2340.spacetraderredux.ui.tradespec

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

import java.util.LinkedList

import edu.gatech.cs2340.spacetraderredux.R
import edu.gatech.cs2340.spacetraderredux.domain.entities.BuyMarketPlace
import edu.gatech.cs2340.spacetraderredux.domain.entities.PlayerState

class CargoActivity : AppCompatActivity() {
    var playerState: PlayerState = TradeActivity.game!!.playerState
    var bmp = BuyMarketPlace(TradeActivity.game!!.playerState.currPlanet, TradeActivity.game!!.playerState);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cargo)
        val tabText = findViewById<View>(R.id.labelTabName) as TextView
        tabText.text = "Cargo"

        val trades = LinkedList<Trade>()
        for (element in playerState.ship.storageUnits.cargoHold.getItems()) {
            for (i in (0 until element.value)) {
                trades.add(Trade(element.key, -1))
            }
        }

        val recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView

        var adapter = ResourcesViewAdapter(trades)
        val mLayoutManager = GridLayoutManager(applicationContext, 2)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    fun systemInfoClick(view: View) {
        val activityChangeIntent = Intent(this@CargoActivity, SystemInfoActivity::class.java)
        this@CargoActivity.startActivity(activityChangeIntent)
    }

    fun cargoClick(view: View) {
        val activityChangeIntent = Intent(this@CargoActivity, CargoActivity::class.java)
        this@CargoActivity.startActivity(activityChangeIntent)
    }

    fun tradeableClick(view: View) {
        val activityChangeIntent = Intent(this@CargoActivity, TradeActivity::class.java)
        this@CargoActivity.startActivity(activityChangeIntent)
    }
}
