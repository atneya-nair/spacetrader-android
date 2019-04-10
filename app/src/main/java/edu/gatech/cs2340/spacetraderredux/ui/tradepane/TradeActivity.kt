package edu.gatech.cs2340.spacetraderredux.ui.tradepane

import android.app.Dialog
import android.content.Intent
import android.support.v7.app.AlertDialog
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import edu.gatech.cs2340.spacetraderredux.R
import edu.gatech.cs2340.spacetraderredux.di.presenters.DaggerTradeComponent
import edu.gatech.cs2340.spacetraderredux.domain.entities.Trade
import edu.gatech.cs2340.spacetraderredux.ui.common.App
import edu.gatech.cs2340.spacetraderredux.ui.common.BaseActivity
import kotlinx.android.synthetic.main.activity_buy_trade_pane.view.*
import kotlinx.android.synthetic.main.activity_sell_trade_pane.view.*
import kotlinx.android.synthetic.main.activity_trade.*
import java.util.*

class TradeActivity : BaseActivity<TradePresenter>(), TradeView {
    private lateinit var recyclerView: RecyclerView
    private var dialog: Dialog? = null
    private var tradePane: View? = null
    private var trades: List<Trade> = ArrayList()

    override fun displayToast(message: String) {
        Toast.makeText(this@TradeActivity, message, Toast.LENGTH_SHORT).show()
    }

    override fun displayBuyDialog(trade: Trade) {
        val builder = AlertDialog.Builder(this)
        tradePane = layoutInflater.inflate(R.layout.activity_buy_trade_pane, parent as? ViewGroup)
        builder.setView(tradePane)
        builder.setTitle("Buying " + trade.tradeable.displayName)
        tradePane!!.cancelButton.setOnClickListener { presenter.onCancelTransaction() }
        tradePane!!.okBuyButton.setOnClickListener { presenter.onBuyConfirmation() }
        tradePane!!.upResourceButton.setOnClickListener { presenter.onIncrementBuyQuantityClick() }
        tradePane!!.downResourceButton.setOnClickListener { presenter.onDecrementBuyQuantityClick() }
        tradePane!!.unitCost.text = trade.price.toString()
        tradePane!!.resourceValueText.text = "0"
        tradePane!!.transactionTotalText.text = "0"

        dialog = builder.create()
        dialog?.show()
    }

    override fun setBuyQuantity(quantity: Int, newTotal: Int) {
        tradePane!!.resourceValueText.text = quantity.toString()
        tradePane!!.transactionTotalText.text = newTotal.toString()
    }

    override fun setSellQuantity(quantity: Int, newTotal: Int) {
        tradePane!!.resourceSellValueText.text = quantity.toString()
        tradePane!!.sellTransactionTotalText.text = newTotal.toString()
    }

    override fun closeDialog() {
        dialog?.dismiss()
        dialog = null
        tradePane = null
    }

    override fun displaySellDialog(trade: Trade) {
        val builder = AlertDialog.Builder(this)
        tradePane = layoutInflater.inflate(R.layout.activity_sell_trade_pane, parent as? ViewGroup,
                false)
        builder.setView(tradePane)
        builder.setTitle("Selling " + trade.tradeable.displayName)
        tradePane!!.cancelSellButton.setOnClickListener { presenter.onCancelTransaction() }
        tradePane!!.okSellButton.setOnClickListener { presenter.onSellConfirmation() }
        tradePane!!.upSellResourceButton.setOnClickListener()
            { presenter.onIncrementSellQuantityClick() }
        tradePane!!.downSellResourceButton.setOnClickListener()
            { presenter.onDecrementSellQuantityClick() }
        tradePane!!.sellUnitCost.text = trade.price.toString()
        tradePane!!.resourceSellValueText.text = "0"
        tradePane!!.sellTransactionTotalText.text = "0"

        dialog = builder.create()
        dialog?.show()
    }

    override fun <T> changeActivity(newActivity: Class<T>) {
        val activityChangeIntent = Intent(this@TradeActivity, newActivity)
        activityChangeIntent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        startActivityIfNeeded(activityChangeIntent, 0)
    }

    override fun getLayout(): Int {
        return R.layout.activity_trade
    }

    override fun initInjector() {
        DaggerTradeComponent.builder().appComponent(
                (application as App).applicationComponent).build().inject(this)
    }

    override fun setPlanetName(name: String) {
        planetName.text = name
    }

    override fun displayTrades(trades: List<Trade>) {
        recyclerView = findViewById(R.id.recyclerView)
        this.trades = trades
        val adapter = TradeViewAdapter(trades)
        val mLayoutManager = GridLayoutManager(applicationContext, 2)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        presenter.initialise()
    }

    fun buyClick(view: View) {
        val trade = trades[recyclerView.getChildAdapterPosition(view.parent as View)]
        presenter.onBuyClick(trade)
    }

    fun sellClick(view: View) {
        val trade = trades[recyclerView.getChildAdapterPosition(view.parent as View)]
        presenter.onSellClick(trade)
    }

    fun systemInfoClick(view: View) {
        presenter.onSystemInfoClick()
    }

    fun cargoClick(view: View) {
        presenter.onCargoClick()
    }

    fun tradeableClick(view: View) {
        presenter.onTradeableClick()
    }

    fun solarClick(view: View) {
        presenter.onSolarClick()
    }
}
