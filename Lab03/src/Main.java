import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String nomeGrupo;
		String matricula;
		String operacao;
		Menu menu;
		Sistema sistema = new Sistema();

		do {
			menu = new Menu();
			System.out.print(menu.opcoes());
			operacao = in.nextLine();

			switch (operacao) {
			case "C":
				System.out.print(menu.matricula());
				matricula = in.nextLine();

				System.out.print(menu.nomeAluno());
				String nome = in.nextLine();

				System.out.print(menu.curso());
				String curso = in.nextLine();

				System.out.println(sistema.cadastraAluno(matricula, nome, curso));

				break;

			case "E":
				System.out.print(menu.matricula());
				matricula = in.nextLine();

				System.out.println(sistema.exibeAluno(matricula));
				break;

			case "N":
				System.out.print(menu.nomeGrupo());
				nomeGrupo = in.nextLine();

				System.out.println(sistema.cadastraGrupo(nomeGrupo));
				break;

			case "A":
				System.out.print(menu.alocarAluno());

				String opcao = in.nextLine();
				if (opcao.equals("A")) {
					System.out.print(menu.matricula());
					matricula = in.nextLine();

					System.out.print(menu.nomeGrupo());
					nomeGrupo = in.nextLine();

					System.out.println(sistema.alocaAluno(nomeGrupo, matricula));
				} else {
					System.out.print(menu.nomeGrupo());

					nomeGrupo = in.nextLine();
					System.out.println(sistema.imprimeGrupos(nomeGrupo));
				}
				break;
			case "R":
				System.out.print(menu.matricula());
				matricula = in.nextLine();

				System.out.println(sistema.cadastraQuemRespondeu(matricula));
				break;
			case "I":
				System.out.println(sistema.imprimeQuemRepondeu());
				break;
			default:
				break;
			}
		} while (!operacao.equals("O"));
	}

}
