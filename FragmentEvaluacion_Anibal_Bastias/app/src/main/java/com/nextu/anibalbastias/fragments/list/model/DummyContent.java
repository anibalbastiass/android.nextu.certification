package com.nextu.anibalbastias.fragments.list.model;

import android.content.Context;

import com.nextu.anibalbastias.fragments.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class DummyContent implements Serializable {

    private List<InstrumentItem> instruments = new ArrayList<>();
    private Context context;

    public DummyContent(Context context) {
        this.context = context;
        addItems();
    }

    private void addItems() {
        instruments.add(new InstrumentItem(
                context,
                getString(R.string.instrument_string_title),
                getString(R.string.instrument_string_description),
                R.drawable.ic_instrument_string_main,
                R.drawable.ic_instrument_string_secondary));

        instruments.add(new InstrumentItem(
                context,
                getString(R.string.instrument_drums_title),
                getString(R.string.instrument_drums_description),
                R.drawable.ic_instrument_drums_main,
                R.drawable.ic_instrument_drums_secondary));

        instruments.add(new InstrumentItem(
                context,
                getString(R.string.instrument_brass_title),
                getString(R.string.instrument_brass_description),
                R.drawable.ic_instrument_brass_main,
                R.drawable.ic_instrument_brass_secondary));

        instruments.add(new InstrumentItem(
                context,
                getString(R.string.instrument_electric_title),
                getString(R.string.instrument_electric_description),
                R.drawable.ic_instrument_electric_main,
                R.drawable.ic_instrument_electric_secondary));
    }

    private String getString(int idString) {
        return context.getString(idString);
    }

    public List<InstrumentItem> getInstruments() {
        return instruments;
    }
}
