package com.mi.www.beatbox.beatbox;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
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
    private static final int MAX_SOUNDS = 5;
    private AssetManager mAssetManager;
    private List<Sound> mSounds = new ArrayList<>();
    private SoundPool mSoundPool;

    public BeatBox(Context context) {
        mAssetManager = context.getAssets();
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC, 0);
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
                load(sound);//载入全部音频文件
                mSounds.add(sound);
            }
            Log.e(TAG, soundNames.length+"");
        } catch (IOException e) {
            Log.e(TAG, "",e);
        }
    }

    private void load(Sound sound) throws IOException{
        AssetFileDescriptor afd = mAssetManager.openFd(sound.getAssetPath());
        int soundId = mSoundPool.load(afd, 1);
        sound.setSoundId(soundId);
    }

    /**
     * 播放音频
     * @param sound
     */
    public void play(Sound sound){
        Integer soundId = sound.getSoundId();
        if(soundId == null){
            return;
        }
        mSoundPool.play(soundId, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    /**
     * 播放结束后释放音频
     */
    public void release(){
        mSoundPool.release();
    }



    public List<Sound> getSounds() {
        return mSounds;
    }
}
