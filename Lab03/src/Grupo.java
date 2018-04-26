
import java.util.HashSet;

public class Grupo {

	private String nome;
	private HashSet<Aluno> alunos;
	private final String NL = System.lineSeparator();

	public Grupo(String nome) {
		if (nome == null) {
			throw new NullPointerException("Nome nulo!");
		}
		if (nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome invalido!");
		}
		this.nome = nome;
		this.alunos = new HashSet<Aluno>();
	}

	public String getNome() {
		return this.nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public void alocaAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}

	public String toString() {
		String saida = "";
		for (Aluno aluno : alunos) {
			saida += "* " + aluno.toString() + NL;
		}
		return saida;
	}
}