package com.baway.yuekao.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.baway.yuekao.R;
import com.baway.yuekao.adapter.MyAdapter;
import com.baway.yuekao.adapter.ProAdapter;
import com.baway.yuekao.bean.ProductBean;
import com.baway.yuekao.contract.ContractInterface;
import com.baway.yuekao.presenter.MyPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：dell
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/4 8:57
 * @Description：描述信息
 */
public class Fragment01 extends Fragment implements ContractInterface.ViewInterface {
    ContractInterface.PresenterInterface presenterInterface;
    List<ProductBean.DataBean> list=new ArrayList<>();
    CheckBox checkBox;
    RecyclerView recyclerView;
    MyAdapter adapter;
    public TextView textView;
    ProAdapter adapter1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.layout_fragment01,null);
        checkBox=view.findViewById(R.id.check_id);
        recyclerView=view.findViewById(R.id.recycler);
        textView=view.findViewById(R.id.title_sum);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenterInterface=new MyPresenter<>(this);
        adapter1=new ProAdapter(Fragment01.this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter=new MyAdapter(list,getActivity(),Fragment01.this);
        recyclerView.setAdapter(adapter);
        presenterInterface.toProduct();
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()){
                    selectAll(true);
                }else{
                    selectAll(false);
                    textView.setText("0.00");
                }
                adapter.notifyDataSetChanged();
            }
        });
    }
    //全选 全不选
    public void selectAll(boolean ischeck){
        for (int i = 0; i < list.size(); i++) {
            list.get(i).isSelect=ischeck;
            for (int j = 0; j < list.get(i).getList().size(); j++) {
                list.get(i).getList().get(j).itemSelect=ischeck;
            }
        }
        total();
        adapter.notifyDataSetChanged();
    }
    //商家的全选  全不选
    public  void ShangSelect(int i,boolean ischeck){
        list.get(i).isSelect=ischeck;
        for (int j = 0; j < list.get(i).getList().size(); j++) {
            list.get(i).getList().get(j).itemSelect=ischeck;
        }
        totall(i);
        adapter.notifyDataSetChanged();
    }

   /* public void itemtotal(){
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getList().size(); j++) {
                list.get(i).getList().get(j).ge
            }
        }
    }*/
    public void totall(int i){
        int ssum=0;
        for (int j = 0; j < list.get(i).getList().size(); j++) {
            ssum+=list.get(i).getList().get(j).getPrice();
        }
        textView.setText(ssum+"");
    }
    public void total() {
        int sum_pic=0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getList().size(); j++) {
                 sum_pic+=list.get(i).getList().get(j).getPrice();
            }
        }
        textView.setText(sum_pic+"");
    }


    @Override
    public void showProduct(Object o) {
        ProductBean productBean= (ProductBean) o;
        list.addAll(productBean.getData());
        adapter.notifyDataSetChanged();
    }
}
