package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.BorrowPageRequest;
import com.example.springboot.entity.Borrow;
import com.example.springboot.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    IBorrowService borrowService;


    //存信息
    @PostMapping("/save")
    public Result save(@RequestBody Borrow obj) {
        borrowService.save(obj);
        return Result.success();
    }

    //通过id号查询
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        System.out.println("-----------------------------------------------------------------");
        System.out.println(id);
        Borrow obj = borrowService.getById(id);
        return Result.success(obj);
    }

    //将编辑的结果存入数据库
    @PutMapping("/update")
    public Result update(@RequestBody Borrow obj) {
        borrowService.update(obj);
        return Result.success();
    }

    //通过对应的id删除admin信息
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        borrowService.deleteById(id);
        return Result.success();
    }

    //请求获取整个admin列表
    @GetMapping("/list")
    public Result list() {
        return Result.success(borrowService.list());
    }

    //通过查询框中输入的用户名，电话，email信息查询管理员
    @GetMapping("/page")
    public Result page(BorrowPageRequest pageRequest) {
        return Result.success(borrowService.page(pageRequest));
    }

}
