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

class SystemInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_system_info)
        val tabText = findViewById<View>(R.id.labelTabName) as TextView
        tabText.text = "System Info"

        val trades = LinkedList<TempTrade>()
        trades.add(TempTrade())
        trades.add(TempTrade())
        trades.add(TempTrade())

        val recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView

        var adapter = ResourcesViewAdapter(trades)
        val mLayoutManager = GridLayoutManager(applicationContext, 2)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    fun systemInfoClick(view: View) {
        val activityChangeIntent = Intent(this@SystemInfoActivity, SystemInfoActivity::class.java)
        this@SystemInfoActivity.startActivity(activityChangeIntent)
    }

    fun cargoClick(view: View) {
        val activityChangeIntent = Intent(this@SystemInfoActivity, CargoActivity::class.java)
        this@SystemInfoActivity.startActivity(activityChangeIntent)
    }

    fun tradeableClick(view: View) {
        val activityChangeIntent = Intent(this@SystemInfoActivity, Trade::class.java)
        this@SystemInfoActivity.startActivity(activityChangeIntent)
    }
}
