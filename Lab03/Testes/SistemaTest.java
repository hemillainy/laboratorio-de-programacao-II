import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SistemaTest {
	Aluno aluno1;
	Grupo grupo1;
	Sistema sistema;
	final String NL = System.lineSeparator();

	@Before
	public void setUp() {
		aluno1 = new Aluno("300", "Neto", "Jogos Digitais");
		grupo1 = new Grupo("Loops");
		sistema = new Sistema();

		sistema.cadastraAluno("250", "Hemillainy", "CC");
		sistema.cadastraGrupo(grupo1.getNome());

	}

	@Test
	public void testCadastraAluno() {

		assertEquals("CADASTRO REALIZADO!" + NL, sistema.cadastraAluno("450", "Marcos", "Engenharia Civil"));
		assertEquals("MATRÍCULA JÁ CADASTRADA!" + NL, sistema.cadastraAluno("250", "Hemillainy", "CC"));
	}

	@Test
	public void testExibeAluno() {
		assertEquals("Aluno: 250 - Hemillainy - CC" + NL, sistema.exibeAluno("250"));
		assertEquals("Aluno não cadastrado." + NL, sistema.exibeAluno(aluno1.getMatricula()));
	}

	@Test
	public void testCadastraGrupo() {
		assertEquals("CADASTRO REALIZADO!" + NL, sistema.cadastraGrupo("Listas"));
		assertEquals("GRUPO JÁ CADASTRADO!" + NL, sistema.cadastraGrupo("LISTAS"));
	}

	@Test
	public void testAlocaAluno() {
		assertEquals("ALUNO ALOCADO!" + NL, sistema.alocaAluno(grupo1.getNome(), "250"));
		assertEquals("Aluno não cadastrado." + NL, sistema.alocaAluno(grupo1.getNome(), "300"));
		assertEquals("Grupo não cadastrado." + NL, sistema.alocaAluno("Listas", "250"));
	}

	@Test
	public void testImprimeGrupo() {
		sistema.alocaAluno(grupo1.getNome(), "250");
		assertEquals(NL + "Alunos do grupo Loops:" + NL + "* 250 - Hemillainy - CC" + NL,
				sistema.imprimeGrupos(grupo1.getNome()));
		assertEquals("Grupo não cadastrado.", sistema.imprimeGrupos("Listas"));
	}

	@Test
	public void testCadastraQuemRespondeu() {
		assertEquals("ALUNO REGISTRADO!" + NL, sistema.cadastraQuemRespondeu("250"));
		assertEquals("Aluno não cadastrado." + NL, sistema.cadastraQuemRespondeu(aluno1.getMatricula()));
	}

	@Test
	public void testImprimeQuemRespondeu() {
		sistema.cadastraAluno("300", "Neto", "Jogos Digitais");
		sistema.cadastraQuemRespondeu("250");
		sistema.cadastraQuemRespondeu(aluno1.getMatricula());
		assertEquals("1. 250 - Hemillainy - CC" + NL + "2. 300 - Neto - Jogos Digitais" + NL,
				sistema.imprimeQuemRepondeu());
	}

}
