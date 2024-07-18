package com.example.springboot.controller.request;

import lombok.Data;

@Data
public class BorrowPageRequest extends BaseRequest {
    private String book_name;
    private String isbn;
    private String user_name;
}
