package test.dmdfchina.com.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IUserView, View.OnClickListener {

    private EditText userName_ed;
    private EditText userPwd_ed;
    private Button userLogin;
    private Button clearContent;
    private UserPresenter userPresenter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        userName_ed = (EditText) findViewById(R.id.userName_ed);
        userPwd_ed = (EditText) findViewById(R.id.userPwd_ed);
        userLogin = (Button) findViewById(R.id.userLogin);
        clearContent = (Button) findViewById(R.id.clearContent);
        userPresenter = new UserPresenter(this);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        userLogin.setOnClickListener(this);
        clearContent.setOnClickListener(this);
    }

    @Override
    public String getUserName() {
        return userName_ed.getText().toString();
    }

    @Override
    public String getPwd() {
        return userPwd_ed.getText().toString();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void clearUserName() {
        userName_ed.setText("");
    }

    @Override
    public void clearPwd() {
        userPwd_ed.setText("");
    }

    @Override
    public void toActivity(UserEntity userEntity) {
        Toast.makeText(MainActivity.this,"传过来的值是："+userEntity.getUserName()+" 密码："+userEntity.getPassword(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failedOp() {
        Toast.makeText(MainActivity.this,"用户登录失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.userLogin:
                userPresenter.login();
                break;
            case R.id.clearContent:
                userPresenter.clearData();
                break;
        }
    }
}
