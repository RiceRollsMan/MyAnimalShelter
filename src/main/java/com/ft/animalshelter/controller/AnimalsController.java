package com.ft.animalshelter.controller;

import com.ft.animalshelter.pojo.Animals;
import com.ft.animalshelter.pojo.Post;
import com.ft.animalshelter.pojo.User;
import com.ft.animalshelter.service.AnimalService;
import com.ft.animalshelter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/animals")
public class AnimalsController {
    @Autowired
    public AnimalService animalService;
    @RequestMapping("/queryAll")
    @ResponseBody
    public String queryAllAnimals(){
        for(Animals animals: animalService.queryAll()){
            System.out.println(animals.toString());
        }
        return animalService.queryAll().toString();
    }
    @RequestMapping("/queryById/{id}")
    @ResponseBody
    public String queryById(@PathVariable("id") int id){
        return animalService.queryById(id).toString();
    }
    @GetMapping("/toAnimals")
    @ResponseBody
    public String toAnimals(
            String animalName,
            int gender,
            String avatorUrl,
            int varietyId,
            String introduction,
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String uploadUsername= (String) request.getSession().getAttribute("user");
        int id=animalService.getCounts();//从0开始
        Animals animals = new Animals(id,uploadUsername,animalName,gender,avatorUrl,varietyId,introduction);
        request.setAttribute("animals",animals);
        request.getRequestDispatcher("/animals/releaseAnimals").include(request,response);
        System.out.println("测试");
        return "true";
    }
    @GetMapping("/releaseAnimals")
    public void releaseAnimals(HttpServletRequest request,HttpServletResponse response){
        animalService.addAnimal((Animals) request.getAttribute("animals"));
    }

    @GetMapping("/showAnimals")
    public String showAnimals(Model model){
        List<Animals> animals = animalService.showAnimals();
        model.addAttribute("animals",animals);
        return "showAnimals";
    }
    @GetMapping("/showPassAnimals")
    public String showPassAnimals(Model model){
        List<Animals> passAnimals = animalService.showPassAnimals();
        model.addAttribute("passAnimals",passAnimals);
        return "showPassAnimals";
    }
    @GetMapping("/showDontPassAnimals")
    public String showDontPassAnimals(Model model){
        List<Animals> dontPassAnimals = animalService.showDontPassAnimals();
        model.addAttribute("dontPassAnimals",dontPassAnimals);
        return "showDontPassAnimals";
    }
    @GetMapping("/approvalAnimals")
    @ResponseBody
    public String approvalAnimals(int id,int approvalStatus,HttpServletRequest request){
//        System.out.println("1");
        String approvalUsername= (String) request.getSession().getAttribute("user");
//        System.out.println(approvalUser);
        if(animalService.approvalAnimals(id,approvalStatus,approvalUsername)==1)
            return "true";
        return "false";
    }
    @GetMapping("/fuzzyQueryAnimals")
    public String fuzzyQueryAnimals(String keyWords,Model model){
        List<Animals> fuzzyQueryAnimals = animalService.fuzzyQueryAnimals(keyWords);
        System.out.println(keyWords);
        for(Animals animals:fuzzyQueryAnimals){
            System.out.println(animals.toString());
        }
        model.addAttribute("fuzzyQueryAnimals",fuzzyQueryAnimals);
//        System.out.println(model.getAttribute("fuzzyQueryAnimals"));
        return "testIframeShowAnimalsIdCard";
    }
    @GetMapping("/getAnimalsPicWall")
    public String getAnimalsPicWall(int id,Model model){
        List<String> animalsPicWall = animalService.getAnimalsPicWall(id);
        model.addAttribute("animalsPicWall",animalsPicWall);
        return "animalsPicWall";
    }
    @GetMapping("/animalPicWall")
    public String animalPicWall(int id,Model model){
        model.addAttribute("picWallUrl",animalService.getAnimalsPicWall(id));
        for (String string:animalService.getAnimalsPicWall(id)){
            System.out.println(string);
        }
        return "testPicWall";
    }
//    @RequestMapping("/getPicWallInfo")
//    @ResponseBody
//    public String getPicWallInfo( int id){
//        return animalService.queryById(id).getAvatorUrl()+";"+animalService.queryById(id).getAnimalName();
//    }
    @GetMapping("/getNameAndPic")
    @ResponseBody
    public String getNameAndPic(int id){
        System.out.println(animalService.getNameAndPic(id).get("animalName")+";"+animalService.getNameAndPic(id).get("avatorUrl"));
        return animalService.getNameAndPic(id).get("animalName")+";"+animalService.getNameAndPic(id).get("avatorUrl");
    }
    @GetMapping("/showMyFollowAnimals")
    public String showMyFollowAnimals(Model model,HttpServletRequest request){
       System.out.println(animalService.showMyFollowAnimals((String) request.getSession().getAttribute("user")).toString());
        model.addAttribute("myFollowAnimals",animalService.showMyFollowAnimals((String) request.getSession().getAttribute("user")));
        return "showMyFollowAnimals";
    }
    @RequestMapping("/getAnimalCounts")
    @ResponseBody
    public String getAnimalCounts(){
        return ""+animalService.getPassCounts();
    }
}
