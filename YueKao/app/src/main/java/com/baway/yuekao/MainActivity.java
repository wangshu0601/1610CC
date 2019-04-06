package com.baway.yuekao;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baway.yuekao.adapter.FragmentAdapter;
import com.baway.yuekao.fragment.Fragment01;
import com.baway.yuekao.fragment.Fragment02;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    List<Fragment> list=new ArrayList<>();
    String[] titles={"首页","我的"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.view_pager);
        tabLayout=findViewById(R.id.tab_layout);
        list.add(new Fragment01());
        list.add(new Fragment02());
        //创建适配器
        FragmentAdapter adapter=new FragmentAdapter(getSupportFragmentManager(),list,titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
