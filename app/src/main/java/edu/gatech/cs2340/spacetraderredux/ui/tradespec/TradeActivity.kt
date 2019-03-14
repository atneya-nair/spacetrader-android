package edu.gatech.cs2340.spacetraderredux.ui.tradespec

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.TextView

import java.util.LinkedList

import edu.gatech.cs2340.spacetraderredux.R
import edu.gatech.cs2340.spacetraderredux.domain.Game
import edu.gatech.cs2340.spacetraderredux.domain.entities.BuyMarketPlace

class TradeActivity : AppCompatActivity() {
    //Lol
    companion object {
        var game: Game? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("sdfs", "sdfdfsdf")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trade)
        val trades = LinkedList<Trade>()
        var bmp = BuyMarketPlace(game!!.playerState.currPlanet, game!!.playerState);
        for (element in bmp.marketPrice) {
            if (element.value == 0) {
                continue
            }
            trades.add(Trade(element.key, element.value))
        }

        val recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView

        var adapter = TradeViewAdapter(trades)
        val mLayoutManager = GridLayoutManager(applicationContext, 2)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    fun buyClick(view: View) {
        val parentView = view.parent as View
        val tradeResource = parentView.findViewById<View>(R.id.tradeResource) as TextView
        val tradeResourcePrice = parentView.findViewById<View>(R.id.tradeResourcePrice) as TextView
        val activityChangeIntent = Intent(this@TradeActivity, TradeSpecification::class.java)
        activityChangeIntent.putExtra("resource", tradeResource.text as String)
        activityChangeIntent.putExtra("resourcePrice", tradeResourcePrice.text as String)
        activityChangeIntent.putExtra("buy", "True")
        this@TradeActivity.startActivity(activityChangeIntent)
    }

    fun sellClick(view: View) {
        val parentView = view.parent as View
        val tradeResource = parentView.findViewById<View>(R.id.tradeResource) as TextView
        val tradeResourcePrice = parentView.findViewById<View>(R.id.tradeResourcePrice) as TextView
        val activityChangeIntent = Intent(this@TradeActivity, TradeSpecification::class.java)
        activityChangeIntent.putExtra("resource", tradeResource.text as String)
        activityChangeIntent.putExtra("resourcePrice", tradeResourcePrice.text as String)
        activityChangeIntent.putExtra("buy", "False")
        this@TradeActivity.startActivity(activityChangeIntent)
    }

    fun systemInfoClick(view: View) {
        val activityChangeIntent = Intent(this@TradeActivity, SystemInfoActivity::class.java)
        this@TradeActivity.startActivity(activityChangeIntent)
    }

    fun cargoClick(view: View) {
        val activityChangeIntent = Intent(this@TradeActivity, CargoActivity::class.java)
        this@TradeActivity.startActivity(activityChangeIntent)
    }

    fun tradeableClick(view: View) {
        val activityChangeIntent = Intent(this@TradeActivity, TradeActivity::class.java)
        this@TradeActivity.startActivity(activityChangeIntent)
    }
}
