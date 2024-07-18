package com.example.springboot.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.example.springboot.controller.request.BaseRequest;
import com.example.springboot.controller.request.UserPageRequest;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public PageInfo<User> page(BaseRequest baseRequest) {
        //调用pagehelper方法，将页码和每页容量传给方法。
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<User> users = userMapper.listByCondition(baseRequest);
        //返回时创建一个PageInfo就行。
        return new PageInfo<>(users);
    }

    @Override
    public void save(User user) {
        //新建一个对象时，开一个卡号
        Date date = new Date();
        //user.setMember_id(DateUtil.format(date, "yyyy") + IdUtil.fastSimpleUUID());
        long timestamp = System.currentTimeMillis(); // 获取当前时间戳
        String formattedTimestamp = String.valueOf(timestamp); // 将时间戳转换为字符串
        user.setMember_id(formattedTimestamp);
        userMapper.save(user);
    }

    @Override
    public User getById(String member_id) {
        return userMapper.getById(member_id);
    }

    @Override
    public void update(User user) {
        user.setUpdate_time(new Date());
        userMapper.updateById(user);
    }

    @Override
    public void deleteById(String memberId) {
        userMapper.deleteById(memberId);
    }
}
