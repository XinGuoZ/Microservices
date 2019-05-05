package cc.ant.user.controller;

import cc.ant.user.entity.LoginResult;
import cc.ant.user.services.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @program: user_service
 * @description: 用户页面权限
 * @Author: XINGUOZ
 * @date: 2019-05-03 21:18
 */
@Controller
public class HomeController {
    @Resource
    private LoginService loginService;

    @RequestMapping({"/","/index"})
    public String index(){
        return"/index";
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "/user/403";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLogin(Map<String, Object> map,HttpServletRequest request)
    {
        loginService.logout();
        return "/user/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map login(Map<String, Object> map, HttpServletRequest request) throws Exception{
        System.out.println("login()");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        LoginResult loginResult = loginService.login(userName,password);
        if(loginResult.isLogin())
        {
            return null;
        }
        else {
            map.put("msg",loginResult.getResult());
            map.put("userName",userName);
            return map;
        }
    }

    @RequestMapping("/logout")
    public String logOut(HttpSession session) {
        loginService.logout();
        return "user/login";
    }
}