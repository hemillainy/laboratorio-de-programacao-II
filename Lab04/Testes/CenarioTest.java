import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CenarioTest {
	private Cenario cenario1;
	private Cenario cenario2;
	private final String NL = System.lineSeparator();

	/**
	 * Instancia um cenário e cadastras duas apostas.
	 */
	@Before
	public void setUp() {
		cenario1 = new Cenario("Testes", 1);
		cenario2 = new Cenario("Cenario 1", 2);
		cenario1.cadastraAposta("Hemi Santos", 10000, "VAI ACONTECER");
		cenario1.cadastraAposta("Neto Silva", 20199, "NAO VAI ACONTECER");
	}

	/**
	 * Testa o toString do Cenario.
	 */
	@Test
	public void testToString() {
		assertEquals("1 - Testes - Nao finalizado", cenario1.toString());
	}

	/**
	 * Testa o metodo valorTotalDeApostas.
	 */
	@Test
	public void testValorTotalDeApostas() {
		assertEquals(30199, cenario1.valorTotalDeApostas());
	}

	/**
	 * Testa o metodo totalDeApostas.
	 */
	@Test
	public void testTotalDeApostas() {
		assertEquals(2, cenario1.totalDeApostas());
	}

	/**
	 * Testa o metodo exibeApostas.
	 */
	@Test
	public void testExibeApostas() {
		assertEquals("Hemi Santos - 100,00 - VAI ACONTECER" + NL + "Neto Silva - 201,99 - NAO VAI ACONTECER" + NL,
				cenario1.exibeApostas());
	}

	/**
	 * Testa o metodo getCaixaCenario.
	 */
	@Test
	public void testGetCaixaCenario() {
		cenario1.fechaAposta(true);
		assertEquals(201, cenario1.getCaixaCenario(0.01));
		cenario1.fechaAposta(false);
		assertEquals(100, cenario1.getCaixaCenario(0.01));
	}

	/**
	 * Testa o metodo getTotalRatio.
	 */
	@Test
	public void testGetTotalRateio() {
		cenario1.fechaAposta(true);
		assertEquals(19199, cenario1.getTotalRateio(1000, 0.01));
	}

	/**
	 * Testa o getId.
	 */
	@Test
	public void testGetId() {
		assertEquals(1, cenario1.getId());
	}

	/**
	 * Testa o compareTo.
	 */
	@Test
	public void testCompareTo() {
		assertEquals(17, cenario1.compareTo(cenario2));
	}
}
