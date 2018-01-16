package test.dmdfchina.com.mvpdemo;

import android.os.SystemClock;

/**
 * Created by mkt on 2018/1/15.
 */

public class IUserLoginImp implements IUserLogMethod {
    @Override
    public void userLogin(final String userName, final String password, final OnLoginListenr onLoginListenr) {
        /*通过线程来模仿用户登录*/
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(3000);
                if ("cll".equals(userName) && "123".equals(password)){
                    UserEntity userEntity=new UserEntity();
                    userEntity.setUserName(userName);
                    userEntity.setPassword(password);
                    onLoginListenr.onSucce(userEntity);
                }else {
                    onLoginListenr.onFailed();
                }
            }
        }).start();
    }
}
