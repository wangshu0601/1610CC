package com.baway.yuekao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.baway.yuekao.LoginActivity;
import com.baway.yuekao.R;
import com.baway.yuekao.view.WaterView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;

/**
 * @Author：dell
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/4 8:57
 * @Description：描述信息
 */
public class Fragment02 extends Fragment {
    ImageView imageView;
    String picUrl="http://p0.so.qhmsg.com/sdr/400__/t0161435906c2c50455.jpg";
    Button button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.layout_fragment02,null);
        imageView=view.findViewById(R.id.image_id);
        button=view.findViewById(R.id.btn_shu);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Glide.with(getActivity()).load(picUrl).apply(new RequestOptions().circleCrop()).into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),LoginActivity.class);
                startActivityForResult(intent,100);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
