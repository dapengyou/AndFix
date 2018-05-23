package com.test.andfix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.test.andfix.andfix.AndFixPatchManager;
import com.test.andfix.util.Utils;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    public static final String FILE_END = ".apatch";
    private String mFileDir;//存储文件路径

    @BindView(R.id.bt_getBug)
    Button mBtGetBug;
    @BindView(R.id.bt_fixBug)
    Button mBtFixBug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initDir();
    }

    /**
     * 初始化文件
     */
    private void initDir() {
        //设置文件路径
        mFileDir = getExternalCacheDir().getAbsolutePath() + "/apatch";
        //创建文件夹
        File file = new File(mFileDir);

        //当文件为null或者不存在时 创建文件
        if (file == null || file.exists()) {
            file.mkdir();
        }
    }


    @OnClick({R.id.bt_fixBug, R.id.bt_getBug})
    public void onClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_getBug:
                creatBug();
                break;
            case R.id.bt_fixBug:
                fixBug();
                break;
        }
    }

    /**
     * 创建bug
     */
    private void creatBug() {
        Utils.printLog();
    }

    /**
     * 修复bug
     */
    private void fixBug() {
        AndFixPatchManager.getInstance().addPatch(getPatchName());
    }

    /**
     * 构建patch文件名
     *
     * @return
     */
    private String getPatchName() {
        return mFileDir.concat("test").concat(FILE_END);
    }


}
