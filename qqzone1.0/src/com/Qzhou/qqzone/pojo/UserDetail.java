package com.Qzhou.qqzone.pojo;

import java.sql.Date;

public class UserDetail {
    private Integer id;
    private String realName;
    private String tel;
    private String email;
    //父类 java.util.Date 年月日时分秒毫秒
    //子类 java.sql.Date 年月日
    //子类  java.sql.Time 时分秒
    private Date birth;
    private String star; //星座

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
