package edu.gatech.cs2340.spacetraderredux.domain.entities

data class TradeAction(val tradeable: Tradeable, val price: Int, val sell:Boolean)