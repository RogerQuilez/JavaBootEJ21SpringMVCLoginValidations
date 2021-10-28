package es.curso.babel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.curso.babel.model.service.UsuarioService;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService userService;
	
	@GetMapping("")
	public String getLogin() {
		return "login";
	}

	@PostMapping("login")
	public String login(@RequestParam("username") String username, 
			@RequestParam("password") String password, Model model) {

		if (userService.isUsuarioRegistered(username, password)) {
			return "redirect:/videojuegos";
		} else {
			model.addAttribute("error", "Unknown user, please try again");
			return "login";
		}

	}

}
