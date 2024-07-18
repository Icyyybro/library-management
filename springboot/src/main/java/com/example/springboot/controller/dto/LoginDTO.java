package com.example.springboot.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class LoginDTO {
    private Integer id;
    private String username;
    private String email;
    private String phone;
}
