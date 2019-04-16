package weektest.baway.com.mvc;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.VolleyError;

import java.util.HashMap;

import weektest.baway.com.volley.HttpVolley;

/**
 * 郑可心
 * Data:2019/4/1619:04
 * 描述
 */
public class LoginModel implements LoginContract.IloginModel{

    private HashMap<String, String> stringHashMap;
    private boolean wifiConnected;
    private Handler handler = new Handler();
    public static final String TAG = "LoginModel";

    @Override
    public void getRequest(final Context context, String url, String username, String pswd, final ModelCallBack modelCallBack) {

        //网略请求去掉
        stringHashMap = new HashMap<>();
        stringHashMap.put("phone",username);
        stringHashMap.put("pwd",pswd);
        wifiConnected = HttpVolley.getInstance().isNetWorkConnected(context);
        if (wifiConnected){
            HttpVolley.getInstance().VolleyHttpPost(url, stringHashMap, new HttpVolley.VolleyCallBack() {
                @Override
                public void OnSuccess(String data) {
                    modelCallBack.onSeccess(data);
                }

                @Override
                public void onFail(VolleyError error) {
                        modelCallBack.onFail(error);
                }
            });

        }else {
            //子线程
          new Thread(new Runnable() {
              @Override
              public void run() {

                  handler.post(new Runnable() {
                      @Override
                      public void run() {
                          Toast.makeText(context,"网络链接失败",Toast.LENGTH_SHORT).show();
                      }
                  });
              }
          }).start();
            Log.d(TAG,"getRequest: " + "网络连接失败");

        }
    }
}
