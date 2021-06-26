package com.ft.animalshelter.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commit {
    private int commitId;
    private int postId;
    private String commitUser;
    private String commitContext;
    private Date commitDate;
    private int likeCounts;
    public Commit(
            int commitId,
            int postId,
            String commitUser,
            String commitContext){
        this.commitId=commitId;
        this.postId=postId;
        this.commitUser=commitUser;
        this.commitContext=commitContext;
    }
}
