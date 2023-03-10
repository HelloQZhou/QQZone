package com.Qzhou.qqzone.service;

import com.Qzhou.qqzone.pojo.UserBasic;

import java.util.List;

public interface UserBasicService {
    UserBasic login(String loginId,String pwd);
    //获取好友列表
    List<UserBasic> getFriendList(UserBasic userBasic);
    //根据id获取指定哟id获取指定用户信息
    UserBasic getUserBasicById(Integer id);

}
