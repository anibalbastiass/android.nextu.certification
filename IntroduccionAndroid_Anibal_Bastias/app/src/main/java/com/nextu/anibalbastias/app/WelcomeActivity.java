package com.nextu.anibalbastias.app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.nextu.anibalbastias.R;
import com.nextu.anibalbastias.lib.ActivityController;
import com.nextu.anibalbastias.lib.ActivityController.Type;

public class WelcomeActivity extends AppCompatActivity {

    private static String TAG = WelcomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        new ActivityController(this)
                .setKey(Type.WELCOME)
                .setMessage(R.id.tv_welcome_message)
                .showLogCat(TAG);
    }
}
