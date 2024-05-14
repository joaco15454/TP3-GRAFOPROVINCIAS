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
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Relaciones {

	private JFrame frame;
	private JTextField similaridad;
	private JComboBox comboBoxProv1;
	private JComboBox comboBoxProv2;
	private JButton btnAgregarConexion;
	private JButton btnSiguiente;
	private DefaultComboBoxModel model;
	private DefaultComboBoxModel model1;
	private JLabel lblNewLabel_1;

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
	

/*----------------------------------------------------------------------------------------------------------------*/	
	private void inicializarComponentes() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.desktop);
		frame.setBounds(100, 100, 843, 609);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		comboBoxProv1 = new JComboBox();
		comboBoxProv1.setForeground(SystemColor.text);
		comboBoxProv1.setBackground(SystemColor.desktop);
	
		comboBoxProv1.setBounds(60, 228, 175, 22);
		frame.getContentPane().add(comboBoxProv1);
		
		comboBoxProv2 = new JComboBox();
		comboBoxProv2.setForeground(SystemColor.inactiveCaptionBorder);
		comboBoxProv2.setBackground(SystemColor.controlText);
		comboBoxProv2.setBounds(279, 228, 175, 22);
		frame.getContentPane().add(comboBoxProv2);
		
		similaridad = new JTextField();
		similaridad.setBackground(SystemColor.desktop);
		similaridad.setForeground(SystemColor.text);
		similaridad.setText("0");
		similaridad.setBounds(487, 229, 86, 20);
		frame.getContentPane().add(similaridad);
		
		 btnAgregarConexion = new JButton("Agregar conexion");
		 btnAgregarConexion.setForeground(SystemColor.text);
		 btnAgregarConexion.setBackground(SystemColor.desktop);
		btnAgregarConexion.setBounds(620, 228, 124, 23);
		frame.getContentPane().add(btnAgregarConexion);
		
		 btnSiguiente = new JButton("Siguiente");
		 btnSiguiente.setBackground(new Color(255, 228, 181));
		btnSiguiente.setBounds(693, 521, 124, 38);
		frame.getContentPane().add(btnSiguiente);
		
		JLabel lblNewLabel = new JLabel("Coloque las relaciones");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 47));
		lblNewLabel.setBounds(184, 23, 668, 48);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Relaciones.class.getResource("/Imagenes/Mapa.png")));
		lblNewLabel_1.setBounds(10, 93, 786, 443);
		frame.getContentPane().add(lblNewLabel_1);
		
	}
	
 /*----------------------------------------------------------------------------------------------------------------*/	
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
	
/*----------------------------------------------------------------------------------------------------------------*/	
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
			 		inicilizarboxes();
			 		similaridad.setText("0");
			 		;}

				} catch (Exception e1) {JOptionPane.showMessageDialog(null, "ERROR");}		
					
		}});
	}

/*----------------------------------------------------------------------------------------------------------------*/		
	private void escucharSiguiente() {
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					CantReg.main(null);
						;}

					catch (Exception e1) {JOptionPane.showMessageDialog(null, "ERROR");}		
						
			}});
		}
		
/*----------------------------------------------------------------------------------------------------------------*/	
	
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
		escucharSiguiente();
	}
}
