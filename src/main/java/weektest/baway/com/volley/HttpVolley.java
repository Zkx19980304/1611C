package weektest.baway.com.volley;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

import weektest.baway.com.zhengkexin20190416.MyApp;

/**
 * 郑可心
 * Data:2019/4/1618:55
 * 描述
 */
public class HttpVolley {

    private static HttpVolley httpVolley;

    //判断网络
    public boolean isNetWorkConnected(Context context){
        if (context != null){
            ConnectivityManager mConnectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
            final NetworkInfo activeNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null){
                return activeNetworkInfo.isAvailable();
            }


        }
        return false;
    }
    //懒汉模式
    public static synchronized HttpVolley getInstance(){
        if (httpVolley == null){
            httpVolley = new HttpVolley();
        }

        return httpVolley;
    }
    //get请求
    public void VolleyHttpGet(String url,final VolleyCallBack callBack){
        final StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                    callBack.OnSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                    callBack.onFail(error);
            }
        });
        //设置请求的TAG的标签,可以在全局请求队列中的通过yag标签进行请求的查找
        stringRequest.setTag("testPost");


    }
    public void VolleyHttpPost(String url, final Map<String ,String> map,final VolleyCallBack callBack){

        final StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.OnSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onFail(error);
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }


        };
        stringRequest.setTag("testPost");



    }




    public interface VolleyCallBack{
        void OnSuccess(String response);
        void onFail(VolleyError error);
    }
}
