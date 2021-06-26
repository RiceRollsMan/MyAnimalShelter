package com.ft.animalshelter.mapper;

import com.ft.animalshelter.pojo.Animals;
import com.ft.animalshelter.pojo.Post;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface AnimalMapper {
    public List<Animals> queryAll();//查询所有的信息
    public Animals queryById(int id);//根据id查询对应的动物
    public void addAnimal(Animals animals);//用户提交添加动物申请
    public int getCounts();//获取数目
    public int getPassCounts();//获取数目
    public List<Animals> showAnimals();//展示未审核的动物
    public List<Animals> showPassAnimals();//展示通过审核动物
    public List<Animals> showDontPassAnimals();//展示未通过审核的动物
    public int approvalAnimals(int id,int approvalStatus,String approvalUsername);//审核贴子改变数据库里的状态
    public List<Animals> fuzzyQueryAnimals(String keyWords);//模糊查询动物
    public List<String> getAnimalsPicWalls(int id);//获取某动物的照片墙照片Url
    public HashMap<String, String> getNameAndPic(int id);//根据id获取动物的姓名和头像
    public List<Animals> showMyFollowAnimals(String username);//根据username查看我关注的动物
}
