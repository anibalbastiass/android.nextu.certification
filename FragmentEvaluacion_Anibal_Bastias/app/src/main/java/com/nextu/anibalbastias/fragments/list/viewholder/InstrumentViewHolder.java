package com.nextu.anibalbastias.fragments.list.viewholder;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nextu.anibalbastias.fragments.R;
import com.nextu.anibalbastias.fragments.list.model.InstrumentItem;

public class InstrumentViewHolder extends RecyclerView.ViewHolder {

    public final View mView;
    public final TextView mContentView;
    public InstrumentItem mItem;

    public InstrumentViewHolder(View view) {
        super(view);
        mView = view;
        mContentView = view.findViewById(R.id.title);
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString() + " '" + mContentView.getText() + "'";
    }
}