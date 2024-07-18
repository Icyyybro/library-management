package com.example.springboot.mapper;

import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.UserPageRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.springboot.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {

    //@Select("select * from user")
    List<User> list();

    List<User> listByCondition(BaseRequest baseRequest);

    void save(User user);

    User getById(String member_id);

    void updateById(User user);

    void deleteById(String memberId);
}
