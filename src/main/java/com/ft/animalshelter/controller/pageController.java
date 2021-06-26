package com.ft.animalshelter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class pageController {
    @RequestMapping("/main")
    public String main(){ return "main"; }
    @RequestMapping("/signUpOk")
    public String signUpOk(){
        return "signUpOk";
    }
    @RequestMapping("/test")
    public String test(){
        return "test";
    }
    @RequestMapping("/test2")
    public String test2(){
        return "test2";
    }
    @RequestMapping("/postRelease")
    public String postRelease(HttpServletRequest request){
        return "postRelease";
    }
    @RequestMapping("/animalRelease")
    public String postRelease(){
        return "animalRelease";
    }
    @RequestMapping("/details")
    public String details(){
        return "details";
    }
    @RequestMapping("/commits")
    public String commits(){return "commits";}
    @RequestMapping("/goFuzzyQueryPost")
    public String fuzzyQueryPosts(){return "fuzzyQueryPost";}
    @RequestMapping("/testMain")
    public String goTestMain(){return "testMain";}
    @RequestMapping("/goDonate")
    public String goDonate(){return "testDonation";}
    @RequestMapping("/testBar")
    public String testBar(){
        return "testBar";
    }
    @RequestMapping("/goPerson")
    public String testPerson(){
        return "testPerson";
    }
    @RequestMapping("/goAdminController")
    public String testAdminController(){
        return "testAdminController";
    }
    @RequestMapping("/testPosition")
    public String testPosition(){
        return "testPosition";
    }
    @RequestMapping("/testWebBack")
    public String testWebBack(){
        return "testWebBack";
    }
}
