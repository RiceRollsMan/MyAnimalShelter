package com.ft.animalshelter.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animals {
    private int id;
    private String animalName;
    private int gender;
    private String uploadUsername;
    private String avatorUrl;
    private String boardUrl;
    private int cheatRoomId;
    private int varietyId;
    private String introduction;
    private Date date;
    public Animals(int id,String uploadUsername, String animalName, int gender, String avatorUrl, int varietyId, String introduction){
        this.id=id;
        this.uploadUsername=uploadUsername;
        this.animalName=animalName;
        this.gender=gender;
        this.avatorUrl=avatorUrl;
        this.varietyId=varietyId;
        this.introduction=introduction;
    }
}
