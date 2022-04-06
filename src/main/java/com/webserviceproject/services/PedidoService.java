package com.webserviceproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webserviceproject.entities.Pedido;
import com.webserviceproject.repositorios.PedidoRepositorio;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepositorio repositorio;
	
	public List<Pedido> findAll(){
		return repositorio.findAll();
	}
}
