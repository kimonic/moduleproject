package com.kimonic.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ScrollView scrollView;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_test_main);

        scrollView = findViewById(R.id.sv_act_test_main);
        button = findViewById(R.id.bt_act_test_main);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_act_test_main:
                scrollView.pageScroll(View.FOCUS_DOWN);
                break;
        }
    }
}
