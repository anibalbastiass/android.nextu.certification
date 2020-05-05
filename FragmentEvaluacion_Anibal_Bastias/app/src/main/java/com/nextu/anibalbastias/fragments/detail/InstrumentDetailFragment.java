package com.nextu.anibalbastias.fragments.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.nextu.anibalbastias.fragments.R;
import com.nextu.anibalbastias.fragments.list.model.InstrumentItem;
import com.nextu.anibalbastias.fragments.util.MainUtils;

public class InstrumentDetailFragment extends Fragment implements View.OnClickListener {

    public static final String ARG_INSTRUMENT_ITEM = "INSTRUMENT_ITEM";
    private InstrumentItem instrumentItem;

    private TextView description;
    private ImageView mainImage;
    private ImageView secondaryImage;

    private ImageButton primaryStarButton;
    private ImageButton primaryPlayButton;
    private ImageButton secondaryStarButton;
    private ImageButton secondaryPlayButton;

    public InstrumentDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            instrumentItem = (InstrumentItem) getArguments().getSerializable(ARG_INSTRUMENT_ITEM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_instrument_detail, container, false);
        setView(view);

        if (instrumentItem != null) {
            updateFragment(instrumentItem);
        }

        return view;
    }

    private void setView(View view) {
//        getActivity().setTitle();
        description = view.findViewById(R.id.tv_detail_instrument_title);
        mainImage = view.findViewById(R.id.iv_instrument_detail_first_image);
        secondaryImage = view.findViewById(R.id.iv_instrument_detail_second_image);
        primaryStarButton = view.findViewById(R.id.ib_instrument_detail_first_star_button);
        primaryPlayButton = view.findViewById(R.id.ib_instrument_detail_first_play_button);
        secondaryStarButton = view.findViewById(R.id.ib_instrument_detail_second_star_button);
        secondaryPlayButton = view.findViewById(R.id.ib_instrument_detail_second_play_button);

        setClickListeners();
    }

    private void setClickListeners() {
        primaryStarButton.setOnClickListener(this);
        primaryPlayButton.setOnClickListener(this);
        secondaryStarButton.setOnClickListener(this);
        secondaryPlayButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_instrument_detail_first_star_button:
            case R.id.ib_instrument_detail_second_star_button:
                MainUtils.showToast(getContext(), getString(R.string.toast_favorite));
                break;
            case R.id.ib_instrument_detail_first_play_button:
            case R.id.ib_instrument_detail_second_play_button:
                MainUtils.showToast(getContext(), getString(R.string.toast_play));
                break;
        }
    }

    public void updateFragment(InstrumentItem item) {
        description.setText(item.getDescription());
        mainImage.setImageResource(item.getMainInstrumentImage());
        secondaryImage.setImageResource(item.getSecondaryInstrumentImage());
    }
}
