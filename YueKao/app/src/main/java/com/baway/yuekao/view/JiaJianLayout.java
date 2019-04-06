package com.baway.yuekao.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baway.yuekao.R;
import com.baway.yuekao.bean.ProductBean;

import java.util.List;

/**
 * @Author：dell
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/4 15:23
 * @Description：描述信息
 */
public class JiaJianLayout extends LinearLayout {
    TextView textView;
    Button btn_jia,btn_jian;
    int sum=0;
    public JiaJianLayout(Context context) {
        super(context);
    }

    public JiaJianLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view=View.inflate(context, R.layout.layout_jia,this);
        textView=view.findViewById(R.id.text_num);
        btn_jia=view.findViewById(R.id.btn_jia);
        btn_jian=view.findViewById(R.id.btn_jian);

        btn_jian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                /*sum = Integer.parseInt(textView.getText().toString());
                sum++;
                textView.setText(sum+"");*/
                /*sum=Integer.parseInt(textView.getText().toString());
                sum++;
                textView.setText(sum+"");*/
                sum=Integer.parseInt(textView.getText().toString());
                sum--;
                if(sum<=1){
                    sum=1;
                }
                textView.setText(sum+"");
            }
        });

        btn_jia.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                /*sum = Integer.parseInt(textView.getText().toString());
                sum--;
                if (sum<=1){
                    sum=1;
                }*/
                sum=Integer.parseInt(textView.getText().toString());
                sum++;
                textView.setText(sum+"");
            }
        });
    }

    public JiaJianLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
