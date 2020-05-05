package com.nextu.anibalbastias.lib;


import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;

public class ActivityController implements ActivityContract {

    private Context mContext;

    // Constants
    private String message;
    private Type keySelected;

    public enum Type {
        WELCOME, MATERIAL_DESIGN, ADVANCED_CONCEPTS, ADVANCED_APPS_DEV
    }

    public ActivityController(Context context) {
        this.mContext = context;
    }

    @Override
    public ActivityController showLogCat(String tagName) {
        Log.v(tagName, message);
        return this;
    }

    @Override
    public ActivityController setMessage(int resourceId) {
        TextView tvMessage = ((Activity) mContext).findViewById(resourceId);
        setMessageByType(keySelected);
        tvMessage.setText(message);
        return this;
    }

    @Override
    public ActivityController setKey(Type type) {
        this.keySelected = type;
        return this;
    }

    private void setMessageByType(Type type) {
        switch (type) {
            case WELCOME:
                message = setMessageByResourceId(R.string.welcome_activity_message);
                break;
            case MATERIAL_DESIGN:
                message = setMessageByResourceId(R.string.material_design_activity_message);
                break;
            case ADVANCED_CONCEPTS:
                message = setMessageByResourceId(R.string.advanced_concepts_activity_message);
                break;
            case ADVANCED_APPS_DEV:
                message = setMessageByResourceId(R.string.advanced_apps_dev_activity_message);
                break;
        }
    }

    private String setMessageByResourceId(int resourceId) {
        return mContext.getString(resourceId);
    }
}
