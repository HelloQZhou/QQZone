package com.Qzhou.qqzone.service.Impl;

import com.Qzhou.qqzone.dao.UserBasicDAO;
import com.Qzhou.qqzone.pojo.UserBasic;
import com.Qzhou.qqzone.service.UserBasicService;

import java.util.ArrayList;
import java.util.List;

public class UserBasicServiceImpl implements UserBasicService {

    private UserBasicDAO userBasicDAO=null;
    @Override
    public UserBasic login(String loginId, String pwd) {
        //登录验证
        UserBasic userBasic = userBasicDAO.getUserBasic(loginId, pwd);
        return userBasic;
    }

    //左侧的好友列表
    @Override
    public List<UserBasic> getFriendList(UserBasic userBasic) {
        List<UserBasic> userBasicsList=userBasicDAO.getUserBasicList(userBasic);
        List<UserBasic> friendList=new ArrayList<>(userBasicsList.size());
        for (int i = 0; i < userBasicsList.size(); i++) {
            UserBasic friend = userBasicsList.get(i);
            friend= userBasicDAO.getUserBasicById(friend.getId());
            friendList.add(friend);
        }
        return friendList;
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        return  userBasicDAO.getUserBasicById(id);

    }
}
