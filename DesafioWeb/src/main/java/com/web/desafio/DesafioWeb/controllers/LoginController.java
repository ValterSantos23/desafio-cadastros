package com.web.desafio.DesafioWeb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.desafio.DesafioWeb.models.User;
import com.web.desafio.DesafioWeb.repositorio.UsersRepo;


@Controller
public class LoginController {
	@Autowired
	private UsersRepo repo;
	
	@GetMapping("/login")
	public String index() {
		return "login/index";
	}
	
	@PostMapping("/logar")
	public String logar(Model model, User user) {
		User usuario = this.repo.Login(user.getIdent(), user.getSenha());
		
		//Condição para dizer se usuário está correto
		if(usuario != null) {
			return "redirect:/";
		}
		
		//Mensagem de erro para caso algum campo esteja incorreto
		model.addAttribute("erro", "Identificação ou senha de usuário inválida!");
		return "login/index";
	}
}
