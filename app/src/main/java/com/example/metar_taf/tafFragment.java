package com.example.metar_taf;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class tafFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle SavedInstance){
        return inflater.inflate(R.layout.fragment_taf,container,false);
    }
}
