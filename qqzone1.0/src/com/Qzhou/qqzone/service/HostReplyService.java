package com.Qzhou.qqzone.service;

import com.Qzhou.qqzone.pojo.HostReply;

public interface HostReplyService {
    HostReply getHostReplyByReplyId(Integer replyId);
    void delHostReply(Integer id);
    //������߻ظ���Ϣ
    void addHostReply(HostReply hostReply);
}
