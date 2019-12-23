package com.tangtang.gmall.user.mapper;

import com.tangtang.gmall.user.bean.UserInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

//使用通用mapper
public interface UserInfoMapper extends Mapper<UserInfo> {

    //List<UserInfo> selectAllUserInfo();
}
