package edu.gatech.cs2340.spacetraderredux.ui.systempane

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import android.widget.Toast

import java.util.LinkedList

import edu.gatech.cs2340.spacetraderredux.R
import edu.gatech.cs2340.spacetraderredux.domain.entities.Trade
import edu.gatech.cs2340.spacetraderredux.ui.mappane.MapActivity
import edu.gatech.cs2340.spacetraderredux.ui.cargopane.CargoActivity
import edu.gatech.cs2340.spacetraderredux.ui.cargopane.ResourcesViewAdapter
import edu.gatech.cs2340.spacetraderredux.ui.tradepane.TradeActivity

class SystemInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_system_info)
        val tabText = findViewById<View>(R.id.labelTabName) as TextView
        tabText.text = "System Info"

        val trades = LinkedList<Trade>()
        /*trades.add(Trade())
        trades.add(Trade())
        trades.add(Trade())*/

        val recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView

        var adapter = ResourcesViewAdapter(trades)
        val mLayoutManager = GridLayoutManager(applicationContext, 2)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    fun systemInfoClick(view: View) {
        Toast.makeText(this@SystemInfoActivity, "Already on System Info page!", Toast.LENGTH_SHORT).show()
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
}
