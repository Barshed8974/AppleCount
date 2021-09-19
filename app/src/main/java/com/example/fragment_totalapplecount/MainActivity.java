package com.example.fragment_totalapplecount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements FragmentListener {
    FrameLayout frameLayout;
    FragmentA fragmentA=new FragmentA();
    FragmentB fragmentb=new FragmentB();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout=findViewById(R.id.frame);
        launchFragA();
    }

    private void launchFragA() {
        fragmentA.setFragmentListener(this);
        getSupportFragmentManager().beginTransaction().add(R.id.frame,fragmentA,"fragmentA").addToBackStack("fragmentA").commit();
    }

    @Override
    public void onFragmentDataPassed(Bundle bundle, String context) {
        if(context.equals("A"))
        {
            launchA(bundle);
        }
        else if(context.equals("B"))
        {
            launchB(bundle);
        }
    }

    private void launchA(Bundle bundle) {
        fragmentA.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(R.id.frame,fragmentA,"fragmentA").addToBackStack("fragmentA").commit();
    }

    private void launchB(Bundle bundle) {
        fragmentb.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(R.id.frame,fragmentb,"frag").addToBackStack("frag").commit();
    }
}