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
    //此处引用的是其他POJO对应的 ？Serivice接口 而不是DAO接口
    //其他POJO对应的业务逻辑封装在service层 我们需要调用别人的业务逻辑方法 而不去深入考虑别人的内部细节
    //（此时为 DAO 也是同样的效果 不同的理解）
    private HostReplyService hostReplyService;
    private UserBasicService userBasicService;
    @Override
    public List<Reply> getReplyListByTopicId(Integer topicId) {
        List<Reply> replyList= replyDAO.getReplyList(new Topic(topicId));
        for (int i = 0; i < replyList.size(); i++) {
            Reply reply = replyList.get(i);
            //1、将关联的作者设置进去
            UserBasic author = userBasicService.getUserBasicById(reply.getAuthor().getId());
            reply.setAuthor(author);

            //2、将关联的HostReply 设置进去

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
        //1、根据id 获取到reply
        Reply reply = replyDAO.getReply(id);
        if(reply!=null){
        //2、如果reply有关联的hostReply 则先删除hostReply
            HostReply hostReply = hostReplyService.getHostReplyByReplyId(reply.getId());
            if(hostReply!=null){
                hostReplyService.delHostReply(hostReply.getId());
            }
        }
        //3、删除reply
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
