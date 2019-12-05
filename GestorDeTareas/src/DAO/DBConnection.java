package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	private static Connection instance = null;

	public DBConnection() {
	}

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		try {
			if (instance == null) {
				Class.forName("com.mysql.jdbc.Driver");
				instance = (Connection) DriverManager.getConnection("jdbc:mysql://halifaxtraining.es:3306/ciberkaos018", "uss018", "leon2019");
				//crearTablas();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return instance;
	}

	/*public static void crearTablas() throws SQLException {
		tablaTarea();
	}

	public static void tablaTarea() throws SQLException {
		PreparedStatement ps=null;
		try {
			ps = getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS Tareas ("
					+ "id int auto_increment primary key ," + "pid int," + "nombre varchar(20)," + "descripcion varchar(100)"
					+ "categoria int," + "estado int," + "fechaIni varchar(10)," + "fechaFin varchar(10),"
					+ "importancia int," +");");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ps.executeUpdate();
		ps.close();
	}
	*/

}