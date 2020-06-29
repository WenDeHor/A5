package com.serv.worldmap.repository;

import com.serv.worldmap.model.Magazine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class MagazineRepositoryImpl {
    @Autowired
    private MagazineDataJpaRepository magazineRepository;
    @Autowired
    private UserDataJpaRepository userRepository;

    @Transactional
    public Magazine save(Magazine magazine, int userId){
        if(!magazine.isNew()&&get(magazine.getId(), userId)==null){
            return null;
        }
        magazine.setUser(userRepository.getOne(userId));
        return magazineRepository.save(magazine);
    }

    public Magazine get(int id, int userId){
        return magazineRepository.findById(id).filter(magazine -> magazine.getUser().getId()==userId).orElse(null);
    }
    public boolean delate(int id, int userId){
        return magazineRepository.delate(id, userId)!=0;
    }
     public List<Magazine> getAll(int userId){
        return magazineRepository.getAll(userId);
     }
}
