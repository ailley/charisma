package com.w3cmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/8/17.
 */
@Controller
public class MenuController {

    @RequestMapping("menu")
    public String toMenu(){
        return "menu";
    }

}
