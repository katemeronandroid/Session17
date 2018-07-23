package com.emarkova.session17;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter {
    ArrayList<String> mData;
    Context context;

    public CustomAdapter(Context context) {
        super();
        this.context = context;
        mData = new ArrayList<>();
        DataManager manager = new DataManager(context);
        int counter = 1;
        int amount = manager.getCounter();
        while(counter < amount + 1) {
            mData.add(manager.getUser(counter));
            counter++;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.fileName);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final int position = i;
        ((MyViewHolder)viewHolder).name.setText(mData.get(i));
        ((MyViewHolder)viewHolder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ActivityDetail.class);
                intent.putExtra("name", mData.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
