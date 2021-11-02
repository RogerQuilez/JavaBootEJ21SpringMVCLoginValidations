package es.curso.babel.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.curso.babel.model.entity.Videojuego;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Integer> {
}
