package com.Qzhou.qqzone.dao;

import com.Qzhou.qqzone.pojo.Topic;
import com.Qzhou.qqzone.pojo.UserBasic;

import java.util.List;

public interface TopicDAO {
    //��ȡָ���û���������־�б�
    public List<Topic> getTopicList(UserBasic userBasic);
    //�����־
    public void addTopic(Topic topic);
    //ɾ����־
    public void delTopic(Topic topic);
    //��ȡָ������־��Ϣ
    Topic getTopic(Integer id);
}
