package com.Qzhou.qqzone.service;

import com.Qzhou.qqzone.pojo.UserBasic;

import java.util.List;

public interface UserBasicService {
    UserBasic login(String loginId,String pwd);
    //��ȡ�����б�
    List<UserBasic> getFriendList(UserBasic userBasic);
    //����id��ȡָ��Ӵid��ȡָ���û���Ϣ
    UserBasic getUserBasicById(Integer id);

}
