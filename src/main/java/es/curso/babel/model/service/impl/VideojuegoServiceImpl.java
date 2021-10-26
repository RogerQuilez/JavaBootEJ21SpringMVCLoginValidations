package es.curso.babel.model.service.impl;

import java.util.List;

import es.curso.babel.model.entity.Videojuego;
import es.curso.babel.model.service.VideojuegoService;
import es.curso.babel.repository.VideojuegoRepository;
import es.curso.babel.repository.impl.VideojuegoRepositoryImpl;

public class VideojuegoServiceImpl implements VideojuegoService {
	
	private VideojuegoRepository videoRepo = new VideojuegoRepositoryImpl();

	@Override
	public List<Videojuego> getAllVideojuegos() {
		return videoRepo.getAllVideojuegos();
	}

	@Override
	public Videojuego findVideojuegoById(int id) {
		return videoRepo.findVideojuegoById(id);
	}

}
