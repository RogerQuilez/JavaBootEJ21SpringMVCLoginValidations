package es.curso.babel.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.babel.model.entity.Usuario;
import es.curso.babel.model.repository.UsuarioRepository;
import es.curso.babel.model.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository userRepo;

	@Override
	public List<Usuario> getAllUsuarios() {
		return userRepo.getAllUsuarios();
	}

	@Override
	public boolean isUsuarioRegistered(String username, String password) {
		Usuario user = userRepo.findUsuarioByUsername(username);
		if (user != null) {
			if (user.getUsername().equals(username) &&
					user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

}
