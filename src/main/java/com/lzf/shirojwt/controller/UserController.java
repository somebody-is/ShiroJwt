package com.lzf.shirojwt.controller;

import com.lzf.shirojwt.model.BaseResponse;
import com.lzf.shirojwt.model.User;
import com.lzf.shirojwt.service.UserService;
import com.lzf.shirojwt.utils.JwtUtils;
import com.lzf.shirojwt.utils.SaltUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zongfang
 * @date 2022/4/19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register",produces = {"application/json;charset=UTF-8"})
    public BaseResponse<String> register(@RequestBody Map<String,String>request){
        User user = new User();
        String username =request.get("username");
        String password = request.get("password");
        String salt = SaltUtils.getSalt(8);
        user.setUsername(username);
        user.setSalt(salt);
        Md5Hash md5Hash = new Md5Hash(password,salt,507);
        user.setPassword(md5Hash.toHex());
        userService.save(user);
        return new BaseResponse<String>(200,"注册成功!", JwtUtils.sign(user.getId()));
    }

    @RequestMapping(value = "/login",produces = {"application/json;charset=UTF-8"})
    public BaseResponse<String> login(@RequestBody Map<String,String>request){
        String username = request.get("username");
        String password = request.get("password");
        User user = userService.findByUserName(username);
        Md5Hash md5Hash3 = new Md5Hash(password,user.getSalt(),507);
        if(md5Hash3.toHex().equals(user.getPassword())) {
            return new BaseResponse<>(200,"登陆成功！", JwtUtils.sign(user.getId()));
        }else{
            return new BaseResponse<>(403,"用户名或密码错误！");
        }
    }

    @RequestMapping(value = "/select",produces = {"application/json;charset=UTF-8"})
    @RequiresPermissions("user:*:*")
    public BaseResponse<String> select(){
        return new BaseResponse<>(200,"所有用户","hahaha");
    }

    @RequestMapping(value = "/userselect",produces = {"application/json;charset=UTF-8"})
    @RequiresPermissions("user:select:*")
    public BaseResponse<String> selectUser(){
        return new BaseResponse<>(200,"selectUser","hahaha");
    }



}
