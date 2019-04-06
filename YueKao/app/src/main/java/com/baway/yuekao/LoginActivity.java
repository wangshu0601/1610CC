package com.baway.yuekao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.baway.yuekao.contract.ContractInterface;
import com.baway.yuekao.presenter.MyPresenter;

public class LoginActivity extends AppCompatActivity implements ContractInterface.LoViewInterface {

    Button btn_login,btn_regist;
    EditText edit_phone,edit_pwd;
    TextView back;
    ContractInterface.PresenterInterface presenterInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenterInterface=new MyPresenter<>(this);
        btn_login=findViewById(R.id.btn_login);
        btn_regist=findViewById(R.id.btn_regist);
        edit_phone=findViewById(R.id.edit_phone);
        edit_pwd=findViewById(R.id.edit_pwd);
        back=findViewById(R.id.back);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = edit_phone.getText().toString();
                String pwd = edit_pwd.getText().toString();
                presenterInterface.toLogin(phone,pwd);
            }
        });
        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegistActivity.class);
                startActivityForResult(intent,200);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    public void showLogin(Object o) {
        Toast.makeText(LoginActivity.this,(String)o,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showRegist(Object o) {

    }
}
