package com.web.desafio.DesafioWeb.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.web.desafio.DesafioWeb.models.Cliente;

public interface ClientesRepo extends CrudRepository<Cliente, Integer>{
	
	//Tentativa de fazer buscas por filtros para a tela de clientes
	//@Query(value="SELECT * FROM clientes WHERE (cod_cliente::text LIKE '%' || COALESCE(:cod_cliente, '') || '%') AND (nome LIKE '%' || COALESCE(:nome, '') || '%') AND (cpf LIKE '%' || COALESCE(:cpf, '') || '%')", nativeQuery = true)
	@Query(value="SELECT * FROM clientes WHERE (:cod_cliente IS NULL OR :cod_cliente = '' OR cod_cliente::text LIKE '%' || :cod_cliente || '%') AND (:nome IS NULL OR :nome = '' OR nome LIKE '%' || :nome || '%') AND (:cpf IS NULL OR :cpf = '' OR cpf LIKE '%' || :cpf || '%')", nativeQuery = true)
	List<Cliente> consultaClientes(@Param("cod_cliente") String cod_cliente,
						           @Param("nome") String nome,
						           @Param("cpf") String cpf);
}
