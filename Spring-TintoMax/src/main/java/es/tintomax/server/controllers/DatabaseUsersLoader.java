package es.tintomax.server.controllers;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.tintomax.server.jpa.User;
import es.tintomax.server.repositories.UserRepository;

@Component
public class DatabaseUsersLoader {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void initDatabase() {
    	//userRepository.save(new User("user", "pass", "ROLE_USER"));
    	//userRepository.save(new User("ROLE_ADMIN", "50555500","apellido","calle",666,"mymail@gmail.com", new Date(23,12,1989),"password"));
		//userRepository.save(new User("admin", "adminpass", "ROLE_USER", "ROLE_ADMIN"));
    }

}
