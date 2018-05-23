package com.test.andfix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bt_getBug)
    Button mBtGetBug;
    @BindView(R.id.bt_fixBug)
    Button mBtFixBug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_fixBug, R.id.bt_getBug})
    public void onClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_getBug:

                break;
            case R.id.bt_fixBug:

                break;
        }
    }
}
