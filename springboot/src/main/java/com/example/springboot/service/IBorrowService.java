package com.example.springboot.service;

import com.example.springboot.controller.dto.LoginDTO;
import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.LoginRequest;
import com.example.springboot.entity.Borrow;

import java.util.List;

public interface IBorrowService {
    List<Borrow> list();

    Object page(BaseRequest baseRequest);

    void save(Borrow obj);

    Borrow getById(Integer id);

    void update(Borrow obj);

    void deleteById(Integer id);

    LoginDTO login(LoginRequest request);
}
