package br.com.alura.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public String hello(Model model) {
		// Pode usar HttpServletRequest ao inves de Model se quiser
		// request.setAttribute("nome", "Mundo"); 
		model.addAttribute("nome", "Mundo");
		return "hello";
	}
	
}
