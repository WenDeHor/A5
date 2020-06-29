package com.serv.worldmap.web;

import com.serv.worldmap.model.AbstractBaseEntity;

public class SecurityUtil {
    private static int id= AbstractBaseEntity.STAR_SEQ;

    public SecurityUtil() {
    }
    public static int authUserId(){return id;}
    public static void setAuthUserId(int id){
        SecurityUtil.id=id;
    }
}
