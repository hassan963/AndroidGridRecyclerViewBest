package com.hassanmashraful.androidgridrecyclerviewbest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Hassan M.Ashraful on 11/25/2016.
 */

public class AndroidDataAdapter extends RecyclerView.Adapter<AndroidDataAdapter.ViewHolder> {

    private ArrayList<AndroidVersion> arrayList;
    private Context mcontext;

    public AndroidDataAdapter(Context context, ArrayList<AndroidVersion> android) {
        this.arrayList = android;
        this.mcontext = context;
    }

    @Override
    public AndroidDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AndroidDataAdapter.ViewHolder holder, int position) {
        holder.textView.setText(arrayList.get(position).getrecyclerViewTitleText());
        //holder.imageView.setImageResource(arrayList.get(position).getrecyclerViewImage());
        Picasso.with(mcontext).load(arrayList.get(position).getrecyclerViewImage()).resize(240, 120).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;

        public ViewHolder(View v) {
            super(v);

            textView = (TextView) v.findViewById(R.id.text);
            imageView = (ImageView) v.findViewById(R.id.image);
        }
    }

}
