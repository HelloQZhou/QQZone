package com.Qzhou.qqzone.dao.impl;

import com.Qzhou.myssm.basedao.BaseDAO;
import com.Qzhou.qqzone.dao.HostReplyDAO;
import com.Qzhou.qqzone.pojo.HostReply;
import com.Qzhou.qqzone.pojo.Reply;

public class HostReplyDAOImpl extends BaseDAO<HostReply> implements HostReplyDAO {
    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        return load("select * from t_host_reply where reply=?",replyId);
    }

    @Override
    public void delHostReply(Integer id) {
        super.executeUpdate("delete from t_host_reply where id=?",id);
    }


    @Override
    public void addHostReply(HostReply hostReply) {
    executeUpdate("insert into t_host_reply values(0,?,?,?,?)",hostReply.getContent(),hostReply.getHostReplyDate(),hostReply.getAuthor().getId(),hostReply.getReply().getId());

    }
}
