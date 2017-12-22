package com.mi.www.beatbox.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.mi.www.beatbox.Sound;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wm on 2017/12/22.
 */

public class BeatBox {
    private static final String TAG = "BeatBox";
    private static final String SOUNDS_FOLDER = "sample_sounds";
    private AssetManager mAssetManager;
    private List<Sound> mSounds = new ArrayList<>();

    public BeatBox(Context context) {
        mAssetManager = context.getAssets();
        loadSounds();
    }

    private void loadSounds() {
        String[] soundNames;
        try {
            //AssetManager.list(String)方法能列出指定目录下的所有文件名
            soundNames = mAssetManager.list(SOUNDS_FOLDER);
            for (String fileName : soundNames){
                String assetPath = SOUNDS_FOLDER + "/" + fileName;
                Sound sound = new Sound(assetPath);
                mSounds.add(sound);
            }
            Log.e(TAG, soundNames.length+"");
        } catch (IOException e) {
            Log.e(TAG, "",e);
        }
    }

    public List<Sound> getSounds() {
        return mSounds;
    }
}
