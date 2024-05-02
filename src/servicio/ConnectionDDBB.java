package servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Aqui realizamos la conexion a la BBDD
 */

public class ConnectionDDBB {
	private final static String bbdd = "gestwow";
	private final static String user = "root";
	private final static String passwd = "";
	private final static String tmz = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private final static String bbddURL = "jdbc:mysql://localhost:3306/" + bbdd + tmz;
	private static Connection conx;

	public static Connection connectDDBB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conx = DriverManager.getConnection(bbddURL, user, passwd);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return conx;
	}
}
