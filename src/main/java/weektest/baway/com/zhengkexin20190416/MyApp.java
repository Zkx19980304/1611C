package weektest.baway.com.zhengkexin20190416;

import android.app.Application;
import android.content.Context;

/**
 * 郑可心
 * Data:2019/4/1619:42
 * 描述
 */
public class MyApp extends Application {

    public static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        this.context = context;
    }
}
