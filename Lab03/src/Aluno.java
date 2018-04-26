
public class Aluno {
	private String nome;
	private String matricula;
	private String curso;

	public Aluno(String matricula, String nome, String curso) {
		if (matricula == null) {
			throw new NullPointerException("Matricula nula!");
		}
		if (nome == null) {
			throw new NullPointerException("Nome nulo!");
		}
		if (curso == null) {
			throw new NullPointerException("Curso nulo!");
		}
		if (matricula.trim().isEmpty()) {
			throw new IllegalArgumentException("Matricula invalida!");
		}
		if (nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome invalido!");
		}
		if (curso.trim().isEmpty()) {
			throw new IllegalArgumentException("Curso invalido!");
		}
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
	}

	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}

	public String getMatricula() {
		return this.matricula;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
}