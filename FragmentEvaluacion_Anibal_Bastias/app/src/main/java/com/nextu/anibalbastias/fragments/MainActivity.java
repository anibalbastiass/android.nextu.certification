package com.nextu.anibalbastias.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.nextu.anibalbastias.fragments.detail.InstrumentDetailFragment;
import com.nextu.anibalbastias.fragments.list.InstrumentListFragment;
import com.nextu.anibalbastias.fragments.list.interfaces.OnListFragmentInteractionListener;
import com.nextu.anibalbastias.fragments.list.model.InstrumentItem;
import com.nextu.anibalbastias.fragments.util.MainUtils;

import static com.nextu.anibalbastias.fragments.util.MainUtils.pushRootFragment;

public class MainActivity extends AppCompatActivity implements OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnListFragmentInteractionListener mListener = this;

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            InstrumentListFragment listFragment = InstrumentListFragment.newInstance();
            listFragment.setListener(mListener);
            pushRootFragment(getSupportFragmentManager(), R.id.fragment_container, listFragment);
        }
    }

    @Override
    public void onListFragmentInteraction(InstrumentItem item) {
        InstrumentDetailFragment detailsFragment = (InstrumentDetailFragment)
                getSupportFragmentManager().findFragmentById(R.id.movie_details_fragment);

        if (detailsFragment != null) {
            detailsFragment.updateFragment(item);
        } else {
            InstrumentDetailFragment detailFragment = new InstrumentDetailFragment();
            Bundle args = new Bundle();
            args.putSerializable(InstrumentDetailFragment.ARG_INSTRUMENT_ITEM, item);
            detailFragment.setArguments(args);

            MainUtils.pushFragment(getSupportFragmentManager(), R.id.fragment_container, detailFragment);
        }
    }
}
