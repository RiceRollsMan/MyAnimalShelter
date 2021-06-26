package com.ft.animalshelter.service.Impls;

import com.ft.animalshelter.mapper.AnimalMapper;
import com.ft.animalshelter.pojo.Animals;
import com.ft.animalshelter.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class AnimalServiceImpl implements AnimalService {
    @Autowired
    private AnimalMapper animalMapper;
    @Override
    public List<Animals> queryAll() {
        return animalMapper.queryAll();
    }

    @Override
    public Animals queryById(int id) {
        return animalMapper.queryById(id);
    }

    @Override
    public void addAnimal(Animals animals) {
        animalMapper.addAnimal(animals);
    }

    @Override
    public int getCounts() {
        return animalMapper.getCounts();
    }

    @Override
    public int getPassCounts() {
        return animalMapper.getPassCounts();
    }

    @Override
    public List<Animals> showAnimals() {
        return animalMapper.showAnimals();
    }

    @Override
    public List<Animals> showPassAnimals() {
        return animalMapper.showPassAnimals();
    }

    @Override
    public List<Animals> showDontPassAnimals() {
        return animalMapper.showDontPassAnimals();
    }

    @Override
    public int approvalAnimals(int id, int approvalStatus, String approvalUsername) {
        return animalMapper.approvalAnimals(id,approvalStatus,approvalUsername);
    }

    @Override
    public List<Animals> fuzzyQueryAnimals(String keyWords) {
        return animalMapper.fuzzyQueryAnimals(keyWords);
    }

    @Override
    public List<String> getAnimalsPicWall(int id) {
        return animalMapper.getAnimalsPicWalls(id);
    }

    @Override
    public HashMap<String, String> getNameAndPic(int id) {
        return animalMapper.getNameAndPic(id);
    }

    @Override
    public List<Animals> showMyFollowAnimals(String username) {
        return animalMapper.showMyFollowAnimals(username);
    }
}
