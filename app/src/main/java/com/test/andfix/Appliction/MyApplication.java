package com.test.andfix.Appliction;

import android.app.Application;

import com.test.andfix.andfix.AndFixPatchManager;

/**
 * Created by lady_zhou on 2018/5/23.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //初始化AndFix
        initAndFix();
    }

    private void initAndFix() {
        AndFixPatchManager.getInstance().initPatch(this);
    }
}
