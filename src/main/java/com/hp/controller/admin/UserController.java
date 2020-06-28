package com.hp.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hp.mapper.UserMapper;
import com.hp.mapper.UsersMapper;
import com.hp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/show")
    public String show(Model model,
                       @RequestParam(defaultValue = "1") Integer pageNo,
                       @RequestParam(defaultValue = "3") Integer pageSize
    ){
        //1.pageHelper开始分页
        PageHelper.startPage(pageNo,pageSize);
        //通用mapper查询数据
        List<User> users = userMapper.selectAll();
        //封装user到pageInfo对象中
        PageInfo<User> pageInfo=new PageInfo<>(users);
        //将结果集存到model中
        model.addAttribute("pageInfo",pageInfo);
        //跳转到show_users页面中
        return "admin/users/show_users";
    }

  /*  @RequestMapping("/deleteUser/{uid}")
    public String deleteUser(@PathVariable Integer uid){
        System.out.println(uid);
        userMapper.deleteByPrimaryKey(uid);
        return "admin/users/show_users";
    }*/
   /* @GetMapping("/user")
    @ResponseBody//异步请求
    public PageInfo<User> users(
            @RequestParam(defaultValue ="1") Integer pageNo,
            @RequestParam(defaultValue ="5") Integer size){
        //分页
        PageHelper.startPage(pageNo,size);
        //查询
        List<User> user = userMapper.selectAll();
        System.out.println(user);
        //响应
        return new PageInfo<>(user);
    }*/
}
