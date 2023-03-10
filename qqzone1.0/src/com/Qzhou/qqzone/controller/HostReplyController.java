package com.Qzhou.qqzone.controller;

import com.Qzhou.qqzone.pojo.HostReply;
import com.Qzhou.qqzone.pojo.Reply;
import com.Qzhou.qqzone.pojo.UserBasic;
import com.Qzhou.qqzone.service.HostReplyService;

import javax.servlet.http.HttpSession;
import java.util.Date;

public class HostReplyController {
    private HostReplyService hostReplyService;
    public String addHostReply(String content, HttpSession session,Integer replyId,Integer topicId){
        UserBasic author=(UserBasic)session.getAttribute("userBasic");
        HostReply hostReply=new HostReply(content,new Date(),author,new Reply(replyId));
        hostReplyService.addHostReply(hostReply);

       return "redirect:topic.do?operate=topicDetail&id="+topicId;

    }
}
