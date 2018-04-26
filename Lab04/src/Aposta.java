import javax.sql.rowset.spi.TransactionalWriter;

/**
 * 
 * Laboratório de Programação 2 - Lab 4
 * 
 * Representação de uma aposta. Toda aposta tem um valor, uma apostador e uma
 * previsão.
 * 
 * @author Hemillainy Santos - 116210802
 *
 */
public class Aposta {
	private int valor;
	private String apostador;
	private String previsao;
	private Seguro seguro;

	/**
	 * Contrói uma aposta a partir de um apostar, um valor e uma previsão
	 * 
	 * @param apostador
	 *            nome do apostador.
	 * @param valor
	 *            valor apostador.
	 * @param previsao
	 *            previsao para a aposta.
	 */
	public Aposta(String apostador, int valor, String previsao) {
		this.apostador = apostador;
		this.valor = valor;
		this.previsao = previsao;
		this.seguro = new SemSeguro();
	}

	/**
	 * Contrói uma aposta assegurada por valor a partir de um apostardor, um
	 * valor, uma previsão e um valor de seguro.
	 * 
	 * @param apostador
	 *            nome do apostador.
	 * @param valor
	 *            valor apostador.
	 * @param previsao
	 *            previsao para a aposta.
	 * @param valorSeguro
	 *            valor do seguro da aposta.
	 */
	public Aposta(String apostador, int valor, String previsao, int valorSeguro) {
		this.apostador = apostador;
		this.valor = valor;
		this.previsao = previsao;
		seguro = new SeguroValor(valorSeguro);
	}

	/**
	 * Contrói uma aposta assegurada por taxa a partir de um apostardor, um
	 * valor, uma previsão e uma taxa.
	 * 
	 * @param apostador
	 *            nome do apostador.
	 * @param valor
	 *            valor apostador.
	 * @param previsao
	 *            previsao para a aposta.
	 * @param taxa
	 *            taxa do seguro.
	 */
	public Aposta(String apostador, int valor, String previsao, double taxa) {
		this.apostador = apostador;
		this.valor = valor;
		this.previsao = previsao;
		this.seguro = new SeguroTaxa(valor, taxa);
	}

	/**
	 * Gera uma representação em reais para o valor da aposta.
	 * 
	 * @return o valor da aposta em reais.
	 */
	private String valorEmReais() {
		return String.format("%.2f", (this.valor / 100.0));
	}

	/**
	 * Metodo responsavel por gerar a representação em String de uma Aposta. A
	 * representação segue o modelo "nome do apostador - R$ valor apostador -
	 * previsao".
	 * 
	 * @return a representação em String de uma aposta.
	 */
	public String toString() {
		return this.apostador + " - " + valorEmReais() + " - " + this.previsao + seguro.toString();
	}

	/**
	 * Retorna o valor de uma aposta.
	 */
	public int getValor() {
		return this.valor;
	}

	/**
	 * Retorna true caso a previsão tenha sido "VAI ACONTECER" ou false caso
	 * tenha sido "NÃO VAI ACONTECER".
	 * 
	 * @return retorna true ou false
	 */
	public boolean getPrevisao() {
		if (this.previsao.equals("VAI ACONTECER")) {
			return true;
		}
		return false;
	}

	/**
	 * Pega o valor do seguro de uma aposta assegurada.
	 * 
	 * @return o valor de seguro.
	 */
	public int getValorSeguro() {
		return seguro.getValor();
	}

	/**
	 * Altera o seguro de uma aposta assegura de taxa para valor.
	 * 
	 * @param valor
	 *            valor do seguro.
	 */
	public void setSeguroValor(int valor) {
		this.seguro = new SeguroValor(valor);
	}

	/**
	 * Altera o seguro de uma aposta assegura de valor para taxa.
	 * 
	 * @param taxa
	 *            taxa do seguro.
	 */
	public void setSeguroTaxa(double taxa) {
		this.seguro = new SeguroTaxa(this.valor, taxa);
	}

}
