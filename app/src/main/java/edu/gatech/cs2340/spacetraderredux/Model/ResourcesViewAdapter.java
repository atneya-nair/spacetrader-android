package edu.gatech.cs2340.spacetraderredux.Model;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import edu.gatech.cs2340.spacetraderredux.R;
import edu.gatech.cs2340.spacetraderredux.ui.tradespec.TempTrade;


public class ResourcesViewAdapter extends RecyclerView.Adapter<ResourcesViewAdapter.MyViewHolder> {

    private List<TempTrade> list;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView resourceName;
        public TextView price;

        public MyViewHolder(View view) {
            super(view);
            resourceName = (TextView) view.findViewById(R.id.tradeResource);
            price = (TextView) view.findViewById(R.id.tradeResourcePrice);
        }
    }

    public ResourcesViewAdapter(List<TempTrade> updatedList) {
        this.list = updatedList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resources_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TempTrade tempTrade = list.get(position);
        holder.resourceName.setText(tempTrade.getResourceName());
        holder.price.setText(tempTrade.getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
