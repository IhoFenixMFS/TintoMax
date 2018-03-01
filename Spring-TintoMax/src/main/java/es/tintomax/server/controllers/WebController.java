package es.tintomax.server.controllers;

import java.util.List;

import es.tintomax.server.jpa.Ticket;
import es.tintomax.server.repositories.TicketRepository;
import es.tintomax.server.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.tintomax.server.jpa.User;
import es.tintomax.server.repositories.TestRepository;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class WebController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
	private TicketRepository ticketRepository;

	@RequestMapping("/home")
	public String home(Model model) {

		return "home";
	}
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String home(Model model,HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    	String name = auth.getName(); //get logged in username
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("username",name);

		return "home";
	}

	@RequestMapping("/")
	public String index(Model model) {

		

		//	model.addAttribute("name", "World");

		return "home";
	}
	@RequestMapping(value="/servicios_cliente",method = RequestMethod.GET)
	public String servicios_cliente(Model model,HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    	String name = auth.getName(); //get logged in username
	    	model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("username",name);


		return "servicios_cliente";
	}
	
	@RequestMapping(value="/datos_usuario",method = RequestMethod.GET)
	public String datos_cliente(Model model,HttpServletRequest request) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    	String name = auth.getName(); //get logged in username
	    	model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("username",name);

		return "datos_usuario";
	}
	@RequestMapping("/login")
	public String login(Model model) {

	//	model.addAttribute("name", "World");

		return "login";
	}
	@RequestMapping(value="/listado_precios",method = RequestMethod.GET)
	public String precios(Model model,HttpServletRequest request) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    	String name = auth.getName(); //get logged in username
	    	model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("username",name);

		return "listado_precios";
	}
	@RequestMapping(value="/administracion",method = RequestMethod.GET)
	public String administracion(Model model,HttpServletRequest request) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    	String name = auth.getName(); //get logged in username
	    	model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("username",name);

		return "administracion";
	}
	
}
