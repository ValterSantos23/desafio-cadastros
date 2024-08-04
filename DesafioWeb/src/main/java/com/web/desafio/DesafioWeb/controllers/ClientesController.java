package com.web.desafio.DesafioWeb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.desafio.DesafioWeb.models.Cliente;
import com.web.desafio.DesafioWeb.repositorio.ClientesRepo;

@Controller
public class ClientesController {
	@Autowired
	private ClientesRepo repo;
	@GetMapping("/clientes")
	public String index(Model model) {
		List<Cliente> clientes = (List<Cliente>)repo.findAll();
		model.addAttribute("clientes", clientes);
		return "clientes/index";
	}
	@GetMapping("/clientes/novo")
	public String novo() {
		return "clientes/novo";
	}
	
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
	
	@GetMapping("/clientes/{id}")
	public String buscar(@PathVariable int id, Model model) {
		Optional <Cliente> cliente = repo.findById(id);
		//Tratamento para caso seja digitado na URL um ID inexistente
		try {
			model.addAttribute("cliente", cliente.get());
		} catch (Exception e){
			return "redirect:/clientes";
		}
		
		return "/clientes/alterar";
	}
	
	@GetMapping("/clientes/{id}/excluir")
	public String excluir(@PathVariable int id) {
		repo.deleteById(id);
		return "redirect:/clientes";
	}
}
