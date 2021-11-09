package com.ft.animalshelter.service;

import com.ft.animalshelter.pojo.Bodhisattva;
import com.ft.animalshelter.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> queryAll();
    public User queryByUsername(String username);
    public User login(String username,String password);
    public User username_exist(String username);
    public int goSignUp(User user);
    public int getCounts();
    public int getPosition(String username);
    public void donation(Bodhisattva bodhisattva);
    public int followOrNotFollow(int animalsId,String username);//是否关注了
    public void followAnimals(int animalsId,String username);//添加对动物的关注
    public void dontFollowAnimals(int animalsId,String username);//取消对动物的关注
    public String getAvator(String username);//根据username获取头像
    public void updatePosition(String username,int position);//根据username改变用户的身份
    public int getDonationID();//获取捐款id
    public List<Bodhisattva> getDonationDetails();
    public List<Bodhisattva> showMyDonation(String username);
    public void useDonation(String useDetails,int donationID);
    public List<User> fuzzyQueryUser(String keyWords);
    public int getDonationCounts();//获取捐款总金额
    public List<String> getTopFiveBodhisattvaName();//获得前五菩萨榜的名字
    public List<Integer> getTopFiveBodhisattvaMoney();//获得前五菩萨榜的捐款数额
    public List<Bodhisattva> getTopFiveBodhisattva();//获取前五的捐助
}
