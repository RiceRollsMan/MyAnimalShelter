package com.ft.animalshelter.mapper;

import com.ft.animalshelter.pojo.Commit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommitMapper {
    public int getCounts();
    public int addCommit(Commit commit);
    public List<Commit> showCommits(int postId);
    public void likeCommits(int commitId);
    public int getCommitLikes(int commitId);
}
