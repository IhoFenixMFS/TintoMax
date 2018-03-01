package es.tintomax.server.controllers;

import es.tintomax.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataBaseLoader {

    @Autowired private UserRepository userRepository;


    @PostConstruct
    public void init(){

    }
}