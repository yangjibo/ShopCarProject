package com.maitai.www.shopcarproject.bean;

/**
 * Created by YangBo on 2017/3/21.
 */

public class MyProducts {
    private String name;
    private int num;
    private int prices;
    private boolean isChecked;

    public MyProducts(boolean isChecked, String name, int num, int prices) {
        this.isChecked = isChecked;
        this.name = name;
        this.num = num;
        this.prices = prices;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPrices() {
        return prices;
    }

    public void setPrices(int prices) {
        this.prices = prices;
    }
}
