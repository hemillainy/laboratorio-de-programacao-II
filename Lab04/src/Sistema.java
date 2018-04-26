import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Laboratório de Programação 2 - Lab 4
 * 
 * Representação de um Controller. Tem acesso aos cenários e sistema de aposta e
 * faz as demais operações sobre eles.
 * 
 * @author Hemillainy Santos - 116210802
 *
 */
public class Sistema {
	private int caixa;
	private double taxa;
	private final String NL;
	private Validacao validacao;
	private List<Cenario> cenarios;
	private ComparacaoAposta comparacao;
	private List<Cenario> cenariosOrdenados;

	/**
	 * Inicia o ArrayList de cenarios, a constante NL e a variável idCenario que
	 * representa o id do ultimo cenário cadastrado..
	 */
	public Sistema() {
		NL = System.lineSeparator();
		validacao = new Validacao();
		cenarios = new ArrayList<Cenario>();
		cenariosOrdenados = new ArrayList<>();
		comparacao = new ComparacaoAposta();

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
		validacao.inicializacaoInvalida(caixa, taxa);
		this.caixa = caixa;
		this.taxa = taxa;
	}

	/**
	 * Cadastra um cenário no sistema caso o mesmo ainda não tenha sido
	 * cadastrado..
	 * 
	 * @param descricao
	 *            descrição do cenario.
	 * @return retorna o id do cenario cadastrado.
	 */
	public int cadastraCenario(String descricao) {
		validacao.cenarioInvalido(descricao);
		Cenario cenario = new Cenario(descricao, cenarios.size() + 1);
		cenarios.add(cenario);
		cenariosOrdenados.add(cenario);
		return cenarios.size();
	}

	/**
	 * Cadastra um cenário no sistema caso o mesmo ainda não tenha sido
	 * cadastrado..
	 * 
	 * @param descricao
	 *            descrição do cenario.
	 * @return retorna o id do cenario cadastrado.
	 */
	public int cadastraCenario(String descricao, int bonus) {
		validacao.bonusInvalido(bonus);
		Cenario cenario = new CenarioBonus(descricao, bonus, cenarios.size() + 1);
		cenarios.add(cenario);
		cenariosOrdenados.add(cenario);
		caixa -= bonus;
		return cenarios.size();
	}

	/**
	 * Gera a exibição de um cenário.
	 * 
	 * @param cenario
	 *            cenario que será exibido.
	 * @return retorna a exibição do cenario.
	 */
	public String exibeCenario(int cenario) {
		String erro = "Erro na consulta de cenario: ";
		validacao.cenarioInvalido(erro, cenario, cenarios.size());
		return cenarios.get(cenario - 1).toString();

	}

