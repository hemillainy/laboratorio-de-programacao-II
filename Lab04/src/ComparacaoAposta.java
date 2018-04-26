import java.util.Comparator;

/**
 * Laboratório de Programação 2 - Lab 4
 * 
 * Classe que implementa o compare de Cenario.
 * 
 * @author Hemillainy Santos - 116210802
 *
 */
public class ComparacaoAposta implements Comparator<Cenario> {

	/**
	 * Faz a comparação entre o total de apostas de cada cenario. Caso sejam
	 * iguais, compara os Id's dos mesmos.
	 */
	@Override
	public int compare(Cenario o1, Cenario o2) {
		int result = o2.totalDeApostas() - o1.totalDeApostas();
		if (result == 0) {
			return o1.getId() - o2.getId();
		}
		return result;
	}

}
