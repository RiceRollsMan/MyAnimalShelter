package com.ft.animalshelter.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int postId;
    private String postUser;
    private Date postDate;
    private String postTitle;
    private String postPicUrl;
    private String postContext;
    private int postStatus;
    private String approvalUser;
    private int likeCounts;
    private int animalId;
    public Post(
            int postId,
            String postUser,
            String postTitle,
            String postPicUrl,
            String postContext,
            int animalsId
            ){
        this.postId=postId;
        this.postTitle=postTitle;
        this.postPicUrl=postPicUrl;
        this.postUser=postUser;
        this.postContext=postContext;
        this.animalId=animalsId;
    }
}
