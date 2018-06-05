package com.iesvirgendelcarmen.PROYECTO.modelo;

import java.util.List;

public interface CiudadesDAO {
	
	public void crearTabla();
	public boolean insertarCiudad(CiudadesDTO ciudad);
	public boolean insertarListaCiudades(List<CiudadesDTO> lista);
	public boolean borrarCiudad(CiudadesDTO ciudad);
	public boolean borrarListaCiudades(List<CiudadesDTO> lista);
	public boolean actualizarCiudad(CiudadesDTO ciudad);
	public List<CiudadesDTO> listarCiudades(); 
	public void llenarObjetoBidimensional(List<CiudadesDTO> lista);

	
}
