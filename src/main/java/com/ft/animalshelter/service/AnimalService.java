package com.ft.animalshelter.service;

import com.ft.animalshelter.pojo.Animals;
import com.ft.animalshelter.pojo.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public interface AnimalService {
    public List<Animals> queryAll();
    public Animals queryById(int id);
    public void addAnimal(Animals animals);
    public int getCounts();
    public int getPassCounts();
    public List<Animals> showAnimals();//展示未审核的动物
    public List<Animals> showPassAnimals();//展示通过审核动物
    public List<Animals> showDontPassAnimals();//展示未通过审核的动物
    public int approvalAnimals(int id,int approvalStatus,String approvalUsername);//审核贴子改变数据库里的状态
    public List<Animals> fuzzyQueryAnimals(String keyWords);//模糊查询动物
    public List<String> getAnimalsPicWall(int id);//根据动物id获取到照片墙
    public HashMap<String,String> getNameAndPic(int id);//根据动物id获取name和pic
    public List<Animals> showMyFollowAnimals(String username);
}
