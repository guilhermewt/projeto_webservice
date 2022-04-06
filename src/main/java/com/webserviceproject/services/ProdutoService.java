package com.webserviceproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webserviceproject.entities.Produto;
import com.webserviceproject.repositorios.ProdutoRepositorio;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepositorio repositorio;
	
	public List<Produto> findAll(){
		return repositorio.findAll();
	}
}
