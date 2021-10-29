package es.curso.babel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.curso.babel.model.entity.Videojuego;
import es.curso.babel.model.service.VideojuegoService;

@Controller
@RequestMapping("videojuegos")
public class VideojuegoController {
	
	@Autowired
	private VideojuegoService videoService;

	@GetMapping("")
	public ModelAndView getVideojuegos() {
		ModelAndView modelView = new ModelAndView("videojuegos");
		modelView.addObject("videojuegos", videoService.getAllVideojuegos());
		return modelView;
	}
	
	@GetMapping("/videojuegoDetalle")
	public ModelAndView getVideojuegoDetalle(@RequestParam("id") String id) {
		ModelAndView modelView = new ModelAndView("videojuegoDetalle");
		Integer idInt = Integer.parseInt(id);
		modelView.addObject("videojuego", videoService.findVideojuegoById(idInt));
		return modelView;
	}
	
	@GetMapping("/videojuegoDelete")
	public String eliminarVideojuego(@RequestParam("id") String id) {
		videoService.eliminarVideojuego(Integer.parseInt(id));
		return "redirect:/videojuegos";
	}
	
	@GetMapping("/formVideojuego")
	public String getFormVideojuego(@RequestParam(required=false) Integer id, Model model) {
		
		if (id != null) {
			model.addAttribute("videojuego", videoService.findVideojuegoById(id));
		} else {
			model.addAttribute("videojuego", new Videojuego());
		}
		return "formVideojuego";
	}
	
	@PostMapping("/formVideojuego")
	public String newVideojuego(@ModelAttribute("videojuego") Videojuego videojuego, Model model) {
		
		videojuego.setImagen("imagen-default.jpg");
		
		List<String> messages = videoService.añadirVideojuego(videojuego);
		if (messages.get(0) == "Alta correcta") {
			return "redirect:/videojuegos";
		} else {
			model.addAttribute("messages", messages);
			return "formVideojuego";
		}
		
	}

}
