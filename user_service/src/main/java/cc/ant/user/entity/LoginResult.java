package cc.ant.user.entity;

/**
 * @program: user_service
 * @description: 登入结果
 * @Author: XINGUOZ
 * @date: 2019-05-03 20:30
 */
public class LoginResult {
    private boolean isLogin = false;
    private String result;

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}