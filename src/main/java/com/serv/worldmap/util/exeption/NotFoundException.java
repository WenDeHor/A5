package com.serv.worldmap.util.exeption;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String messege){
        super(messege);
    }
}
