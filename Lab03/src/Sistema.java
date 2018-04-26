
import java.util.ArrayList;
import java.util.HashMap;

public class Sistema {
	private HashMap<String, Aluno> alunos;
	private HashMap<String, Grupo> grupos;
	private ArrayList<Aluno> respondeuQuestoes;
	private final String NL = System.lineSeparator();

	public Sistema() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.respondeuQuestoes = new ArrayList<>();
	}

	public String cadastraAluno(String matricula, String nome, String curso) {
		if (!alunos.containsKey(matricula)) {
			this.alunos.put(matricula, new Aluno(matricula, nome, curso));
			return "CADASTRO REALIZADO!" + NL;
		} else {
			return "MATRÍCULA JÁ CADASTRADA!" + NL;
		}
	}

	public String exibeAluno(String matricula) {
		String saida = "";
		if (alunos.containsKey(matricula)) {
			saida = "Aluno: " + alunos.get(matricula);
		} else {
			saida = "Aluno não cadastrado.";
		}
		return saida + NL;
	}

	public String cadastraGrupo(String nome) {
		if (!grupos.containsKey(nome.toLowerCase())) {
			this.grupos.put(nome.toLowerCase(), (new Grupo(nome)));
			return "CADASTRO REALIZADO!" + NL;
		} else {
			return "GRUPO JÁ CADASTRADO!" + NL;
		}
	}

	public String alocaAluno(String nomeGrupo, String matricula) {
		if (alunos.containsKey(matricula)) {
			if (grupos.containsKey(nomeGrupo.toLowerCase())) {
				grupos.get(nomeGrupo.toLowerCase()).alocaAluno(alunos.get(matricula));
				return "ALUNO ALOCADO!" + NL;
			} else {
				return "Grupo não cadastrado." + NL;
			}
		}
		return "Aluno não cadastrado." + NL;
	}

	public String imprimeGrupos(String nomeGrupo) {
		String saida = NL + "Alunos do grupo " + nomeGrupo + ":" + NL;
		if (grupos.containsKey(nomeGrupo.toLowerCase())) {
			saida += grupos.get(nomeGrupo.toLowerCase());
		} else {
			saida = "Grupo não cadastrado.";
		}
		return saida;
	}

	public String cadastraQuemRespondeu(String matricula) {
		if (alunos.containsKey(matricula)) {
			this.respondeuQuestoes.add(alunos.get(matricula));
			return "ALUNO REGISTRADO!" + NL;
		}
		return "Aluno não cadastrado." + NL;
	}

	public String imprimeQuemRepondeu() {
		String saida = "";
		for (int i = 0; i < respondeuQuestoes.size(); i++) {
			saida += i + 1 + ". " + respondeuQuestoes.get(i).toString() + NL;
		}
		return saida;
	}
}