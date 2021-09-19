package com.example.fragment_totalapplecount;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FragmentA extends Fragment {

    private FragmentListener mFragmentListener;
    private EditText et;
    private TextView tv;
    private Button btn;
    String st;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initview(view);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putString("Name", et.getText().toString());
                mFragmentListener.onFragmentDataPassed(bundle, "B");
            }
        });
        Bundle bundle1=getArguments();
        if(bundle1!=null) {
            st = bundle1.getString("key");
            tv.setText(st);
        }
        else
            tv.setText("Null");
    }


    private void initview(View view) {
        et=view.findViewById(R.id.et1);
        tv=view.findViewById(R.id.tv1);
        btn=view.findViewById(R.id.btn1);
    }

    public void setFragmentListener(FragmentListener fragmentListener) {
        mFragmentListener = fragmentListener;
    }
}