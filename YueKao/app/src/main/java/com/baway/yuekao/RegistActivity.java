package com.baway.yuekao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.baway.yuekao.contract.ContractInterface;
import com.baway.yuekao.presenter.MyPresenter;

public class RegistActivity extends AppCompatActivity implements ContractInterface.LoViewInterface {

    Button btn_login,btn_regist;
    TextView back_id;
    EditText edit_phone,edit_pwd;
    ContractInterface.PresenterInterface presenterInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        btn_regist=findViewById(R.id.regist_id1);
        btn_login=findViewById(R.id.login_id1);
        edit_phone=findViewById(R.id.edit_phone1);
        edit_pwd=findViewById(R.id.edit_pwd1);
        back_id=findViewById(R.id.back_id);
        presenterInterface=new MyPresenter<>(this);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pwd = edit_pwd.getText().toString();
                String phone = edit_phone.getText().toString();
                presenterInterface.toLogin(phone,pwd);
            }
        });
        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pwd = edit_pwd.getText().toString();
                String phone = edit_phone.getText().toString();
                presenterInterface.toRegist(phone,pwd);
            }
        });
        back_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void showLogin(Object o) {
        Toast.makeText(RegistActivity.this,(String)o,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showRegist(Object o) {
        Toast.makeText(RegistActivity.this,(String)o,Toast.LENGTH_SHORT).show();
    }
}
