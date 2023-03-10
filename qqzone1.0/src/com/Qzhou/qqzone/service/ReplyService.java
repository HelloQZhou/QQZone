package com.Qzhou.qqzone.service;

import com.Qzhou.qqzone.pojo.Reply;
import com.Qzhou.qqzone.pojo.Topic;

import java.util.List;

public interface ReplyService {
    //����topic��id��ȡ���������лظ�
    List<Reply> getReplyListByTopicId(Integer id);
    //������˻ظ�
    void addReply(Reply reply);
    //ɾ��ָ���Ļظ�
    void delReply(Integer id);
    //ɾ��ָ������־���������лظ�
    void delReplyList(Topic topic);

}
