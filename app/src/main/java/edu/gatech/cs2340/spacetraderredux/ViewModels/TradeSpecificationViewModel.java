package edu.gatech.cs2340.spacetraderredux.ViewModels;

import android.arch.lifecycle.ViewModel;

public class TradeSpecificationViewModel extends ViewModel {
    public int labelValue = 0;
    public int transactionCredits = 0;
    private int resourceValue;

    public void incPoints() {
        labelValue++;
        transactionCredits += resourceValue;
    }

    public void decPoints() {
        if (labelValue != 0) {
            labelValue--;
            transactionCredits -= resourceValue;
        }
    }

    public int getResourceValue() {
        return resourceValue;
    }

    public void setResourceValue(int resourceValue) {
        this.resourceValue = resourceValue;
    }
}
