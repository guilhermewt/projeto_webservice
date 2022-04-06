package com.webserviceproject.entities.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webserviceproject.entities.Categoria;
import com.webserviceproject.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping
	public ResponseEntity<List<Categoria>> findAll(){
		List<Categoria> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
