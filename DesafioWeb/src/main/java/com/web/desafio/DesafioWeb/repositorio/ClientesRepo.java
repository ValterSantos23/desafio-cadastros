package com.web.desafio.DesafioWeb.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.web.desafio.DesafioWeb.models.Cliente;

public interface ClientesRepo extends CrudRepository<Cliente, Integer>{
	
}
