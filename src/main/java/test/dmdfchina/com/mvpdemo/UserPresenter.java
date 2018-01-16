package test.dmdfchina.com.mvpdemo;

import android.os.Handler;

/**
 * Created by mkt on 2018/1/15.
 * presenter 主要负责更新UI和数据处理后的回调问题
 */

public class UserPresenter {
    private IUserLogMethod userLogMethod;
    private IUserView userView;
    private Handler mHandler=new Handler();

    public UserPresenter(IUserView userView){
        this.userView=userView;
        userLogMethod=new IUserLoginImp();
    }

    /*封装方法处理登录成功后ui的更新*/

    public void login(){
        //登录时显示对话框
        userView.showLoading();
        userLogMethod.userLogin(userView.getUserName(), userView.getPwd(), new OnLoginListenr() {
            @Override
            public void onSucce(final UserEntity userEntity) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        //登录成功后将数据传递给activity
                        userView.toActivity(userEntity);

                        //隐藏对话框
                        userView.hideLoading();
                    }
                });

            }

            @Override
            public void onFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userView.failedOp();
                        userView.hideLoading();
                    }
                });
            }
        });
    }
    /*清空数据的操作*/
    public void clearData(){
        userView.clearUserName();
        userView.clearPwd();
    }

}
