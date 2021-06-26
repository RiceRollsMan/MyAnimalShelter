package com.ft.animalshelter.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bodhisattva {
    private int donationID;
    private int animalsId;
    private String username;
    private int money;
    private Date date;
    private String useDetails;
    public Bodhisattva(int donationID,int animalsId,String username,int money){
        this.donationID=donationID;
        this.animalsId=animalsId;
        this.username=username;
        this.money=money;
    }
    public Bodhisattva(int money,String username){
        this.money=money;
        this.username=username;
    }
}
