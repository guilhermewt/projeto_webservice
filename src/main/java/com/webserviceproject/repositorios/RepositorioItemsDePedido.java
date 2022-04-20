package com.webserviceproject.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webserviceproject.entities.Categoria;
import com.webserviceproject.entities.ItemsDePedido;

@Repository
public interface RepositorioItemsDePedido extends JpaRepository<ItemsDePedido, Long>{

}
