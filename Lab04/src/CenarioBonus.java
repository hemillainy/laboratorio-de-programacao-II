
public class CenarioBonus extends Cenario {
	private int bonus;

	/**
	 * Constrói um cenario bonus a partir de uma descrição e um valor bonus.
	 * 
	 * @param descricao
	 *            descriçao do cenario
	 * @param bonus
	 *            bonus do cenario
	 * @param id
	 *            id do cenario
	 */
	public CenarioBonus(String descricao, int bonus, int id) {
		super(descricao, id);
		this.bonus = bonus;
	}

	/**
	 * Retorna o rateio total.
	 */
	@Override
	public int getTotalRateio(int getCaixaCenario, double taxa) {
		return (int) ((getCaixaCenario / taxa) - getCaixaCenario) + bonus;
	}

	/**
	 * Representação em String de um cenario bonus. A representação segue o
	 * formato "ID - DESCRICAO - STATUS - BONUS"
	 */
	@Override
	public String toString() {
		return String.format("%s - R$ %.2f", super.toString(), bonus / 100.0);
	}
}
