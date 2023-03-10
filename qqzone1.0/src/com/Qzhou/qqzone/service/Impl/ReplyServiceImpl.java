package com.Qzhou.qqzone.service.Impl;

import com.Qzhou.qqzone.dao.ReplyDAO;
import com.Qzhou.qqzone.pojo.HostReply;
import com.Qzhou.qqzone.pojo.Reply;
import com.Qzhou.qqzone.pojo.Topic;
import com.Qzhou.qqzone.pojo.UserBasic;
import com.Qzhou.qqzone.service.HostReplyService;
import com.Qzhou.qqzone.service.ReplyService;
import com.Qzhou.qqzone.service.UserBasicService;

import java.util.List;

public class ReplyServiceImpl implements ReplyService {
    private ReplyDAO replyDAO;
    //�˴����õ�������POJO��Ӧ�� ��Serivice�ӿ� ������DAO�ӿ�
    //����POJO��Ӧ��ҵ���߼���װ��service�� ������Ҫ���ñ��˵�ҵ���߼����� ����ȥ���뿼�Ǳ��˵��ڲ�ϸ��
    //����ʱΪ DAO Ҳ��ͬ����Ч�� ��ͬ����⣩
    private HostReplyService hostReplyService;
    private UserBasicService userBasicService;
    @Override
    public List<Reply> getReplyListByTopicId(Integer topicId) {
        List<Reply> replyList= replyDAO.getReplyList(new Topic(topicId));
        for (int i = 0; i < replyList.size(); i++) {
            Reply reply = replyList.get(i);
            //1�����������������ý�ȥ
            UserBasic author = userBasicService.getUserBasicById(reply.getAuthor().getId());
            reply.setAuthor(author);

            //2����������HostReply ���ý�ȥ

            HostReply hostReply = hostReplyService.getHostReplyByReplyId(reply.getId());
            reply.setHostReply(hostReply);
        }
        return replyList;
    }

    @Override
    public void addReply(Reply reply) {
        replyDAO.addReply(reply);
    }

    @Override
    public void delReply(Integer id) {
        //1������id ��ȡ��reply
        Reply reply = replyDAO.getReply(id);
        if(reply!=null){
        //2�����reply�й�����hostReply ����ɾ��hostReply
            HostReply hostReply = hostReplyService.getHostReplyByReplyId(reply.getId());
            if(hostReply!=null){
                hostReplyService.delHostReply(hostReply.getId());
            }
        }
        //3��ɾ��reply
        replyDAO.delReply(id);

    }

    @Override
    public void delReplyList(Topic topic) {
        List<Reply> replyList = replyDAO.getReplyList(topic);
        if(replyList!=null){
            for (int i = 0; i < replyList.size(); i++) {
                delReply(replyList.get(i).getId());
            }
        }
    }


}
