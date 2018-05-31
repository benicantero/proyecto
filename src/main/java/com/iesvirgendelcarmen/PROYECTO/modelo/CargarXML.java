package com.iesvirgendelcarmen.PROYECTO.modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class CargarXML {
	
	private List<CiudadesDTO> listaCiudades = new ArrayList<>();
	
	public List<CiudadesDTO> getListaCiudades(String ruta) {

		try {
			//api para entender XML
			SAXBuilder builder = new SAXBuilder();
			//carga el fichero
			File xmlFile = new File(ruta);
			//Se crea el documento a traves del archivo
			Document document = (Document) builder.build(xmlFile);
			//Se obtiene la raiz 'dataset'
			Element rootNode = document.getRootElement();
			//Se obtiene la lista de hijos de la raiz 'dataset'
			List<Element> list = rootNode.getChildren("record");
			for (int i = 0; i<list.size(); i++ ){
				//Se obtiene cada nodo
				Element node = (Element)list.get(i);
				listaCiudades.add(new CiudadesDTO((Integer.parseInt(node.getChildText("id"))), node.getChildText("City"), 
						node.getChildText("Country"), node.getChildText("Postal_Code") ,Double.parseDouble(node.getChildText("Latitude")) , 
						Double.parseDouble(node.getChildText("Longitude"))));
			}
			
		} catch ( IOException | JDOMException io ) {
			System.out.println( io.getMessage() );
		}
		return listaCiudades;
	}
}
