/**
 * Laboratório de Programação 2 - Lab 2
 * 
 * Representação de um menu.
 * 
 * @author Hemillainy Santos - 116210802
 *
 */
public class Menu {
	private final String NL = System.lineSeparator();
	
	/**
	 * Imprime no console as opções de cadastro.
	 */
	public void opcoes() {
		System.out.print("(C)adastrar Contato" + NL + "(L)istar Contatos" + NL + "(E)xibir Contato" + NL + "(S)air" + NL + NL + "Opção> ");

	}
	/**
	 * Imprime "Posição: " no console para o usuário digitá-la.
	 */
	public void posicao() {
		System.out.print("Posição: ");
	}
	/**
	 * Imprime "POSIÇÃO INVÁLIDA!" no console caso o usuário digite um posição menor ou maior que a capacidade do array.
	 */
	public void posicaoInexistente() {
		System.out.println("POSIÇÃO INVÁLIDA!" + NL);
	}
	/**
	 * Imprime "Nome: " no console para o usuário digitá-lo.
	 */
	public void nome() {
		System.out.print("Nome: ");
	}
	/**
	 * Imprime "Sobrenome: " no console para o usuário digitá-lo.
	 */
	public void sobrenome() {
		System.out.print("Sobrenome: ");
	}
	/**
	 * Imprime "Telefone: " no console para o usuário digitá-lo.
	 */
	public void telefone() {
		System.out.print("Telefone: ");
	}
	/**
	 * Imprime "CADASTRO REALIZADO!" no console quando o cadastro é realizado.
	 */
	public void cadastroRealizado() {
		System.out.println("CADASTRO REALIZADO!" + NL);
	}
	/**
	 * Imprime "Contato> " no console para o usuário digitar o contato que deseja que seja exibido.
	 */
	public void contato() {
		System.out.print("Contato > ");
	}
	/**
	 * Imprime "OPÇÃO INVÁLIDA!" no console quando o usuário digita uma opção que não está presente no menu.
	 */
	public void opcaoInvalida() {
		System.out.println("OPÇÃO INVÁLIDA!" + NL);
	}

}
