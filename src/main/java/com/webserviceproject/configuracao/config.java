package com.webserviceproject.configuracao;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.webserviceproject.entities.Categoria;
import com.webserviceproject.entities.Payment;
import com.webserviceproject.entities.Pedido;
import com.webserviceproject.entities.Produto;
import com.webserviceproject.entities.Usuario;
import com.webserviceproject.entities.enums.StatusDePedido;
import com.webserviceproject.repositorios.CategoriaRepositorio;
import com.webserviceproject.repositorios.PedidoRepositorio;
import com.webserviceproject.repositorios.ProdutoRepositorio;
import com.webserviceproject.repositorios.UsuarioRepositorio;

@Configuration
public class config implements CommandLineRunner{

	@Autowired
	private UsuarioRepositorio repositorio;
	
	@Autowired
	private PedidoRepositorio pedidoRepositorio;

	@Autowired
	private ProdutoRepositorio produtoRepo;
	
	@Autowired
	private CategoriaRepositorio categoriaRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "gabriel", "gabriel@gmail", "339333", "12345");
		Usuario u2 = new Usuario(null, "pedro", "pedro@gmail", "31233", "54321");
		Usuario u3 = new Usuario(null, "alex", "alex@gmail", "32434", "43245");
		
		repositorio.saveAll(Arrays.asList(u1,u2,u3));
		
		Pedido pedido1 = new Pedido(null,Instant.parse("2019-06-20T19:53:07Z"),StatusDePedido.PAID,u1);
		Pedido pedido2 = new Pedido(null,Instant.parse("2022-04-05T16:16:45Z"),StatusDePedido.WAITING_PAYMENT,u2);
		Pedido pedido3 = new Pedido(null,Instant.parse("2022-04-05T21:19:45Z"),StatusDePedido.WAITING_PAYMENT,u2);
		
		Payment pay = new Payment(null, Instant.parse("2022-06-06T15:42:01Z"), pedido1);		
		pedidoRepositorio.saveAll(Arrays.asList(pedido1,pedido2,pedido3));
		pedido1.setPayment(pay);
		pedidoRepositorio.save(pedido1);
		
		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers"); 
		
		categoriaRepo.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		p1.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat3);
		p3.getCategorias().add(cat3);
		p4.getCategorias().add(cat3);
		p5.getCategorias().add(cat2);
		
		produtoRepo.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
	}
}
