package com.nextu.anibalbastias.app.gallery;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.nextu.anibalbastias.app.R;

import java.util.ArrayList;

public class GalleryAdapter extends BaseAdapter {

    private ArrayList<Integer> images;
    private final LayoutInflater mInflater;

    GalleryAdapter(Context context, ArrayList<Integer> images) {
        this.images = images;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        ImageView picture;

        if (convertView == null) {
            v = mInflater.inflate(R.layout.cell_grid_view_gallery, parent, false);
            v.setTag(R.id.picture, v.findViewById(R.id.picture));
        } else
            v = convertView;

        picture = (ImageView) v.getTag(R.id.picture);
        picture.setImageResource(images.get(position));
        return v;
    }
}