package visual;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Logica;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.ImageIcon;



public class CantReg extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField cantRegiones;
	private JButton btnRestar = new JButton("-");
	private JButton btnSumar = new JButton("+");
	private JButton btnContinuar = new JButton("CONTINUAR");
	private JButton btnVolver = new JButton("VOLVER");
	static JPanel panel = new JPanel();
	private final JLabel lblNewLabel = new JLabel("New label");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CantReg dialog = new CantReg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

/*----------------------------------------------------------------------------------------------------------------*/
	private void incializarPanel() {
		setBounds(100, 100, 832, 627);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel.setBounds(208, 204, 348, 163);
		panel.setBackground(new Color(0,0,0,0));
		contentPanel.add(panel);
		panel.setLayout(null);
		
		cantRegiones = new JTextField();
		cantRegiones.setText("1");
		cantRegiones.setHorizontalAlignment(SwingConstants.CENTER);
		cantRegiones.setBounds(142, 52, 64, 44);
		panel.add(cantRegiones);
		cantRegiones.setColumns(10);
		
		JPanel buttonPane = new JPanel();
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		buttonPane.setLayout(null);
	}
	

/*----------------------------------------------------------------------------------------------------------------*/
	private void crearBotones() {
		btnSumar.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnSumar.setForeground(new Color(255, 255, 255));
		btnSumar.setBackground(new Color(0, 0, 0));
		btnSumar.setBounds(215, 52, 64, 46);
		panel.add(btnSumar);
		btnRestar.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnRestar.setForeground(new Color(255, 255, 255));
		btnRestar.setBackground(new Color(0, 0, 0));
		
		btnRestar.setBounds(68, 52, 64, 46);
		panel.add(btnRestar);	
		btnContinuar.setBackground(new Color(255, 250, 205));
		btnContinuar.setBounds(666, 553, 140, 23);
		contentPanel.add(btnContinuar);
		btnContinuar.setActionCommand("CONTINUAR");
		btnVolver.setBackground(new Color(255, 250, 205));
		
		btnVolver.setBounds(10, 553, 140, 23);
		contentPanel.add(btnVolver);
		btnVolver.setActionCommand("VOLVER");
		lblNewLabel.setIcon(new ImageIcon(CantReg.class.getResource("/Imagenes/Mapa.png")));
		lblNewLabel.setBounds(0, 74, 806, 502);
		
		contentPanel.add(lblNewLabel);
		
		JLabel txtIndicacion = new JLabel("CANTIDAD DE REGIONES");
		txtIndicacion.setForeground(new Color(255, 255, 255));
		txtIndicacion.setBounds(221, 41, 348, 25);
		contentPanel.add(txtIndicacion);
		txtIndicacion.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtIndicacion.setHorizontalAlignment(SwingConstants.CENTER);
	}
	

/*----------------------------------------------------------------------------------------------------------------*/
	private void escucharBotonRestar() {
		btnRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {		
					int grupos=Integer.parseInt(cantRegiones.getText());
					if(grupos>1){
						cantRegiones.setText((--grupos)+"");
					}
					
				} catch (Exception e) {JOptionPane.showMessageDialog(null, "ERROR");}		
			}		
		});
	}
	

/*----------------------------------------------------------------------------------------------------------------*/
	private void escucharBotonSumar() {
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {		
					int grupos=Integer.parseInt(cantRegiones.getText().toString());
					int cantMax=Logica.tamlistprov()-1;
					if(grupos<cantMax){
						cantRegiones.setText((++grupos)+"");
					}
					
				} catch (Exception e) {JOptionPane.showMessageDialog(null, "ERROR");}		
			}		
		});
	}
	

/*----------------------------------------------------------------------------------------------------------------*/
	private void escucharBotonContinuar() {
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {	
					
					
					Logica.crearGrafo();
					Logica.ArbolGeneradorMinimo();
					Integer grupos=Integer.parseInt(cantRegiones.getText().toString());
					for(int i=1;i<grupos;i++) {
						Logica.dividirGrafo();
					}
					Resultados.main(null);						
					dispose();
					}
				catch (Exception e) {JOptionPane.showMessageDialog(null, "ERROR");}		
			}		
		});
	}
	

/*----------------------------------------------------------------------------------------------------------------*/
	private void escucharBotonVolver() {
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {	
					Relaciones.main(null);
					incializarPanel() ;
					dispose();
					}
				catch (Exception e) {JOptionPane.showMessageDialog(null, "ERROR");}		
			}		
		});
	}

/*----------------------------------------------------------------------------------------------------------------*/
	
	
	
	/**
	 * Create the dialog.
	 */
	public CantReg() {
		incializarPanel();
		crearBotones();
		escucharBotonRestar();
		escucharBotonSumar();
		escucharBotonContinuar();
		escucharBotonVolver();
	}


}
