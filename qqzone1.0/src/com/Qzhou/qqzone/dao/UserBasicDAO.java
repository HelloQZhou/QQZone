package com.Qzhou.qqzone.dao;

import com.Qzhou.qqzone.pojo.UserBasic;

import java.util.List;

public interface UserBasicDAO {
    //�����˺������ȡ�ض��û���Ϣ
    public UserBasic getUserBasic(String loginId,String pwd);
    //��ȡָ���û����к����б� ��id
    List<UserBasic> getUserBasicList(UserBasic userBasic);
    //����id��ѯUserBasic ����Ϣ
    UserBasic getUserBasicById(Integer id );
}
