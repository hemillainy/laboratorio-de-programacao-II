
public class Menu {

	private final String NL = System.lineSeparator();

	public String opcoes() {
		return "(C)adastrar Aluno" + NL + "(E)xibir Aluno" + NL + "(N)ovo Grupo" + NL
				+ "(A)locar Aluno no Grupo e Imprimir Grupos" + NL + "(R)egistrar Resposta de Aluno" + NL
				+ "(I)mprimir Alunos que Responderam" + NL + "(O)ra, vamos fechar o programa!" + NL + NL + "Opção> ";
	}

	public String matricula() {
		return "Matrícula: ";
	}

	public String nomeAluno() {
		return "Nome: ";
	}

	public String curso() {
		return "Curso: ";
	}

	public String nomeGrupo() {
		return "Grupo: ";
	}

	public String alocarAluno() {
		return "(A)locar Aluno ou (I)mprimir Grupo? ";
	}
}