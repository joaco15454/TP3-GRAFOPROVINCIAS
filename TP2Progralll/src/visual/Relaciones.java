package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableModel;

import logica.Logica;

import javax.swing.JButton;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;

public class Relaciones {

	private JFrame frame;
	private JTextField similaridad;
	private JComboBox comboBoxProv1;
	private JComboBox comboBoxProv2;
	private JButton btnAgregarConexion;
	private JButton btnResultados;
	private DefaultComboBoxModel model;
	private DefaultComboBoxModel model1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relaciones window = new Relaciones();
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
	private void inicializarComponentes() {
		frame = new JFrame();
		frame.setBounds(100, 100, 778, 409);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		comboBoxProv1 = new JComboBox();
	
		comboBoxProv1.setBounds(60, 127, 175, 22);
		frame.getContentPane().add(comboBoxProv1);
		
		comboBoxProv2 = new JComboBox();
		comboBoxProv2.setBounds(271, 127, 175, 22);
		frame.getContentPane().add(comboBoxProv2);
		
		similaridad = new JTextField();
		similaridad.setBounds(468, 128, 86, 20);
		frame.getContentPane().add(similaridad);
		
		 btnAgregarConexion = new JButton("Agregar conexion");
		btnAgregarConexion.setBounds(575, 127, 124, 23);
		frame.getContentPane().add(btnAgregarConexion);
		
		 btnResultados = new JButton("Resultados");
		btnResultados.setBounds(309, 311, 124, 23);
		frame.getContentPane().add(btnResultados);
		
	}
	
	private void inicilizarboxes() {
	    model1 = new DefaultComboBoxModel();
		comboBoxProv1.setModel( model1);
		model = new DefaultComboBoxModel();
		comboBoxProv2.setModel( model);
		for (int i = 0; i < Logica.tamlistprov(); i++) {
		model1.addElement(Logica.listadeprov().get(i));
		model.addElement(Logica.listadeprov().get(i));
		}
		
	}
	
	private void escucharAgregarConexion() {
		 btnAgregarConexion.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		try {		
			 		int prov1 = model1.getIndexOf( comboBoxProv1.getSelectedItem());
			 		int prov2 = model.getIndexOf( comboBoxProv2.getSelectedItem());
			 		if(prov1==prov2) {
			 			JOptionPane.showMessageDialog(null, "No se permiten elementos iguales: ");

			 		}else {
			 	    Integer peso=Integer.parseInt(similaridad.getText().toString());
			 		Logica.conexiones(prov1, prov2, peso);
			 		;}

				} catch (Exception e1) {JOptionPane.showMessageDialog(null, "ERROR");}		
					
		}});
	}
	
	public Relaciones() {
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		inicializarComponentes();
		inicilizarboxes();
		escucharAgregarConexion();
	}
}
