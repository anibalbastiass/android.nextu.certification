package com.nextu.anibalbastias.fragments.list;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nextu.anibalbastias.fragments.R;
import com.nextu.anibalbastias.fragments.list.interfaces.OnListFragmentInteractionListener;
import com.nextu.anibalbastias.fragments.list.model.InstrumentItem;
import com.nextu.anibalbastias.fragments.list.viewholder.InstrumentViewHolder;

import java.util.List;

public class InstrumentListRecyclerViewAdapter extends RecyclerView.Adapter<InstrumentViewHolder> {

    private final List<InstrumentItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    InstrumentListRecyclerViewAdapter(List<InstrumentItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @NonNull
    @Override
    public InstrumentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_cell_instrument_list, parent, false);
        return new InstrumentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final InstrumentViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).getTitle());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

}
