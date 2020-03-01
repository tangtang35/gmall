package com.tangtang.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.tangtang.gmall.bean.UserInfo;
import com.tangtang.gmall.service.UserService;
import com.tangtang.gmall.user.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserService {

    @Autowired
    public UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> userInfoList() {
        //List<UserInfo> userInfoList = userInfoMapper.selectAllUserInfo();
        //使用通用mapper
        //List<UserInfo> userInfoList = userInfoMapper.selectAll();
        List<UserInfo> userInfoList = userInfoMapper.selectAll();
        return userInfoList;
    }
}
