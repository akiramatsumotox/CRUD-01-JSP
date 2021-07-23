package br.com.akira.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.akira.factory.ConectionFactory;
import br.com.akira.model.Aluno;

/**
 * @author Akira Matsumoto
 *
 */
public class AlunoDAO {

	Connection conn = ConectionFactory.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;

	// CREATE Aluno
	public void addAluno(Aluno a) {
		String sql = "INSERT INTO aluno(nome,idade)VALUES(?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, a.getNome());
			ps.setInt(2, a.getIdade());
			ps.execute();
			System.out.println("Add Aluno");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// READ Aluno
	public List<Aluno> listAluno() {
		String sql = "SELECT * FROM aluno";
		ArrayList<Aluno> list = new ArrayList<Aluno>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Aluno a = new Aluno();
				a.setIdAluno(rs.getInt("idAluno"));
				a.setNome(rs.getString("nome"));
				a.setIdade(rs.getInt("idade"));
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// UPDATE Aluno
	public void editAluno(Aluno a) {
		String sql = "UPDATE aluno SET nome=?,idade=? WHERE idAluno=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, a.getNome());
			ps.setInt(2, a.getIdade());
			ps.setInt(3, a.getIdAluno());
			ps.execute();
			System.out.println("Edit Aluno");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// DELETE Aluno
	public void deleteAluno(Aluno a) {
		String sql = "DELETE FROM aluno WHERE idAluno=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, a.getIdAluno());
			ps.execute();
			System.out.println("DELETE Aluno");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//Save Aluno
	//Add or Update
	public void saveAluno(Aluno a) {
		if(a.getIdAluno()==0) {
			addAluno(a);
		}else {
			editAluno(a);
		}
	}
	
	// Find by ID Aluno
		public Aluno findByIdAluno(Aluno aluno) {
			String sql = "SELECT * FROM aluno WHERE idAluno=?";
			Aluno a = new Aluno();
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, aluno.getIdAluno());
				rs = ps.executeQuery();
				if (rs.next()) {
					a.setIdAluno(rs.getInt("idAluno"));
					a.setNome(rs.getString("nome"));
					a.setIdade(rs.getInt("idade"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (ps != null) {
						ps.close();
					}
					if (rs != null) {
						rs.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return a;
		}

}
