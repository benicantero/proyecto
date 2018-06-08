package com.iesvirgendelcarmen.PROYECTO.controlador;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import com.iesvirgendelcarmen.PROYECTO.modelo.CargarXML;
import com.iesvirgendelcarmen.PROYECTO.modelo.CiudadesDAOImp;
import com.iesvirgendelcarmen.PROYECTO.modelo.CiudadesDTO;
import com.iesvirgendelcarmen.PROYECTO.vista.TablaMenu;

public class ControladorMenu implements ActionListener{

	private TablaMenu vista; 
	private String path;
	private List<CiudadesDTO> listaCiudades;
	private static List<CiudadesDTO> listaCiudadesEstaticas;
	private CargarXML cargarXml = new CargarXML();
	CiudadesDAOImp utilizarDaoImp = new CiudadesDAOImp();
	Boolean check;
	Dimension dimension;
	JScrollPane scrollPane;
	int filas = 20;

	public ControladorMenu(TablaMenu vista) {
		this.vista = vista;
		registrarBotones();
	}

	private void registrarBotones() {
		vista.getBtnActualizar().addActionListener(this);
		vista.getBtnBorrar().addActionListener(this);
		vista.getBtnInsertar().addActionListener(this);
		vista.getBtnBuscar().addActionListener(this);


		vista.getMntmAcercaDe().addActionListener(this);
		vista.getMnArchivo().addActionListener(this);
		vista.getMntmCargarBd().addActionListener(this);
		vista.getMntmSalir().addActionListener(this);

	}


	@Override
	public void actionPerformed(ActionEvent e){
		//		if(e.getSource().getClass() == KeyStroke.getKeyStrok) )


		if(e.getSource().getClass() == JButton.class){
			JButton boton =(JButton)e.getSource();
			String botonString = boton.getText();
			switch (botonString) {
			case "Actualizar":
				actualizarDatosYTabla();
				break;
			case "Borrar":
				borrarDatosTabla();
				break;
			case "INSERTAR":
				System.out.println("hola");
				insertarCiudadEnTabla();
				break;
			case "Buscar":

				break;
			default:
				break;
			}
		}

		if(e.getSource().getClass() == JMenuItem.class) {
			JMenuItem menuItem = (JMenuItem) e.getSource();
			String menuString = menuItem.getText();
			switch (menuString) {
			case "Cargar BD" :
				introducirFichero();
				llenarTabla();
				break;
			case "Salir" :
				System.exit(0);
				break;
			case "Acerca" :
				JOptionPane.showMessageDialog( null, "Benigno Cantero - Junio 2018", "Info", JOptionPane.INFORMATION_MESSAGE);
				break;
			default:
				break;
			}
		}
	}

	private void actualizarDatosYTabla () {
		List<CiudadesDTO> listaSeleccionados = new ArrayList<>();
		int id = 0;
		String city, country, postal_code;
		double latitude, longitude;
		for (int i = 0; i < listaCiudades.size(); i++) {
			if((boolean)vista.getTabla().getValueAt(i, 6)) {
				id=(int) vista.getTabla().getValueAt(i, 0);
				city = (String) vista.getTabla().getValueAt(i, 1);
				country = (String) vista.getTabla().getValueAt(i, 2);
				postal_code = (String) vista.getTabla().getValueAt(i, 3);
				latitude = (Double) vista.getTabla().getValueAt(i, 4);
				longitude = (Double) vista.getTabla().getValueAt(i, 5);
				CiudadesDTO ciudadAñadida = new CiudadesDTO(id, city, country, postal_code, latitude, longitude);
				utilizarDaoImp.actualizarCiudad(ciudadAñadida);
			}//controlar no item marcado
		}
		//		if(listaSeleccionados.size()<=0) JOptionPane.showMessageDialog(parentComponent, message);
		utilizarDaoImp.actualizarListaCiudades(listaSeleccionados);
		llenarTabla();
	}

