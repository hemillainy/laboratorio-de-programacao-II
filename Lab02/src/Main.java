import java.util.*;
/**
 *  Laboratório de Programação 2 - Lab 2
 * 
 * @author Hemillainy Santos - 116210802
 *
 */
public class Main {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		Agenda agenda = new Agenda();
		Menu menu = new Menu();
		
		String operacao;
		do{
			menu.opcoes();
			operacao = input.nextLine();
			
			switch (operacao) {
			
			case "S":
				break;
			
			case "C":
				menu.posicao();;
				int posicao = input.nextInt();
				input.nextLine();
				
				if (posicao <= 0 || posicao > 100){
					menu.posicaoInexistente();
					break;
				}
				menu.nome();
				String nome = input.nextLine();
				
				menu.sobrenome();
				String sobrenome = input.nextLine();
				
				menu.telefone();
				String telefone = input.nextLine();
				
				menu.cadastroRealizado();
				agenda.agendaContato(nome, sobrenome, telefone, posicao);
		
				break;
				
			case "L":
				System.out.println(agenda.listaContato());
				break;
				
			case "E":
				menu.contato();
				int posContato = input.nextInt();
				input.nextLine();
				
				System.out.println(agenda.exibeContato(posContato));
				break;
			default:
				menu.opcaoInvalida();
				break;
			}
		}while(!operacao.equals("S"));
		input.close();
	}
}