import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CenarioBonusTest {
	private Cenario cenarioBonus;
	private final String NL = System.lineSeparator();
	
	@Before
	public void setUp(){
		cenarioBonus = new CenarioBonus("Testes 1", 1000, 0);
		cenarioBonus.cadastraAposta("Hemi", 2000, "N VAI ACONTECER");

	}
	@Test
	public void testExibeApostas() {
		assertEquals("Hemi - 20,00 - N VAI ACONTECER" + NL, cenarioBonus.exibeApostas());
	}
	@Test
	public void testGetCaixaCenario(){
		cenarioBonus.fechaAposta(true);
		assertEquals(20, cenarioBonus.getCaixaCenario(0.01));
		cenarioBonus.fechaAposta(false);
		assertEquals(0, cenarioBonus.getCaixaCenario(0.01));
	}

}
