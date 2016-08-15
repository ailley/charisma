package com.w3cmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/8/13.
 */
@Controller
public class UserController {

    /**
     * 登陆PC页面
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "login")
    public String loginForPC(String userName, String password,
                             HttpServletRequest request, HttpServletResponse response,
                             Model model) {
        // 判断已经登录，跳转到index
        Subject subject = SecurityUtils.getSubject();


        if (subject.getPrincipal() != null) {
            try {
                WebUtils.issueRedirect(request, response,
                        "/pages/jsp/home/index.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String exceptionClassName = (String) request
                .getAttribute("shiroLoginFailure");
        String error = null;
        if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if (IncorrectCredentialsException.class.getName().equals(
                exceptionClassName)) {
            error = "用户名/密码错误";
        } else if (exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
        model.addAttribute("error", error);
        return "/jsp/login";
    }
    @RequestMapping("/logout")
    public void logout(HttpServletRequest req, Model model,HttpServletResponse response){

        Subject subject = SecurityUtils.getSubject();
        try {
            subject.logout();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            WebUtils.issueRedirect(req, response, "/pages/jsp/login.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
