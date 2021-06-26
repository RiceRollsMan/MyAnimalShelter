package com.ft.animalshelter.controller;

import com.ft.animalshelter.pojo.Commit;
import com.ft.animalshelter.service.CommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/commit")
public class CommitController {
    @Autowired
    private CommitService commitService;
    @RequestMapping("/toCommit")
    @ResponseBody
    public String toCommit(int postId,String commitContext, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int commitId=commitService.getCounts();
        String commitUser= (String) request.getSession().getAttribute("user");
        request.setAttribute("commit",new Commit(commitId,postId,commitUser,commitContext));
        request.getRequestDispatcher("/commit/commitRelease").include(request,response);
    return "true";
    }
    @RequestMapping("/commitRelease")
    @ResponseBody
    public void commitRelease(HttpServletRequest request,HttpServletResponse response){
        commitService.addCommit((Commit) request.getAttribute("commit"));
    }
    @RequestMapping("/showCommits")
    public String commitRelease(Model model,int postId){
        model.addAttribute("commits",commitService.showCommits(postId));
        System.out.println(commitService.showCommits(postId).toString());
        return "commits";
    }
    @RequestMapping("/likeCommit")
    @ResponseBody
    public String likeCommit(int commitId){
        commitService.likeCommit(commitId);
        return ""+commitService.getCommitLikes(commitId);
    }
}
