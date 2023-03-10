package com.Qzhou.qqzone.dao;

import com.Qzhou.qqzone.pojo.HostReply;
import com.Qzhou.qqzone.pojo.Reply;

public interface HostReplyDAO {
    //����replyId ��ѯ������HostReply ʵ��
    HostReply getHostReplyByReplyId(Integer replyId);
    //ɾ����reply�������(�ض���)hostReply
    void delHostReply(Integer id);
    //�������߻ظ���Ϣ
    void addHostReply(HostReply hostReply);
}
