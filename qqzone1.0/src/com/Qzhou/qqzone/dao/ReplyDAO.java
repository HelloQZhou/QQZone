package com.Qzhou.qqzone.dao;

import com.Qzhou.qqzone.pojo.HostReply;
import com.Qzhou.qqzone.pojo.Reply;
import com.Qzhou.qqzone.pojo.Topic;

import java.util.List;

public interface ReplyDAO {
    //��ȡָ����־�Ļظ��б�
    List<Reply> getReplyList(Topic topic);
    //��ӻظ� ��ʱӦ������־�ظ������ǻظ��Ļظ�
    void addReply(Reply reply);
    //ɾ���ظ�
    void delReply(Integer id);
    //����id��ȡָ����Reply
    Reply getReply(Integer id);

}
