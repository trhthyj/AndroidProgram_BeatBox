package com.mi.www.beatbox;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BeatBoxActivity extends SingleFragmnetActivity {

    @Override
    public Fragment newInstance() {
        return BeatBoxFragment.newInstance();
    }
}
