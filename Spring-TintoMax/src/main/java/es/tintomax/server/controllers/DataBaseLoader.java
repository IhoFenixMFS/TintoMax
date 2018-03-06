package es.tintomax.server.controllers;

import es.tintomax.server.jpa.Ticket;
import es.tintomax.server.jpa.User;
import es.tintomax.server.repositories.TicketRepository;
import es.tintomax.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@Component
public class DataBaseLoader {

    @Autowired private UserRepository userRepository;
    @Autowired private TicketRepository ticketRepository;
    @PostConstruct
    public void init(){
    	// User user1 =  new User("o", "Omi", "Fernandez", "Calle Tulipan s/n", "marina@marina", Calendar.getInstance(), 1234 ,"1234", "ROLE_ADMIN");

        //Para poder guardar los datos primero se crea el objeto "user1" de la clase 1 y se inicializa con los valores de cada campo.
        User user1 =  new User("123456V", "Marina", "Fernandez", "Calle Tulipan s/n", "marina@marina", Calendar.getInstance(), 1234 ,"1234", "ROLE_ADMIN");
        User user2 =  new User("987641V", "Ana", "Fernandez", "Calle Tulipan s/n", "ana@marina", Calendar.getInstance(), 2222,"1234", "ROLE_EMPLOYEE");
        User user3 =  new User("0000000V", "Juan", "Fernandez", "Calle Tulipan s/n", "juan@marina", Calendar.getInstance(), 33333, "1234", "ROLE_CLIENT");
        User user4 =  new User("1234563A", "Luis", "Fernandez", "Calle Tulipan s/n", "luis@marina", Calendar.getInstance(), 44444, "1234", "ROLE_CLIENT");
        if(userRepository.findByDni("123456V")==null)
        	user1=userRepository.save(user1);
        user1=userRepository.findByDni("123456V");
        if(userRepository.findByDni("987641V")==null)
	        user2=userRepository.save(user2);
        user2=userRepository.findByDni("987641V");
        if(userRepository.findByDni("0000000V")==null)
	        user3=userRepository.save(user3);
        user3=userRepository.findByDni("0000000V");
        if(userRepository.findByDni("1234563A")==null)
	        user4=userRepository.save(user4);
        user4=userRepository.findByDni("1234563A");
        
        
        
        
        
        
        Ticket t1= new Ticket (user3, 2, LocalDate.now().toString(), LocalDate.now().toString(), LocalDate.now().toString(), 11.1,"Pendiente");
        Ticket t2= new Ticket (user3, 1, LocalDate.now().toString(), LocalDate.now().toString(), LocalDate.now().toString(), 12.2,"Pendiente");
        Ticket t3= new Ticket (user3, 1, LocalDate.now().toString(), LocalDate.now().toString(), LocalDate.now().toString(), 13.3,"Listo");
        Ticket t4= new Ticket (user3, 1, LocalDate.now().toString(), LocalDate.now().toString(), LocalDate.now().toString(), 14.4,"Recogido");
        Ticket t5= new Ticket (user3, 1, LocalDate.now().toString(), LocalDate.now().toString(), LocalDate.now().toString(), 15.5,"Recogido");
        
       /*ticketRepository.save(t1);
       ticketRepository.save(t2);
       ticketRepository.save(t3);
       ticketRepository.save(t4);
       ticketRepository.save(t5);
       for(int i=0;i<25;i++)
    	   ticketRepository.save(new Ticket (user3, 1, LocalDate.now().toString(), LocalDate.now().toString(), LocalDate.now().toString(), i,"Recogido"));
       for(int i=0;i<25;i++)
    	   ticketRepository.save(new Ticket (user3, 1, LocalDate.now().toString(), LocalDate.now().toString(), LocalDate.now().toString(), i,"Listo"));
    */
    }
}