package com.webserviceproject.configuracao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.webserviceproject.entities.Usuario;
import com.webserviceproject.repositorios.UsuarioRepositorio;

@Configuration
public class config implements CommandLineRunner{

	@Autowired
	private UsuarioRepositorio repositorio;
	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "gabriel", "gabriel@gmail", "339333", "12345");
		Usuario u2 = new Usuario(null, "pedro", "pedro@gmail", "31233", "54321");
		
		repositorio.saveAll(Arrays.asList(u1,u2));
	}
}
