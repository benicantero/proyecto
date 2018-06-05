package com.iesvirgendelcarmen.PROYECTO.vista;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;

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
	private JButton btnInsertar;
	private JButton btnBorrar;
	private JPanel panel_tabla;
	private JTable tabla;
	private JPanel panel_botones;
	private JButton btnSiguiente;
	private JButton btnAnterior;
	private JMenuItem mntmAcercaDe;
	private JScrollPane scrollPaneTabla;


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
		frame.setBounds(100, 100, 450, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		menuBar = new JMenuBar();
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
		frame.getContentPane().add(splitPane);
		
		panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnActualizar = new JButton("Actualizar");
		panel.add(btnActualizar);
		btnActualizar.setEnabled(false);
		
		btnBorrar = new JButton("Borrar");
		panel.add(btnBorrar);
		btnBorrar.setEnabled(false);
		
		btnInsertar = new JButton("Insertar");
		panel.add(btnInsertar);
		btnBorrar.setEnabled(false);
		btnInsertar.setEnabled(false);
		
		panel_tabla = new JPanel();
		splitPane.setRightComponent(panel_tabla);
		
		panel_tabla.setLayout(new BorderLayout(0, 0));
		
		scrollPaneTabla = new JScrollPane();
		panel_tabla.add(scrollPaneTabla);
		
		tabla = new JTable();
		scrollPaneTabla.add(tabla);
		
		panel_botones = new JPanel();
		panel_tabla.add(panel_botones, BorderLayout.SOUTH);
		
		btnSiguiente = new JButton("Siguiente");
		panel_botones.add(btnSiguiente);
		btnSiguiente.setEnabled(false);
		
		btnAnterior = new JButton("Anterior");
		panel_botones.add(btnAnterior);
		btnAnterior.setEnabled(false);
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
		return panel_botones;
	}

	public void setPanel_botones(JPanel panel_botones) {
		this.panel_botones = panel_botones;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public JButton getBtnInsertar() {
		return btnInsertar;
	}

	public void setBtnInsertar(JButton btnInsertar) {
		this.btnInsertar = btnInsertar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public void setBtnBorrar(JButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}

	public JButton getBtnSiguiente() {
		return btnSiguiente;
	}

	public void setBtnSiguiente(JButton btnSiguiente) {
		this.btnSiguiente = btnSiguiente;
	}

	public JButton getBtnAnterior() {
		return btnAnterior;
	}

	public void setBtnAnterior(JButton btnAnterior) {
		this.btnAnterior = btnAnterior;
	}
}
