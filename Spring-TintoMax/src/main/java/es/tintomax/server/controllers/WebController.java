package es.tintomax.server.controllers;

import es.tintomax.server.jpa.Ticket;
import es.tintomax.server.repositories.TicketRepository;
import es.tintomax.server.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class WebController {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private TicketRepository ticketRepository;

	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String home(Model model,HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String dni = auth.getName(); //get logged in username
	    String name="";
	    if(userRepository.findByDni(dni)!=null)
	    	name=userRepository.findByDni(dni).getName();
	    model.addAttribute("employee", request.isUserInRole("EMPLOYEE"));
	    model.addAttribute("client", request.isUserInRole("CLIENT"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user",(request.isUserInRole("EMPLOYEE")||
				request.isUserInRole("CLIENT")||
				request.isUserInRole("ADMIN")));
		model.addAttribute("username",name);

		return "home";
	}

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index(Model model,HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String dni = auth.getName(); //get logged in username
	    String name="";
	    if(userRepository.findByDni(dni)!=null)
	    	name=userRepository.findByDni(dni).getName();
	    model.addAttribute("employee", request.isUserInRole("EMPLOYEE"));
	    model.addAttribute("client", request.isUserInRole("CLIENT"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user",(request.isUserInRole("EMPLOYEE")||
				request.isUserInRole("CLIENT")||
				request.isUserInRole("ADMIN")));
		model.addAttribute("username",name);
		

		return "home";
	}
	@RequestMapping(value="/servicios_cliente",method = RequestMethod.GET)
	public String servicios_cliente(Model model,Pageable page,HttpServletRequest request,@RequestParam(name = "actpage", required = false, defaultValue = "0") Integer actpage,@RequestParam(name = "oldpage", required = false, defaultValue = "0") Integer oldpage) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String dni = auth.getName(); //get logged in username
	    String name="";
	    if(userRepository.findByDni(dni)!=null)
	    	name=userRepository.findByDni(dni).getName();
	    
	     Page<Ticket> oldTickets = ticketRepository.findByUserAndStatus(userRepository.findByDni(dni), "Recogido", new PageRequest(oldpage,10));

	    Page<Ticket> activeTickets = ticketRepository.findActiveByUser(userRepository.findByDni(dni), new PageRequest(actpage,10));

	    //model.addAttribute("readyTickets",readyTickets);
	    //model.addAttribute("pendingTickets",pendingTickets);
	    model.addAttribute("activeTickets",activeTickets);
	    model.addAttribute("oldTickets",oldTickets);
	    model.addAttribute("showNextActive",!activeTickets.isLast());
	    model.addAttribute("showPrevActive",!activeTickets.isFirst());
	    model.addAttribute("showNextOld",!oldTickets.isLast());
	    model.addAttribute("showPrevOld",!oldTickets.isFirst());
	    
	    model.addAttribute("prevActPage",activeTickets.getNumber()-1);
	    model.addAttribute("nextActPage",activeTickets.getNumber()+1);
	    model.addAttribute("prevOldPage",oldTickets.getNumber()-1);
	    model.addAttribute("nextOldPage",oldTickets.getNumber()+1);
	    model.addAttribute("actPage",activeTickets.getNumber());
	    model.addAttribute("oldPage",oldTickets.getNumber());
	    
	    model.addAttribute("employee", request.isUserInRole("EMPLOYEE"));
	    model.addAttribute("client", request.isUserInRole("CLIENT"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user",(request.isUserInRole("EMPLOYEE")||
				request.isUserInRole("CLIENT")||
				request.isUserInRole("ADMIN")));
		model.addAttribute("username",name);


		return "servicios_cliente";
	}
	
	@RequestMapping(value="/datos_usuario",method = RequestMethod.GET)
	public String datos_usuario(Model model,HttpServletRequest request) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String dni = auth.getName(); //get logged in username
	    String name="";
	    if(userRepository.findByDni(dni)!=null)
	    	name=userRepository.findByDni(dni).getName();
	    
	    model.addAttribute("employee", request.isUserInRole("EMPLOYEE"));
	    model.addAttribute("client", request.isUserInRole("CLIENT"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user",(request.isUserInRole("EMPLOYEE")||
				request.isUserInRole("CLIENT")||
				request.isUserInRole("ADMIN")));
		model.addAttribute("username",name);
		model.addAttribute("surname",userRepository.findByDni(dni).getLastNames());
		model.addAttribute("dni",dni);
		model.addAttribute("address",userRepository.findByDni(dni).getAddress());
		model.addAttribute("email",userRepository.findByDni(dni).getEmail());
		return "datos_usuario";
	}
	@RequestMapping(value="/editar_usuario",method = RequestMethod.GET)
	public String editar_usuario(Model model,HttpServletRequest request) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String dni = auth.getName(); //get logged in username
	    String name="";
	    if(userRepository.findByDni(dni)!=null)
	    	name=userRepository.findByDni(dni).getName();
	    model.addAttribute("employee", request.isUserInRole("EMPLOYEE"));
	    model.addAttribute("client", request.isUserInRole("CLIENT"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user",(request.isUserInRole("EMPLOYEE")||
				request.isUserInRole("CLIENT")||
				request.isUserInRole("ADMIN")));
		model.addAttribute("username",name);
		model.addAttribute("surname",userRepository.findByDni(dni).getLastNames());
		model.addAttribute("dni",dni);
		model.addAttribute("address",userRepository.findByDni(dni).getAddress());
		model.addAttribute("email",userRepository.findByDni(dni).getEmail());

		return "editar_usuario";
	}
	@RequestMapping("/login")
	public String login(Model model) {


		return "login";
	}
	@RequestMapping(value="/listado_precios",method = RequestMethod.GET)
	public String precios(Model model,HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String dni = auth.getName(); //get logged in username
	    String name="";
	    if(userRepository.findByDni(dni)!=null)
	    	name=userRepository.findByDni(dni).getName();
	    model.addAttribute("employee", request.isUserInRole("EMPLOYEE"));
	    model.addAttribute("client", request.isUserInRole("CLIENT"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user",(request.isUserInRole("EMPLOYEE")||
				request.isUserInRole("CLIENT")||
				request.isUserInRole("ADMIN")));
		model.addAttribute("username",name);

		return "listado_precios";
	}
	@RequestMapping(value="/error",method = RequestMethod.GET)
	public String loginerror(Model model,HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String dni = auth.getName(); //get logged in username
	    String name="";
	    if(userRepository.findByDni(dni)!=null)
	    	name=userRepository.findByDni(dni).getName();
	    model.addAttribute("employee", request.isUserInRole("EMPLOYEE"));
	    model.addAttribute("client", request.isUserInRole("CLIENT"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user",(request.isUserInRole("EMPLOYEE")||
				request.isUserInRole("CLIENT")||
				request.isUserInRole("ADMIN")));
		model.addAttribute("username",name);

		return "error";
	}
	@RequestMapping(value="/administracion",method = RequestMethod.GET)
	public String administracion(Model model,HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String dni = auth.getName(); //get logged in username
	    String name="";
	    if(userRepository.findByDni(dni)!=null)
	    	name=userRepository.findByDni(dni).getName();
	    model.addAttribute("employee", request.isUserInRole("EMPLOYEE"));
	    model.addAttribute("client", request.isUserInRole("CLIENT"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user",(request.isUserInRole("EMPLOYEE")||
				request.isUserInRole("CLIENT")||
				request.isUserInRole("ADMIN")));
		model.addAttribute("username",name);

		return "administracion";
	}
	@RequestMapping(value="/localizacion",method = RequestMethod.GET)
	public String localizacion(Model model,HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String dni = auth.getName(); //get logged in username
	    String name="";
	    if(userRepository.findByDni(dni)!=null)
	    	name=userRepository.findByDni(dni).getName();
	    model.addAttribute("employee", request.isUserInRole("EMPLOYEE"));
	    model.addAttribute("client", request.isUserInRole("CLIENT"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user",(request.isUserInRole("EMPLOYEE")||
				request.isUserInRole("CLIENT")||
				request.isUserInRole("ADMIN")));
		model.addAttribute("username",name);

		return "localizacion";
	}
}
