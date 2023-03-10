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

        //此次逻辑放在Service内部去了
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
        //从session中获取当前用户信息
        UserBasic userBasic=(UserBasic)session.getAttribute("userBasic");
        //再次查询当前用户关联的所有日志
        List<Topic> topicList = topicService.getTopicList(userBasic);
        //设置一下关联的日志列表（以为经过了 删除操作 需要更新 ）
        userBasic.setTopicList(topicList);
        //重新覆盖一下friend 中的信息 (为什么不是userBasic 中的 因为main.html 页面中迭代的是friend这个key中的数据 也防止别人点击左侧跳转到好友空间)
        session.setAttribute("friend",userBasic);
        return "frames/main";
    }
    public String addTopic(String title,String content ,HttpSession session){
        UserBasic userBasic=(UserBasic)session.getAttribute("userBasic");
        Topic topic = new Topic(title, content, new Date(), userBasic);
        topicService.addTopic(topic);

        //如用这个 需要手动刷新网页 很不方便
        //return "frames/main";


        //重定向 更新数据
        return "redirect:topic.do?operate=getTopicList";
    }



}
