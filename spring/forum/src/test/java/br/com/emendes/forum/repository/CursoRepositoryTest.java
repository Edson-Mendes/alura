package br.com.emendes.forum.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import br.com.emendes.forum.modelo.Curso;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class CursoRepositoryTest {

	@Autowired
	private CursoRepository repository;
	
	@Autowired
	private TestEntityManager em;
	
	@Test
	public void deveriaCarregarUmCursoAoBuscarPeloSeuNome() {
		String nomeCurso = "HTML 5";
		
		Curso html5 = new Curso();
		html5.setCategoria("Programação");
		html5.setNome(nomeCurso);
		em.persist(html5);
		
		Curso curso = repository.findByNome(nomeCurso);
		
		Assertions.assertNotNull(curso);
		Assertions.assertEquals(nomeCurso, curso.getNome());
	}
	
	@Test
	public void naoDeveriaCarregarUmCursoQueNaoEstejaNoDatabase() {
		String nomeCurso = "JPA";
		Curso curso = repository.findByNome(nomeCurso);
		
		Assertions.assertNull(curso);
	}

}
