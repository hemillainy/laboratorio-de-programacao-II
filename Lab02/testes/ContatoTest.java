import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Testa a classe Contato.
 * 
 *  Laboratório de Programação 2 - Lab 2
 * 
 * @author Hemillainy Santos - 116210802
 *
 */
public class ContatoTest {
	
	/**
	 * Verifica se o o contato está sendo exibido corretamente.
	 */
	@Test
	public void testExibeContato() {
		Contato contato = new Contato("Hemillainy", "Santos", "(83) 8888-8888");
		assertEquals("Hemillainy Santos - (83) 8888-8888", contato.exibeContato());
	}
	/**
	 * Verifica se o método toString está retornando a String corretamente.
	 */
	@Test
	public void testToString() {
		Contato contato = new Contato("Hemillainy", "Santos", "(83) 8888-8888");
		assertEquals("Hemillainy Santos", contato.toString());
	}
	/**
	 * Testa se a exceção está sendo lançada quando é passado um nome nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testNomeNulo() {
		new Contato(null, "Santos", "(83) 8888-8888");
	}
	/**
	 * Testa se a exceção está sendo lançada quando é passado um sobrenome nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testSobrenomeNulo() {
		new Contato("Hemillainy", null, "(83) 8888-8888");
	}
	/**
	 * Testa se a exceção está sendo lançada quando é passado um telefone nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testTelefoneNulo() {
		new Contato("Hemillainy", "Santos", null);
	}
}