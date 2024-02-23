package bbdd;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    static String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static String dbName = "perswow";
	static String url = "jdbc:mysql://localhost:3306/" + dbName + timeZone;
	static String user = "root";
	static String pass = "";
	static String driver = "com.mysql.cj.jdbc.Driver";

    static Connection conexion;
    static Statement consulta;
    static ResultSet resultado;

    public static void Conectar() {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, user, pass);
            System.out.println("La base de datos esta situada en: \n " + url);
            consulta = conexion.createStatement();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }

    public static ResultSet EjecutarSentencia(String Sentencia){
        try{
            resultado = consulta.executeQuery(Sentencia);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return resultado;
    }

    public static void EjecutarUpdate(String sentencia) {
        try{
            consulta.executeQuery(sentencia);
            System.out.println("Done.");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void CerrarConexion(){
        try{
            consulta.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
