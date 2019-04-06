package com.baway.yuekao.contract;

/**
 * @Author：dell
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/4 9:17
 * @Description：描述信息
 */
public interface ContractInterface {
    //view
    public interface ViewInterface{
        public void showProduct(Object o);

    }
    //view
    public interface LoViewInterface{
        //登录注册
        public void showLogin(Object o);
        public void showRegist(Object o);
    }
    //pre
    public interface PresenterInterface{
        public void toProduct();

        //登录注册
        public void toLogin(String phone,String pwd);
        public void toRegist(String phone,String pwd);
    }
}
