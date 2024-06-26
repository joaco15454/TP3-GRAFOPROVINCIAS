package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import logica.Logica;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;

public class Inicial {

	private JFrame frame;
	private JTextField Provincia;
	private JButton btnAgregarProvincia;
	private JButton btnSiguiente;
	private JLabel fondo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicial window = new Inicial();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
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
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 811, 602);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Provincia = new JTextField();
		Provincia.setBounds(128, 209, 336, 26);
		frame.getContentPane().add(Provincia);
		Provincia.setColumns(10);
		
		btnAgregarProvincia = new JButton("Agregar Provincia\r\n");
		btnAgregarProvincia.setForeground(SystemColor.inactiveCaptionBorder);
		btnAgregarProvincia.setBackground(new Color(0, 0, 0));
		btnAgregarProvincia.setBounds(561, 211, 174, 23);
		frame.getContentPane().add(btnAgregarProvincia);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBackground(new Color(255, 228, 196));
		btnSiguiente.setBounds(671, 504, 114, 48);
		frame.getContentPane().add(btnSiguiente);
		
		JLabel lblNewLabel = new JLabel("Agregue las provincias que quiere utilizar para hacer la division de regiones");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(168, 12, 485, 53);
		frame.getContentPane().add(lblNewLabel);
		
		fondo = new JLabel("New label");
		fondo.setIcon(new ImageIcon(Inicial.class.getResource("/Imagenes/Mapa.png")));
		fondo.setBounds(10, 76, 785, 448);
		frame.getContentPane().add(fondo);
	}
	
/*----------------------------------------------------------------------------------------------------------------*/	
	private void escucharAgregarProvincia() {
		btnAgregarProvincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
		
				if(Provincia.getText().equals("") ){
					JOptionPane.showMessageDialog(null, "Tiene que colocar una provincia ");
				}else if(!Provincia.getText().equals("") && !Logica.estaEnLaLista(Provincia.getText())) {
					Logica.CargarProvincia(Provincia.getText());
					Provincia.setText("");
				} else{
					JOptionPane.showMessageDialog(null, "Provincia ya agregada a la lista ");
				
					;}

				} catch (Exception e1) {JOptionPane.showMessageDialog(null, "ERROR");}		
					
		}});
	}
	
 /*----------------------------------------------------------------------------------------------------------------*/	
	private void escucharSiguiente() {
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					
					if(Logica.tamlistprov()<4){
						JOptionPane.showMessageDialog(null, "Tiene que colocar mas de 4 provincias ");
					}else {
						Logica.cargarTodosLosNodos();
						Relaciones.main(null);
						frame.dispose();
						;}

					} catch (Exception e1) {JOptionPane.showMessageDialog(null, "ERROR");}		
						
			}});
	}
	
 /*----------------------------------------------------------------------------------------------------------------*/
		
	
	
	public Inicial() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		inicializarComponentes();
		escucharAgregarProvincia();
		escucharSiguiente();
		
	}

}
