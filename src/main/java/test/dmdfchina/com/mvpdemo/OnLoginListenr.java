package test.dmdfchina.com.mvpdemo;

/**
 * Created by mkt on 2018/1/15.
 * 监听登录的状态
 */

public interface OnLoginListenr {
    void onSucce(UserEntity userEntity);
    void onFailed();
}
