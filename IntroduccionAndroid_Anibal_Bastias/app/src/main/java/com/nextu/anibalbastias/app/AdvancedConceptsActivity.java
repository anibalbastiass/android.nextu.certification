package com.nextu.anibalbastias.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nextu.anibalbastias.R;
import com.nextu.anibalbastias.lib.ActivityController;
import com.nextu.anibalbastias.lib.ActivityController.Type;

public class AdvancedConceptsActivity extends AppCompatActivity {

    private static String TAG = AdvancedConceptsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_concepts);

        new ActivityController(this)
                .setKey(Type.ADVANCED_CONCEPTS)
                .setMessage(R.id.tv_advanced_concepts_message)
                .showLogCat(TAG);
    }
}
