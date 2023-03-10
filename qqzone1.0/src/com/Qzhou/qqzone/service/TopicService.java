package com.Qzhou.qqzone.service;

import com.Qzhou.qqzone.pojo.Topic;
import com.Qzhou.qqzone.pojo.UserBasic;

import java.util.List;

public interface TopicService {
    //��ѯ�ض����û��б�
    public List<Topic> getTopicList(UserBasic userBasic);
    //����id��ȡ�ض���topic
    public Topic getTopicById(Integer id);
    // ����id��ȡָ����topic��Ϣ ����topic������������Ϣ
    public Topic getTopic(Integer id);
    //ɾ���ض���topic
    public void delTopic(Integer id);
    //�������־
    public void addTopic(Topic topic);
}
