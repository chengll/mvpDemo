package test.dmdfchina.com.mvpdemo;

/**
 * Created by mkt on 2018/1/15.
 * 定义activty中UI需要操作的方法
 */

public interface IUserView {
    /*获取用户名*/
    String getUserName();
    /*获取密码*/
    String getPwd();

    /*显示登录时候的对话框*/
    void showLoading();

    /*隐藏对话框*/
    void hideLoading();

    /*清空*/
    void clearUserName();
    void clearPwd();

    /*登录成功后将数据传递给Activity*/
    void toActivity(UserEntity userEntity);

    /*登录失败后的操作*/

    void failedOp();
}
