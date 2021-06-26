package com.ft.animalshelter.mapper;

import com.ft.animalshelter.pojo.Animals;
import com.ft.animalshelter.pojo.Bodhisattva;
import com.ft.animalshelter.pojo.User;
import com.ft.animalshelter.pojo.Post;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    public List<User> queryAll();
    public User queryByUsername(String username);//根据用户名查询用户
    public User login(String username,String password);//登录验证
    public User username_exist(String username);//检查用户名是否存在
    public int goSignUp(User user);
    public int getCounts();
    public int followOrNotFollow(int animalsId,String username);//是否关注了
    public void followAnimals(int animalsId,String username);//添加对动物的关注
    public void dontFollowAnimals(int animalsId,String username);//取消对动物的关注
    public int getPosition(String username);//获得用户的身份
    public void donation(Bodhisattva bodhisattva);//捐赠
    public List<String> getTopFiveBodhisattvaName();//获得前五菩萨榜的名字
    public List<Integer> getTopFiveBodhisattvaMoney();//获得前五菩萨榜的捐款数额
    public List<Post> showMyPosts(String username);//根据username获取到发布的帖子
    public List<Animals> showMyFollowAnimals(String username);//根据username获取到我关注的动物
    public List<Bodhisattva> showMyDonation(String username);//根据username获取我的捐赠记录
    public int getMyDonationCounts(String username);//获取我的捐赠总次数
    public int getMyDonationMoney(String money);//获取我的捐赠总金额
    public String getAvator(String username);//根据username获取头像
    public void updatePosition(String username,int position);//根据username改变用户的身份
    public int getDonationID();
    public List<Bodhisattva> getDonation();
    public void useDonation(String useDetails,int donationID);
    public List<User> fuzzyQueryUser(String keyWords);//根据用户名模糊查询
    public int getDonationCounts();
}
