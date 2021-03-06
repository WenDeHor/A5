package com.serv.worldmap.service;

import com.serv.worldmap.model.User;
import com.serv.worldmap.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.serv.worldmap.util.ValidationUtil.checkNotFound;
import static com.serv.worldmap.util.ValidationUtil.checkNotFoundWithId;

@Service
public class UserService {
    private final UserRepositoryImpl repository;

    @Autowired
    public UserService(UserRepositoryImpl repository) {
        this.repository = repository;
    }

    @CacheEvict(value = "users", allEntries = true)
    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return repository.save(user);
    }
    public void delete(int id){
        checkNotFoundWithId(repository.delate(id), id);
    }
    public User get(int id){
        return checkNotFoundWithId(repository.get(id), id);
    }
    public User getByEmail(String email){
        Assert.notNull(email, "email must not be null");
        return checkNotFound(repository.getByEmail(email), "email"+email);
    }
    @Cacheable("users")
    public List<User> getAll(){
        return repository.getAll();
    }
    @CacheEvict(value = "users", allEntries = true)
    public void update(User user){
        Assert.notNull(user, "user must not be null");
        checkNotFoundWithId(repository.save(user), user.getId());
    }
}
