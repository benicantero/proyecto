package com.iesvirgendelcarmen.PROYECTO.modelo;

import java.util.List;

public class CiudadesDTOImp implements CiudadesDAO{

	@Override
	public boolean insertarCiudad() {
		String sql = "INSERT into CIUDADES VALUES";
		
		return false;
	}

	@Override
	public boolean insertaListaCiudades(List<CiudadesDTO> lista) {
		// TODO Auto-generated method stub
		return false;
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
		//String sql = ""
		return null;
	}

	/*@Override
	public boolean crearBaseDatos() {
		String sql = "CREATE TABLE Ciudades (Id number primary key);";
		return false;
	}*/

}
