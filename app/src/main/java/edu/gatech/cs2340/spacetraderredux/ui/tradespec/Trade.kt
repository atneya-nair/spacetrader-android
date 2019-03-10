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
import edu.gatech.cs2340.spacetraderredux.di.SpaceTraderGlobal
import kotlinx.android.synthetic.main.activity_trade.*

class Trade : AppCompatActivity() {
    var adapter: RecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        var global = getApplication() as SpaceTraderGlobal
        val game = global.game
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trade)
        planetName.text = game!!.player.currPlanet.name.toString()
        val trades = LinkedList<TempTrade>()
        trades.add(TempTrade())
        trades.add(TempTrade())
        trades.add(TempTrade())

        val recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView

        adapter = RecyclerViewAdapter(trades)
        val mLayoutManager = GridLayoutManager(applicationContext, 2)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter
        adapter!!.notifyDataSetChanged()
    }

    fun buyClick(view: View) {
        val parentView = view.parent as View
        val tradeResource = parentView.findViewById<View>(R.id.tradeResource) as TextView
        val tradeResourcePrice = parentView.findViewById<View>(R.id.tradeResourcePrice) as TextView
        val activityChangeIntent = Intent(this@Trade, TradeSpecification::class.java)
        activityChangeIntent.putExtra("resource", tradeResource.text as String)
        activityChangeIntent.putExtra("resourcePrice", tradeResourcePrice.text as String)
        activityChangeIntent.putExtra("buy", "True")
        this@Trade.startActivity(activityChangeIntent)
    }

    fun sellClick(view: View) {
        val parentView = view.parent as View
        val tradeResource = parentView.findViewById<View>(R.id.tradeResource) as TextView
        val tradeResourcePrice = parentView.findViewById<View>(R.id.tradeResourcePrice) as TextView
        val activityChangeIntent = Intent(this@Trade, TradeSpecification::class.java)
        activityChangeIntent.putExtra("resource", tradeResource.text as String)
        activityChangeIntent.putExtra("resourcePrice", tradeResourcePrice.text as String)
        activityChangeIntent.putExtra("buy", "False")
        this@Trade.startActivity(activityChangeIntent)
    }
}
