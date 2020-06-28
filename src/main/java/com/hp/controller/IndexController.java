package com.hp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        //跳转index.html
        return "index";
    }
    //跳转到后台首页
    @RequestMapping("/admin")
    public String admin(){
        return "admin/admin";
    }

    //访问前台首页
    @RequestMapping("/front")
    public String front(){
        //跳转index.html
        return "front/home_index";
    }

}
