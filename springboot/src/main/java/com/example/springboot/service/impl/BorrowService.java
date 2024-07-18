package com.example.springboot.service.impl;

import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.entity.Borrow;
import com.example.springboot.mapper.BorrowMapper;
import com.example.springboot.service.IBorrowService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BorrowService implements IBorrowService {
    @Resource
    BorrowMapper borrowMapper;

    @Override
    public List<Borrow> list() {
        return borrowMapper.list();
    }

    @Override
    public PageInfo<Borrow> page(BaseRequest baseRequest) {
        //调用pagehelper方法，将页码和每页容量传给方法。
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Borrow> list = borrowMapper.listByCondition(baseRequest);
        System.out.println("--------------");
        for (Borrow borrow : list) {
            System.out.println(borrow);
        }
        //返回时创建一个PageInfo就行。
        return new PageInfo<>(list);
    }

    @Override
    public void save(Borrow obj) {
        borrowMapper.save(obj);
    }

    @Override
    public Borrow getById(Integer id) {
        return borrowMapper.getById(id);
    }

    @Override
    public void update(Borrow obj) {
        borrowMapper.updateById(obj);
    }

    @Override
    public void deleteById(Integer id) {
        borrowMapper.deleteById(id);
    }

    @Override
    public LoginDTO login(LoginRequest request) {
        return null;
    }
}
