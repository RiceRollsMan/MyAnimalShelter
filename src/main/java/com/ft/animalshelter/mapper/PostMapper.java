package com.ft.animalshelter.mapper;

import com.ft.animalshelter.pojo.Post;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PostMapper {
    public int getCounts();
    public int getPassCounts();
    public void releasePost(Post post);
    public List<Post> showPosts();//展示未审核的贴子
    public List<Post> showPassPosts();//展示通过审核贴子
    public List<Post> showDontPassPosts();//展示未通过审核的贴子
    public int approvalPost(int postId,int postStatus,String approvalUser);//审核贴子改变数据库里的状态
    public List<Post> fuzzyQueryPosts(String keyWords);//通过标题模糊查询
    public void likePost(int postId);//给贴子点赞
    public int getLikes(int postId);//获取贴子的点赞数量
    public List<Post> showPostsByAnimalsId(int id);//根据动物id查询帖子
    public Post showPostById(int postId);//根据id查询post
    public List<Post> fuzzyQueryPostsAndAnimalsId(String keyWords,int id);//通过标题模糊查询
    public List<Post> showMyPosts(String username);//通过用户名进去贴子
}
