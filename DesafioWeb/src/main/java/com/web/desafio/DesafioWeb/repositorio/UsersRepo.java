package com.web.desafio.DesafioWeb.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.web.desafio.DesafioWeb.models.User;

public interface UsersRepo extends CrudRepository<User, Integer>{
	//Verificação de dados de login
	@Query(value="select * from users where ident = :ident and senha = :senha", nativeQuery = true)
	public User Login(int ident, String senha);
}
