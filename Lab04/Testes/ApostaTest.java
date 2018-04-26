import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Laboratório de Programação 2 - Lab 4
 * 
 * Testes para a classe Apostas
 * 
 * @author Hemillainy Santos - 116210802
 *
 */
public class ApostaTest {
	private Aposta aposta;
	private Aposta apostaValor;
	private Aposta apostaTaxa;

	/**
	 * Instancia uma aposta.
	 */
	@Before
	public void setUp() {
		aposta = new Aposta("Hemillainy Santos", 10000, "VAI ACONTECER");
		apostaValor = new Aposta("Hemi", 501, "VAI ACONTECER", 200);
		apostaTaxa = new Aposta("Hemi", 501, "VAI ACONTECER", 0.02);
	}

	/**
	 * Testa o toString de Aposta.
	 */
	@Test
	public void testToString() {
		assertEquals("Hemillainy Santos - 100,00 - VAI ACONTECER", aposta.toString());
	}

	/**
	 * Testa o getValor de Aposta.
	 */
	@Test
	public void testGetValor() {
		assertEquals(10000, aposta.getValor());
	}

	/**
	 * Testa o getPrevisao de aposta.
	 */
	@Test
	public void testGetPrevisao() {
		assertEquals(true, aposta.getPrevisao());
	}

	/**
	 * Testa o getValorSeguro de Aposta.
	 */
	@Test
	public void testGetValorSeguro() {
		assertEquals(200, apostaValor.getValorSeguro());
		assertEquals(10, apostaTaxa.getValorSeguro());
	}

	/**
	 * Testa o setSeguroValor de Aposta.
	 */
	@Test
	public void testSetSeguroValor() {
		apostaTaxa.setSeguroValor(100);
		assertEquals(100, apostaTaxa.getValorSeguro());

	}

	/**
	 * Testa o setSeguroTaxa de Aposta.
	 */
	@Test
	public void testSetSeguroTaxa() {
		apostaValor.setSeguroTaxa(0.02);
		assertEquals(10, apostaValor.getValorSeguro());

	}

}
