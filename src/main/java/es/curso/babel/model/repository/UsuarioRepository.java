package es.curso.babel.model.repository;

import java.util.List;

import es.curso.babel.model.entity.Usuario;

public interface UsuarioRepository {

	List<Usuario> getAllUsuarios();
	Usuario findUsuarioByUsername(String username);
}
