package com.challenge.crm.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.crm.model.Usuario;



@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@GetMapping
	public List<Usuario> listar(List<Usuario> Usuario) {
		return Usuario;
		  
	}
}
