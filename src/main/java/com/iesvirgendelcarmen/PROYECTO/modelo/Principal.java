package com.iesvirgendelcarmen.PROYECTO.modelo;

import java.awt.EventQueue;
import com.iesvirgendelcarmen.PROYECTO.controlador.ControladorMenu;
import com.iesvirgendelcarmen.PROYECTO.vista.TablaMenu;

public class Principal {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				TablaMenu ventana = new TablaMenu();
				ControladorMenu controlador = new ControladorMenu(ventana);

			}
		});
	}
}
