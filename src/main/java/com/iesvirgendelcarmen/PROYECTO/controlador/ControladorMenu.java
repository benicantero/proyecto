package com.iesvirgendelcarmen.PROYECTO.controlador;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;
import com.iesvirgendelcarmen.PROYECTO.modelo.CargarXML;
import com.iesvirgendelcarmen.PROYECTO.modelo.CiudadesDAOImp;
import com.iesvirgendelcarmen.PROYECTO.modelo.CiudadesDTO;
import com.iesvirgendelcarmen.PROYECTO.modelo.CreateLogs;
import com.iesvirgendelcarmen.PROYECTO.modelo.Excepciones;
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
	CreateLogs log = new CreateLogs();

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
				insertarCiudad();
				break;
			case "Buscar":
				buscarCiudad();
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
				JOptionPane.showMessageDialog( null, "Benigno Cantero - Junio 2018", "App Info", JOptionPane.INFORMATION_MESSAGE);
				break;
			default:
				break;
			}
		}
	}

	private void buscarCiudad() {
		Object[] textField = {
				"Ciudad", vista.getTextFieldbuscador()};
		int result = JOptionPane.showConfirmDialog(null, textField, "BÚSQUEDA CIUDADES", JOptionPane.OK_CANCEL_OPTION);
		String busquedaCiudad = vista.getTextFieldbuscador().getText();
		if(result==JOptionPane.OK_OPTION) {
			CiudadesDTO ciudadDeTabla = utilizarDaoImp.buscarCiudad(busquedaCiudad);
			if (ciudadDeTabla!=null) {
				JOptionPane.showMessageDialog(null, "Ciudad: "+ciudadDeTabla.getCity()+
						"\nID: "         + ciudadDeTabla.getId()+
						"\nCountry: "    +ciudadDeTabla.getCountry()+
						"\nPostal Code: "+ciudadDeTabla.getPostal_Code()+
						"\nLatiude: "    + ciudadDeTabla.getLatitude() + 
						"\nLongitude: "  +ciudadDeTabla.getLongitude());
			} else
				JOptionPane.showMessageDialog(null,"No se han encontrado datos");
		}		
	}

	private void actualizarDatosYTabla () {
		List<CiudadesDTO> listaSeleccionados = new ArrayList<>();
		int id = 0;
		String city, country, postal_code;
		double latitude, longitude;
		for (int i = 0; i < listaCiudades.size(); i++) {
			if((boolean)vista.getTabla().getValueAt(i, 6)) {
				id= (int) vista.getTabla().getValueAt(i, 0);
				city = (String) vista.getTabla().getValueAt(i, 1);
				country = (String) vista.getTabla().getValueAt(i, 2);
				postal_code = (String) vista.getTabla().getValueAt(i, 3);
				latitude = Double.parseDouble(vista.getTabla().getValueAt(i, 4).toString());
				longitude =  Double.parseDouble(vista.getTabla().getValueAt(i, 5).toString());
				CiudadesDTO ciudadAñadida;
				try {
					ciudadAñadida = new CiudadesDTO(id, city, country, postal_code, latitude, longitude);
					utilizarDaoImp.actualizarCiudad(ciudadAñadida);
					JOptionPane.showMessageDialog( null, "Actualización realizada", "ACTUALIZACIÓN", JOptionPane.INFORMATION_MESSAGE);
				} catch (Excepciones e) {
					log.hacerLog("Error al actualizar lista", id);
				}

			}	
		}
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
				CiudadesDTO ciudadAñadida;
				try {
					
					int opcion = JOptionPane.showConfirmDialog(null, "Confirmacion de borrado", "BORRADO", JOptionPane.OK_CANCEL_OPTION);
//				System.out.println(opcion);
					if (opcion == JOptionPane.OK_OPTION) {
						ciudadAñadida = new CiudadesDTO(id, city, country, postal_code, latitude, longitude);
						listaSeleccionados.add(ciudadAñadida);
						utilizarDaoImp.borrarListaCiudades(listaSeleccionados); 
					}
				} catch (Excepciones e) {
					log.hacerLog("No se puede borrar datos de tabla", id);
				}
			}
		}
		utilizarDaoImp.borrarListaCiudades(listaSeleccionados);
		llenarTabla();
	}


	private void insertarCiudad () {
		listaCiudades = utilizarDaoImp.listarCiudades();
		boolean existe = false;
		int id=0;
		String city= null, country=null, postal_code=null;
		double latitude, longitude;
		if(vista.getTextField_id().getText().equals(""))//controla la entradad del id para que no de excepcion si se queda vacío
			id = 0;
		else 
			id = Integer.parseInt(vista.getTextField_id().getText());
		city = vista.getTextField_City().getText();
		country = vista.getTextField_Country().getText();
		postal_code = vista.getTextField_Postal_Code().getText();
		if(vista.getTextField_latitude().getText().equals("")) //controla la entrada de la latitude para que no de excepcion si viene vacio
			latitude = 0.0;
		else
			latitude = Double.parseDouble(vista.getTextField_latitude().getText());
		if (vista.getTextField_longitude().getText().equals(""))//controla la entrada de la longitude para que no de excepcion si viene vacio
			longitude = 0.0;
		else
			longitude = Double.parseDouble(vista.getTextField_longitude().getText());
		CiudadesDTO ciudadInsertada;
		try {
			ciudadInsertada = new CiudadesDTO(id, city, country, postal_code, latitude, longitude);
			for (int i = 0; i < listaCiudades.size(); i++) { //controla que no exista el id introducido
				if (id == listaCiudades.get(i).getId()) existe = true;
			}
			if(id == 0 || existe) {
				JOptionPane.showMessageDialog( null, "No se puede insertar ciudad. ID existente o campo no insertado", "ERROR ID", JOptionPane.INFORMATION_MESSAGE);
			}else {
				utilizarDaoImp.insertarCiudad(ciudadInsertada);
				JOptionPane.showMessageDialog( null, "Ciudad insertada correctamente", "INSERCIÓN CORRECTA", JOptionPane.INFORMATION_MESSAGE);
				llenarTabla();
			}
		} catch (Excepciones e) {
			log.hacerLog("Error al insertar ciudad", id);
		}
		llenarTabla();
	}


	private void introducirFichero(){

		JFileChooser jFileChooser = new JFileChooser("./Ficheros");
		int resultado = jFileChooser.showOpenDialog(vista.getFrame());
		if(resultado == JFileChooser.APPROVE_OPTION) {
			path = jFileChooser.getSelectedFile().getPath();
			listaCiudadesEstaticas = cargarXml.getListaCiudades(path);
			listaCiudades = utilizarDaoImp.listarCiudades();
			if(listaCiudades.size()<=0) {
				utilizarDaoImp.crearTabla();
				utilizarDaoImp.insertarListaCiudades(listaCiudadesEstaticas);
				listaCiudades = utilizarDaoImp.listarCiudades();
			}
			vista.getBtnActualizar().setEnabled(true);
			vista.getBtnBorrar().setEnabled(true);
			vista.getBtnInsertar().setEnabled(true);
			vista.getMnArchivo().setEnabled(true);
			vista.getMntmCargarBd().setEnabled(true);
			vista.getBtnBuscar().setEnabled(true);
		}else if(resultado == JFileChooser.CANCEL_OPTION) {
			path = ".";
		}
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
