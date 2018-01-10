package com.mi.www.beatbox;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.mi.www.beatbox.beatbox.BeatBox;

/**
 * Created by wm on 2017/12/22.
 */

public class SoundViewModel extends BaseObservable{
   /* 使用BaseObservable类需要三个步骤：
    (1) 在视图模型里继承BaseObservable类；
    (2) 使用@Bindable注解视图模型里可绑定的属性；
    (3) 每次可绑定的属性值改变时，就调用notifyChange()方法或notifyPropertyChanged(int)方法。*/

    private Sound mSound;
    private BeatBox mBeatBox;

    public SoundViewModel(BeatBox beatBox) {
        mBeatBox = beatBox;
    }

    public Sound getSound() {
        return mSound;
    }

    public void setSound(Sound sound) {
        mSound = sound;
        notifyChange();//每次可绑定的属性值改变时，就调用notifyChange()方法
    }

    @Bindable
    public String getTitle() {
        return mSound.getName();
    }

    public void onButtonClicked() {
        mBeatBox.play(mSound);
    }
}
