package edu.gatech.cs2340.spacetraderredux.ui.tradespec


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import edu.gatech.cs2340.spacetraderredux.R


class TradeViewAdapter(private val list: List<TempTrade>) : RecyclerView.Adapter<TradeViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var resourceName: TextView
        var price: TextView

        init {
            resourceName = view.findViewById<View>(R.id.tradeResource) as TextView
            price = view.findViewById<View>(R.id.tradeResourcePrice) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.trade_row, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val tempTrade = list[position]
        holder.resourceName.text = tempTrade.resourceName
        holder.price.text = tempTrade.price
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
