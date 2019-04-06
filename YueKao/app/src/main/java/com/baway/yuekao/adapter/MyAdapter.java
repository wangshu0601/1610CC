package com.baway.yuekao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.baway.yuekao.R;
import com.baway.yuekao.bean.ProductBean;
import com.baway.yuekao.fragment.Fragment01;

import java.util.List;

/**
 * @Author：dell
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/4 9:28
 * @Description：描述信息
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder>{
    List<ProductBean.DataBean> list;
    Context context;
    ProAdapter adapter;
    Fragment01 fragment01;
    public MyAdapter(List<ProductBean.DataBean> list, Context context,Fragment01 fragment01) {
        this.list = list;
        this.context = context;
        this.fragment01=fragment01;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.layout_item1,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int position) {
        final boolean ischeck=list.get(position).isSelect;
        holder.checkBox.setChecked(ischeck);
        holder.textView.setText(list.get(position).getSellerName());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        holder.recyclerView.setLayoutManager(linearLayoutManager);
        adapter=new ProAdapter(list.get(position).getList(),context);
        holder.recyclerView.setAdapter(adapter);
        //商家的全选  全不选
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment01.ShangSelect(position,holder.checkBox.isChecked());
                if(holder.checkBox.isChecked()){
                    fragment01.totall(position);
                }else{
                    fragment01.textView.setText("0.00");
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{

        CheckBox checkBox;
        TextView textView;
        RecyclerView recyclerView;
        public Holder(View itemView) {
            super(itemView);
            checkBox=itemView.findViewById(R.id.v1_check);
            textView=itemView.findViewById(R.id.v1_text);
            recyclerView=itemView.findViewById(R.id.recycler_id);
        }
    }
}
