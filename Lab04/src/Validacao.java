public class Validacao {

	/**
	 * Verifica se o caixa ou taxa passados para a inicialização do sistema de
	 * aposta são validos.
	 * 
	 * @param caixa
	 *            caixa do sistema de apostas.
	 * @param taxa
	 *            taxa inicial do sistema de apostas.
	 */
	public void inicializacaoInvalida(int caixa, double taxa) {
		if (caixa < 0) {
			throw new IllegalAccessError("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}
		if (taxa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}
	}

	/**
	 * Verifica se os dados passados para o cadastro de uma aposta são válidos.
	 * 
	 * @param cenario
	 *            cenario da aposta.
	 * @param apostador
	 *            apostar da aposta.
	 * @param valor
	 *            valor da aposta.
	 * @param previsao
	 *            previsao para a aposta.
	 * @param tamanhoCenario
	 *            quantidade de cenarios cadastrados.
	 */
	public void apostaInvalida(String msg, int cenario, String apostador, int valor, String previsao,
			int tamanhoCenario) {
		if (cenario - 1 < 0) {
			throw new IllegalArgumentException(msg + "Cenario invalido");
		}
		if (cenario - 1 > tamanhoCenario) {
			throw new IllegalArgumentException(msg + "Cenario nao cadastrado");
		}
		if (apostador == null || apostador.trim().isEmpty()) {
			throw new IllegalArgumentException(msg + "Apostador nao pode ser vazio ou nulo");
		}
		if (previsao == null || previsao.trim().isEmpty()) {
			throw new IllegalArgumentException(msg + "Previsao nao pode ser vazia ou nula");
		}
		if (!previsao.equals("VAI ACONTECER") && !previsao.equals("N VAI ACONTECER")) {
			throw new IllegalArgumentException(msg + "Previsao invalida");
		}
		if (valor <= 0) {
			throw new IllegalArgumentException(msg + "Valor nao pode ser menor ou igual a zero");
		}
	}

	/**
	 * Verifica se a descrição para o cenario é valida.
	 * 
	 * @param descricao
	 *            descriçao do cenario.
	 */
	public void cenarioInvalido(String descricao) {
		if (descricao == null || descricao.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
	}

	/**
	 * Verifica se o cenário solicitado é valido.
	 * 
	 * @param erro
	 *            erro que será exibido ao ser lançada a exceção.
	 * @param cenario
	 *            cenario solicitado.
	 * @param tamanhoCenario
	 *            quantidade de cenarios cadastrados.
	 */
	public void cenarioInvalido(String erro, int cenario, int tamanhoCenario) {
		if (cenario - 1 < 0) {
			throw new IllegalArgumentException(erro + "Cenario invalido");
		}
		if (cenario - 1 > tamanhoCenario) {
			throw new IllegalArgumentException(erro + "Cenario nao cadastrado");
		}
	}

	/***
	 * Verifica se o cenário já está fechado.
	 * 
	 * @param erro
	 *            erro que sera exibido caso o cenario ja esteja fechado.
	 * @param cenario
	 *            cenario verificado.
	 * @param tamanhoCenario
	 *            quantidade de cenarios cadastrados.
	 */
	public void cenarioFechado(String erro, Cenario cenario, int tamanhoCenario) {
		if (cenario.fechado()) {
			throw new IllegalArgumentException(erro + "Cenario ja esta fechado");
		}
	}

	/**
	 * Verifica se o cenario esta aberto.
	 * 
	 * @param erro
	 *            eror que sera exibido caso o cenario esteja aberto.
	 * @param cenario
	 *            cenario que sera verificado.
	 * @param tamanhoCenario
	 *            quantidade de cenarios cadastrados.
	 */
	public void cenarioAberto(String erro, Cenario cenario, int tamanhoCenario) {
		if (!cenario.fechado()) {
			throw new IllegalArgumentException(erro + "Cenario ainda esta aberto");
		}
	}

	/**
	 * Verifica se o bonus do cenario passado é valido.
	 * 
	 * @param bonus
	 *            bonus do cenario.
	 */
	public void bonusInvalido(int bonus) {
		if (bonus <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Bonus invalido");
		}
	}

	/**
	 * Verifica se o valor passado é valido.
	 * 
	 * @param msg
	 *            Complemento da mensagem que será exibida ao ser lançada a
	 *            exceçao.
	 * @param valor
	 *            valor que será verificado.
	 */
	public void valorInvalido(String msg, int valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException(msg + "Valor nao pode ser menor ou igual a zero");
		}
	}

	/**
	 * Verifica se a ordem passada é uma opçao valida.
	 * 
	 * @param ordem
	 *            ordem que será verificada.
	 */
	public void ordemInvalida(String ordem) {
		if (ordem == null || ordem.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem nao pode ser vazia ou nula");
		} else if (!(ordem.equals("nome") || ordem.equals("apostas") || ordem.equals("cadastro"))) {
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem invalida");
		}
	}
}
