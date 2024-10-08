package com.web.desafio.DesafioWeb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.desafio.DesafioWeb.models.Cliente;
import com.web.desafio.DesafioWeb.repositorio.ClientesRepo;

@Controller
public class ClientesController {
	@Autowired
	private ClientesRepo repo;
	
	//Tela de clientes vazia
	@GetMapping("/clientes")
	public String index() {
		return "clientes/index";
	}
	
	//Tentativa de fazer consultas por filtros, SQL do ClientesRepo.java precisa de correções.
	@GetMapping("/clientes/consultar")
    public String consultar(@RequestParam(required = false) String cod_cliente,
                            @RequestParam(required = false) String nome,
	                        @RequestParam(required = false) String cpf,
	                        Model model) {
		
		List<Cliente> clientes = repo.consultaClientes(cod_cliente, nome, cpf);
		
		try {
	        model.addAttribute("clientes", clientes);
	        return "clientes/index";
		} catch (Exception e) {
			return "redirect:/clientes";
		}
		
    }
	
	//Tela de criação de novo cliente
	@GetMapping("/clientes/novo")
	public String novo() {
		return "clientes/novo";
	}
	
	//Criação do cliente
	@PostMapping("/clientes/criar")
	public String criar(Cliente cliente) {
		//Deixando apenas números em CPF, RG e CEP
		cliente.cpfNumeros();
		cliente.rgNumeros();
		cliente.cepNumeros();
		
		//Salvando cliente no banco
		repo.save(cliente);
		return "redirect:/clientes";
	}
	
	//Direcionamento para tela de alteração de clientes.
	@GetMapping("/clientes/{id}")
	public String busca(@PathVariable int id, Model model) {
		Optional <Cliente> cliente = repo.findById(id);
		
		//Tratamento para caso seja digitado na URL um ID inexistente.
		try {
			model.addAttribute("cliente", cliente.get());
		} catch (Exception e){
			return "redirect:/clientes";
		}
		
		return "/clientes/alterar";
	}
	
	//Salvando dados alterados de um cliente.
	@PostMapping("/clientes/{id}/atualizar")
	public String atualizar(@PathVariable int id, Cliente cliente) {
		if(!repo.existsById(id)) {
			return "redirect:/clientes"; 
		}
		//Setando id para alterar o cliente correto e não criar outro novo.
		cliente.setCod_cliente(id);
		repo.save(cliente);
		
		return "redirect:/clientes";
	}
	
	//Exclusão de clientes.
	@GetMapping("/clientes/{id}/excluir")
	public String excluir(@PathVariable int id) {
		repo.deleteById(id);
		return "redirect:/clientes";
	}
}
