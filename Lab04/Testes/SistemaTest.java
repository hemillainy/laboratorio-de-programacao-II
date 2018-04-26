import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Laboratório de Programação 2 - Lab 4
 * 
 * Testes para a classe Sistema.
 * 
 * @author Hemillainy Santos - 116210802
 *
 */
public class SistemaTest {
	Sistema sistema;
	private final String NL = System.lineSeparator();

	/**
	 * Intancia um controller, inicializa um sistema e cadastra dois cenários e
	 * duas apostas.
	 */
	@Before
	public void setUp() {
		sistema = new Sistema();
		sistema.inicializa(1000, 0.01);
		sistema.cadastraCenario("Teste 1");
		sistema.cadastraCenario("Outro Teste");
		sistema.cadastraAposta(1, "hemi", 10000, "VAI ACONTECER");
		sistema.cadastraAposta(1, "neto", 20199, "N VAI ACONTECER");
		sistema.cadastraApostaSeguraValor(1, "Hemi", 1000, "VAI ACONTECER", 100, 50);
	}

	/**
	 * Testa se está sendo lançada a exceção quando é passada um cenário
	 * inválido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioInvalidaOuNula() {
		sistema.exibeCenario(0);
		sistema.exibeCenario(4);
		sistema.cadastraAposta(0, "Hemi", 10000, "NAO VAI ACONTECER");
	}

	/**
	 * Testa o metodo cadastraCenario.
	 */
	@Test
	public void testCadastraCenario() {
		assertEquals(3, sistema.cadastraCenario("Teste 3"));
		assertEquals(4, sistema.cadastraCenario("Teste 4"));
	}

	/**
	 * Testa o metodo exibeCenario;
	 */
	@Test
	public void testExibeCenario() {
		assertEquals("1 - Teste 1 - Nao finalizado", sistema.exibeCenario(1));
	}

	/**
	 * Testa o metodo exibeTodosOsCenarios;
	 */
	@Test
	public void testExibeTodosOsCenarios() {
		assertEquals("1 - Teste 1 - Nao finalizado" + NL + "2 - Outro Teste - Nao finalizado" + NL,
				sistema.exibeTodosOsCenario());
	}

	/**
	 * Testa o metodo valorTotalDeApostas.
	 */
	@Test
	public void testValorTotalDeApostas() {
		assertEquals(31199, sistema.valorTotalDeApostas(1));
	}

	/**
	 * Testa o metodo totalDeApostas.
	 */
	@Test
	public void testTotalDeApostas() {
		assertEquals(3, sistema.totalDeApostas(1));
	}

	/**
	 * Testa o metodo caixaCenario.
	 */
	@Test
	public void getCaixaCenario() {
		sistema.fechaAposta(1, true);
		assertEquals(201, sistema.getCaixaCenario(1));
	}

	/**
	 * Testa o metodo totalRateioCenario.
	 */
	@Test
	public void testTotalRateioCenario() {
		sistema.fechaAposta(1, true);
		assertEquals(19998, sistema.getTotalRateioCenario(1));
	}

	/**
	 * Testa o getCaixa do Controller.
	 */
	@Test
	public void testGetCaixa() {
		assertEquals(1050, sistema.getCaixa());
	}

	/**
	 * Testa o metodo alterarSeguroValor..
	 */
	@Test
	public void testAlterarSeguroValor() {
		assertEquals(3, sistema.alterarSeguroValor(1, 3, 1000));
	}
	/**
	 * Testa o metodo exibirCenarioOrdenado.
	 */
	@Test
	public void testExibirCenarioOrdenado(){
		sistema.alterarOrdem("nome");
		assertEquals("2 - Outro Teste - Nao finalizado", sistema.exibirCenarioOrdenado(1));
		sistema.alterarOrdem("apostas");
		assertEquals("1 - Teste 1 - Nao finalizado", sistema.exibirCenarioOrdenado(1));
		sistema.alterarOrdem("cadastro");
		assertEquals("1 - Teste 1 - Nao finalizado", sistema.exibirCenarioOrdenado(1));
	}
}
