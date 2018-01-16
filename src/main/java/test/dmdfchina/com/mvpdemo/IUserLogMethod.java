package test.dmdfchina.com.mvpdemo;

/**
 * Created by mkt on 2018/1/15.
 */

public interface IUserLogMethod {
    void userLogin(String userName,String password,OnLoginListenr onLoginListenr);
}
