package com.baway.yuekao.presenter;

import com.baway.yuekao.contract.ContractInterface;
import com.baway.yuekao.model.MyModel;

/**
 * @Author：dell
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/4 9:18
 * @Description：描述信息
 */
public class MyPresenter<ViewIn> implements ContractInterface.PresenterInterface {
    MyModel myModel;
    ViewIn viewin;

    public MyPresenter(ViewIn viewin) {
        this.viewin = viewin;
        myModel=new MyModel();
    }

    @Override
    public void toProduct() {
        myModel.setMyCallBack(new MyModel.MyCallBack() {
            @Override
            public void success(Object o) {
                ContractInterface.ViewInterface viewInterface= (ContractInterface.ViewInterface) viewin;
                viewInterface.showProduct(o);
            }
        });
        myModel.getRequest();
    }

    @Override
    public void toLogin(String phone,String pwd) {
        myModel.setMyCallBack(new MyModel.MyCallBack() {
            @Override
            public void success(Object o) {
                ContractInterface.LoViewInterface viewInterface= (ContractInterface.LoViewInterface) viewin;
                viewInterface.showLogin(o);
            }
        });
        myModel.postRequest(phone,pwd,"http://172.17.8.100/small/user/v1/login");
    }

    @Override
    public void toRegist(String phone,String pwd) {
        myModel.setMyCallBack(new MyModel.MyCallBack() {
            @Override
            public void success(Object o) {
                ContractInterface.LoViewInterface viewInterface= (ContractInterface.LoViewInterface) viewin;
                viewInterface.showRegist(o);
            }
        });
        myModel.postRequest(phone,pwd,"http://172.17.8.100/small/user/v1/register");
    }
}
