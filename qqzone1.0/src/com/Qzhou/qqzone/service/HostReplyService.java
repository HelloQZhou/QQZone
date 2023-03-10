package com.Qzhou.qqzone.service;

import com.Qzhou.qqzone.pojo.HostReply;

public interface HostReplyService {
    HostReply getHostReplyByReplyId(Integer replyId);
    void delHostReply(Integer id);
    //添加作者回复信息
    void addHostReply(HostReply hostReply);
}
