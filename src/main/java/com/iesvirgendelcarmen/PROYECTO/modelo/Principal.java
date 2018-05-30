package com.iesvirgendelcarmen.PROYECTO.modelo;

public class Principal {

	
	public static void main(String[] args) {
		
		CargarXML cargarXML = new CargarXML();
		
		System.out.println(cargarXML.getListaCiudades("archivoXml/ciudades.xml"));
		
	}
}
