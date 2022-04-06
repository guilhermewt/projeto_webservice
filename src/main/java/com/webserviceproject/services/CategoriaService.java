package com.webserviceproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webserviceproject.entities.Categoria;
import com.webserviceproject.repositorios.CategoriaRepositorio;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepositorio repositorio;
	
	public List<Categoria> findAll(){
		return repositorio.findAll();
	}
}
