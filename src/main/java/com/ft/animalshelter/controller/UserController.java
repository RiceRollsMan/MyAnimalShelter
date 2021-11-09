package com.ft.animalshelter.controller;

import com.ft.animalshelter.pojo.Bodhisattva;
import com.ft.animalshelter.pojo.User;
import com.ft.animalshelter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping("/signup")
    public String signup(){
        return "signup";
    }


    @GetMapping("/goSignUp")
    public void goSignUp(HttpServletRequest request,HttpServletResponse response){
        User user=(User)request.getAttribute("user");
//        System.out.println("到这了");
        userService.goSignUp(user);
    }

    @RequestMapping("/userCounts")
    @ResponseBody
    public String userCounts(){
        System.out.println(userService.getCounts());
        return ""+userService.getCounts();
    }
    @RequestMapping("/queryAll")
    public String queryAllUser(Model model){
        model.addAttribute("allUser",userService.queryAll());
        return "testPosition";
    }

    @RequestMapping("/queryByUsername/{username}")
    @ResponseBody
    public String queryById(@PathVariable("username") String username){
        return userService.queryByUsername(username).toString();
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(String username, String password, HttpServletRequest request){
        HttpSession session= request.getSession();
        if(userService.login(username,password)==null)
            return "false";
        session.setAttribute("user",username);
        return "true";
    }
    @GetMapping("/username_exist")
    @ResponseBody
    public String username_exist(String username){
        if(userService.username_exist(username)==null)
            return "true";//不存在返回true，可以注册
        return "false";//存在返回false，不允许注册
    }
    @GetMapping("/toUser")
    @ResponseBody
    public String toUser(String avatorUrl,
                         String username,
                         String password,
                         int gender,
                        //  Date birth,
                         String mail,
                         int collegeId,
                         String introduction,
                         HttpServletRequest request,
                         HttpServletResponse response
    ) throws ServletException, IOException {
        String msg="false";
        User user=new User(username,password,gender,new Date(),mail,avatorUrl,collegeId,introduction);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/user/goSignUp").include(request,response);
//        System.out.println("wcnm");
        HttpSession session = request.getSession();
        session.setAttribute("user",username);
        msg="true";
        return msg;
    }
    @RequestMapping("/getPosition")
    @ResponseBody
    public int getPosition(HttpServletRequest request){
        System.out.println(userService.getPosition((String) request.getSession().getAttribute("user")));
        return userService.getPosition((String) request.getSession().getAttribute("user"));
    }
    @RequestMapping("/goDonation")
    public String goDonation(int id, Model model){
        model.addAttribute("animalsId",id);
        return "testDonation";
    }
    @RequestMapping("/toBodhisattva")
    @ResponseBody
    public String toBodhisattva(int id,int money,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int donationID=userService.getDonationID();
        request.setAttribute("bodhisattva",new Bodhisattva(donationID,id, (String) request.getSession().getAttribute("user"),money));
        request.getRequestDispatcher("/user/doDonate").include(request,response);
        return "true";
    }
    @RequestMapping("/doDonate")
    public void doDonate(HttpServletRequest request,HttpServletResponse response){
        userService.donation((Bodhisattva) request.getAttribute("bodhisattva"));
    }
    @RequestMapping("/focusOrNot")
    @ResponseBody
    public String focusOrNot(int id, HttpServletRequest request){
        if(userService.followOrNotFollow(id, (String) request.getSession().getAttribute("user"))==0)
            return "关注";
        return "已关注";
    }
    @RequestMapping("/focusOrCancelFocus")
    @ResponseBody
    public String focusOrCancelFocus(int id,HttpServletRequest request){
        if(userService.followOrNotFollow(id, (String) request.getSession().getAttribute("user"))==0){//没关注
            userService.followAnimals(id,(String) request.getSession().getAttribute("user"));
            return "已关注";
        }
        else{
            userService.dontFollowAnimals(id,(String) request.getSession().getAttribute("user"));
        }
        return "关注";

    }
    @RequestMapping("/getUsernameAndAvator")
    @ResponseBody
    public String getUsernameAndAvator(HttpServletRequest request){
        String username= (String) request.getSession().getAttribute("user");
        String avator=userService.getAvator(username);
        return username+";"+avator;
    }
    @RequestMapping("/updatePosition")
    @ResponseBody
    public String updatePosition(String username,int position){
        userService.updatePosition(username,position);
        return "true";
    }
    @RequestMapping("/getDonation")
    public String getDonation(Model model){
        model.addAttribute("donation",userService.getDonationDetails());
        return "testDonationDetails";
    }
    @RequestMapping("/getUserPic")
    @ResponseBody
    public String getUserPic(String username){
        return userService.getAvator(username)+"";
    }
    @RequestMapping("/showMyDonation")
    public String getMyDonation(Model model,HttpServletRequest request){
        model.addAttribute("donation",userService.showMyDonation((String) request.getSession().getAttribute("user")));
        return "showMyDonation";
    }
    @RequestMapping("/useDetails")
    @ResponseBody
    public String useDonation(String useDetails,int donationID){
        userService.useDonation(useDetails,donationID);
        return "true";
    }
    @RequestMapping("/fuzzyQueryUser")
    public String fuzzyQueryUser(Model model,String keyWords){
        model.addAttribute("allUser",userService.fuzzyQueryUser(keyWords));
        return "testPosition";
    }
    @RequestMapping("/getUserCounts")
    @ResponseBody
    public String getUserCounts(){
        return ""+userService.getCounts();
    }
    @RequestMapping("/getDonationCounts")
    @ResponseBody
    public String getDonationCounts(){
        return ""+userService.getDonationCounts();
    }
    @RequestMapping("/getTopFiveBodhisattva")
    public String getTopFiveBodhisattvaName(Model model,HttpServletRequest request,HttpServletResponse response){
        model.addAttribute("getTopFiveBodhisattvaName",userService.getTopFiveBodhisattvaName());
        model.addAttribute("getTopFiveBodhisattvaMoney",userService.getTopFiveBodhisattvaMoney());
        return "testWebBack";
    }
    @RequestMapping("/getDonationTopFive")
    public String  getTopFiveBodhisattva(Model model){
        model.addAttribute("donation",userService.getTopFiveBodhisattva());
        return "testWebBack";
    }

}
