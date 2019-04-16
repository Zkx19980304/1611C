package weektest.baway.com.zhengkexin20190416;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import weektest.baway.com.mvc.LoginContract;
import weektest.baway.com.mvc.LoginPresenter;

public class MainActivity extends AppCompatActivity implements LoginContract.IoginView {

    private EditText edit_name;
    private EditText edit_pwd;
    private Button btn_login;
    private Button btn_register;
    private CheckBox check_pwd;

    private LoginPresenter loginPresenter;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;
    public static final String BaseLoginUrl="http://172.17.8.100/small/user/v1/login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginPresenter = new LoginPresenter();
        loginPresenter.attch(this);
        sharedPreferences = getSharedPreferences("mvp", MODE_PRIVATE);
        edit = sharedPreferences.edit();
        init();
    }

    private void init() {
        edit_name = findViewById(R.id.edit_name);
        edit_pwd = findViewById(R.id.edit_pwd);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_regsiter);
        check_pwd = findViewById(R.id.check_pwd);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public void getPreData(String data) {




    }
}
