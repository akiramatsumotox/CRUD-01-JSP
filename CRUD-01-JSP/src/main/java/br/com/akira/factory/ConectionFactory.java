package br.com.akira.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Akira Matsumoto
 *
 */
public class ConectionFactory {

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/bancoCRUD01JSP", "root", "");
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

}
