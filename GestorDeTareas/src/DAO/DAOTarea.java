package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import Modelo.*;

public class DAOTarea {
	private Connection con = null;

	public static DAOTarea instance = null;

	public DAOTarea() throws SQLException, ClassNotFoundException {
			con = DBConnection.getConnection();
	}

	public static DAOTarea getInstance() throws SQLException, ClassNotFoundException {
		if (instance == null)
			instance = new DAOTarea();
		return instance;
	}
	
	public void insert(Tarea n) throws SQLException {
		PreparedStatement ps = con
				.prepareStatement("INSERT INTO Tarea (nombre, pid, descripcion, categoria, estado, fechaIni, fechaFin, importancia)" + "VALUES" + "(?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, n.getNombre());
		ps.setInt(2, n.getPid());
		ps.setString(3, n.getDescripcion());
		ps.setInt(4, n.getCategoria());
		ps.setInt(5, n.getEstado());
		ps.setString(6, n.getFechaIni().toString());
		ps.setString(7, n.getFechaFin().toString());
		ps.setInt(8, n.getImportancia());
		ps.executeUpdate();
		ps.close();
	}
	
	public void update(Tarea n) throws SQLException {
		String sql="";
		sql="UPDATE Tarea ";
		PreparedStatement ps = con
				.prepareStatement("UPDATE Tarea SET nombre= ?, pid= ?, descripcion= ?, categoria=?, estado=?, fechaIni=?, fechaFin=?, importancia=? WHERE id=?");
		ps.setString(1, n.getNombre());
		ps.setInt(2, n.getPid());
		ps.setString(3, n.getDescripcion());
		ps.setInt(4, n.getCategoria());
		ps.setInt(5, n.getEstado());
		ps.setString(6, n.getFechaIni().toString());
		ps.setString(7, n.getFechaFin().toString());
		ps.setInt(8, n.getImportancia());
		ps.setInt(9, n.getId());
		ps.executeUpdate();
		ps.close();
	}
	
	public ArrayList<Tarea> listaTareas() throws SQLException {
		PreparedStatement psa = con.prepareStatement("SELECT * FROM Tarea");
		ResultSet rs = psa.executeQuery();

		ArrayList<Tarea> result = new ArrayList<Tarea>();

		while (rs.next()) {
			Tarea t = new Tarea(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), 
					rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9));
				result.add(t);
		}
		rs.close();
		psa.close();
		return result;
	}
	
	public void delete(int id) throws SQLException{
		PreparedStatement psa = con.prepareStatement("DELETE FROM Tarea WHERE id=?");
		psa.setInt(1, id);
		psa.executeUpdate();
		psa.close();
	}
	
	/*
	
	public Misiones buscarID(int id) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM ussmisiones WHERE id = ?");
		ps.se;tInt(1, id);
		ResultSet rs = ps.executeQuery();
		Misiones result = null;
		if (rs.next()) {
			result =new Misiones(rs.getInt("id"), rs.getString("nombre"), rs.getInt("nave"),
					rs.getString("descripcion"));
		}
		rs.close();
		ps.close();
		return result;
	}
	
	public void delete(Misiones e) throws SQLException {
		delete(e.getId());
	}

	public void delete(int id) throws SQLException {
		if (id <= 0)
			return;

		PreparedStatement ps = con.prepareStatement("DELETE FROM ussmisiones WHERE id = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
	}
	
	public void update(Misiones n) throws SQLException {
		if (n.getId() == 0)
			return;
		PreparedStatement ps = con.prepareStatement(
				"UPDATE ussmisiones SET nombre = ?, nave = ?, descripcion = ? WHERE id = ?");
		ps.setString(1, n.getNombre());
		ps.setInt(2, n.getNave());
		ps.setString(3, n.getDescripcion());
		ps.setInt(4, n.getId());

		ps.executeUpdate();
		ps.close();
	}
	*/
	
}
