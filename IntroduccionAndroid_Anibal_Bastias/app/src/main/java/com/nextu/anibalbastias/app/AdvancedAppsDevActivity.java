package com.nextu.anibalbastias.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nextu.anibalbastias.R;
import com.nextu.anibalbastias.lib.ActivityController;
import com.nextu.anibalbastias.lib.ActivityController.Type;

public class AdvancedAppsDevActivity extends AppCompatActivity {

    private static String TAG = AdvancedAppsDevActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_apps_dev);

        new ActivityController(this)
                .setKey(Type.ADVANCED_APPS_DEV)
                .setMessage(R.id.tv_advanced_apps_dev_message)
                .showLogCat(TAG);
    }
}
