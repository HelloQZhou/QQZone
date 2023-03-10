package com.Qzhou.qqzone.controller;

import com.Qzhou.qqzone.pojo.Reply;
import com.Qzhou.qqzone.pojo.Topic;
import com.Qzhou.qqzone.pojo.UserBasic;
import com.Qzhou.qqzone.service.ReplyService;

import javax.servlet.http.HttpSession;
import java.util.Date;

public class ReplyController {
    private ReplyService replyService;

    public String addReply(String content, HttpSession session,Integer topicId){
        UserBasic author=(UserBasic)session.getAttribute("userBasic");
        Reply reply=new Reply(content,new Date(),author,new Topic(topicId));

        replyService.addReply(reply);
        //重定向 更新数据
        return "redirect:topic.do?operate=topicDetail&id="+topicId;


    }

    public String delReply(Integer replyId,Integer topicId){
        replyService.delReply(replyId);
        return "redirect:topic.do?operate=topicDetail&id="+topicId;
    }
}
