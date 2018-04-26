
abstract class Seguro {
	private String tipo;
	protected int valor;

	/**
	 * Construtor base para um seguro.
	 * 
	 * @param valor
	 *            valor do seguro.
	 */
	public Seguro(int valor) {
		this.valor = valor;
	}

	/**
	 * Pega o valor do seguro.
	 * 
	 * @return o valor do seguro.
	 */
	public int getValor(){
		return this.valor;
	}

	/**
	 * Representação em String de um seguro;
	 */
	public abstract String toString();
}
