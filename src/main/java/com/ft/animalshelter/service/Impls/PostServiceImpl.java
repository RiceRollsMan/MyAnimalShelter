package com.ft.animalshelter.service.Impls;

import com.ft.animalshelter.mapper.PostMapper;
import com.ft.animalshelter.pojo.Post;
import com.ft.animalshelter.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;
    @Override
    public int getCounts() {
        return postMapper.getCounts();
    }

    @Override
    public int getPassCounts() {
        return postMapper.getPassCounts();
    }

    @Override
    public void releasePost(Post post) {
        postMapper.releasePost(post);
    }

    @Override
    public List<Post> showPosts() {
        return postMapper.showPosts();
    }

    @Override
    public List<Post> showPassPosts() {
        return postMapper.showPassPosts();
    }

    @Override
    public List<Post> showDontPassPosts() {
        return postMapper.showDontPassPosts();
    }

    @Override
    public int approvalPost(int postId, int postStatus, String approvalUser) {
       return postMapper.approvalPost(postId,postStatus,approvalUser);
    }

    @Override
    public List<Post> fuzzyQueryPosts(String keyWords) {
        return postMapper.fuzzyQueryPosts(keyWords);
    }

    @Override
    public void likePost(int postId) {
        postMapper.likePost(postId);
    }

    @Override
    public int getLikes(int postId) {
        return postMapper.getLikes(postId);
    }

    @Override
    public List<Post> showPostsByAnimalsId(int id) {
        return postMapper.showPostsByAnimalsId(id);
    }

    @Override
    public Post showPostById(int postId) {
        return postMapper.showPostById(postId);
    }

    @Override
    public List<Post> fuzzyQueryPostsAndAnimalsId(String keyWords, int id) {
        return postMapper.fuzzyQueryPostsAndAnimalsId(keyWords,id);
    }

    @Override
    public List<Post> showMyPosts(String username) {
        return postMapper.showMyPosts(username);
    }

}
