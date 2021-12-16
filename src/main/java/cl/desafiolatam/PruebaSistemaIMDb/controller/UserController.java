package cl.desafiolatam.PruebaSistemaIMDb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.desafiolatam.PruebaSistemaIMDb.model.Usuario;
import cl.desafiolatam.PruebaSistemaIMDb.service.UserService;


@Controller
public class UserController {
	
	
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	
	@GetMapping("/register")
	public ModelAndView signup() {
		return new ModelAndView("register");
	}

	@PostMapping("/register")
	public String  registro(Model model,@ModelAttribute("usuario") Usuario usuario) {
		System.out.println("Usuario registrado"+usuario.toString());
		if(userService.signup(usuario)==true) {
			return "redirect:/register?exito=true";
		}
		else {
			return "redirect:/register?error=true";
		}
	
		
	}
}
