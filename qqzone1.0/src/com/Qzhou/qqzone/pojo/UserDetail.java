package com.Qzhou.qqzone.pojo;

import java.sql.Date;

public class UserDetail {
    private Integer id;
    private String realName;
    private String tel;
    private String email;
    //���� java.util.Date ������ʱ�������
    //���� java.sql.Date ������
    //����  java.sql.Time ʱ����
    private Date birth;
    private String star; //����

    public UserDetail() {
    }

    public UserDetail(Integer id, String realName, String tel, String email, Date birth, String star) {
        this.id = id;
        this.realName = realName;
        this.tel = tel;
        this.email = email;
        this.birth = birth;
        this.star = star;
    }
}
