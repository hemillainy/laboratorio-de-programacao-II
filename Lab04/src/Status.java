/**
 * 
 * Laboratório de Programação 2 - Lab 4
 * 
 * Representação do Status de um cenário.
 * 
 * @author Hemillainy Santos - 116210802
 *
 */
public enum Status {
	FINALIZADO("Finalizado"), NAO_FINALIZADO("Nao finalizado"), OCORREU("Finalizado (ocorreu)"), NAO_OCORREU(
			"Finalizado (n ocorreu)");
	private final String valor;

	/**
	 * @param valor
	 *            valor associado à constante "valor".
	 */
	Status(String valor) {
		this.valor = valor;
	}

	/**
	 * 
	 * @return o valor em String da constante "valor".
	 */
	public String getValor() {
		return valor;
	}
}
