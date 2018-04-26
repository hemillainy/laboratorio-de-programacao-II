
public class SeguroTaxa extends Seguro {
	private double taxa;

	/**
	 * Constrói um seguro por taxa a partir de um valor e uma taxa.
	 * 
	 * @param valor
	 *            valor do seguro.
	 * @param taxa
	 *            taxa do seguro.
	 */
	public SeguroTaxa(int valor, double taxa) {
		super(valor);
		this.taxa = taxa;
	}

	/**
	 * Pega o valor do seguro.
	 */
	public int getValor() {
		return (int) (this.valor * this.taxa);
	}

	/**
	 * Representação em String de um seguro por taxa. A representação segue o
	 * formato " - ASSEGURADA (TAXA) - TAXA %".
	 */
	public String toString() {
		return " - ASSEGURADA (TAXA) - " + (int) (this.taxa * 100.0) + "%";
	}

}
