import easyaccept.EasyAccept;

/**
 * 
 * Laboratório de Programação 2 - Lab 4
 * 
 * Representção de uma Facade. A Facade delega ações para o Controller.
 * 
 * @author Hemillainy Santos - 116210802
 *
 */
public class Facade {
	public static void main(String[] args) {
		args = new String[] { "Facade", "acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt",
				"acceptance_test/us3_test.txt", "acceptance_test/us4_test.txt", "acceptance_test/us5_test.txt",
				"acceptance_test/us6_test.txt", "acceptance_test/us7_test.txt" };
		EasyAccept.main(args);
	}

	private Sistema controller;

	/**
	 * Retorna o caixa do sistema.
	 * 
	 * @return caixa do sistema.
	 */
	public int getCaixa() {
		return controller.getCaixa();
	}

	/**
	 * Inicia o controller.
	 */
	public Facade() {
		this.controller = new Sistema();
	}

	/**
	 * Inicializa o sistema de apostas.
	 * 
	 * @param caixa
	 *            caixa do sistema.
	 * @param taxa
	 *            taxa inicial do sistema.
	 */
	public void inicializa(int caixa, double taxa) {
		controller.inicializa(caixa, taxa);
	}

	/**
	 * Armazena um cenário no ArrayList de cenarios.
	 * 
	 * @param descricao
	 *            descrição do cenario.
	 * @return retorna o id do cenario cadastrado.
	 */
	public int cadastrarCenario(String descricao) {
		return controller.cadastraCenario(descricao);
	}

	public int cadastrarCenario(String descricao, int bonus) {
		return controller.cadastraCenario(descricao, bonus);
	}

	/**
	 * Gera a exibição de um cenário.
	 * 
	 * @param cenario
	 *            cenario que será exibido.
	 * @return retorna a exibição do cenario.
	 */
	public String exibirCenario(int cenario) {
		return this.controller.exibeCenario(cenario);
	}

	/**
	 * Gera a representação de todos os cenários cadastrados.
	 * 
	 * @return retorna a representação de todos os cenários cadastrado.
	 */
	public String exibeTodosOsCenarios() {
		return this.controller.exibeTodosOsCenario();
	}

	/**
	 * Cadastra uma aposta no ArrayList de apostas.
	 * 
	 * @param cenario
	 *            cenario no qual a aposta será cadastrada.
	 * @param apostador
	 *            apostador que está fazendo a aposta.
	 * @param valor
	 *            valor que o apostador está apostando.
	 * @param previsao
	 *            previsão do apostar para aquela aposta.
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		controller.cadastraAposta(cenario, apostador, valor, previsao);
	}

	/**
	 * Retorna o valor total de apostas feitas em um cenario.
	 * 
	 * @param cenario
	 *            cenário o qual será calculado seu valor total de apostas.
	 */
	public int valorTotalDeApostas(int cenario) {
		return controller.valorTotalDeApostas(cenario);
	}

	/**
	 * Retorna o total de apostas feitas em um cenário.
	 * 
	 * @param cenario
	 *            cenario o qual será calculado o total de apostas feitas nele.
	 */
	public int totalDeApostas(int cenario) {
		return controller.totalDeApostas(cenario);
	}

	/**
	 * Retorna a exibição de todas as apostas feitas em um cenario.
	 * 
	 * @param cenario
	 *            cenario o qual será exibido suas apostas.
	 */
	public String exibeApostas(int cenario) {
		return controller.exibeApostas(cenario);
	}

	/**
	 * Encerra um cenário.
	 * 
	 * @param cenario
	 *            cenario que será encerrado.
	 * @param ocorreu
	 *            boolean que indica se o cenario ocorreu ou não.
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		controller.fechaAposta(cenario, ocorreu);
	}

	/**
	 * Retorna o caixa de um cenário após o mesmo ser encerrado.
	 * 
	 * @param cenario
	 *            cenario o qual será exibido seu caixa.
	 */
	public int getCaixaCenario(int cenario) {
		return controller.getCaixaCenario(cenario);
	}

	/**
	 * Retorna o rateio total de um cenário.
	 * 
	 * @param cenario
	 */
	public int getTotalRateioCenario(int cenario) {
		return controller.getTotalRateioCenario(cenario);
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
	 * @param custo
	 *            custo do seguro.
	 * @return
	 */
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorSeguro,
			int custo) {
		return controller.cadastraApostaSeguraValor(cenario, apostador, valor, previsao, valorSeguro, custo);
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
	 * @param custo
	 *            custo do seguro.
	 * @return
	 */
	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa,
			int custo) {
		return controller.cadastrarApostaSeguraTaxa(cenario, apostador, valor, previsao, taxa, custo);
	}

	/**
	 * Altera o tipo de uma aposta assegurada por taxa para aposta assegurada
	 * por valor.
	 * 
	 * @param cenario
	 *            cenario no qual está a aposta que será alterada.
	 * @param apostaAssegurada
	 *            aposta que será alterada.
	 * @param valor
	 *            valor do seguro.
	 * @return
	 */
	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		return controller.alterarSeguroValor(cenario, apostaAssegurada, valor);
	}

	/**
	 * Altera o tipo de uma aposta assegurada por valor para aposta assegurada
	 * por taxa.
	 * 
	 * @param cenario
	 *            cenario no qual a aposta está cadastrada.
	 * @param apostaAssegurada
	 *            aposta que será alterada.
	 * @param taxa
	 *            taxa do seguro.
	 * @return
	 */
	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		return controller.alterarSeguroTaxa(cenario, apostaAssegurada, taxa);
	}

	/**
	 * Altera a ordem atual dos cenarios para a ordem desejada.
	 * 
	 * @param ordem
	 *            nova ordem na qual os cenario seram colocados.
	 */
	public void alterarOrdem(String ordem) {
		controller.alterarOrdem(ordem);
	}

	/**
	 * Exibe o cenario de acordo com sua nova ordenaçao.
	 * 
	 * @param cenario
	 *            o cenario que sera exibico.
	 * @return retorna o cenario que foi solicitada a exibiçao.
	 */
	public String exibirCenarioOrdenado(int cenario) {
		return controller.exibirCenarioOrdenado(cenario);
	}
}