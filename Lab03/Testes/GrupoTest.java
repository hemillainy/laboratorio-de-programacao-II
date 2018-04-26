import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GrupoTest {
	Grupo grupo1;
	Grupo grupo2;
	Grupo grupo3;
	Aluno aluno1;
	Aluno aluno2;

	@Before
	public void setUp() {
		grupo1 = new Grupo("Listas");
		grupo2 = new Grupo("Loops");
		grupo3 = new Grupo("Listas");

		aluno1 = new Aluno("250", "Hemillainy", "CC");

		grupo1.alocaAluno(aluno1);
	}

	@Test(expected = NullPointerException.class)
	public void testNomeNulo() {
		assertEquals("Nome nulo!", new Grupo(null));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNomeInvalido() {
		assertEquals("Nome invalido!", new Grupo("     "));
	}

	@Test
	public void testGetNome() {
		assertEquals("Listas", grupo1.getNome());
		assertEquals("Loops", grupo2.getNome());
	}

	@Test
	public void testToString() {
		assertEquals("* 250 - Hemillainy - CC" + System.lineSeparator(), grupo1.toString());
	}

	@Test
	public void testEquals() {
		assertEquals(true, grupo1.equals(grupo3));
	}

}
