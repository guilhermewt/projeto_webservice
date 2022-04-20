package com.webserviceproject.services;

import java.util.List;
import java.util.Optional;
import java.util.function.ObjDoubleConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webserviceproject.entities.Usuario;
import com.webserviceproject.repositorios.UsuarioRepositorio;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepositorio repositorio;
	
	public List<Usuario> findAll(){
		return repositorio.findAll();
	}
	
	public Usuario findById(long id) {
		Optional<Usuario> obj =  repositorio.findById(id);
		return obj.get();
	}
	
	public Usuario insert(Usuario obj) {
		return repositorio.save(obj);
	}
	
	public void delete(long id) {
		 repositorio.deleteById(id);
	}
	
	public Usuario update(Usuario obj) {
		Usuario user = repositorio.getOne(obj.getId());
		atualizarUsuario(user,obj);
		return repositorio.save(user);
	}

	private void atualizarUsuario(Usuario user, Usuario obj) {
		user.setNome(obj.getNome());
		user.setEmail(obj.getEmail());
		user.setTelefone(obj.getTelefone());
		user.setSenha(obj.getSenha());
		
	}
}
