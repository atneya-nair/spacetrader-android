package edu.gatech.cs2340.spacetraderredux.ui.tradespec

import android.arch.lifecycle.ViewModel

class TradeSpecificationViewModel : ViewModel() {
    var labelValue = 0
    var transactionCredits = 0
    var resourceValue: Int = 0

    fun incPoints() {
        labelValue++
        transactionCredits += resourceValue
    }

    fun decPoints() {
        if (labelValue != 0) {
            labelValue--
            transactionCredits -= resourceValue
        }
    }
}
