package com.webserviceproject.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webserviceproject.entities.Categoria;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long>{

}
