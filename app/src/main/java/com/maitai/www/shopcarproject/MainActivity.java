package com.maitai.www.shopcarproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.maitai.www.shopcarproject.bean.MyProducts;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnDo;
    private Button btnAll;
    private Button btnNone;
    private Button btnOther;
    private RecyclerView mRv;
    private List<MyProducts> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        btnDo = (Button) findViewById(R.id.btn_do);
        btnAll = (Button) findViewById(R.id.btn_all);
        btnOther = (Button) findViewById(R.id.btn_other);
        btnNone = (Button) findViewById(R.id.btn_none);
        mRv = (RecyclerView) findViewById(R.id.recyclerView);
        //设置RecyclerView配置
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        mRv.setLayoutManager(manager);
        //数据源
        initData();
        //我就随便改改东西 试试下拉合并
        //Adapter

    }

    /**
     * 数据源
     */
    private void initData() {
        list = new ArrayList<>();
        MyProducts product = null;
        for (int i = 0; i < 50; i++) {
            product = new MyProducts(false,"三文治",(i+1),5);
            list.add(product);
        }
    }

    /**
     * 点击事件
     * @param view
     */
    public void myClick(View view) {

    }
}
