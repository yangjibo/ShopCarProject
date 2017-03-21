package com.maitai.www.shopcarproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.maitai.www.shopcarproject.adapter.MyShopCarAdapter;
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
    private MyShopCarAdapter mAdapter;

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
        mAdapter = new MyShopCarAdapter(MainActivity.this,list);
        mRv.setAdapter(mAdapter);
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
        switch (view.getId()) {
            case R.id.btn_do:
                //编辑
                btnDoSomthing();
                break;
            case R.id.btn_all:
                //全选
                btnSelectAll();
                break;
            case R.id.btn_other:
                //反选
                btnCheckOther();
                break;
            case R.id.btn_none:
                //全部取消
                btnDeletAll();
                break;
        }
        mAdapter.notifyDataSetChanged();
    }

    private void btnCheckOther() {
        if(mAdapter.isCbShow == true){
            for (MyProducts p: list) {
                if(p.isChecked() == true){
                    p.setChecked(false);
                }else{
                    p.setChecked(true);
                }
            }
        }else{
            Toast.makeText(MainActivity.this, "打开编辑", Toast.LENGTH_SHORT).show();
        }
    }

    private void btnDeletAll() {
        if(mAdapter.isCbShow == true){
            for (MyProducts p: list) {
                p.setChecked(false);
            }
        }else{
            Toast.makeText(MainActivity.this, "打开编辑", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 全选
     */
    private void btnSelectAll() {
        if(mAdapter.isCbShow == true){
            for (MyProducts p: list) {
                p.setChecked(true);
            }
        }else{
            Toast.makeText(MainActivity.this, "打开编辑", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 编辑
     */
    private void btnDoSomthing() {
        if (mAdapter.isCbShow == false) {
            btnDo.setText("完成");
            mAdapter.isCbShow = true;
        }else{
            btnDo.setText("编辑");
            mAdapter.isCbShow = false;
        }
    }
}
