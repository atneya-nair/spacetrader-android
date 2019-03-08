package edu.gatech.cs2340.spacetraderredux.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.LinkedList;

import edu.gatech.cs2340.spacetraderredux.Model.TradeViewAdapter;
import edu.gatech.cs2340.spacetraderredux.Model.TempTrade;
import edu.gatech.cs2340.spacetraderredux.R;

public class Trade extends AppCompatActivity {
    public TradeViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade);
        LinkedList<TempTrade> trades = new LinkedList<TempTrade>();
        trades.add(new TempTrade());
        trades.add(new TempTrade());
        trades.add(new TempTrade());

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        adapter = new TradeViewAdapter(trades);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void buyClick(View view) {
        View parentView = (View) view.getParent();
        TextView tradeResource = (TextView) parentView.findViewById(R.id.tradeResource);
        TextView tradeResourcePrice = (TextView) parentView.findViewById(R.id.tradeResourcePrice);
        Intent activityChangeIntent = new Intent(Trade.this, TradeSpecification.class);
        activityChangeIntent.putExtra("resource", (String)tradeResource.getText());
        activityChangeIntent.putExtra("resourcePrice", (String)tradeResourcePrice.getText());
        activityChangeIntent.putExtra("buy", "True");
        Trade.this.startActivity(activityChangeIntent);
    }

    public void sellClick(View view) {
        View parentView = (View) view.getParent();
        TextView tradeResource = (TextView) parentView.findViewById(R.id.tradeResource);
        TextView tradeResourcePrice = (TextView) parentView.findViewById(R.id.tradeResourcePrice);
        Intent activityChangeIntent = new Intent(Trade.this, TradeSpecification.class);
        activityChangeIntent.putExtra("resource", (String)tradeResource.getText());
        activityChangeIntent.putExtra("resourcePrice", (String)tradeResourcePrice.getText());
        activityChangeIntent.putExtra("buy", "False");
        Trade.this.startActivity(activityChangeIntent);
    }

    public void systemInfoClick(View view) {
        Intent activityChangeIntent = new Intent(Trade.this, SystemInfoActivity.class);
        Trade.this.startActivity(activityChangeIntent);
    }

    public void cargoClick(View view) {
        Intent activityChangeIntent = new Intent(Trade.this, CargoActivity.class);
        Trade.this.startActivity(activityChangeIntent);
    }

    public void tradeableClick(View view) {
        Intent activityChangeIntent = new Intent(Trade.this, Trade.class);
        Trade.this.startActivity(activityChangeIntent);
    }
}
