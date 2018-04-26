
public class SeguroValor extends Seguro {

	/**
	 * Constrói um seguro por valor a partir de um valor.
	 * 
	 * @param valor
	 *            valor do seguro.
	 */
	public SeguroValor(int valor) {
		super(valor);
	}

	/**
	 * Representação em String de um seguro por valor. A representação segue o
	 * formato " - ASSEGURADA (VALOR) - R$VALOR".
	 */
	public String toString() {
		return " - ASSEGURADA (VALOR) - R$" + this.valor;
	}
}
