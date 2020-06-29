package com.serv.worldmap.web.magazine;

import com.serv.worldmap.model.Magazine;
import com.serv.worldmap.service.MagazineService;
import com.serv.worldmap.web.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.serv.worldmap.util.ValidationUtil.assureIdConsistent;
import static com.serv.worldmap.util.ValidationUtil.checkNew;


public abstract class AbstractMagazineController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MagazineService service;

    public Magazine get(int id) {
        int userId = SecurityUtil.authUserId();
        log.info("get magazine {} for user{}", id, userId);
        return service.get(id, userId);
    }

    public void delete(int id) {
        int userId = SecurityUtil.authUserId();
        log.info("delete magezine {} for user {}", id, userId);
        service.delete(id, userId);
    }

    public List<Magazine> getAll() {
        int userId = SecurityUtil.authUserId();
        log.info("getAll for user {}", userId);
        return service.getAll(userId);
    }

    public Magazine create(Magazine magazine) {
        int userId = SecurityUtil.authUserId();
        checkNew(magazine);
        log.info("create {} for user {}", magazine, userId);
        return service.create(magazine, userId);
    }

    public void update(Magazine magazine, int id) {
        int userId = SecurityUtil.authUserId();
        assureIdConsistent(magazine, id);
        log.info("update {} for user {}", magazine, userId);
        service.update(magazine, id);
    }
}
