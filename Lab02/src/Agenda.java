/**
 * Laboratório de Programação 2 - Lab 2
 * 
 * Representação de uma agenda de contatos.
 * 
 * @author Hemillainy Santos - 116210802
 *
 */
public class Agenda {
	private Contato[] contatos = new Contato[100];
	final String NL = System.lineSeparator();
	
	/**Armazena o contato recebido no array de contatos.
	 * 
	 * @param nome o nome do contato
	 * @param sobrenome o sobrenome do contato
	 * @param telefone o telefone do contato
	 * @param posicao a posição que o contato ocupa no array
	 */
	public void agendaContato(String nome, String sobrenome, String telefone, int posicao){
		contatos[posicao-1] = new Contato(nome, sobrenome, telefone);
	}
	/**
	 * Imprime toda a lista de contatos.
	 * 
	 * @return a representação em String de um contato quando listado.
	 */
	public String listaContato(){
		String saida = "";
		for(int i = 0; i < 100; i++){
			if (contatos[i] != null){
				saida += (i + 1) + " - " + contatos[i].toString() + NL;
			}
		}
		return saida;
	}
	/**
	 * Exibe o contato expecífico que o usuáro deseja ver.
	 * 
	 * @param posicaoContato a posição na qual se encontra o contato que o usuário deseja ver.
	 * 
	 * @return a representação em String de um contato quando exibido.
	 */
	public String exibeContato(int posicaoContato){
		String saida = "";
		if(posicaoContato - 1 > 100 || contatos[posicaoContato - 1] == null){
			saida = "CONTATO INEXISTENTE!";
		}
		else {
			saida += contatos[posicaoContato-1].exibeContato();
		}
		return saida + NL;
	}
}