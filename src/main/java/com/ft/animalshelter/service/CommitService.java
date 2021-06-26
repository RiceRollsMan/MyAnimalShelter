package com.ft.animalshelter.service;

import com.ft.animalshelter.pojo.Commit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommitService {
    public int getCounts();
    public int addCommit(Commit commit);
    public List<Commit> showCommits(int postId);
    public void likeCommit(int commitId);
    public int getCommitLikes(int commitId);
}
