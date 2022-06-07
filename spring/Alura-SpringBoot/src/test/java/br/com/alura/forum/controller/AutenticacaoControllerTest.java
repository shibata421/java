package br.com.alura.forum.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.repository.UsuarioRepository;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class AutenticacaoControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private UsuarioRepository repository;
	
	@Test
	void deveriaDevolver400CasoDadosDeAutenticacaoEstejamIncorretos() throws Exception {
		URI uri = new URI("/auth");
		String json = "{\"email\":\"invalido@email.com\",\"senha\":\"123456\"}";
		
		mockMvc
		.perform(post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest());
	}

	@Test
	void deveriaDevolver200CasoDadosDeAutenticacaoEstejamCorretos() throws Exception {
		URI uri = new URI("/auth");
		String json = "{\"email\":\"aluno@email.com\",\"senha\":\"123456\"}";
		
		Usuario usuario = new Usuario();
		usuario.setEmail("aluno@email.com");
		usuario.setSenha("$2a$10$HcoYtM/HONzCtph/H3t5Iu.sliut4ow882AdH8YszYO71uCO.Wahm");
		repository.save(usuario);
		
		mockMvc
		.perform(post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

}
