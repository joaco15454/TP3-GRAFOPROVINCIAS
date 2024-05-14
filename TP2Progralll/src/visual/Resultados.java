package visual;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import logica.Logica;

import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;

public class Resultados {

	private JFrame frame;
	private JTextArea txtrLasRelacionesSon = new JTextArea();
	private static List<List<Integer>> componentesConexas = new ArrayList<>();
	private String cadena="";
	private JButton btnCerrar = new JButton("CERRAR");
	private JPanel panel_1 = new JPanel();
	private JPanel panel = new JPanel();
	private JScrollPane scrollPane = new JScrollPane();
	private final JLabel lblNewLabel_1 = new JLabel("New label");

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resultados window = new Resultados();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
/*----------------------------------------------------------------------------------------------------------------*/	
	private void respuesta() {
		componentesConexas = Logica.componentesConexas();
	    cadena = "Las relaciones son:\n";
	    for (int i = 0; i < componentesConexas.size(); i++) {
	        for (int j = 0; j < componentesConexas.get(i).size(); j++) {
	            int provId = componentesConexas.get(i).get(j);
	            cadena += Logica.listadeprov().get(provId)  ;    
	            if (j < componentesConexas.get(i).size() - 1) {
	                cadena += ", ";
	            }
	        }  
	        cadena += "\n";
	    }	    
	    txtrLasRelacionesSon.setText(cadena);
	}
	
/*----------------------------------------------------------------------------------------------------------------*/	
	private void inicializarPaneles() {	
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 849, 656);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel.setBounds(113, 0, 531, 55);
		panel.setBackground(new Color(0,0,0,0));
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("RESULTADOS");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 39));
		panel.add(lblNewLabel);	
		
		scrollPane.setBounds(113, 150, 531, 359);
		frame.getContentPane().add(scrollPane);	
		
	    txtrLasRelacionesSon.setTabSize(0);
	    txtrLasRelacionesSon.setEditable(false);
		txtrLasRelacionesSon.setFont(new Font("Calibri", Font.PLAIN, 18));
		scrollPane.setViewportView(txtrLasRelacionesSon);
			
		panel_1.setBounds(0, 552, 833, 70);
		panel_1.setBackground(new Color(0,0,0,0));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);	
		lblNewLabel_1.setIcon(new ImageIcon(Resultados.class.getResource("/Imagenes/Mapa.png")));
		lblNewLabel_1.setBounds(0, 30, 823, 555);
		
		frame.getContentPane().add(lblNewLabel_1);
	}
	
/*----------------------------------------------------------------------------------------------------------------*/	
	private void incializarBotones() {
		btnCerrar.setBackground(new Color(255, 250, 240));
		btnCerrar.setBounds(678, 23, 145, 23);
		panel_1.add(btnCerrar);
	}
/*----------------------------------------------------------------------------------------------------------------*/	
	private void escucharBotonCerrar() {
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					frame.dispose();
					}
				catch (Exception e) {JOptionPane.showMessageDialog(null, "ERROR");}		
			}		
		});
	}
	
/*----------------------------------------------------------------------------------------------------------------*/	
	
	/**
	 * Create the application.
	 */
	public Resultados() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		inicializarPaneles();
		respuesta();
		incializarBotones();
		escucharBotonCerrar();
		
	
	}
}
