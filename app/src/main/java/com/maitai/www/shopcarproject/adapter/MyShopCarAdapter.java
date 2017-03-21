package com.maitai.www.shopcarproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.maitai.www.shopcarproject.R;
import com.maitai.www.shopcarproject.bean.MyProducts;

import java.util.List;

/**
 * Created by YangBo on 2017/3/21.
 */

public class MyShopCarAdapter extends RecyclerView.Adapter<MyShopCarAdapter.MyViewHolder> {

    private List<MyProducts> data;
    private Context context;
    private LayoutInflater inflater;
    //单选框是否展示
    public boolean isCbShow = false;

    public MyShopCarAdapter(Context context, List<MyProducts> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //获得布局对象
        View view = inflater.inflate(R.layout.item_layout, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        //设置单选框不显示
        if(isCbShow == false){
            holder.cbSelected.setVisibility(View.GONE);
        }else{
            holder.cbSelected.setVisibility(View.VISIBLE);
        }
        //商品信息
        holder.tvShow.setText("商品:"+data.get(position).getName()+"\n单价:"+data.get(position).getPrices());
        //设置选择事件
        if(data.get(position).isChecked() == true){
            holder.cbSelected.setChecked(true);
        }else{
            holder.cbSelected.setChecked(false);
        }
        //设置单选狂点击事件
        holder.cbSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(data.get(position).isChecked() == false){
                    data.get(position).setChecked(true);
                }else{
                    data.get(position).setChecked(false);
                }
            }
        });
        Log.i("Mr.Yang", "onBindViewHolder: "+data.get(position).isChecked());
    }

    @Override
    public int getItemCount() {
        return data.size() == 0?0:data.size();
    }

    /**
     * 控件内部类
     */
    class MyViewHolder extends RecyclerView.ViewHolder{


        private  TextView tvShow;
        private  CheckBox cbSelected;

        public MyViewHolder(View itemView) {
            super(itemView);
            cbSelected = ((CheckBox) itemView.findViewById(R.id.cb_checked));
            tvShow = ((TextView) itemView.findViewById(R.id.tv_show));
        }
    }
}
