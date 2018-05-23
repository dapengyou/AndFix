package com.test.andfix.andfix;

import android.content.Context;

import com.alipay.euler.andfix.AndFixManager;
import com.alipay.euler.andfix.patch.PatchManager;
import com.test.andfix.util.Utils;

import java.io.IOException;

/**
 * Created by lady_zhou on 2018/5/23.
 */

public class AndFixPatchManager {
    private static AndFixPatchManager mInstance = null;

    private PatchManager mPatchManager = null;

    public static AndFixPatchManager getInstance() {
        if (mInstance == null) {
            synchronized (AndFixManager.class) {
                if (mInstance == null) {
                    mInstance = new AndFixPatchManager();
                }
            }
        }
        return mInstance;
    }

    //初始化AndFix方法
    public void initPatch(Context context) {
        mPatchManager = new PatchManager(context);
        mPatchManager.init(Utils.getVersionName(context));
        mPatchManager.loadPatch();
    }

    //加载我们的patch文件
    public void addPatch(String patch) {
        try {
            if (mPatchManager != null) {
                mPatchManager.addPatch(patch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
