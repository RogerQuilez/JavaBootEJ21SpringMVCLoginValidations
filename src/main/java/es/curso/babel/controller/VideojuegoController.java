package es.curso.babel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

}
