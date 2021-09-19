package com.example.fragment_totalapplecount;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class FragmentB extends Fragment {
    private EditText et;
    private String st,st1;
    private MainActivity mainActivity;
    private FragmentListener mFragmentListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity=(MainActivity) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et = view.findViewById(R.id.et2);
        Bundle bundle = getArguments();
        if (bundle != null)
            st = bundle.getString("Name");
        et.setText(st);
    }

    @Override
    public void onPause() {
        super.onPause();
            Log.d("Ali","Pause");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Ali","Stop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Bundle bundle=new Bundle();
        bundle.putString("key", et.getText().toString());
        Log.d("Ali","Destroy");
    }
}