package com.Qzhou.qqzone.service.Impl;

import com.Qzhou.qqzone.dao.TopicDAO;
import com.Qzhou.qqzone.pojo.Reply;
import com.Qzhou.qqzone.pojo.Topic;
import com.Qzhou.qqzone.pojo.UserBasic;
import com.Qzhou.qqzone.service.ReplyService;
import com.Qzhou.qqzone.service.TopicService;
import com.Qzhou.qqzone.service.UserBasicService;

import java.util.List;

public class TopicServiceImpl implements TopicService {
    private TopicDAO topicDAO=null;
    //�˴�����ΪreplyService ������DAO
    private ReplyService replyService;
    private UserBasicService userBasicService;
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return topicDAO.getTopicList(userBasic);
    }

    //��װһ�� ����id��ȡָ����topic��Ϣ ����topic������������Ϣ
    public Topic getTopic(Integer id){
        Topic topic= topicDAO.getTopic(id);
        UserBasic author = topic.getAuthor();
        author=userBasicService.getUserBasicById(author.getId());
        topic.setAuthor(author);
        return topic;
    }

    @Override
    public void delTopic(Integer id) {
        Topic topic = topicDAO.getTopic(id);
        if(topic!=null){
            replyService.delReplyList(topic);
            topicDAO.delTopic(topic);
        }
    }

    @Override
    public void addTopic(Topic topic) {
        topicDAO.addTopic(topic);
    }

    @Override
    public Topic getTopicById(Integer id) {
        Topic topic = getTopic(id);

        List<Reply> replyList = replyService.getReplyListByTopicId(topic.getId());
        topic.setReplyList(replyList);

        return topic;
    }
}
