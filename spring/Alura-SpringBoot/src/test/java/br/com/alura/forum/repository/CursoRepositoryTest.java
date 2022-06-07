package br.com.alura.forum.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import br.com.alura.forum.modelo.Curso;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
class CursoRepositoryTest {

	@Autowired
	private CursoRepository repository;
	
	@Autowired
	private TestEntityManager em;
	
	@Test
	void deveriaCarregarUmCursoAoBuscarPeloNome() {
		Curso html5 = new Curso();
		html5.setNome("HTML 5");
		html5.setCategoria("Programacao");
		em.persist(html5);
		
		Curso curso = repository.findByNome("HTML 5");
		assertNotNull(curso);
		assertThat(curso.getNome(), is("HTML 5"));
	}
	
	@Test
	void naoDeveriaCarregarUmCursoCujoNomeNaoEstaCadastrado() {
		Curso curso = repository.findByNome("HTML 3");
		assertNull(curso);
	}

}
