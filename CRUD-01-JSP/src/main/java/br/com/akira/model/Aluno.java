package br.com.akira.model;

/**
 * @author Akira Matsumoto
 *
 */
public class Aluno {

	private int idAluno;
	private String nome;
	private int idade;
	

	@Override
	public String toString() {
		return "\n"+"idAluno=" + idAluno + ", nome=" + nome + ", idade=" + idade;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
