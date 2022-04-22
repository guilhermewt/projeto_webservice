package com.webserviceproject.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.webserviceproject.entities.Usuario;
import com.webserviceproject.repositorios.UsuarioRepositorio;
import com.webserviceproject.services.exceptions.DataBaseException;
import com.webserviceproject.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepositorio repositorio;
	

	public List<Usuario> findAll() {
		return repositorio.findAll();
	}

	public Usuario findById(long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Usuario insert(Usuario obj) {
		return repositorio.save(obj);
	}

	public void delete(long id) {
		try {
			findById(id);
			repositorio.deleteById(id);
		}

		catch (EmptyResultDataAccessException e) {
			throw new DataBaseException(e.getMessage());
		}

		catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	public Usuario update(Usuario obj) {
		try {
		   Usuario user = repositorio.getOne(obj.getId());
		   atualizarUsuario(user,obj);
		   return repositorio.save(user);
		}
		
		catch(EntityNotFoundException e) {
			throw new DataBaseException(e.getMessage());
		}
		
		
	}

	private void atualizarUsuario(Usuario user, Usuario obj) {
		user.setNome(obj.getNome());
		user.setEmail(obj.getEmail());
		user.setTelefone(obj.getTelefone());
		user.setSenha(obj.getSenha());

	}
}
