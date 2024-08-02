package com.web.desafio.DesafioWeb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
