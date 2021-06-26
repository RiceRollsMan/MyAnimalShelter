package com.ft.animalshelter;

import com.ft.animalshelter.mapper.AnimalMapper;
import com.ft.animalshelter.mapper.CommitMapper;
import com.ft.animalshelter.mapper.PostMapper;
import com.ft.animalshelter.mapper.UserMapper;
import com.ft.animalshelter.pojo.Animals;
import com.ft.animalshelter.pojo.Bodhisattva;
import com.ft.animalshelter.pojo.Post;
import com.ft.animalshelter.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class AnimalShelterApplicationTests {
    @Autowired
    private DataSource dataSource;

    @Autowired
    public PostMapper postMapper;

    @Autowired
    public UserMapper userMapper;

    @Autowired
    public AnimalMapper animalMapper;
    @Autowired
    public CommitMapper commitMapper;
    @Autowired
    public PostService postService;
    @Test
    void contextLoads() {
    }
    @Test
    void testDatasource() throws SQLException {
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
    }
    @Test
    void testQueryInt(){
        System.out.println(userMapper.getCounts());
    }
    @Test
    void testPostStatus(){
        System.out.println(postMapper.approvalPost(0,0,"riceRollsSSS"));
    }
    @Test
    void testAddAnimal(){
        animalMapper.addAnimal(new Animals(3,"RiceRollsMan","ft",1,"https://i01piccdn.sogoucdn.com/93f5a1419dbc2e41",1,"xxx"));
    }
    @Test
    void testGetCountsForCommit(){
        System.out.println(commitMapper.getCounts());
    }
    @Test
    void testGetCountsForPost(){
        System.out.println(postMapper.getCounts());
    }
    @Test
    void testGetCommits(){
        System.out.println(commitMapper.showCommits(0));
    }
    @Test
    void testFuzzyQueryPosts(){
        List<Post> posts = postService.fuzzyQueryPosts("123");
        for(Post post: posts){
            System.out.println(post);
        }
    }
    @Test
    void testPostLike(){
        postMapper.likePost(0);
    }
    @Test
    void testGetLikes(){

        System.out.println(postMapper.getLikes(0));
    }
    @Test
    void testFuzzyQueryAnimals(){
        List<Animals> animals = animalMapper.fuzzyQueryAnimals("d");
        for(Animals animalss: animals){
            System.out.println(animalss.toString());
        }
    }
    @Test
    void testFollowAnimal(){
        userMapper.followAnimals(0,"RiceRollsMan");
    }
    @Test
    void testDontFollowAnimal(){
        userMapper.dontFollowAnimals(0,"RiceRollsMan");
    }
    @Test
    void getPosition(){
        System.out.println(userMapper.getPosition("RiceRollsMan"));
    }
    @Test
    void testGetPicWall(){
        for(String picWall:animalMapper.getAnimalsPicWalls(0))
            System.out.println(picWall);
    }
    @Test
    void testDonation(){
        userMapper.donation(new Bodhisattva(0,0,"RiceRollsMaster",2222));
    }
    @Test
    void testGetTopFiveDonationName(){
       for(String string: userMapper.getTopFiveBodhisattvaName()){
           System.out.println(string);
       }
       for (Integer money : userMapper.getTopFiveBodhisattvaMoney()){
           System.out.println(money);
       }
    }
    @Test
    void testShowMyPosts(){
        for (Post post:userMapper.showMyPosts("RiceRollsMaster")){
            System.out.println(post.toString());
        }
    }
    @Test
    void testShowMyFollowAnimals(){
        for (Animals animals:userMapper.showMyFollowAnimals("RiceRollsMaster")){
            System.out.println(animals.toString());
        }
    }
    @Test
    void testShowMyDonation(){
        for (Bodhisattva bodhisattva:userMapper.showMyDonation("RiceRollsMan")){
            System.out.println(bodhisattva.toString());
        }
    }
    @Test
    void testGetMyDonationMoney(){
        System.out.println(userMapper.getMyDonationMoney("RiceRollsMan"));
    }
    @Test
    void testGetMyDonationCounts(){
        System.out.println(userMapper.getMyDonationCounts("RiceRollsMan"));
    }
    @Test
    void testE(){
        System.out.println(userMapper.username_exist("RiceRollsMan"));
    }
    @Test
    void testFollowOrNotFollow(){
        System.out.println(userMapper.followOrNotFollow(0,"RiceRollsMaster"));
    }
    @Test
    void testShowPostByAnimalsId(){
        for (Post post:postMapper.showPostsByAnimalsId(0)){
            System.out.println(post.toString());
        }
    }
    @Test
    void testHashMap(){
        System.out.println(animalMapper.getNameAndPic(0).get("animalName"));
    }
    @Test
    void testFuzzyByAnimalsId(){
//        List<Post> posts = postMapper.fuzzyQueryPostsAndAnimalsId("1",0);
//        System.out.println(posts);
        for (Post post:postMapper.fuzzyQueryPostsAndAnimalsId("1",0)){
            System.out.println(post.toString());
        }
    }
    @Test
    void testGetPosition(){
        System.out.println(userMapper.getPosition("RiceRollsMan"));
    }
    @Test
    void testDonationDeatils(){
        System.out.println(userMapper.getDonation().toString());
    }
    @Test
    void testGetMyFollow(){
        System.out.println(animalMapper.showMyFollowAnimals("RiceRollsMan"));
    }
    @Test
    void testGetAvator(){
        System.out.println(userMapper.getAvator("RiceRollsMan"));
    }
    @Test
    void testUseDonation(){
       userMapper.useDonation("wxx",0);
    }
    @Test
    void testUseFuzzy(){
        System.out.println(userMapper.fuzzyQueryUser("Rice")) ;
    }
    @Test
    void testDonationCounts(){
        System.out.println(userMapper.getDonationCounts()) ;
    }
}
