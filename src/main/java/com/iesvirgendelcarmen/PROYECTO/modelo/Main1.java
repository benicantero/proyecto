package com.iesvirgendelcarmen.PROYECTO.modelo;

import java.util.ArrayList;
import java.util.List;

public class Main1 {

	public static void main(String[] args) {

		CargarXML cargarXML = new CargarXML();
		CiudadesDAOImp manipularCiudades = new CiudadesDAOImp();
		List<CiudadesDTO> listaCiudades = cargarXML.getListaCiudades("Ficheros/ciudades.xml");
		List<CiudadesDTO> lista2 = manipularCiudades.listarCiudades();

		if(lista2.size()<=0) {
			System.out.println("La BBDD existe pero no tiene datos... Insertamos datos");
			manipularCiudades.crearTabla();
			manipularCiudades.insertarListaCiudades(listaCiudades);
			lista2=manipularCiudades.listarCiudades();  //llena la lista con un select
		}else System.out.println("La BBDD existe y contiene datos");
		System.out.println("Tamaño inicial: " + lista2.size());
		CiudadesDTO ciudad1 = new CiudadesDTO(1001, "Ciudad" , "Pais", "0000AS", 230.52, 25.25 ); 
		CiudadesDTO ciudad2 = new CiudadesDTO(1002, "Ciudad" , "Pais", "0000AS", 230.52, 25.25 ); 
		CiudadesDTO ciudad3 = new CiudadesDTO(1003, "Ciudad" , "Pais", "0000AS", 230.52, 25.25 ); 
		CiudadesDTO ciudad4 = new CiudadesDTO(1004, "Ciudad" , "Pais", "0000AS", 230.52, 25.25 ); 
		CiudadesDTO ciudad5 = new CiudadesDTO(1005, "Ciudad" , "Pais", "0000AS", 230.52, 25.25 ); 
		manipularCiudades.insertarCiudad(ciudad1);
		manipularCiudades.insertarCiudad(ciudad2);
		manipularCiudades.insertarCiudad(ciudad3);
		manipularCiudades.insertarCiudad(ciudad4);
		manipularCiudades.insertarCiudad(ciudad5);
		lista2=manipularCiudades.listarCiudades();
		System.out.println("Tamaño despues de insertar las ciudades: " + lista2.size());
//		System.out.println(lista2);
		System.out.println("Borrado efectuado: " + manipularCiudades.borrarCiudad(ciudad1));
		lista2=manipularCiudades.listarCiudades();
		System.out.println("Tamaño despues del borrado: " + lista2.size());
//		System.out.println(lista2);
		CiudadesDTO ciudad6 = new CiudadesDTO(1006, "Ciudad" , "Pais", "0000AS", 230.52, 25.25 ); 
		CiudadesDTO ciudad7 = new CiudadesDTO(1007, "Ciudad" , "Pais", "0000AS", 230.52, 25.25 ); 
		CiudadesDTO ciudad8 = new CiudadesDTO(1008, "Ciudad" , "Pais", "0000AS", 230.52, 25.25 ); 
		CiudadesDTO ciudad9 = new CiudadesDTO(1009, "Ciudad" , "Pais", "0000AS", 230.52, 25.25 ); 
		CiudadesDTO ciudad10 = new CiudadesDTO(1010, "Ciudad" , "Pais", "0000AS", 230.52, 25.25 ); 
		List<CiudadesDTO> listaInsertar = new ArrayList<>();
		listaInsertar.add(ciudad6);
		listaInsertar.add(ciudad7);
		listaInsertar.add(ciudad8);
		listaInsertar.add(ciudad9);
		listaInsertar.add(ciudad10);
//		System.out.println(listaInsertar);
		manipularCiudades.insertarListaCiudades(listaInsertar);
		lista2=manipularCiudades.listarCiudades();
		System.out.println("Tamaño despues de la insercion de la lista: " + lista2.size());
		
	}
}
