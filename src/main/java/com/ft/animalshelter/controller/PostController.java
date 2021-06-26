package com.ft.animalshelter.controller;

import com.ft.animalshelter.pojo.Post;
import com.ft.animalshelter.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping ("/toPost")
    @ResponseBody
    public String toPost(
            String postTitle,
            String postPicUrl,
            String postContext,
            int animalId,
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String postUser= (String) request.getSession().getAttribute("user");
        int postId= postService.getCounts();//从0开始
        request.setAttribute("post",new Post(postId,postUser,postTitle,postPicUrl,postContext,animalId));
        request.getRequestDispatcher("/post/releasePost").include(request,response);
        System.out.println("到这了");
        return "true";
    }

    @GetMapping("/releasePost")
    @ResponseBody
    public void releasePost(HttpServletRequest request){
        Post post= (Post) request.getAttribute("post");
        postService.releasePost(post);
    }
    @GetMapping("/showPosts")
    public String showPorts(Model model){
        List<Post> posts = postService.showPosts();
        model.addAttribute("posts",posts);
        return "showPosts";
    }

    @GetMapping("/showPassPosts")
    public String showPassPorts(Model model){
        List<Post> passPosts = postService.showPassPosts();
        model.addAttribute("passPosts",passPosts);
        return "showPassPosts";
    }
    @GetMapping("/showDontPassPosts")
    public String showDontPassPorts(Model model){
        List<Post> dontPassPosts = postService.showDontPassPosts();
        model.addAttribute("dontPassPosts",dontPassPosts);
        return "showDontPassPosts";
    }

    @GetMapping("/approvalPost")
    @ResponseBody
    public String approvalPost(int postId,int postStatus,HttpServletRequest request){
//        System.out.println("1");
        String approvalUser= (String) request.getSession().getAttribute("user");
//        System.out.println(approvalUser);
        if(postService.approvalPost(postId,postStatus,approvalUser)==1)
            return "true";
        return "false";
    }
    @GetMapping("/fuzzyQueryPosts")
    public String fuzzyQueryPosts(String keyWords,Model model){
        List<Post> fuzzyQueryPosts = postService.fuzzyQueryPosts(keyWords);
        System.out.println(keyWords);
//        for(Post post: fuzzyQueryPosts){
//            System.out.println(keyWords);
//            System.out.println(post.toString());
//        }
        model.addAttribute("posts",fuzzyQueryPosts);
        return "testShowPostsInBar";
    }
    @GetMapping("/likePost")
    @ResponseBody
    public String likePost(int postId){
        postService.likePost(postId);
        System.out.println(postService.getLikes(postId));
        return ""+postService.getLikes(postId);
    }
    @GetMapping("/showPostsByAnimalsId")
    public String showPostsByAnimalsId( int id,Model model){
        model.addAttribute("posts",postService.showPostsByAnimalsId(id));
        return "testShowPostsInBar";
    }
    @GetMapping("/goBar")
    public String goBar(){
        return "testBar";
    }
    @GetMapping("/goDetails")
    public String goDetails(int postId,Model model){
        postService.showPostById(postId);
        model.addAttribute("posts",postService.showPostById(postId));
        return "testDetails";
    }
    @GetMapping("/fuzzyQueryPostsAndAnimalsId")
    public String fuzzyQueryPostsByKeyWordsAndAnimalsId(String keyWords,int id,Model model){
        List<Post> fuzzyQueryPostsAndAnimalsId = postService.fuzzyQueryPostsAndAnimalsId(keyWords,id);
        model.addAttribute("posts",fuzzyQueryPostsAndAnimalsId);
        return "testShowPostsInBar";
    }
    @GetMapping("/showMyPosts")
    public String showMyPosts(Model model,HttpServletRequest request){
        model.addAttribute("posts",postService.showMyPosts((String) request.getSession().getAttribute("user")));
        return "testShowMyPosts";
    }
    @GetMapping("/getPostCounts")
    @ResponseBody
    public String getPostCounts(){
        return ""+postService.getPassCounts();
    }
}
