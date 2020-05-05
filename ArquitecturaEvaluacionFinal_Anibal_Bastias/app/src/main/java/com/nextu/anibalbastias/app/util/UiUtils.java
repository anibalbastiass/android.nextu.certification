package com.nextu.anibalbastias.app.util;


import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;

public class UiUtils {

    public static void startActivity(Context context, Class destination) {
        // Without bundle for now
        Intent intent = new Intent(context, destination);
        context.startActivity(intent);
    }

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void showSnackBar(View parent,
                                    String title,
                                    String titleButton,
                                    final SnackBarListener callback) {
        Snackbar.make(parent, title, Snackbar.LENGTH_LONG)
                .setAction(titleButton, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        callback.onSnackBarClick(view);
                    }
                })
                .setActionTextColor(ContextCompat.getColor(parent.getContext(), android.R.color.holo_red_light))
                .show();
    }

    public interface SnackBarListener {
        void onSnackBarClick(View view);
    }
}
