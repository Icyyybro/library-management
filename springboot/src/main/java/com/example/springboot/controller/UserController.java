package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.UserPageRequest;
import com.example.springboot.entity.User;
import com.example.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    //存用户信息
    @PostMapping("/save")
    public Result save(@RequestBody User user) {
        userService.save(user);
        return Result.success();
    }

    //通过id号查询
    @GetMapping("/{member_id}")
    public Result getById(@PathVariable String member_id) {
        User user = userService.getById(member_id);
        return Result.success(user);
    }

    //将编辑的结果存入数据库
    @PutMapping("/update")
    public Result update(@RequestBody User user) {
        userService.update(user);
        return Result.success();
    }

    //删除用户信息
    @DeleteMapping("/delete/{member_id}")
    public Result delete(@PathVariable String member_id) {
        userService.deleteById(member_id);
        return Result.success();
    }

    //请求获取整个user列表
    @GetMapping("/list")
    public Result list() {
        return Result.success(userService.list());
    }

    //请求获取分页面的信息
    @GetMapping("/page")
    public Result page(UserPageRequest userPageRequest) {
        return Result.success(userService.page(userPageRequest));
    }

}
