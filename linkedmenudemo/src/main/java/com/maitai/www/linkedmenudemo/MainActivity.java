package com.maitai.www.linkedmenudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView lvFirMenu;
    private ListView lvSecMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        lvFirMenu = (ListView) findViewById(R.id.lv_menu);
        lvSecMenu = ((ListView) findViewById(R.id.lv_sec_menu));
    }
}
