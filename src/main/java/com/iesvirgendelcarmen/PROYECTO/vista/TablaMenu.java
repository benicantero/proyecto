package com.iesvirgendelcarmen.PROYECTO.vista;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class TablaMenu {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmCargarBd;
	private JMenuItem mntmSalir;
	private JMenu mnAcercaDe;
	private JSplitPane splitPane;
	private JPanel panel;
	private JButton btnActualizar;
	private JButton btnBuscar;
	private JButton btnBorrar;
	private JPanel panel_tabla;
	private JTable tabla;
	private JPanel panel_insertar;
	private JMenuItem mntmAcercaDe;
	private JScrollPane scrollPaneTabla;
	private JLabel lblCity;
	private JLabel lblCountry;
	private JLabel lblPostalCode;
	private JLabel lblLatitude;
	private JLabel lblLongitude;
	private JTextField textField_City;
	private JTextField textField_Country;
	private JTextField textField_Postal_Code;
	private JTextField textField_latitude;
	private JTextField textField_longitude;
	private JPanel panel_id;
	private JPanel panel_city;
	private JPanel panel_country;
	private JPanel panel_postal_code;
	private JPanel panel_latitude;
	private JPanel panel_longitude;
	private JLabel label;
	private JTextField textField_id;
	private JButton btnInsertar;


	/**
	 * Create the application.
	 */
	public TablaMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Proyecto Fin de Curso Beni");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 850, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(128, 128, 128));
		frame.setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnArchivo);
		
		mntmCargarBd = new JMenuItem("Cargar BD");
		mnArchivo.add(mntmCargarBd);
		
		mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
		
		mnAcercaDe = new JMenu("Acerca de");
		menuBar.add(mnAcercaDe);
		
		mntmAcercaDe = new JMenuItem("Acerca");
		mnAcercaDe.add(mntmAcercaDe);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		splitPane = new JSplitPane();
		splitPane.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(splitPane);
		
		panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBackground(Color.LIGHT_GRAY);
		panel.add(btnActualizar);
		btnActualizar.setEnabled(false);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBackground(Color.LIGHT_GRAY);
		panel.add(btnBorrar);
		btnBorrar.setEnabled(false);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(Color.LIGHT_GRAY);
		panel.add(btnBuscar);
		btnBorrar.setEnabled(false);
		btnBuscar.setEnabled(false);
		
		panel_tabla = new JPanel();
		splitPane.setRightComponent(panel_tabla);
		
		panel_tabla.setLayout(new BorderLayout(0, 0));
		
		scrollPaneTabla = new JScrollPane();
		panel_tabla.add(scrollPaneTabla);
		
		tabla = new JTable();
		scrollPaneTabla.add(tabla);
		
		panel_insertar = new JPanel();
		panel_tabla.add(panel_insertar, BorderLayout.SOUTH);
		panel_insertar.setLayout(new GridLayout(1, 6, 0, 0));
		
		panel_id = new JPanel();
		panel_id.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
		panel_insertar.add(panel_id);
		panel_id.setLayout(new GridLayout(0, 1, 0, 0));
		
		label = new JLabel("ID");
		panel_id.add(label);
		
		textField_id = new JTextField();
		textField_id.setColumns(10);
		panel_id.add(textField_id);
		
		panel_city = new JPanel();
		panel_city.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
		panel_insertar.add(panel_city);
		panel_city.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblCity = new JLabel("CITY");
		panel_city.add(lblCity);
		
		textField_City = new JTextField();
		panel_city.add(textField_City);
		textField_City.setColumns(10);
		
		panel_country = new JPanel();
		panel_country.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
		panel_insertar.add(panel_country);
		panel_country.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblCountry = new JLabel("COUNTRY");
		panel_country.add(lblCountry);
		
		textField_Country = new JTextField();
		panel_country.add(textField_Country);
		textField_Country.setColumns(10);
		
		panel_postal_code = new JPanel();
		panel_postal_code.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
		panel_insertar.add(panel_postal_code);
		panel_postal_code.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblPostalCode = new JLabel("POSTAL CODE");
		panel_postal_code.add(lblPostalCode);
		
		textField_Postal_Code = new JTextField();
		panel_postal_code.add(textField_Postal_Code);
		textField_Postal_Code.setColumns(10);
		
		panel_latitude = new JPanel();
		panel_latitude.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
		panel_insertar.add(panel_latitude);
		panel_latitude.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblLatitude = new JLabel("LATITUDE");
		panel_latitude.add(lblLatitude);
		
		textField_latitude = new JTextField();
		panel_latitude.add(textField_latitude);
		textField_latitude.setColumns(10);
		
		panel_longitude = new JPanel();
		panel_longitude.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
		panel_insertar.add(panel_longitude);
		panel_longitude.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblLongitude = new JLabel("LONGITUDE");
		panel_longitude.add(lblLongitude);
		
		textField_longitude = new JTextField();
		panel_longitude.add(textField_longitude);
		textField_longitude.setColumns(10);
		
		btnInsertar = new JButton("INSERTAR");
		panel_insertar.add(btnInsertar);
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JScrollPane getScrollPaneTabla() {
		return scrollPaneTabla;
	}

	public void setScrollPaneTabla(JScrollPane scrollPaneTabla) {
		this.scrollPaneTabla = scrollPaneTabla;
	}

	public JMenuItem getMntmAcercaDe() {
		return mntmAcercaDe;
	}

	public void setMntmAcercaDe(JMenuItem mntmAcercaDe) {
		this.mntmAcercaDe = mntmAcercaDe;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JMenu getMnArchivo() {
		return mnArchivo;
	}

	public void setMnArchivo(JMenu mnArchivo) {
		this.mnArchivo = mnArchivo;
	}

	public JMenuItem getMntmCargarBd() {
		return mntmCargarBd;
	}

	public void setMntmCargarBd(JMenuItem mntmCargarBd) {
		this.mntmCargarBd = mntmCargarBd;
	}

	public JMenuItem getMntmSalir() {
		return mntmSalir;
	}

	public void setMntmSalir(JMenuItem mntmSalir) {
		this.mntmSalir = mntmSalir;
	}

	public JMenu getMnAcercaDe() {
		return mnAcercaDe;
	}

	public void setMnAcercaDe(JMenu mnAcercaDe) {
		this.mnAcercaDe = mnAcercaDe;
	}

	public JSplitPane getSplitPane() {
		return splitPane;
	}

	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}


	public JPanel getPanel_tabla() {
		return panel_tabla;
	}

	public void setPanel_tabla(JPanel panel_tabla) {
		this.panel_tabla = panel_tabla;
	}

	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	public JPanel getPanel_botones() {
		return panel_insertar;
	}

	public void setPanel_botones(JPanel panel_botones) {
		this.panel_insertar = panel_botones;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public JButton getBtnInsertar() {
		return btnBuscar;
	}

	public void setBtnInsertar(JButton btnInsertar) {
		this.btnBuscar = btnInsertar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public void setBtnBorrar(JButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}

	public JPanel getPanel_insertar() {
		return panel_insertar;
	}

	public void setPanel_insertar(JPanel panel_insertar) {
		this.panel_insertar = panel_insertar;
	}

	public JLabel getLblCity() {
		return lblCity;
	}

	public void setLblCity(JLabel lblCity) {
		this.lblCity = lblCity;
	}

	public JLabel getLblCountry() {
		return lblCountry;
	}

	public void setLblCountry(JLabel lblCountry) {
		this.lblCountry = lblCountry;
	}

	public JLabel getLblPostalCode() {
		return lblPostalCode;
	}

	public void setLblPostalCode(JLabel lblPostalCode) {
		this.lblPostalCode = lblPostalCode;
	}

	public JLabel getLblLatitude() {
		return lblLatitude;
	}

	public void setLblLatitude(JLabel lblLatitude) {
		this.lblLatitude = lblLatitude;
	}

	public JLabel getLblLongitude() {
		return lblLongitude;
	}

	public void setLblLongitude(JLabel lblLongitude) {
		this.lblLongitude = lblLongitude;
	}

	public JTextField getTextField_City() {
		return textField_City;
	}

	public void setTextField_City(JTextField textField_City) {
		this.textField_City = textField_City;
	}

	public JTextField getTextField_Country() {
		return textField_Country;
	}

	public void setTextField_Country(JTextField textField_Country) {
		this.textField_Country = textField_Country;
	}

	public JTextField getTextField_Postal_Code() {
		return textField_Postal_Code;
	}

	public void setTextField_Postal_Code(JTextField textField_Postal_Code) {
		this.textField_Postal_Code = textField_Postal_Code;
	}

	public JTextField getTextField_latitude() {
		return textField_latitude;
	}

	public void setTextField_latitude(JTextField textField_latitude) {
		this.textField_latitude = textField_latitude;
	}

	public JTextField getTextField_longitude() {
		return textField_longitude;
	}

	public void setTextField_longitude(JTextField textField_longitude) {
		this.textField_longitude = textField_longitude;
	}

	public JPanel getPanel_id() {
		return panel_id;
	}

	public void setPanel_id(JPanel panel_id) {
		this.panel_id = panel_id;
	}

	public JPanel getPanel_city() {
		return panel_city;
	}

	public void setPanel_city(JPanel panel_city) {
		this.panel_city = panel_city;
	}

	public JPanel getPanel_country() {
		return panel_country;
	}

	public void setPanel_country(JPanel panel_country) {
		this.panel_country = panel_country;
	}

	public JPanel getPanel_postal_code() {
		return panel_postal_code;
	}

	public void setPanel_postal_code(JPanel panel_postal_code) {
		this.panel_postal_code = panel_postal_code;
	}

	public JPanel getPanel_latitude() {
		return panel_latitude;
	}

	public void setPanel_latitude(JPanel panel_latitude) {
		this.panel_latitude = panel_latitude;
	}

	public JPanel getPanel_longitude() {
		return panel_longitude;
	}

	public void setPanel_longitude(JPanel panel_longitude) {
		this.panel_longitude = panel_longitude;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JTextField getTextField_id() {
		return textField_id;
	}

	public void setTextField(JTextField textField) {
		this.textField_id = textField;
	}
	
	
}
