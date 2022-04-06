package com.webserviceproject.entities.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webserviceproject.entities.Pedido;
import com.webserviceproject.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService service;
	
	@RequestMapping
	public ResponseEntity<List<Pedido>> findAll(){
		
		List<Pedido> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
