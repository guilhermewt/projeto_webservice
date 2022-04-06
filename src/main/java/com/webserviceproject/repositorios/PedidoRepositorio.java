package com.webserviceproject.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webserviceproject.entities.Pedido;
import com.webserviceproject.entities.Usuario;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Long>{

}
