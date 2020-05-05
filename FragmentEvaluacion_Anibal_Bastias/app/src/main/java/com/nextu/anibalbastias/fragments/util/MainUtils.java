package com.nextu.anibalbastias.fragments.util;


import android.content.Context;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainUtils {

    public static void pushRootFragment(FragmentManager fragmentManager,
                                        int fragmentId,
                                        Fragment fragment) {
        fragmentManager.beginTransaction().add(fragmentId, fragment).commit();
    }

    public static void pushFragment(FragmentManager fragmentManager,
                                    int fragmentId,
                                    Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(fragmentId, fragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
