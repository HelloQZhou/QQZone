package com.Qzhou.qqzone.dao;

import com.Qzhou.qqzone.pojo.UserBasic;

import java.util.List;

public interface UserBasicDAO {
    //根据账号密码获取特定用户信息
    public UserBasic getUserBasic(String loginId,String pwd);
    //获取指定用户所有好友列表 的id
    List<UserBasic> getUserBasicList(UserBasic userBasic);
    //根据id查询UserBasic 的信息
    UserBasic getUserBasicById(Integer id );
}
