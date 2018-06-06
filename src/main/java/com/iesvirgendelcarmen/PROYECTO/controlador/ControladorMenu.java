package com.iesvirgendelcarmen.PROYECTO.controlador;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.iesvirgendelcarmen.PROYECTO.modelo.CargarXML;
import com.iesvirgendelcarmen.PROYECTO.modelo.CiudadesDAOImp;
import com.iesvirgendelcarmen.PROYECTO.modelo.CiudadesDTO;
import com.iesvirgendelcarmen.PROYECTO.vista.TablaMenu;

public class ControladorMenu implements ActionListener{

	private TablaMenu vista; 
	private String path;
	private List<CiudadesDTO> listaCiudades;
	private CargarXML cargarXml = new CargarXML();
	CiudadesDAOImp utilizarDaoImp = new CiudadesDAOImp();
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
		vista.getBtnAnterior().addActionListener(this);
		vista.getBtnSiguiente().addActionListener(this);
		vista.getBtnInsertar().addActionListener(this);

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
				//				vista.inse
				//				CiudadesDTO ciudad = vista.getTabla().getSelectedRow();
				//				utilizarDaoImp.actualizarCiudad(ciudad);
				break;
			case "Insertar":

				break;
			case "Borrar":

				break;
			case "Anterior":

				break;
			case "Siguiente":

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

	private void introducirFichero(){
		JFileChooser jFileChooser = new JFileChooser("./Ficheros");
		int resultado = jFileChooser.showOpenDialog(vista.getFrame());
		if(resultado == JFileChooser.APPROVE_OPTION)
			path = jFileChooser.getSelectedFile().getPath();
		else if(resultado == JFileChooser.CANCEL_OPTION) {
			path = ".";
		}
		listaCiudades = cargarXml.getListaCiudades(path);
		vista.getBtnActualizar().setEnabled(true);
		vista.getBtnAnterior().setEnabled(true);
		vista.getBtnBorrar().setEnabled(true);
		vista.getBtnInsertar().setEnabled(true);
		vista.getBtnSiguiente().setEnabled(true);
		vista.getMnArchivo().setEnabled(true);
		vista.getMntmCargarBd().setEnabled(true);
		utilizarDaoImp.insertarListaCiudades(listaCiudades);
	}

	private void llenarTabla() {

		List<CiudadesDTO> listaCiudadesTabla = utilizarDaoImp.listarCiudades();
		utilizarDaoImp.llenarObjetoBidimensional(listaCiudadesTabla);
	/*	DefaultTableModel dftModel = new DefaultTableModel(utilizarDaoImp.getDataXml(), utilizarDaoImp.getCabecerasColumnas()) {
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return column !=0;
			}
		};*/
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
	/*	@Override

		public Class getClumnClass (int c) {
			return getValueAt(0, c).getClass();
		}*/
		@Override
		public boolean isCellEditable(int row, int col) {
			return col != 0;
		}

		@Override

		public void setValueAt(Object value, int row, int col) {
			dataXml[row][col] = value;
			fireTableCellUpdated(row, col);
		}
	}
}
