package com.baway.yuekao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.baway.yuekao.R;
import com.baway.yuekao.bean.ProductBean;
import com.baway.yuekao.fragment.Fragment01;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @Author：dell
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/4 9:41
 * @Description：描述信息
 */
public class ProAdapter extends RecyclerView.Adapter<ProAdapter.Holder>{
    List<ProductBean.DataBean.ListBean> list;
    Context context;
    Fragment01 fragment01;

    public ProAdapter(Fragment01 fragment01) {
        this.fragment01 = fragment01;
    }

    public ProAdapter(List<ProductBean.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.layout_item2,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {
        boolean ischeck=list.get(position).itemSelect;
        holder.checkBox.setChecked(ischeck);
        holder.textView1.setText(list.get(position).getTitle());
        holder.textView2.setText(list.get(position).getPrice()+"");
        Glide.with(context).load(list.get(position).getImages()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{

        CheckBox checkBox;
        ImageView imageView;
        TextView textView1,textView2;
        public Holder(View itemView) {
            super(itemView);
            checkBox=itemView.findViewById(R.id.v2_check);
            imageView=itemView.findViewById(R.id.v2_image);
            textView1=itemView.findViewById(R.id.v2_text1);
            textView2=itemView.findViewById(R.id.v2_text2);
        }
    }
}
