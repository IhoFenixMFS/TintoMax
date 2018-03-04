package es.tintomax.server.controllers;

import es.tintomax.server.jpa.User;
import es.tintomax.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;

@Component
public class DataBaseLoader {

    @Autowired private UserRepository userRepository;

    @PostConstruct
    public void init(){
    	// User user1 =  new User("o", "Omi", "Fernandez", "Calle Tulipan s/n", "marina@marina", Calendar.getInstance(), 1234 ,"1234", "ROLE_ADMIN");

        //Para poder guardar los datos primero se crea el objeto "user1" de la clase 1 y se inicializa con los valores de cada campo.
        User user1 =  new User("123456V", "Marina", "Fernandez", "Calle Tulipan s/n", "marina@marina", Calendar.getInstance(), 1234 ,"1234", "ROLE_ADMIN");
        User user2 =  new User("987641V", "Ana", "Fernandez", "Calle Tulipan s/n", "ana@marina", Calendar.getInstance(), 2222,"1234", "ROLE_EMPLOYEE");
        User user3 =  new User("0000000V", "Juan", "Fernandez", "Calle Tulipan s/n", "juan@marina", Calendar.getInstance(), 33333, "1234", "ROLE_CLIENT");
        User user4 =  new User("1234563A", "Luis", "Fernandez", "Calle Tulipan s/n", "luis@marina", Calendar.getInstance(), 44444, "1234", "ROLE_CLIENT");
        
        //posteriormente, para almacenarlo, con el este método se le pasa el obj antes creado del tipo user.
      
        if(userRepository.findByDni("123456V")==null)
        	userRepository.save(user1);
        if(userRepository.findByDni("987641V")==null)
	        userRepository.save(user2);
        if(userRepository.findByDni("0000000V")==null)
	        userRepository.save(user3);
        if(userRepository.findByDni("1234563A")==null)
	        userRepository.save(user4);
	     	
    }
}