package com.Qzhou.qqzone.controller;

import com.Qzhou.qqzone.pojo.Topic;
import com.Qzhou.qqzone.pojo.UserBasic;
import com.Qzhou.qqzone.service.TopicService;
import com.Qzhou.qqzone.service.UserBasicService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class UserController { //null���ֵܼǵø��ύ��ʽΪpost
    private UserBasicService userBasicService;
    private TopicService topicService;

    public String login(String loginId,String pwd ,HttpSession session){
        //1����¼��֤
        UserBasic userBasic = userBasicService.login(loginId, pwd);
        if(userBasic!=null) {
            //1-1��ȡ��غ��ѵ���Ϣ
            List<UserBasic> friendList = userBasicService.getFriendList(userBasic);
            //1-2 ��ȡ�����־�б����Ϣ
            List<Topic> topicList=topicService.getTopicList(userBasic);

            userBasic.setFriendList(friendList);
            userBasic.setTopicList(topicList);

            //userBasic������ǵ�½�ߵ���Ϣ friend���key����ĵ�ǰ�ǽ�����˭�Ŀռ�
            session.setAttribute("userBasic",userBasic);
            session.setAttribute("friend",userBasic);
            //��ʱû�пո� �硰index ��
            return "index";
        }else{
            return "login";
        }

    }

    public String friend(Integer id,HttpSession session){
    //1������id��ȡָ�����û���Ϣ
        UserBasic currFriend = userBasicService.getUserBasicById(id);

        List<Topic> topicList = topicService.getTopicList(currFriend);
        currFriend.setTopicList(topicList);

        session.setAttribute("friend",currFriend);

        return "index";

    }

}
