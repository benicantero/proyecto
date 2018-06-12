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
	private Object[][] dataXml;
	private String[] cabecerasColumnas = {"ID","CITY","COUNTRY","POSTAL CODE","LATITUDE","LONGITUDE","UPDATE"};

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

	@Override
	public boolean insertarCiudad(CiudadesDTO ciudad) {
		String sqlInsertarCiudad = "INSERT into ciudades (id, City, Country, Postal_Code, Latitude, Longitude ) VALUES (?,?,?,?,?,?);";
		try (PreparedStatement preparedST = conexion.prepareStatement(sqlInsertarCiudad);){
			preparedST.setInt(1, ciudad.getId());
			preparedST.setString(2, ciudad.getCity());
			preparedST.setString(3, ciudad.getCountry());
			preparedST.setString(4, ciudad.getPostal_Code());
			preparedST.setDouble(5, ciudad.getLatitude());
			preparedST.setDouble(6, ciudad.getLongitude());
			return preparedST.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean insertarListaCiudades(List<CiudadesDTO> listaCiudades) {
		try {
			conexion.setAutoCommit(true);
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
	public boolean borrarCiudad(CiudadesDTO ciudad) {
		String sqlBorrarCiudad = "DELETE from ciudades where id = ?;";
		try (PreparedStatement preparedStatement = conexion.prepareStatement(sqlBorrarCiudad);){
			preparedStatement.setInt(1, ciudad.getId());
			return !preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean borrarListaCiudades(List<CiudadesDTO> lista) {
		try {
			conexion.setAutoCommit(true);
			for (CiudadesDTO ciudadesDTO : lista) {
				borrarCiudad(ciudadesDTO);
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean actualizarCiudad(CiudadesDTO ciudad) {
		String sqlActualizarCiudad = "UPDATE ciudades SET City=?, Country=?, Postal_Code=?, Latitude=?, Longitude=? WHERE id=?;";
		try (PreparedStatement preparedStatement = conexion.prepareStatement(sqlActualizarCiudad);){
			preparedStatement.setString(1, ciudad.getCity());
			preparedStatement.setString(2, ciudad.getCountry());
			preparedStatement.setString(3, ciudad.getPostal_Code());
			preparedStatement.setDouble(4, ciudad.getLatitude());
			preparedStatement.setDouble(5, ciudad.getLongitude());
			preparedStatement.setInt(6, ciudad.getId());			
			return preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean actualizarListaCiudades(List<CiudadesDTO> lista) {
		try {
			conexion.setAutoCommit(true);
			for (CiudadesDTO ciudadesDTO : lista) {
				actualizarCiudad(ciudadesDTO);
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public List<CiudadesDTO> listarCiudades() {
		List<CiudadesDTO> lista = new ArrayList<>();
		String sqlListarCiudades = "SELECT * from ciudades;";
		try(PreparedStatement preparedStatement = conexion.prepareStatement(sqlListarCiudades);
				ResultSet result = preparedStatement.executeQuery();) {
			while (result.next()) {
				lista.add(new CiudadesDTO(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),
						result.getDouble(5), result.getDouble(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public void llenarObjetoBidimensional(List<CiudadesDTO> lista) {
		dataXml = new Object[lista.size()][7];
		int contador = 0;

		for (CiudadesDTO ciudad : listarCiudades()) {
			dataXml[contador][0] = ciudad.getId();
			dataXml[contador][1] = ciudad.getCity();
			dataXml[contador][2] = ciudad.getCountry();
			dataXml[contador][3] = ciudad.getPostal_Code();
			dataXml[contador][4] = ciudad.getLatitude();
			dataXml[contador][5] = ciudad.getLongitude();
			dataXml[contador][6] = Boolean.FALSE;
			contador++;
		}
	}


	@Override
	public CiudadesDTO buscarCiudad (String ciudad) {
		CiudadesDTO ciudadBuscada = null;
		String sqlBuscarCiudades = "SELECT * from ciudades WHERE CITY = ?;";
		try (PreparedStatement preparedStatement = conexion.prepareStatement(sqlBuscarCiudades);){
			preparedStatement.setString(1, ciudad);
			ResultSet result = preparedStatement.executeQuery();
			ciudadBuscada = new CiudadesDTO(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),
					result.getDouble(5), result.getDouble(6));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ciudadBuscada;
	}

	
	public Object[][] getDataXml() {
		return dataXml;
	}

	public void setDataXml(Object[][] dataXml) {
		this.dataXml = dataXml;
	}

	public String[] getCabecerasColumnas() {
		return cabecerasColumnas;
	}

	public void setCabecerasColumnas(String[] cabecerasColumnas) {
		this.cabecerasColumnas = cabecerasColumnas;
	}

}
