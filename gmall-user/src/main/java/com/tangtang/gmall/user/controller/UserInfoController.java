package com.tangtang.gmall.user.controller;

import com.tangtang.gmall.user.bean.UserInfo;
import com.tangtang.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserInfoController {

    @Autowired
    UserService userService;

    @RequestMapping("userInfoList")
    @ResponseBody
    public List<UserInfo> userInfoList(){
        List<UserInfo> userInfoList = userService.userInfoList();
        return userInfoList;
    }

}
