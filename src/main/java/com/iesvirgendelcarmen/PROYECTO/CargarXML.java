package com.iesvirgendelcarmen.PROYECTO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class CargarXML {


	public static void main(String[] args) {

		try {
			//api para entender XML
			SAXBuilder builder = new SAXBuilder();
			//carga el fichero
			File xmlFile = new File("archivoXml\\ciudades.xml");
			//Se crea el documento a traves del archivo
			Document document = (Document) builder.build(xmlFile);

			//Se obtiene la raiz 'dataset'
			Element rootNode = document.getRootElement();

			//Se obtiene la lista de hijos de la raiz 'dataset'
			List list = rootNode.getChildren("record");

			List<Nodos> llenarNodos = new ArrayList<>();
			for (int i = 0; i<list.size(); i++ ){

				//Se obtiene cada nodo
				Element node = (Element)list.get(i);

				llenarNodos.add(new Nodos(node.getChildText("city"), node.getChildText("country"), node.getChildText("post_code"),
						node.getChildText("latitude"), node.getChildText("longitude")));

			}
			System.out.println(llenarNodos);
		} catch ( IOException | JDOMException io ) {
			System.out.println( io.getMessage() );
		}
	}
}
