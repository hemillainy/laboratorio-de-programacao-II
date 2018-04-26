import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SeguroTest {
	private Seguro semSeguro;
	private Seguro seguroTaxa;
	private Seguro seguroValor;
	
	@Before
	public void setUp(){
		semSeguro =  new SemSeguro();
		seguroTaxa = new SeguroTaxa(100, 0.1);
		seguroValor = new SeguroValor(100);
	}
	@Test
	public void testGetValor() {
		assertEquals(0, semSeguro.getValor());
		assertEquals(10, seguroTaxa.getValor());
		assertEquals(100, seguroValor.getValor());
	}
	@Test
	public void testToString(){
		assertEquals("", semSeguro.toString());
		assertEquals(" - ASSEGURADA (TAXA) - 10%", seguroTaxa.toString());
		assertEquals(" - ASSEGURADA (VALOR) - R$100", seguroValor.toString());
	}

}
