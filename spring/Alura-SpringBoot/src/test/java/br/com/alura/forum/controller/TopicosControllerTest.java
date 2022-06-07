package br.com.alura.forum.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.empty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class TopicosControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private TopicoRepository repository;
	
	@Autowired
	private CursoRepository cursoRepository;

	private URI uri;
	private static boolean initialized = false;
	private Curso springBoot;
	
	@BeforeEach
	void setup() throws URISyntaxException {
		uri = new URI("/topicos");

		if(!initialized) {	
			springBoot = new Curso();
			springBoot.setNome("Spring Boot");
			springBoot.setCategoria("Programação");
			cursoRepository.save(springBoot);
				
			initialized = true;
		}
	}
	
	@AfterEach
	void destroy() {
		repository.deleteAll();
	}

	@Test
	void deveriaEncontrarTopicosQuandoSePassaURLSemNomeCurso() throws Exception {
		Topico topico = new Topico();
		topico.setTitulo("Duvida");
		topico.setCurso(springBoot);
		topico.setMensagem("Projeto não compila");
		repository.save(topico);

		mockMvc
		.perform(get(uri))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.content[0].titulo", is("Duvida")));
	}
	
	@Test
	void deveriaEncontrarTopicosQuandoSePassaURLComNomeCursoSpringBoot() throws Exception {	
		Topico topico = new Topico();
		topico.setTitulo("Duvida");
		topico.setCurso(springBoot);
		topico.setMensagem("Projeto não compila");
		repository.save(topico);

		mockMvc
		.perform(get(uri).param("nomeCurso", "Spring Boot"))
		.andExpect(status().isOk());
	}
	
	@Test
	void deveriaEncontrarTopicosQuandoSePassaURLComNomeCursoJPA() throws Exception {
		mockMvc
		.perform(get(uri).param("nomeCurso", "JPA"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.content", is(empty())));
	}
	
	@Test
	@WithMockUser(roles = "MODERADOR")
	void deveriaDevolver201AoAdicionarNovoTopico() throws Exception {
		String json = "{\r\n"
				+ "    \"titulo\" : \"Nova Duvida\",\r\n"
				+ "    \"mensagem\" : \"Como escrever uma nova duvida\",\r\n"
				+ "    \"nomeCurso\" : \"Spring Boot\"\r\n"
				+ "}";
		
		mockMvc
		.perform(post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated());
	}

}
