package es.tintomax.server.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class MiController {

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
	@RequestMapping("/servicios_cliente")
	public String servicios_cliente(Model model) {

	//	model.addAttribute("name", "World");

		return "servicios_cliente";
	}
	
	@RequestMapping("/datos_cliente")
	public String datos_cliente(Model model) {

	//	model.addAttribute("name", "World");

		return "datos_cliente";
	}
	@RequestMapping("/login")
	public String login(Model model) {

	//	model.addAttribute("name", "World");

		return "login";
	}
	@RequestMapping("/listado_precios")
	public String precios(Model model) {

	//	model.addAttribute("name", "World");

		return "listado_precios";
	}
	
}
