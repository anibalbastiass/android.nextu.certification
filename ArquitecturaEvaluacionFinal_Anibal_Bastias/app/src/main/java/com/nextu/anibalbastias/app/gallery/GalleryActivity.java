package com.nextu.anibalbastias.app.gallery;

import android.os.Bundle;
import android.widget.GridView;

import com.nextu.anibalbastias.app.R;
import com.nextu.anibalbastias.app.base.BaseActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class GalleryActivity extends BaseActivity {

    private GridView gridView;

    private ArrayList<Integer> images = new ArrayList<>(Arrays.asList(
            R.drawable.image_1,
            R.drawable.image_2,
            R.drawable.image_3,
            R.drawable.image_4,
            R.drawable.image_5,
            R.drawable.image_6
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        setView();
        setAdapter();
    }

    private void setView() {
        gridView = findViewById(R.id.gv_activity_gallery_grid);
    }

    private void setAdapter() {
        gridView.setAdapter(new GalleryAdapter(this, images));
    }
}
