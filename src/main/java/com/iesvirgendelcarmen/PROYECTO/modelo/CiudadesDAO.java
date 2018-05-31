package com.iesvirgendelcarmen.PROYECTO.modelo;

import java.util.List;

public interface CiudadesDAO {
	
	public boolean insertarCiudad(CiudadesDTO ciudad);
	public boolean insertaListaCiudades(List<CiudadesDTO> lista);
	public boolean borrarCiudad();
	public boolean actualizarCiudad();
	public List<CiudadesDTO> listarCiudades(); 
	public void crearTabla();

	
}
