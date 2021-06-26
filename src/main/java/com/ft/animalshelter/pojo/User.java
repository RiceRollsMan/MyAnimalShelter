package com.ft.animalshelter.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private String password;
    private int gender;
    private Date birth;
    private String mail;
    private String avatorUrl;
    private int collegeId;
    private String introduction;
    public int position;
    public User(String username,String password,int gender,Date birth,String mail,String avatorUrl,int collegeId,String introduction){
        this.username=username;
        this.password=password;
        this.gender=gender;
        this.birth=birth;
        this.mail=mail;
        this.avatorUrl=avatorUrl;
        this.collegeId=collegeId;
        this.introduction=introduction;
    }
}
