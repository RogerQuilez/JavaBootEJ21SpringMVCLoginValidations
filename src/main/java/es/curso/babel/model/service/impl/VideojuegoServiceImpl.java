package es.curso.babel.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.babel.model.entity.Videojuego;
import es.curso.babel.model.repository.VideojuegoRepository;
import es.curso.babel.model.service.VideojuegoService;

@Service
public class VideojuegoServiceImpl implements VideojuegoService {
	
	@Autowired
	private VideojuegoRepository videoRepo;

	@Override
	public List<Videojuego> getAllVideojuegos() {
		return videoRepo.getAllVideojuegos();
	}

	@Override
	public Videojuego findVideojuegoById(int id) {
		return videoRepo.findVideojuegoById(id);
	}

}
