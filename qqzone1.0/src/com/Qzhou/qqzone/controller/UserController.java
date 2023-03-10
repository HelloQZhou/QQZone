package com.Qzhou.qqzone.controller;

import com.Qzhou.qqzone.pojo.Topic;
import com.Qzhou.qqzone.pojo.UserBasic;
import com.Qzhou.qqzone.service.TopicService;
import com.Qzhou.qqzone.service.UserBasicService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class UserController { //null的兄弟记得改提交方式为post
    private UserBasicService userBasicService;
    private TopicService topicService;

    public String login(String loginId,String pwd ,HttpSession session){
        //1、登录验证
        UserBasic userBasic = userBasicService.login(loginId, pwd);
        if(userBasic!=null) {
            //1-1获取相关好友的信息
            List<UserBasic> friendList = userBasicService.getFriendList(userBasic);
            //1-2 获取相关日志列表的信息
            List<Topic> topicList=topicService.getTopicList(userBasic);

            userBasic.setFriendList(friendList);
            userBasic.setTopicList(topicList);

            //userBasic保存的是登陆者的信息 friend这个key保存的当前是进入了谁的空间
            session.setAttribute("userBasic",userBasic);
            session.setAttribute("friend",userBasic);
            //此时没有空格 如“index ”
            return "index";
        }else{
            return "login";
        }

    }

    public String friend(Integer id,HttpSession session){
    //1、根据id获取指定的用户信息
        UserBasic currFriend = userBasicService.getUserBasicById(id);

        List<Topic> topicList = topicService.getTopicList(currFriend);
        currFriend.setTopicList(topicList);

        session.setAttribute("friend",currFriend);

        return "index";

    }

}
