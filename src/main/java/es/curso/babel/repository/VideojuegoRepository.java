package es.curso.babel.repository;

import java.util.List;

import es.curso.babel.model.entity.Videojuego;

public interface VideojuegoRepository {

	List<Videojuego> getAllVideojuegos();
	Videojuego findVideojuegoById(int id);
}