	private void borrarDatosTabla () {
		List<CiudadesDTO> listaSeleccionados = new ArrayList<>();
		int id = 0;
		String city, country, postal_code;
		double latitude, longitude;
		listaCiudades= utilizarDaoImp.listarCiudades();
		for (int i = 0; i < listaCiudades.size(); i++) {
			if((boolean)vista.getTabla().getValueAt(i, 6)) {
				id=(int) vista.getTabla().getValueAt(i, 0);
				city = (String) vista.getTabla().getValueAt(i, 1);
				country = (String) vista.getTabla().getValueAt(i, 2);
				postal_code = (String) vista.getTabla().getValueAt(i, 3);
				latitude = (Double) vista.getTabla().getValueAt(i, 4);
				longitude = (Double) vista.getTabla().getValueAt(i, 5);
				CiudadesDTO ciudadAñadida = new CiudadesDTO(id, city, country, postal_code, latitude, longitude);
				listaSeleccionados.add(ciudadAñadida);
			}//controlar no item marcado
		}
		//		if(listaSeleccionados.size()<=0) JOptionPane.showMessageDialog(parentComponent, message);
		utilizarDaoImp.borrarListaCiudades(listaSeleccionados);
		llenarTabla();
	}


	private void insertarCiudadEnTabla () {
		int id = 0;
		String city, country, postal_code;
		double latitude, longitude;
		id = Integer.parseInt(vista.getTextField_id().getText());
		city = vista.getTextField_City().getText();
		country = vista.getTextField_Country().getText();
		postal_code = vista.getTextField_Postal_Code().getText();
		latitude = Double.parseDouble(vista.getTextField_latitude().getText());
		longitude = Double.parseDouble(vista.getTextField_longitude().getText());
		CiudadesDTO ciudadInsertada = new CiudadesDTO(id, city, country, postal_code, latitude, longitude);
		System.out.println("pepe");
		//	controlar si el id existe
		utilizarDaoImp.insertarCiudad(ciudadInsertada);
		llenarTabla();
	}
	
	
	private void introducirFichero(){
		JFileChooser jFileChooser = new JFileChooser("./Ficheros");
		int resultado = jFileChooser.showOpenDialog(vista.getFrame());
		if(resultado == JFileChooser.APPROVE_OPTION)
			path = jFileChooser.getSelectedFile().getPath();
		else if(resultado == JFileChooser.CANCEL_OPTION) {
			path = ".";
		}
		listaCiudadesEstaticas = cargarXml.getListaCiudades(path);
		listaCiudades = utilizarDaoImp.listarCiudades();
		if(listaCiudades.size()<=0)
			utilizarDaoImp.insertarListaCiudades(listaCiudadesEstaticas);
		vista.getBtnActualizar().setEnabled(true);
		vista.getBtnBorrar().setEnabled(true);
		vista.getBtnInsertar().setEnabled(true);
		vista.getMnArchivo().setEnabled(true);
		vista.getMntmCargarBd().setEnabled(true);

	}

	private void llenarTabla() {

		List<CiudadesDTO> listaCiudadesTabla = utilizarDaoImp.listarCiudades();
		utilizarDaoImp.llenarObjetoBidimensional(listaCiudadesTabla);
		MyTableModel modelo = new MyTableModel();
		vista.getTabla().setModel(modelo);
		vista.getScrollPaneTabla().setViewportView(vista.getTabla());
	}

	class MyTableModel extends AbstractTableModel {

		private String[] cabecerasColumnas = utilizarDaoImp.getCabecerasColumnas();

		//{"ID","CITY","COUNTRY","POSTAL CODE","LATITUDE","LONGITUDE"};
		private Object[][] dataXml = utilizarDaoImp.getDataXml();


		@Override
		public int getColumnCount() {
			return cabecerasColumnas.length;
		}

		@Override
		public int getRowCount() {
			return dataXml.length;
		}

		@Override
		public Object getValueAt(int row, int col) {
			return dataXml[row][col];
		}
		@Override

		public String getColumnName (int col) {
			return cabecerasColumnas[col];
		}

		@Override
		public boolean isCellEditable(int row, int col) {
			return col != 0;
		}

		@Override

		public void setValueAt(Object value, int row, int col) {
			dataXml[row][col] = value;
			fireTableCellUpdated(row, col);
		}

		@Override
		public Class getColumnClass (int col) {
			if(col==6) {
				return Boolean.class;
			}
			return super.getColumnClass(col);
		}
	}
}
