package com.Qzhou.qqzone.dao.impl;

import com.Qzhou.myssm.basedao.BaseDAO;
import com.Qzhou.qqzone.dao.UserBasicDAO;
import com.Qzhou.qqzone.pojo.UserBasic;

import java.util.List;

public class UserBasicDAOImpl extends BaseDAO<UserBasic> implements UserBasicDAO {
    @Override
    public UserBasic getUserBasic(String loginId, String pwd) {
        return super.load("select * from t_user_basic where loginId=? and pwd=?",loginId,pwd);
    }

    @Override
    public List<UserBasic> getUserBasicList(UserBasic userBasic) {
        //��Ҫ�ҵ�ָ���û��ĺ����б� �� id
        String sql="SELECT fid as 'id' FROM t_friend WHERE uid=?";
        return super.executeQuery(sql,userBasic.getId() );
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        return load("select * from t_user_basic where id=?",id);
    }
}