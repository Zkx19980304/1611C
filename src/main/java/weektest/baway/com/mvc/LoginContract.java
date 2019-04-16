package weektest.baway.com.mvc;

import android.content.Context;

import com.android.volley.VolleyError;

import weektest.baway.com.zhengkexin20190416.MainActivity;

/**
 * 郑可心
 * Data:2019/4/1619:04
 * 描述
 */
public interface LoginContract {

    //IView
    interface IoginView{
        void  getPreData(String data);
    }

    //Imodel
    interface IloginModel{
        void  getRequest(Context context,String url,String username,String pswd,ModelCallBack modelCallBack);

        interface ModelCallBack{
            void onSeccess(String data);
            void onFail(VolleyError error);
        }
    }


    //IPresenter
    interface IloginPresenter{
        void attch(MainActivity mainActivity);
        void detch();
        void login(Context context,String url,String username,String pwd);
    }



}
