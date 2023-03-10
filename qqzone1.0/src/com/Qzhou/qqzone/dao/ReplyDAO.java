package com.Qzhou.qqzone.dao;

import com.Qzhou.qqzone.pojo.HostReply;
import com.Qzhou.qqzone.pojo.Reply;
import com.Qzhou.qqzone.pojo.Topic;

import java.util.List;

public interface ReplyDAO {
    //获取指定日志的回复列表
    List<Reply> getReplyList(Topic topic);
    //添加回复 此时应该有日志回复或者是回复的回复
    void addReply(Reply reply);
    //删除回复
    void delReply(Integer id);
    //根据id获取指定的Reply
    Reply getReply(Integer id);

}
