package com.serv.worldmap.service;

import com.serv.worldmap.model.Magazine;
import com.serv.worldmap.repository.MagazineRepositoryImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.serv.worldmap.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MagazineService {
    private final MagazineRepositoryImpl repository;

    public MagazineService(MagazineRepositoryImpl repository) {
        this.repository = repository;
    }
    public Magazine get(int id, int userId){
        return checkNotFoundWithId(repository.get(id, userId), id);
    }
    public void delete (int id, int userId){
        checkNotFoundWithId(repository.delate(id, userId), id);
    }
    public List<Magazine>getAll(int userId){
        return repository.getAll(userId);
    }
    public void  update(Magazine magazine, int userId){
        Assert.notNull(magazine, "magazine must not be null");
        checkNotFoundWithId(repository.save(magazine, userId), magazine.getId());
    }
    public Magazine create(Magazine magazine, int userId){
        Assert.notNull(magazine, "magazine must not be null");
        return repository.save(magazine, userId);
    }
}
