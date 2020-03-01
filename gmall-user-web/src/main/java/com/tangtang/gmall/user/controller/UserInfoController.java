package com.tangtang.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tangtang.gmall.bean.UserInfo;
import com.tangtang.gmall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserInfoController {

    @Reference
    UserService userService;

    @RequestMapping("userInfoList")
    @ResponseBody
    public List<UserInfo> userInfoList(){
        List<UserInfo> userInfoList = userService.userInfoList();
        return userInfoList;
    }

}
