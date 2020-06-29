package com.serv.worldmap.repository;

import com.serv.worldmap.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl {
    private static final Sort SORT_ID = Sort.by(Sort.Direction.ASC, "id");
    @Autowired
    private UserDataJpaRepository repository;

    public User save(User user) {
        return repository.save(user);
    }

    public boolean delate(int id) {
        return repository.delete(id) != 0;
    }
    public User get(int id){
        return repository.findById(id).orElse(null);
    }

    public User getByEmail(String email){
        return repository.getByEmail(email);
    }

    public List<User>getAll(){
        return repository.findAll(SORT_ID);
    }
}
