package com.iesvirgendelcarmen.PROYECTO.modelo;

import java.io.File;
import java.util.List;


public class Main1 {


	public static void main(String[] args) {

		CargarXML cargarXML = new CargarXML();
		CiudadesDAOImp manipularCiudades = new CiudadesDAOImp();
//		System.out.println(cargarXML.getListaCiudades("archivoXml/ciudades.xml"));
		List<CiudadesDTO> listaCiudades = cargarXML.getListaCiudades("archivoXml/ciudades.xml");
		//System.out.println(listaCiudades);
//		File file = new File("BD/ciudades");
//		System.out.println(file.exists());
		List<CiudadesDTO> lista2 = manipularCiudades.listarCiudades();
//		System.out.println(listaCiudades.size());
		
		if(lista2.size()<=0) {
			System.out.println("La BBDD existe pero no tiene datos... Insertamos datos");
			manipularCiudades.crearTabla();
			manipularCiudades.insertaListaCiudades(listaCiudades);
		}else System.out.println("La BBDD existe y contiene datos");
		
		//		System.out.println("pepe");
		//		System.out.println(manipularCiudades.insertaListaCiudades(listaCiudades));		
		System.out.println(manipularCiudades.listarCiudades().get(1));

	}
}
