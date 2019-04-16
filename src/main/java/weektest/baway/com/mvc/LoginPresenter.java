package weektest.baway.com.mvc;

import android.content.Context;

import com.android.volley.VolleyError;

import weektest.baway.com.zhengkexin20190416.MainActivity;

/**
 * 郑可心
 * Data:2019/4/1619:04
 * 描述
 */
public class LoginPresenter implements LoginContract.IloginPresenter{

    MainActivity mainActivity;
    private LoginModel loginModel;
    private LoginContract.IoginView ioginView;

    @Override
    public void attch(MainActivity mainActivity) {
            this.mainActivity = mainActivity;
            loginModel = new LoginModel();
    }

    @Override
    public void detch() {
            if (ioginView!=null){
                ioginView = null;
            }
            if (loginModel!= null){
                loginModel=null;
            }
            System.gc();
    }

    @Override
    public void login(Context context, String url, String username, String pwd) {

        loginModel.getRequest(context, url, username, pwd, new LoginContract.IloginModel.ModelCallBack() {
            @Override
            public void onSeccess(String data) {
                        ioginView.getPreData(data);
            }

            @Override
            public void onFail(VolleyError error) {

            }
        });


    }
}
