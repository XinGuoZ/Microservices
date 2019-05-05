package cc.ant.user.services;

import cc.ant.user.entity.LoginResult;

public interface LoginService {
    LoginResult login(String username, String password);
    void logout();
}