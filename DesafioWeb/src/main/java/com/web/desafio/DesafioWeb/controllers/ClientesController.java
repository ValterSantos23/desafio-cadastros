package com.web.desafio.DesafioWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientesController {
	@GetMapping("/clientes")
	public String index() {
		return "clientes/index";
	}
}