	/**
	 * Gera a representação de todos os cenários cadastrados.
	 * 
	 * @return retorna a representação de todos os cenários cadastrado.
	 */
	public String exibeTodosOsCenario() {
		String saida = "";
		for (Cenario cenario : cenarios) {
			saida += cenario + NL;
		}
		return saida;
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
	public void cadastraAposta(int cenario, String apostador, int valor, String previsao) {
		String msg = "Erro no cadastro de aposta: ";
		validacao.apostaInvalida(msg, cenario, apostador, valor, previsao, cenarios.size());
		cenarios.get(cenario - 1).cadastraAposta(apostador, valor, previsao);
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
	public int cadastraApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorSeguro,
			int custo) {
		String msg = "Erro no cadastro de aposta assegurada por valor: ";
		this.caixa += custo;
		validacao.apostaInvalida(msg, cenario, apostador, valorSeguro, previsao, cenarios.size());
		validacao.valorInvalido(msg, valor);
		return cenarios.get(cenario - 1).cadastraApostaSeguraValor(apostador, valor, previsao, valorSeguro);
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
		this.caixa += custo;
		String msg = "Erro no cadastro de aposta assegurada por taxa: ";
		validacao.apostaInvalida(msg, cenario, apostador, valor, previsao, cenarios.size());
		// excecoes.taxaInvalida(msg, taxa);
		return cenarios.get(cenario - 1).cadastraApostaSeguraTaxa(apostador, valor, previsao, taxa);
	}

	/**
	 * Retorna o valor total de apostas feitas em um cenario.
	 * 
	 * @param cenario
	 *            cenário o qual será calculado seu valor total de apostas.
	 */
	public int valorTotalDeApostas(int cenario) {
		String erro = "Erro na consulta do valor total de apostas: ";
		validacao.cenarioInvalido(erro, cenario, cenarios.size());

		int valor = cenarios.get(cenario - 1).valorTotalDeApostas();
		return valor;
	}

	/**
	 * Retorna o total de apostas feitas em um cenário.
	 * 
	 * @param cenario
	 *            cenario o qual será calculado o total de apostas feitas nele.
	 */
	public int totalDeApostas(int cenario) {
		String erro = "Erro na consulta do total de apostas: ";

		validacao.cenarioInvalido(erro, cenario, cenarios.size());
		return cenarios.get(cenario - 1).totalDeApostas();
	}

	/**
	 * Retorna a exibição de todas as apostas feitas em um cenario.
	 * 
	 * @param cenario
	 *            cenario o qual será exibido suas apostas.
	 */
	public String exibeApostas(int cenario) {
		String saida = "";
		saida = cenarios.get(cenario - 1).exibeApostas();

		return saida;
	}

	/**
	 * Encerra um cenário.
	 * 
	 * @param cenario
	 *            cenario que será encerrado.
	 * @param ocorreu
	 *            boolean que indica se o cenario ocorreu ou não.
	 */
	public void fechaAposta(int cenario, boolean ocorreu) {
		String erro = "Erro ao fechar aposta: ";
		validacao.cenarioInvalido(erro, cenario, cenarios.size());
		validacao.cenarioFechado(erro, cenarios.get(cenario - 1), cenarios.size());

		cenarios.get(cenario - 1).fechaAposta(ocorreu);
		caixa += getCaixaCenario(cenario);
		caixa -= cenarios.get(cenario - 1).totalAssegurado();
	}

	/**
	 * Retorna o caixa de um cenário após o mesmo ser encerrado.
	 * 
	 * @param cenario
	 *            cenario o qual será exibido seu caixa.
	 */
	public int getCaixaCenario(int cenario) {
		String erro = "Erro na consulta do caixa do cenario: ";
		validacao.cenarioInvalido(erro, cenario, cenarios.size());
		validacao.cenarioAberto(erro, cenarios.get(cenario - 1), cenarios.size());

		int caixaCenario = this.cenarios.get(cenario - 1).getCaixaCenario(taxa);
		return caixaCenario;
	}

	/**
	 * Retorna o rateio total de um cenáriozz
	 * 
	 * @param cenario
	 * @return
	 */
	public int getTotalRateioCenario(int cenario) {
		String erro = "Erro na consulta do total de rateio do cenario: ";
		validacao.cenarioInvalido(erro, cenario, cenarios.size());
		validacao.cenarioAberto(erro, cenarios.get(cenario - 1), cenarios.size());

		int rateioTotal = this.cenarios.get(cenario - 1).getTotalRateio(getCaixaCenario(cenario), taxa);

		return rateioTotal;
	}

	/**
	 * Retorna o caixa;
	 */
	public int getCaixa() {
		return this.caixa;
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
		cenarios.get(cenario - 1).alterarSeguroValor(apostaAssegurada, valor);
		return apostaAssegurada;
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
	 * @re
	 */
	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		cenarios.get(cenario - 1).alterarSeguroTaxa(apostaAssegurada, taxa);
		return apostaAssegurada;
	}

	/**
	 * Altera a ordem atual dos cenarios para a ordem desejada.
	 * 
	 * @param ordem
	 *            nova ordem na qual os cenario seram colocados.
	 */
	public void alterarOrdem(String ordem) {
		validacao.ordemInvalida(ordem);
		if (ordem.equals("nome")) {
			ordenaPorNome();
		} else if (ordem.equals("apostas")) {
			ordenaPorQntdDeApostas();
		} else if (ordem.equals("cadastro")) {
			Collections.copy(cenariosOrdenados, cenarios);
		}

	}

	/**
	 * Ordena os cenarios em ordem alfabetica.
	 */
	private void ordenaPorNome() {
		Collections.sort(cenariosOrdenados);
	}

	/**
	 * Ordena os cenários de acordo com o total de apostas. Os cenarios que tem
	 * mais apostas vem primeiro.
	 */
	private void ordenaPorQntdDeApostas() {
		Collections.sort(cenariosOrdenados, comparacao);
	}

	/**
	 * Exibe o cenario de acordo com sua nova ordenaçao.
	 * 
	 * @param cenario
	 *            o cenario que sera exibico.
	 * @return retorna o cenario que foi solicitada a exibiçao.
	 */
	public String exibirCenarioOrdenado(int cenario) {
		String msg = "Erro na consulta de cenario ordenado: ";
		validacao.cenarioInvalido(msg, cenario, cenariosOrdenados.size());
		return cenariosOrdenados.get(cenario - 1).toString();
	}
}