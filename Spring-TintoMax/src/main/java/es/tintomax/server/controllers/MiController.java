package es.tintomax.server.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import es.tintomax.server.jpa.User;
import es.tintomax.server.repositories.UserRepository;

@Controller
public class MiController {
	
	@Autowired
	private UserRepository userRepository;
	

	@RequestMapping("/home")
	public String home(Model model) {

	//	model.addAttribute("name", "World");
		int numpagina=1;
		String cad= " ";
		/*Page<User> users = userRepository.findAll();*/
		//Page<User> users = userRepository.findAll(new PageRequest(numpagina, 10));

		/*List<User> finalUsers = users.getContent();
		for (User user : finalUsers) {
			cad=cad+user.getNombre();
		}*/
		System.out.println(cad);		
				

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