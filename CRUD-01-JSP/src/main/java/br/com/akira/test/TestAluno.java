package br.com.akira.test;

import java.util.List;

import br.com.akira.dao.AlunoDAO;
import br.com.akira.model.Aluno;

/**
 * @author Akira Matsumoto
 *
 */
public class TestAluno {

	public static void main(String[] args) {
		
		Aluno a = new Aluno();
		a.setIdAluno(3);
		
		AlunoDAO dao = new AlunoDAO();
		Aluno findByIdAluno = dao.findByIdAluno(a);
		
		System.out.println(findByIdAluno);

//		deleteAluno();
//		updateAluno();
//		addAluno();
//		listAluno();
	}

	private static void deleteAluno() {
		Aluno a = new Aluno();
		a.setIdAluno(3);
		
		AlunoDAO dao = new AlunoDAO();
		dao.deleteAluno(a);
	}

	private static void updateAluno() {
		Aluno a = new Aluno();
		a.setNome("Mario edit");
		a.setIdade(44);
		a.setIdAluno(3);
		
		AlunoDAO dao = new AlunoDAO();
		dao.editAluno(a);
	}

	private static void listAluno() {
		AlunoDAO dao = new AlunoDAO();
		List<Aluno> listAluno = dao.listAluno();
		System.out.println(listAluno);
	}

	private static void addAluno() {
		Aluno a = new Aluno();
		a.setNome("Akira");
		a.setIdade(55);

		AlunoDAO dao = new AlunoDAO();
		dao.addAluno(a);
	}

}
