package com.ft.animalshelter.service.Impls;

import com.ft.animalshelter.mapper.UserMapper;
import com.ft.animalshelter.pojo.Bodhisattva;
import com.ft.animalshelter.pojo.User;
import com.ft.animalshelter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> queryAll() {
        return userMapper.queryAll();
    }

    @Override
    public User queryByUsername(String username) {
        return userMapper.queryByUsername(username);
    }

    @Override
    public User login(String username, String password) {
       return userMapper.login(username,password);
    }

    @Override
    public User username_exist(String username) {
        return userMapper.username_exist(username);
    }

    @Override
    public int goSignUp(User user) {
        return userMapper.goSignUp(user);
    }

    @Override
    public int getCounts() {
        return userMapper.getCounts();
    }

    @Override
    public int getPosition(String username) {
        return userMapper.getPosition(username);
    }

    @Override
    public void donation(Bodhisattva bodhisattva) {
        userMapper.donation(bodhisattva);
    }

    @Override
    public int followOrNotFollow(int animalsId, String username) {
        return userMapper.followOrNotFollow(animalsId,username);
    }

    @Override
    public void followAnimals(int animalsId, String username) {
        userMapper.followAnimals(animalsId,username);
    }

    @Override
    public void dontFollowAnimals(int animalsId, String username) {
    userMapper.dontFollowAnimals(animalsId, username);
    }

    @Override
    public String getAvator(String username) {
        return userMapper.getAvator(username);
    }

    @Override
    public void updatePosition(String username, int position) {
        userMapper.updatePosition(username,position);
    }

    @Override
    public int getDonationID() {
        return userMapper.getDonationID();
    }

    @Override
    public List<Bodhisattva> getDonationDetails() {
        return userMapper.getDonation();
    }

    @Override
    public List<Bodhisattva> showMyDonation(String username) {
        return userMapper.showMyDonation(username);
    }

    @Override
    public void useDonation(String useDetails, int donationID) {
        userMapper.useDonation(useDetails,donationID);
    }

    @Override
    public List<User> fuzzyQueryUser(String keyWords) {
        return userMapper.fuzzyQueryUser(keyWords);
    }

    @Override
    public int getDonationCounts() {
        return userMapper.getDonationCounts();
    }

    @Override
    public List<String> getTopFiveBodhisattvaName() {
        return userMapper.getTopFiveBodhisattvaName();
    }

    @Override
    public List<Integer> getTopFiveBodhisattvaMoney() {
        return userMapper.getTopFiveBodhisattvaMoney();
    }

    @Override
    public List<Bodhisattva> getTopFiveBodhisattva() {
        return userMapper.getTopFiveBodhisattva();
    }


}
