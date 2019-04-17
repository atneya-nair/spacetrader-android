package edu.gatech.cs2340.spacetraderredux.ui.tradepane

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import edu.gatech.cs2340.spacetraderredux.R
import edu.gatech.cs2340.spacetraderredux.di.presenters.DaggerTradeComponent
import edu.gatech.cs2340.spacetraderredux.domain.entities.BuyMarketPlace
import edu.gatech.cs2340.spacetraderredux.domain.entities.PlayerState
import edu.gatech.cs2340.spacetraderredux.domain.entities.Trade
import edu.gatech.cs2340.spacetraderredux.domain.usecases.GetCurrentStateUseCase
import edu.gatech.cs2340.spacetraderredux.ui.shipyard.ShipYardActivity
import edu.gatech.cs2340.spacetraderredux.ui.cargopane.CargoActivity
import edu.gatech.cs2340.spacetraderredux.ui.common.App
import edu.gatech.cs2340.spacetraderredux.ui.mappane.MapActivity
import edu.gatech.cs2340.spacetraderredux.ui.systempane.SystemInfoActivity
import io.reactivex.observers.DisposableSingleObserver
import kotlinx.android.synthetic.main.activity_trade.*
import java.util.*
import javax.inject.Inject

class TradeActivity : AppCompatActivity() {
    companion object {
        var playerState:PlayerState? = null

    }
    @Inject
    lateinit var getCurrentStateUseCase: GetCurrentStateUseCase
    //TODO refactor MVP
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("sdfs", "sdfdfsdf")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trade)
        DaggerTradeComponent.builder().appComponent(
                (application as App).applicationComponent).build().inject(this)
        getCurrentStateUseCase.execute(object: DisposableSingleObserver<PlayerState>() {
            override fun onSuccess(playerStateResult: PlayerState) {
                playerState = playerStateResult
                planetName.text = playerStateResult.currPlanet.name.toString()
                val trades = LinkedList<Trade>()
                val bmp = BuyMarketPlace(playerStateResult.currPlanet, playerStateResult)
                for (element in bmp.marketPrice) {
                    if (element.value == 0) {
                        continue
                    }
                    trades.add(Trade(element.key, element.value))
                }

                val recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView

                val adapter = TradeViewAdapter(trades)
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

    override fun onResume() {
        super.onResume()
        DaggerTradeComponent.builder().appComponent(
                (application as App).applicationComponent).build().inject(this)
        getCurrentStateUseCase.execute(object: DisposableSingleObserver<PlayerState>() {
            override fun onSuccess(playerStateResult: PlayerState) {
                planetName.text = playerStateResult.currPlanet.name.toString()
                val trades = LinkedList<Trade>()
                val bmp = BuyMarketPlace(playerStateResult.currPlanet, playerStateResult)
                for (element in bmp.marketPrice) {
                    if (element.value == 0) {
                        continue
                    }
                    trades.add(Trade(element.key, element.value))
                }

                val recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView

                val adapter = TradeViewAdapter(trades)
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
        activityChangeIntent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        startActivityIfNeeded(activityChangeIntent, 0)

    }

    fun cargoClick(view: View) {
        val activityChangeIntent = Intent(this@TradeActivity, CargoActivity::class.java)
        activityChangeIntent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        startActivityIfNeeded(activityChangeIntent, 0)

    }

    fun tradeableClick(view: View) {
        Toast.makeText(this@TradeActivity, "Already on Trade page!", Toast.LENGTH_SHORT).show()
    }

    fun solarClick(view: View) {
        val activityChangeIntent = Intent(this@TradeActivity, MapActivity::class.java)
        activityChangeIntent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        startActivityIfNeeded(activityChangeIntent, 0)
    }

    fun yardClick(view: View) {
        val activityChangeIntent = Intent(this@TradeActivity, ShipYardActivity::class.java)
        activityChangeIntent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        startActivityIfNeeded(activityChangeIntent, 0)
    }
}
