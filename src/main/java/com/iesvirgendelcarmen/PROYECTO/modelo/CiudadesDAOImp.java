package com.iesvirgendelcarmen.PROYECTO.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CiudadesDAOImp implements CiudadesDAO{

	Connection conexion = Conexion.getConexion();

//	id INTEGER PRIMARY KEY 
//	City TEXT
//	Country TEXT
//	Postal_Code TEXT
//	Latitude NUMBER
//	Longitude NUMBER
	
	@Override
	public boolean insertarCiudad(CiudadesDTO ciudad) {
		String sql = "INSERT into ciudades (id, City, Country, Postal_Code, Latitude, Longitude ) VALUES (?,?,?,?,?,?);";
		try (PreparedStatement preparedST = conexion.prepareStatement(sql);){
			preparedST.setInt(1, ciudad.getId());
			preparedST.setString(2, ciudad.getCity());
			preparedST.setString(3, ciudad.getCountry());
			preparedST.setString(4, ciudad.getPostal_Code());
			preparedST.setDouble(5, ciudad.getLatitude());
			preparedST.setDouble(6, ciudad.getLongitude());
			return preparedST.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean insertaListaCiudades(List<CiudadesDTO> listaCiudades) {
		try {
			conexion.setAutoCommit(false);
			for (CiudadesDTO ciudades : listaCiudades) {
				insertarCiudad(ciudades);
			}
			return true;
		} catch (SQLException e) {
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				return false;
			}
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean borrarCiudad() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarCiudad() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CiudadesDTO> listarCiudades() {
		List<CiudadesDTO> lista = new ArrayList<>();
		String sql = "SELECT * from ciudades;";
		try(PreparedStatement preparedStatement = conexion.prepareStatement(sql);
				ResultSet result = preparedStatement.executeQuery();) {
			while (result.next()) {
				lista.add(new CiudadesDTO(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),
						result.getDouble(5), result.getDouble(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public void crearTabla() {
		
		String sqlCrearBD = "CREATE TABLE IF NOT EXISTS ciudades (" + 
				"        id INTEGER PRIMARY KEY," + 
				"        City TEXT," +
				"        Country TEXT, " +
				"        Postal_Code TEXT," +
				"        Latitude NUMBER," +
				"        Longitude NUMBER" +
				");";

		try {
			Statement statement = conexion.createStatement();
			statement.executeUpdate(sqlCrearBD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
