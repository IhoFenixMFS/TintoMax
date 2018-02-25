<<<<<<< HEAD:Spring-TintoMax/src/main/java/es/tintomax/controllers/MiController.java
package es.tintomax.controllers;
=======
package es.intomax.server.controllers;
>>>>>>> cbef667f508a85267a2a01e8190122f844746f9f:Spring-TintoMax/src/main/java/es/intomax/server/controllers/MiController.java

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MiController {

	@RequestMapping("/home")
	public String home(Model model) {

	//	model.addAttribute("name", "World");

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