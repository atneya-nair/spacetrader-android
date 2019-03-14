package edu.gatech.cs2340.spacetraderredux.ui.tradespec

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

import edu.gatech.cs2340.spacetraderredux.R
import edu.gatech.cs2340.spacetraderredux.domain.entities.Tradeable
import org.w3c.dom.Text


class TradeSpecification : AppCompatActivity() {
    var mViewModel: TradeSpecificationViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setFinishOnTouchOutside(false)
        setContentView(R.layout.activity_trade_specification)
        mViewModel = ViewModelProviders.of(this).get(TradeSpecificationViewModel::class.java)
        val specificationText = findViewById<View>(R.id.labelTradeConfirmation) as TextView
        val intent = intent
        (findViewById<TextView>(R.id.remainingCredits)).text = mViewModel!!.playerState.credits.toString()

        var resourceValue = Integer.parseInt(intent.getStringExtra("resourcePrice"))
        var resourceName = intent.getStringExtra("resource")
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
        val activityChangeIntent = Intent(this@TradeSpecification, TradeActivity::class.java)
        this@TradeSpecification.startActivity(activityChangeIntent)
    }
}
