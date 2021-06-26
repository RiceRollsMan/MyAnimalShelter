package com.ft.animalshelter.service;

import com.ft.animalshelter.pojo.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    public int getCounts();//获取总贴数，好给id
    public int getPassCounts();//获取总贴数，好给id
    public void releasePost(Post post);//发帖人发帖的时候的请求
    public List<Post> showPosts();//展示未审核的贴子
    public List<Post> showPassPosts();//展示通过审核贴子
    public List<Post> showDontPassPosts();//展示未通过审核的贴子
    public int approvalPost(int postId,int postStatus,String approvalUser);//审批贴子改变数据库里的状态
    public List<Post> fuzzyQueryPosts(String keyWords);//根据标题模糊查询
    public void likePost(int postId);//给贴子点赞
    public int getLikes(int postId);//获取贴子点赞数
    public List<Post> showPostsByAnimalsId(int id);//根据动物id查询帖子
    public Post showPostById(int postId);
    public List<Post> fuzzyQueryPostsAndAnimalsId(String keyWords,int id);//通过标题模糊查询
    public List<Post> showMyPosts(String username);//通过用户名进去贴子
}
