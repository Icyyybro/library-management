package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.controller.request.BookPageRequest;
import com.example.springboot.entity.Book;
import com.example.springboot.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    IBookService bookService;


    //存admin信息
    @PostMapping("/save")
    public Result save(@RequestBody Book obj) {
        bookService.save(obj);
        return Result.success();
    }

    //通过id号查询
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Book obj = bookService.getById(id);
        System.out.println("--------------------------------------------");
        System.out.println(id);
        return Result.success(obj);
    }

    //将编辑的结果存入数据库
    @PutMapping("/update")
    public Result update(@RequestBody Book obj) {
        bookService.update(obj);
        return Result.success();
    }

    //通过对应的id删除admin信息
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        bookService.deleteById(id);
        return Result.success();
    }

    //请求获取整个admin列表
    @GetMapping("/list")
    public Result list() {
        return Result.success(bookService.list());
    }

    //通过查询框中输入的用户名，电话，email信息查询管理员
    @GetMapping("/page")
    public Result page(BookPageRequest pageRequest) {
        return Result.success(bookService.page(pageRequest));
    }

}
