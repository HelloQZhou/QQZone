package com.Qzhou.qqzone.dao;

import com.Qzhou.qqzone.pojo.Topic;
import com.Qzhou.qqzone.pojo.UserBasic;

import java.util.List;

public interface TopicDAO {
    //获取指定用户的所有日志列表
    public List<Topic> getTopicList(UserBasic userBasic);
    //添加日志
    public void addTopic(Topic topic);
    //删除日志
    public void delTopic(Topic topic);
    //获取指定的日志信息
    Topic getTopic(Integer id);
}
