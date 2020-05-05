package com.nextu.anibalbastias.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nextu.anibalbastias.R;
import com.nextu.anibalbastias.lib.ActivityController;
import com.nextu.anibalbastias.lib.ActivityController.Type;

public class MaterialDesignActivity extends AppCompatActivity {

    private static String TAG = MaterialDesignActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design);

        new ActivityController(this)
                .setKey(Type.MATERIAL_DESIGN)
                .setMessage(R.id.tv_material_design_message)
                .showLogCat(TAG);
    }
}
