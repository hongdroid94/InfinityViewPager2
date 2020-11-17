package com.hongdroid.infinityviewpager.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hongdroid.infinityviewpager.R;

public class Frag1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false );

        setInit(view);

        return view;

    }

    private void setInit(View _view) {
        TextView textView = _view.findViewById(R.id.textView);
    }
}
