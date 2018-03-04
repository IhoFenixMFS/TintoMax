package es.tintomax.server.controllers;

import es.tintomax.server.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class WebController {

    @Autowired
    private UserRepository userRepository;
    

	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String home(Model model,HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
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
	    String name = auth.getName(); //get logged in username
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
	public String servicios_cliente(Model model,HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
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
	public String datos_cliente(Model model,HttpServletRequest request) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
	    model.addAttribute("employee", request.isUserInRole("EMPLOYEE"));
	    model.addAttribute("client", request.isUserInRole("CLIENT"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user",(request.isUserInRole("EMPLOYEE")||
				request.isUserInRole("CLIENT")||
				request.isUserInRole("ADMIN")));
		model.addAttribute("username",name);

		return "datos_usuario";
	}
	@RequestMapping("/login")
	public String login(Model model) {


		return "login";
	}
	@RequestMapping(value="/listado_precios",method = RequestMethod.GET)
	public String precios(Model model,HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
	    model.addAttribute("employee", request.isUserInRole("EMPLOYEE"));
	    model.addAttribute("client", request.isUserInRole("CLIENT"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user",(request.isUserInRole("EMPLOYEE")||
				request.isUserInRole("CLIENT")||
				request.isUserInRole("ADMIN")));
		model.addAttribute("username",name);

		return "listado_precios";
	}
	@RequestMapping(value="/administracion",method = RequestMethod.GET)
	public String administracion(Model model,HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
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
	    String name = auth.getName(); //get logged in username
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
