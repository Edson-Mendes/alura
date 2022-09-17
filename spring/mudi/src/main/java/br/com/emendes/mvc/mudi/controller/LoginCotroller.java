package br.com.emendes.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginCotroller {
	
	@GetMapping()
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
