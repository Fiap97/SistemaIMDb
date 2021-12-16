package cl.desafiolatam.PruebaSistemaIMDb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.desafiolatam.PruebaSistemaIMDb.config.CustomAuthenticationSuccessHandler;
import cl.desafiolatam.PruebaSistemaIMDb.model.Show;
import cl.desafiolatam.PruebaSistemaIMDb.model.Usuario;
import cl.desafiolatam.PruebaSistemaIMDb.model.UsuarioShow;
import cl.desafiolatam.PruebaSistemaIMDb.service.ShowService;
import cl.desafiolatam.PruebaSistemaIMDb.service.UserService;
import cl.desafiolatam.PruebaSistemaIMDb.service.UsuarioShowService;

@Controller
public class ShowController {
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private CustomAuthenticationSuccessHandler cash;
	
	@Autowired
	private UsuarioShowService usuarioShowService;
	
	@Autowired
	private ShowService showService;
	
	
	@GetMapping("/admin")
	public ModelAndView homeAdmin(Model model) {
		model.addAttribute("shows", showService.findAll());	
		System.out.println(cash.usuarioConectado());
		model.addAttribute("usuario",cash.usuarioConectado());
		return new ModelAndView("home");
	}
	

	@GetMapping("/users")
	public ModelAndView homeCliente(Model model) {
	model.addAttribute("shows", showService.findAll());	
		System.out.println(cash.usuarioConectado());
		model.addAttribute("usuario",cash.usuarioConectado());
		return new ModelAndView("homeUsers");
	}
	
	
	@GetMapping("/add")
	public ModelAndView add() {
		return new ModelAndView("new");
	}
	
	@PostMapping("/add")
	public ModelAndView add(Model model,@ModelAttribute Show show) {
		showService.create(show);
		model.addAttribute("shows", showService.findAll());	
		model.addAttribute("usuario",cash.usuarioConectado());
		return new ModelAndView("home");
	}
	@GetMapping("/addUsers")
	public ModelAndView addUsers() {
		return new ModelAndView("newUsers");
	}
	
	@PostMapping("/addUsers")
	public ModelAndView addUsers(Model model,@ModelAttribute Show show) {
		showService.create(show);
		model.addAttribute("shows", showService.findAll());	
		model.addAttribute("usuario",cash.usuarioConectado());
		return new ModelAndView("homeUsers");
	}
	

	@GetMapping("/mostrar")
	public ModelAndView mostrar(Model model,@RequestParam(value="id")Long id) {
		Show show;
		show = showService.findById(id);
		model.addAttribute("show",show);
		model.addAttribute("usuariosShow",usuarioShowService.findAll());
		
		return new ModelAndView("show");
	}
	
	@PostMapping("/mostrar")
	public ModelAndView mostrar(Model model,@ModelAttribute UsuarioShow usuarioShow) {
	
		String email;
		email=cash.usuarioConectado();
		Usuario usuario;
		usuario=userService.getUsuarioByEmail(email);
		usuarioShow.setUsuario(usuario);
		usuarioShowService.save(usuarioShow);
		Show show;
		show = showService.findById(usuarioShow.getShow().getId());
		model.addAttribute("show",show);
	//	System.out.println("rating: "+usuarioShow.toString());
		model.addAttribute("usuariosShow",usuarioShowService.findAll());
	/*	for(UsuarioShow usuarioShow2 : usuarioShowService.findAll()) {
			System.out.println("Usuario show: "+usuarioShow2);
		}*/
		return new ModelAndView("show");
	}
	
	@GetMapping("/mostrarUsers")
	public ModelAndView mostrarUsers(Model model,@RequestParam(value="id")Long id) {
		Show show;
		show = showService.findById(id);
		model.addAttribute("show",show);
		model.addAttribute("usuariosShow",usuarioShowService.findAll());
		
		return new ModelAndView("showUsers");
	}
	
	@PostMapping("/mostrarUsers")
	public ModelAndView mostrarUsers(Model model,@ModelAttribute UsuarioShow usuarioShow) {
	
		String email;
		email=cash.usuarioConectado();
		Usuario usuario;
		usuario=userService.getUsuarioByEmail(email);
		usuarioShow.setUsuario(usuario);
		usuarioShowService.save(usuarioShow);
		Show show;
		show = showService.findById(usuarioShow.getShow().getId());
		model.addAttribute("show",show);
	//	System.out.println("rating: "+usuarioShow.toString());
		model.addAttribute("usuariosShow",usuarioShowService.findAll());
	/*	for(UsuarioShow usuarioShow2 : usuarioShowService.findAll()) {
			System.out.println("Usuario show: "+usuarioShow2);
		}*/
		return new ModelAndView("showUsers");
	}
	
	@GetMapping("/edit")
	public ModelAndView edit(Model model,@RequestParam(value="id")Long id) {
		Show show;
		show = showService.findById(id);
		model.addAttribute("show",show);
		return new ModelAndView("edit");
	}
	
	@PostMapping("/edit")
	public ModelAndView edit(Model model,@ModelAttribute Show show) {
		showService.update(show);
		model.addAttribute("shows", showService.findAll());	
		model.addAttribute("usuario",cash.usuarioConectado());
		return new ModelAndView("home");
	}
	
	@GetMapping("/editUsers")
	public ModelAndView editUsers(Model model,@RequestParam(value="id")Long id) {
		Show show;
		show = showService.findById(id);
		model.addAttribute("show",show);
		return new ModelAndView("editUsers");
	}
	
	@PostMapping("/editUsers")
	public ModelAndView editUsers(Model model,@ModelAttribute Show show) {
		showService.update(show);
		model.addAttribute("shows", showService.findAll());	
		model.addAttribute("usuario",cash.usuarioConectado());
		return new ModelAndView("homeUsers");
	}
	
	@GetMapping("/delete")
	public ModelAndView delete(Model model,@RequestParam(value="id")Long id) {
		showService.delete(id);
		model.addAttribute("shows", showService.findAll());	
		model.addAttribute("usuario",cash.usuarioConectado());
		return new ModelAndView("home");
	}
	
	@GetMapping("/deleteUsers")
	public ModelAndView deleteUsers(Model model,@RequestParam(value="id")Long id) {
		showService.delete(id);
		model.addAttribute("shows", showService.findAll());	
		model.addAttribute("usuario",cash.usuarioConectado());
		return new ModelAndView("homeUsers");
	}
}
