package com.Qzhou.qqzone.controller;

import com.Qzhou.qqzone.pojo.Topic;
import com.Qzhou.qqzone.pojo.UserBasic;
import com.Qzhou.qqzone.service.ReplyService;
import com.Qzhou.qqzone.service.TopicService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

public class TopicController {
    private TopicService topicService;
    private ReplyService replyService;
    public String topicDetail(Integer id, HttpSession session){
        Topic topic = topicService.getTopicById(id);

        //�˴��߼�����Service�ڲ�ȥ��
//        List<Reply> replyList = replyService.getReplyListByTopicId(topic.getId());
//        topic.setReplyList(replyList);

        session.setAttribute("topic",topic);
        return "frames/detail";
    }
    public String delTopic(Integer topicId){
        topicService.delTopic(topicId);

        return "redirect:topic.do?operate=getTopicList";
    }
    public String getTopicList(HttpSession session){
        //��session�л�ȡ��ǰ�û���Ϣ
        UserBasic userBasic=(UserBasic)session.getAttribute("userBasic");
        //�ٴβ�ѯ��ǰ�û�������������־
        List<Topic> topicList = topicService.getTopicList(userBasic);
        //����һ�¹�������־�б���Ϊ������ ɾ������ ��Ҫ���� ��
        userBasic.setTopicList(topicList);
        //���¸���һ��friend �е���Ϣ (Ϊʲô����userBasic �е� ��Ϊmain.html ҳ���е�������friend���key�е����� Ҳ��ֹ���˵�������ת�����ѿռ�)
        session.setAttribute("friend",userBasic);
        return "frames/main";
    }
    public String addTopic(String title,String content ,HttpSession session){
        UserBasic userBasic=(UserBasic)session.getAttribute("userBasic");
        Topic topic = new Topic(title, content, new Date(), userBasic);
        topicService.addTopic(topic);

        //������� ��Ҫ�ֶ�ˢ����ҳ �ܲ�����
        //return "frames/main";


        //�ض��� ��������
        return "redirect:topic.do?operate=getTopicList";
    }



}
