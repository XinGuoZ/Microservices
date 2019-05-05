package cc.ant.user.controller;

import cc.ant.dataformat.Info;
import cc.ant.user.entity.User;
import cc.ant.user.services.UserService;
import cc.ant.user.utils.EncryptUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;


/**
 * @program: user_service
 * @description: 用户接口
 * @Author: XINGUOZ
 * @date: 2019-05-02 14:04
 */




@Controller
public class UserController {
    @Autowired
    UserService userService;
    /**
     * 用户查询.
     * @return
     */
    @RequestMapping("/userList")
    @RequiresPermissions("user:view")//权限管理;
    public String userInfo(){
        return "userList";
    }

    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("user:add")//权限管理;
    public String userInfoAdd(){
        return "userAdd";
    }

    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("user:del")//权限管理;
    public String userDel(){
        return "userDel";
    }

    @ResponseBody
    @RequestMapping("/userRegister")
    public Info rigester(User user){
        String[] strings = EncryptUtils.EncryptPassword(user.getPassword());
        user.setSalt(strings[0]);
        user.setPassword(strings[1]);
        user.setUid(1);
        Date date = new Date(new java.util.Date().getTime());
        user.setUPDATETIME(date);
        user.setUSERCREATETIME(date);

        User save = userService.save(user);
        Info info = new Info();
        info.setMsg("sucess");
        return info;
    }
}