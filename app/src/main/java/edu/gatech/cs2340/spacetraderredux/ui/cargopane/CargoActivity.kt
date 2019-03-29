package edu.gatech.cs2340.spacetraderredux.ui.cargopane

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
import edu.gatech.cs2340.spacetraderredux.di.presenters.DaggerCargoComponent
import edu.gatech.cs2340.spacetraderredux.di.presenters.DaggerTradeComponent
import edu.gatech.cs2340.spacetraderredux.domain.entities.BuyMarketPlace
import edu.gatech.cs2340.spacetraderredux.domain.entities.PlayerState
import edu.gatech.cs2340.spacetraderredux.domain.entities.Trade
import edu.gatech.cs2340.spacetraderredux.domain.usecases.GetCurrentStateUseCase
import edu.gatech.cs2340.spacetraderredux.ui.common.App
import edu.gatech.cs2340.spacetraderredux.ui.mappane.MapActivity
import edu.gatech.cs2340.spacetraderredux.ui.systempane.SystemInfoActivity
import edu.gatech.cs2340.spacetraderredux.ui.tradepane.TradeActivity
import edu.gatech.cs2340.spacetraderredux.ui.tradepane.TradeViewAdapter
import io.reactivex.observers.DisposableSingleObserver
import kotlinx.android.synthetic.main.activity_trade.*
import javax.inject.Inject

class CargoActivity : AppCompatActivity() {
    @Inject
    lateinit var getCurrentStateUseCase: GetCurrentStateUseCase // TODO refactor this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cargo)
        val tabText = findViewById<View>(R.id.labelTabName) as TextView
        tabText.text = "Cargo"
        DaggerCargoComponent.builder().appComponent((application as App).applicationComponent).build().inject(this)
        getCurrentStateUseCase.execute(object: DisposableSingleObserver<PlayerState>() {
            override fun onSuccess(playerStateResult: PlayerState) {
                val trades = LinkedList<Trade>()
                for (element in playerStateResult.ship.storageUnits.cargoHold.getItems()) {
                    trades.add(Trade(element.key, element.value))
                }

                val recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView

                var adapter = ResourcesViewAdapter(trades)
                val mLayoutManager = GridLayoutManager(applicationContext, 2)
                recyclerView.layoutManager = mLayoutManager
                recyclerView.itemAnimator = DefaultItemAnimator()
                recyclerView.adapter = adapter
                adapter.notifyDataSetChanged()
            }
            override fun onError(e: Throwable) {
                e.printStackTrace()
            }
        })


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

    fun solarClick(view: View) {
        val activityChangeIntent = Intent(this@CargoActivity, MapActivity::class.java)
        this@CargoActivity.startActivity(activityChangeIntent)
    }
}
