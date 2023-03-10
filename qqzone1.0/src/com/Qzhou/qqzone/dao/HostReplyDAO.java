package com.Qzhou.qqzone.dao;

import com.Qzhou.qqzone.pojo.HostReply;
import com.Qzhou.qqzone.pojo.Reply;

public interface HostReplyDAO {
    //根据replyId 查询关联的HostReply 实体
    HostReply getHostReplyByReplyId(Integer replyId);
    //删除与reply相关联的(特定的)hostReply
    void delHostReply(Integer id);
    //增加作者回复信息
    void addHostReply(HostReply hostReply);
}
