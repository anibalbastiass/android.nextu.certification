package com.nextu.anibalbastias.fragments.list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nextu.anibalbastias.fragments.R;
import com.nextu.anibalbastias.fragments.list.interfaces.OnListFragmentInteractionListener;
import com.nextu.anibalbastias.fragments.list.model.DummyContent;


public class InstrumentListFragment extends Fragment {

    private DummyContent dummyContent;
    private OnListFragmentInteractionListener mListener;

    public InstrumentListFragment() {
    }

    public static InstrumentListFragment newInstance() {
        InstrumentListFragment fragment = new InstrumentListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dummyContent = new DummyContent(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_instrument_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            InstrumentListRecyclerViewAdapter adapter =
                    new InstrumentListRecyclerViewAdapter(dummyContent.getInstruments(), mListener);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void setListener(OnListFragmentInteractionListener mListener) {
        this.mListener = mListener;
    }
}
