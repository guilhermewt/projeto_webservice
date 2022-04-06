package com.webserviceproject.configuracao;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.webserviceproject.entities.Pedido;
import com.webserviceproject.entities.Usuario;
import com.webserviceproject.repositorios.PedidoRepositorio;
import com.webserviceproject.repositorios.UsuarioRepositorio;

@Configuration
public class config implements CommandLineRunner{

	@Autowired
	private UsuarioRepositorio repositorio;
	
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "gabriel", "gabriel@gmail", "339333", "12345");
		Usuario u2 = new Usuario(null, "pedro", "pedro@gmail", "31233", "54321");
		
		repositorio.saveAll(Arrays.asList(u1,u2));
		
		Pedido pedido1 = new Pedido(null,Instant.parse("2019-06-20T19:53:07Z"),u1);
		Pedido pedido2 = new Pedido(null,Instant.parse("2022-04-05T16:16:45Z"),u2);
		
		pedidoRepositorio.saveAll(Arrays.asList(pedido1,pedido2));
	}
}
