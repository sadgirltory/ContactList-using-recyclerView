package com.example.endofthefuckingworld;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.Viewholder>{
    private static final String TAG = "recyclerViewAdapter";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mPhonenum = new ArrayList<>();
    private Context mContext;

    public recyclerViewAdapter(ArrayList<String> mNames, ArrayList<String> mPhonenum, Context mContext) {
        this.mNames = mNames;
        this.mPhonenum = mPhonenum;
        this.mContext = mContext;
    }

    @Override
    public Viewholder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item,parent,false);
        Viewholder holder = new Viewholder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(Viewholder holder, final int position) {
        Log.d(TAG,"onBindViewHolder : Called.");
        holder.name.setText(mNames.get(position));
        holder.phonenumber.setText(mPhonenum.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick: clicked on:"+mNames.get(position));
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL); // Action for what intent called for
                intent.setData(Uri.parse("tel: " + mPhonenum.get(position))); // Data with intent respective action on intent
                mContext.startActivity(intent);
                Toast.makeText(mContext,mNames.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNames.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
            TextView name,phonenumber;
            LinearLayout parentLayout;

            public Viewholder(@NonNull View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.name);
                phonenumber = itemView.findViewById(R.id.phonenumber);
                parentLayout = itemView.findViewById(R.id.parentLayout);

            }
    }
}
