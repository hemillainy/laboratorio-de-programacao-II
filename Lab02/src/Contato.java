/**
 * Laboratório de Programação 2 - Lab 2
 * 
 * Representação de um contato. Todo contato precisa ter um nome, um sobrenome e um telefone.
 * 
 * @author Hemillainy Santos - 116210802
 *
 */
public class Contato {
	private String nome;
	private String sobrenome;
	private String telefone;
	
	/**
	 * Constrói um contato a partir de seu nome, sobrenome e telefone e lança exceções caso seja passado um dado nulo ou inválido.
	 * @param nome o nome do contato
	 * @param sobrenome o sobrenome do contato
	 * @param telefone o telefone do contato
	 */
	public Contato(String nome, String sobrenome, String telefone){
		if (nome == null && sobrenome == null && telefone == null){
			throw new NullPointerException("DADOS NULOS!");
		}
		if (nome == null || sobrenome == null || telefone == null){
			if (nome == null){
				throw new NullPointerException("NOME NULO!");
			}
			else if (sobrenome == null){
				throw new NullPointerException("SOBRENOME NULO!");
			}
			else{
				throw new NullPointerException("TELEFONE NULO!");
			}
		}
		if (nome.trim().isEmpty() && sobrenome.trim().isEmpty() && telefone.trim().isEmpty()){
			throw new IllegalArgumentException("DADOS INVÁLIDOS!");
		}
		if (nome.trim().isEmpty() || sobrenome.trim().isEmpty() || telefone.trim().isEmpty()){
			if (nome.trim().isEmpty()){
				throw new IllegalArgumentException("NOME INVÁLIDO!");
			}
			else if (sobrenome.trim().isEmpty()){
				throw new IllegalArgumentException("SOBRENOME INVÁLIDO!");
			}
			else if (telefone.trim().isEmpty()){
				throw new IllegalArgumentException("TELEFONE INVÁLIDO!");
			}
		}
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}
	/**
	 * Retorna a String que representa o contato quando listado. Segue o formato
	 *"posição no array - Nome do contato Sobrenome do contato"
	 *
	 *@return a representação em String de um contato
	 */
	public String toString(){
		return this.nome + " " + this.sobrenome;
	}
	/**
	 * Retorna a String que representa o contato quando exibido. Segue o formato
	 * "Nome do contato Sobrenome do contto - telefone do contato"
	 * 
	 * @return a representação em String de um contato.
	 */
	public String exibeContato(){
		return this.nome + " " + this.sobrenome + " - " + this.telefone;
	}
	public String getNome(){
		return nome;
	}
	public String getSobrenome(){
		return sobrenome;
	}
	public String getTelefone(){
		return telefone;
	}
}