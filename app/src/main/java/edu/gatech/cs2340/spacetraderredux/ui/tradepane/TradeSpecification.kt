package edu.gatech.cs2340.spacetraderredux.ui.tradepane

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

import edu.gatech.cs2340.spacetraderredux.R
import edu.gatech.cs2340.spacetraderredux.di.presenters.DaggerTradeSpecComponent
import edu.gatech.cs2340.spacetraderredux.domain.entities.PlayerState
import edu.gatech.cs2340.spacetraderredux.domain.entities.Trade
import edu.gatech.cs2340.spacetraderredux.domain.entities.Tradeable
import edu.gatech.cs2340.spacetraderredux.ui.common.App


class TradeSpecification : AppCompatActivity() {
    private var mViewModel: TradeSpecificationViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setFinishOnTouchOutside(false)
        setContentView(R.layout.activity_trade_specification)
        mViewModel = ViewModelProviders.of(this).get(TradeSpecificationViewModel::class.java)
        (mViewModel as TradeSpecificationViewModel).playerState = TradeActivity.playerState!!
        DaggerTradeSpecComponent.builder().appComponent((application as App).applicationComponent).build().inject(mViewModel as TradeSpecificationViewModel)
        val specificationText = findViewById<View>(R.id.labelTradeConfirmation) as TextView
        val intent = intent
        (findViewById<TextView>(R.id.remainingCredits)).text = (TradeActivity.playerState as PlayerState).credits.toString()

        val resourceValue = Integer.parseInt(intent.getStringExtra("resourcePrice"))
        val resourceName = intent.getStringExtra("resource")
        mViewModel!!.trade = Trade(Tradeable.valueOf(resourceName.toUpperCase()), resourceValue)
        if (intent.getStringExtra("buy") == "True") {
            mViewModel!!.isBuy = true
            val text = "Buy " + intent.getStringExtra("resource") + " at " + intent.getStringExtra("resourcePrice") + " credits"
            specificationText.text = text
        } else {
            mViewModel!!.isBuy = false
            val text = "Sell " + intent.getStringExtra("resource") + " at " + intent.getStringExtra("resourcePrice") + " credits"
            specificationText.text = text
        }
    }


    fun upResourceClicked(view: View) {
        val parentView = view.rootView as View
        val resourceValue = parentView.findViewById<View>(R.id.resourceValueText) as TextView
        val transactionTotal = parentView.findViewById<View>(R.id.transactionTotalText) as TextView

        mViewModel!!.incPoints()
        resourceValue.text = Integer.toString(mViewModel!!.labelValue)
        transactionTotal.text = Integer.toString(mViewModel!!.transactionCredits)
    }

    fun downResourceClicked(view: View) {
        val parentView = view.rootView as View
        val resourceValue = parentView.findViewById<View>(R.id.resourceValueText) as TextView
        val transactionTotal = parentView.findViewById<View>(R.id.transactionTotalText) as TextView
        mViewModel!!.decPoints()
        resourceValue.text = Integer.toString(mViewModel!!.labelValue)
        transactionTotal.text = Integer.toString(mViewModel!!.transactionCredits)
    }

    fun transact(view: View) {
        mViewModel!!.transact()
        cancel(view)
    }

    fun cancel(view: View) {
        finish();
    }
}
