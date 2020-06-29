package com.serv.worldmap.web.user;


import com.serv.worldmap.model.User;
import com.serv.worldmap.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.serv.worldmap.util.ValidationUtil.assureIdConsistent;
import static com.serv.worldmap.util.ValidationUtil.checkNew;

public abstract class AbstractUserController {
    protected final Logger log= LoggerFactory.getLogger(getClass());
    @Autowired
    private UserService service;

    public User get(int id){
        log.info("user get {}", id);
        return service.get(id);
    }
    public List<User> getAll(){
        log.info("user get all");
        return service.getAll();
    }
    public User create (User user){
        log.info("user create {}", user);
        checkNew(user);
        return service.create(user);
    }
    public void update (User user, int id){
        log.info("user update {} with id={}", user, id);
        assureIdConsistent(user, id);
        service.update(user);
    }
    public User getByMail(String email){
        log.info("getByMail {}", email);
        return service.getByEmail(email);
    }
    public void delete (int id){
        log.info("user delete {}", id);
        service.delete(id);
    }
}
