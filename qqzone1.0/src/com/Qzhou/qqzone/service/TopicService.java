package com.Qzhou.qqzone.service;

import com.Qzhou.qqzone.pojo.Topic;
import com.Qzhou.qqzone.pojo.UserBasic;

import java.util.List;

public interface TopicService {
    //查询特定的用户列表
    public List<Topic> getTopicList(UserBasic userBasic);
    //根据id获取特定的topic
    public Topic getTopicById(Integer id);
    // 根据id获取指定的topic信息 包含topic关联的作者信息
    public Topic getTopic(Integer id);
    //删除特定的topic
    public void delTopic(Integer id);
    //添加新日志
    public void addTopic(Topic topic);
}
