package com.iesvirgendelcarmen.PROYECTO.modelo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class CreateLogs {

	private static File archivo = new File("ficheros/logs.txt");
	
	public void hacerLog(String comentario, int dato2) {
		
		try (PrintWriter salida = new PrintWriter(new BufferedOutputStream(new FileOutputStream(archivo,true)));){
			salida.println(LocalDateTime.now() +" - " + comentario + " - ID: " + dato2 + "\n" );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
