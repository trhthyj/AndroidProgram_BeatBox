package com.mi.www.beatbox;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class SingleFragmnetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragmnet);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fl_fragment_container);
        if(fragment == null){
            fragment = newInstance();
            fragmentManager.beginTransaction()
                    .add(R.id.fl_fragment_container, fragment)
                    .commit();
        }
    }

    public abstract Fragment newInstance();
}
