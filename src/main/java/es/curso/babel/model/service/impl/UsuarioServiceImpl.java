package es.curso.babel.model.service.impl;

import java.util.List;

import es.curso.babel.model.entity.Usuario;
import es.curso.babel.model.service.UsuarioService;
import es.curso.babel.repository.UsuarioRepository;
import es.curso.babel.repository.impl.UsuarioRepositoryImpl;

public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioRepository userRepo = new UsuarioRepositoryImpl();

	@Override
	public List<Usuario> getAllUsuarios() {
		return userRepo.getAllUsuarios();
	}

	@Override
	public boolean isUsuarioRegistered(String username, String password) {
		return userRepo.isUsuarioRegistered(username, password);
	}

}
