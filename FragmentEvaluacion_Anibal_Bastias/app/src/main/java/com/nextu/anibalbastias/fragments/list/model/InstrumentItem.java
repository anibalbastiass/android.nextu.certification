package com.nextu.anibalbastias.fragments.list.model;


import android.content.Context;

import androidx.annotation.NonNull;

import com.nextu.anibalbastias.fragments.R;

import java.io.Serializable;

public class InstrumentItem implements Serializable {

    private String title;
    private String description;
    private int mainInstrumentImage;
    private int secondaryInstrumentImage;
    private Context context;

    InstrumentItem(Context context, String title, String description,
                   int mainInstrumentImage, int secondaryInstrumentImage) {
        this.context = context;
        this.title = title;
        this.description = description;
        this.mainInstrumentImage = mainInstrumentImage;
        this.secondaryInstrumentImage = secondaryInstrumentImage;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getMainInstrumentImage() {
        return mainInstrumentImage;
    }

    public int getSecondaryInstrumentImage() {
        return secondaryInstrumentImage;
    }

    @NonNull
    @Override
    public String toString() {
        return context.getString(R.string.instrument_title_prefix) + title;
    }
}
