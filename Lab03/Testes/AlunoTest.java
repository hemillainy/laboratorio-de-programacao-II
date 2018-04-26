import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlunoTest {
	Aluno aluno1;
	Aluno aluno2;
	Aluno aluno3;

	@Before
	public void setUp() {
		aluno1 = new Aluno("250", "Hemillainy Santos", "CC");
		aluno2 = new Aluno("250", "Hemillainy Santos", "CC");
		aluno3 = new Aluno("300", "Neto Silva", "Jogos Digitais");
	}

	@Test
	public void testEquals() {
		assertEquals(true, aluno1.equals(aluno2));
	}

	@Test(expected = NullPointerException.class)
	public void testAtributosNulos() {
		assertEquals("Matricula nula", new Aluno(null, "Hemillainy", "CC"));
		assertEquals("Nome nulo!", new Aluno("250", null, "CC"));
		assertEquals("Curso nulo!", new Aluno("250", "Hemillainy", null));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAtributosInvalidos(){
		assertEquals("Matricula invalida!", new Aluno("    ", "Hemillainy", "CC"));
		assertEquals("Nome invalido!", new Aluno("250", "      ", "CC"));
		assertEquals("Curso invalido!", new Aluno("250", "Hemillainy", "     "));
	}
	@Test
	public void testGetMatricula(){
		assertEquals("250", aluno1.getMatricula());
		assertEquals("300", aluno3.getMatricula());
	}
	@Test
	public void testToString(){
		assertEquals("250 - Hemillainy Santos - CC", aluno1.toString());
		assertEquals("300 - Neto Silva - Jogos Digitais", aluno3.toString());
		
	}

}
