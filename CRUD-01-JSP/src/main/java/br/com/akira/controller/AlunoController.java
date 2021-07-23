package br.com.akira.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.akira.dao.AlunoDAO;
import br.com.akira.model.Aluno;

@WebServlet("/aluControll")
public class AlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AlunoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		System.out.println("ACTION = "+action);
		
		//redirect alunoController, if action=null return list Aluno
		if(action==null) {
			action="listAluno";
		}

		if (action.equals("listAluno")) {
			listAluno(request, response);
		}
		else if (action.equals("formAddAluno")) {
			formAddAluno(request, response);
		}
		else if (action.equals("formUpdateAluno")) {
			formUpdateAluno(request, response);
		}
		else if (action.equals("deleteAluno")) {
			deleteAluno(request, response);
		}

	}

	private void deleteAluno(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idAluno = request.getParameter("idAluno");
		
		Aluno a = new Aluno();
		a.setIdAluno(Integer.parseInt(idAluno));
		
		AlunoDAO dao = new AlunoDAO();
		dao.deleteAluno(a);
		
		response.sendRedirect("aluControll");
	}

	private void formUpdateAluno(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idAluno = request.getParameter("idAluno");

		Aluno a = new Aluno();
		a.setIdAluno(Integer.parseInt(idAluno));

		AlunoDAO dao = new AlunoDAO();
		Aluno findByIdAluno = dao.findByIdAluno(a);
		
		request.setAttribute("findByIdAluno", findByIdAluno);
		request.getRequestDispatcher("WEB-INF/formUpdateAluno.jsp").forward(request, response);
	}

	private void formAddAluno(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/formAddAluno.jsp").forward(request, response);
	}

	private void listAluno(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AlunoDAO dao = new AlunoDAO();
		List<Aluno> listAlu = dao.listAluno();

		request.setAttribute("listAlu", listAlu);
		request.getRequestDispatcher("WEB-INF/listAluno.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idAluno = request.getParameter("idAluno");
		String nome = request.getParameter("nome");
		String idade = request.getParameter("idade");

		Aluno a = new Aluno();
		if (idAluno != null) {
			a.setIdAluno(Integer.parseInt(idAluno));
		}
		a.setNome(nome);
		a.setIdade(Integer.parseInt(idade));

		// ADD or EDIT
		AlunoDAO dao = new AlunoDAO();
		dao.saveAluno(a);
		
		//redirect alunoController, if action=null return list Aluno
		response.sendRedirect("aluControll");
	}

}
