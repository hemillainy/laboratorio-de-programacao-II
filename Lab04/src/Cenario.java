import java.util.ArrayList;
import java.util.Comparator;

/**
 * 
 * Laboratório de Programação 2 - Lab 4
 * 
 * Representação de uma cenariode aposta. Toda cenario tem uma descrição, um
 * status e apostas.
 * 
 * @author Hemillainy Santos - 116210802
 *
 */
public class Cenario implements Comparable<Cenario> {
	private int id;
	private String descricao;
	private Status status;
	private final String NL;
	private boolean fechado = false;
	private ArrayList<Aposta> apostas;

	/**
	 * Contrói um cenario a partir de uma descrição, inicia o status como
	 * "NAO_FINALIZADO" e inicia o ArrayList de apostas.
	 * 
	 * @param descricao
	 *            descrição de um cenario.
	 * @param id
	 *            id do cenario.
	 */
	public Cenario(String descricao, int id) {
		NL = System.lineSeparator();
		this.id = id;
		this.descricao = descricao;
		this.status = status.NAO_FINALIZADO;
		this.apostas = new ArrayList<Aposta>();
	}

	/**
	 * Pega a descrição de um cenario.
	 * 
	 * @return descriçao do cenario.
	 */
	private String getDescricao() {
		return descricao;
	}

	/**
	 * Retorna a representação em String de um cenario. A representação segue o
	 * formato "descriçao - status"
	 */
	public String toString() {
		return this.id + " - " + this.descricao + " - " + this.status.getValor();
	}

	/**
	 * Armazena as apostas cadastradas no ArrayList de apostas.
	 * 
	 * @param apostador
	 *            nome do apostador.
	 * @param valor
	 *            valor apostado.
	 * @param previsao
	 *            previsão para a aposta.
	 */
	public void cadastraAposta(String apostador, int valor, String previsao) {
		Aposta aposta = new Aposta(apostador, valor, previsao);
		apostas.add(aposta);
	}

	/**
	 * Cadastra uma aposta assegurada por valor.
	 * 
	 * @param cenario
	 *            cenario no qual a aposta será cadastrada.
	 * @param apostador
	 *            pessoa que está fazendo a aposta.
	 * @param valor
	 *            valor que está sendo apostado.
	 * @param previsao
	 *            previsão para aquela aposta.
	 * @param valorSeguro
	 *            valor do seguro da aposta.
	 * @return
	 */
	public int cadastraApostaSeguraValor(String apostador, int valor, String previsao, int valorSeguro) {
		Aposta aposta = new Aposta(apostador, valor, previsao, valorSeguro);
		apostas.add(aposta);
		return apostas.size();
	}

	/**
	 * Cadastra uma aposta assegurada por taxa.
	 * 
	 * @param cenario
	 *            cenario no qual a aposta será cadastrada.
	 * @param apostador
	 *            pessoa que está fazendo a aposta.
	 * @param valor
	 *            valor que está sendo apostado.
	 * @param previsao
	 *            previsão para aquela aposta.
	 * @param taxa
	 *            taxa do seguro.
	 * @return
	 */
	public int cadastraApostaSeguraTaxa(String apostador, int valor, String previsao, double taxa) {
		Aposta aposta = new Aposta(apostador, valor, previsao, taxa);
		apostas.add(aposta);
		return apostas.size();
	}

	/**
	 * Retorna o valor total de apostas feitas em um cenario.
	 */
	public int valorTotalDeApostas() {
		int valorTotal = 0;
		for (Aposta aposta : apostas) {
			valorTotal += aposta.getValor();
		}
		return valorTotal;
	}

	/**
	 * Retorna a quantidade de apostas feitas em um cenario.
	 */
	public int totalDeApostas() {
		return apostas.size();
	}

	/**
	 * Retorna todas as apostas feitas em um cenario, uma abaixo da outra.
	 */
	public String exibeApostas() {
		String saida = "";
		for (Aposta aposta : apostas) {
			saida += aposta.toString() + NL;
		}
		return saida;
	}

	/**
	 * Encerra um cenario e altera seu status de acordo com se ele ocorreu ou
	 * não.
	 * 
	 * @param ocorreu
	 *            boolean que indica se o cenario ocorreu ou nao. True caso
	 *            tenha ocorrido, false caso não tenha.
	 */
	public void fechaAposta(boolean ocorreu) {
		if (ocorreu) {
			this.status = status.OCORREU;
		} else {
			this.status = status.NAO_OCORREU;
		}
		fechado = true;
	}

	/**
	 * Retorna true caso o cenário fechado ou false caso esteja aberto.
	 * 
	 * @return true ou false.
	 */
	public boolean fechado() {
		return this.fechado;
	}

	/**
	 * Verifica se uma aposta foi vencedora ou não.
	 * 
	 * @param aposta
	 *            aposta feita.
	 * @return retorna true caso tenha sido vencedora ou false caso não tenha
	 *         sido.
	 */
	public boolean venceu(Aposta aposta) {
		if ((aposta.getPrevisao() && status.equals(status.NAO_OCORREU))
				|| (!aposta.getPrevisao() && status.equals(status.OCORREU))) {
			return false;
		}
		return true;
	}

	/**
	 * Calcula o valor total das apostas perdedoras.
	 * 
	 * @return valor total das apostas perdedoras.
	 */
	public int perdedores() {
		int total = 0;
		for (Aposta aposta : apostas) {
			if (!venceu(aposta)) {
				total += aposta.getValor();
			}
		}
		return total;
	}

	/**
	 * Calcula o valor do caixa do cenario após o mesmo ter sido encerrado.
	 * 
	 * @return retorna o valor total do caixa.
	 */
	public int getCaixaCenario(double taxa) {
		return (int) (perdedores() * taxa);
	}

	/**
	 * Retorna o rateio total.
	 * 
	 * @param getCaixaCenario
	 * @param taxa
	 * @return o rateio total.
	 */
	public int getTotalRateio(int getCaixaCenario, double taxa) {
		int total = 0;
		total += perdedores() - getCaixaCenario;
		return total;
	}

	/**
	 * Altera o tipo de uma aposta assegurada por taxa para aposta assegurada
	 * por valor.
	 * 
	 * @param apostaAssegurada
	 *            aposta que será alterada.
	 * @param valor
	 *            valor do seguro.
	 */
	public void alterarSeguroValor(int aposta, int valor) {
		apostas.get(aposta - 1).setSeguroValor(valor);
	}

	/**
	 * Altera o tipo de uma aposta assegurada por valor para aposta assegurada
	 * por taxa.
	 * 
	 * @param apostaAssegurada
	 *            aposta que será alterada.
	 * @param taxa
	 *            taxa do seguro.
	 * @return
	 */
	public void alterarSeguroTaxa(int aposta, double taxa) {
		int valor = (int) (apostas.get(aposta - 1).getValor() * taxa);
		apostas.get(aposta - 1).setSeguroTaxa(taxa);

	}

	/**
	 * Retorna o total dos valores dos seguros das apostas asseguradas
	 * perdedoras.
	 */
	public int totalAssegurado() {
		int total = 0;
		for (Aposta aposta : apostas) {
			if (!venceu(aposta)) {
				total += aposta.getValorSeguro();
			}
		}
		return total;
	}

	/**
	 * Compara as descriçoes dos cenarios.
	 */
	@Override
	public int compareTo(Cenario o) {
		return this.descricao.compareTo(o.getDescricao());
	}

	/**
	 * Pega o id do cenario.
	 * 
	 * @return id do cenario.
	 */
	public int getId() {
		return this.id;
	}

}
