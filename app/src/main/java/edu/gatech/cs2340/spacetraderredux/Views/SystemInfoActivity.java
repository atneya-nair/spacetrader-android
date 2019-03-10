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

import edu.gatech.cs2340.spacetraderredux.Model.ResourcesViewAdapter;
import edu.gatech.cs2340.spacetraderredux.Model.TempTrade;
import edu.gatech.cs2340.spacetraderredux.Model.TradeViewAdapter;
import edu.gatech.cs2340.spacetraderredux.R;

public class SystemInfoActivity extends AppCompatActivity {
    public ResourcesViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_info);
        TextView tabText = (TextView) findViewById(R.id.labelTabName);
        tabText.setText("System Info");

        LinkedList<TempTrade> trades = new LinkedList<TempTrade>();
        trades.add(new TempTrade());
        trades.add(new TempTrade());
        trades.add(new TempTrade());

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        adapter = new ResourcesViewAdapter(trades);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void systemInfoClick(View view) {
        Intent activityChangeIntent = new Intent(SystemInfoActivity.this, SystemInfoActivity.class);
        SystemInfoActivity.this.startActivity(activityChangeIntent);
    }

    public void cargoClick(View view) {
        Intent activityChangeIntent = new Intent(SystemInfoActivity.this, CargoActivity.class);
        SystemInfoActivity.this.startActivity(activityChangeIntent);
    }

    public void tradeableClick(View view) {
        Intent activityChangeIntent = new Intent(SystemInfoActivity.this, Trade.class);
        SystemInfoActivity.this.startActivity(activityChangeIntent);
    }
}
