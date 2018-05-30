package com.iesvirgendelcarmen.PROYECTO.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;

public class TablaMenu {

	private JFrame frame;
	private JPanel panel_izquierdo;
	private JTabbedPane tabbedPane;
	private JSplitPane splitPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmCargarDatos;
	private JMenuItem mntmSalir;
	private JMenu mnAbout;
	private JMenuItem mntmAbout;
	private JPanel panel_derecho;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TablaMenu window = new TablaMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.NORTH);
		
		splitPane = new JSplitPane();
		tabbedPane.addTab("Filtrado", null, splitPane, null);
		
		panel_izquierdo = new JPanel();
		splitPane.setLeftComponent(panel_izquierdo);
		panel_izquierdo.setLayout(new GridLayout(0, 1, 0, 0));
		
		button = new JButton("New button");
		panel_izquierdo.add(button);
		
		panel_derecho = new JPanel();
		splitPane.setRightComponent(panel_derecho);
		panel_derecho.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmCargarDatos = new JMenuItem("Cargar Datos");
		mnArchivo.add(mntmCargarDatos);
		
		mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
		
		mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		mntmAbout = new JMenuItem("About");
		mnAbout.add(mntmAbout);
	}

}
