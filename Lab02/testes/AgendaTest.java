import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
/**
 * **
 * Testa a classe Contato.
 * 
 * Laboratório de Programação 2 - Lab 2
 * 
 * @author Hemillainy Santos - 116210802
 *
 */
public class AgendaTest {
	Contato[] contatos;
	Agenda agenda;
	
	/**
	 * Cria um array com três contatos.
	 */
	@Before
	public void setUp() {
		contatos = new Contato[3];
		contatos[0] = new Contato("Hemillainy", "Santos", "(83) 9999-9999");
		contatos[1] = new Contato("Lana", "Del Rey", "(83) 8181-8181");
		contatos[2] = new Contato("Neto", "Silva", "(83) 9786-9787");
		
		agenda = new Agenda();
	}

	@Test
	public void testAgenda() {
		ArrayList<Integer> indices = new ArrayList<Integer>();
		
		/**
		 * Cria indices aleatórios.
		 */
		for(int i = 0; i < 3; i++) {
			int posicao = (int) (Math.random() * 150);
			if(!indices.contains(posicao))
				indices.add(posicao);
		}
		/**
		 * Adiciona cada um dos contatos em uma agenda utilizando os indices gerados anteriormente.
		 */
		boolean existe = true;
		for (int i = 0; i < indices.size(); i++) {
			Contato contato = contatos[i % 3];
			if (indices.get(i) - 1 > 100 || indices.get(i) - 1 < 0){
				assertEquals("CONTATO INEXISTENTE!" + System.lineSeparator(), agenda.exibeContato(indices.get(i)));
				existe = false;
			}
			else {
				agenda.agendaContato(contato.getNome(), contato.getSobrenome(), contato.getTelefone(), indices.get(i));
			}
		}
		
		/**
		 * Verifica se os contatos estão nas posições em que foram colocados.
		 */
		if(existe){
			for (int i = 0; i < indices.size(); i++) {
				assertEquals(contatos[i % 3].exibeContato() + System.lineSeparator(), agenda.exibeContato(indices.get(i)));
		}
		}
	}
	/**
	 * Verifica se os contatos estão sendo listados corretamente.
	 */
	public void testListaContato() {
		assertEquals(contatos.toString(), agenda.listaContato());
	}
}