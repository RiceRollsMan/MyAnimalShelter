package com.ft.animalshelter.service.Impls;

import com.ft.animalshelter.mapper.CommitMapper;
import com.ft.animalshelter.pojo.Commit;
import com.ft.animalshelter.service.CommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommitServiceImpl implements CommitService {
    @Autowired
    private CommitMapper commitMapper;

    @Override
    public int getCounts() {
        return commitMapper.getCounts();
    }

    @Override
    public int addCommit(Commit commit) {
        return commitMapper.addCommit(commit);
    }

    @Override
    public List<Commit> showCommits(int postId) {
        return commitMapper.showCommits(postId);
    }

    @Override
    public void likeCommit(int commitId) {
         commitMapper.likeCommits(commitId);
    }

    @Override
    public int getCommitLikes(int commitId) {
        return commitMapper.getCommitLikes(commitId);
    }

}
