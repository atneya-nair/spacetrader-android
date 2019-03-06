package edu.gatech.cs2340.spacetraderredux.Views;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.gatech.cs2340.spacetraderredux.R;
import edu.gatech.cs2340.spacetraderredux.ViewModels.ConfigurationViewModel;
import edu.gatech.cs2340.spacetraderredux.ViewModels.TradeSpecificationViewModel;

public class TradeSpecification extends AppCompatActivity {
    TradeSpecificationViewModel mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade_specification);
        mViewModel = ViewModelProviders.of(this).get(TradeSpecificationViewModel.class);
        TextView specificationText = (TextView) findViewById(R.id.labelTradeConfirmation);
        Intent intent = getIntent();
        mViewModel.setResourceValue(Integer.parseInt(intent.getStringExtra("resourcePrice")));
        if (intent.getStringExtra("buy").equals("True")) {
            String text = "Buy " + intent.getStringExtra("resource") + " at " + intent.getStringExtra("resourcePrice") + " credits";
            specificationText.setText(text);
        } else {
            String text = "Sell " + intent.getStringExtra("resource") + " at " + intent.getStringExtra("resourcePrice") + " credits";
            specificationText.setText(text);
        }
    }


    public void upResourceClicked(View view) {
        View parentView = (View) view.getRootView();
        TextView resourceValue =  (TextView) parentView.findViewById(R.id.resourceValueText);
        TextView transactionTotal =  (TextView) parentView.findViewById(R.id.transactionTotalText);
        mViewModel.incPoints();
        resourceValue.setText(Integer.toString(mViewModel.labelValue));
        transactionTotal.setText(Integer.toString(mViewModel.transactionCredits));
    }

    public void downResourceClicked(View view) {
        View parentView = (View) view.getRootView();
        TextView resourceValue =  (TextView) parentView.findViewById(R.id.resourceValueText);
        TextView transactionTotal =  (TextView) parentView.findViewById(R.id.transactionTotalText);
        mViewModel.decPoints();
        resourceValue.setText(Integer.toString(mViewModel.labelValue));
        transactionTotal.setText(Integer.toString(mViewModel.transactionCredits));
    }

    public void cancel(View view) {
        Intent activityChangeIntent = new Intent(TradeSpecification.this, Trade.class);
        TradeSpecification.this.startActivity(activityChangeIntent);
    }
}
