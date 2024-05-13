package visual;

import java.awt.EventQueue;
import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Inicio {

	private JFrame frame;
	private JPanel panelMapa;
	private JPanel panelControles;
	private JMapViewer _mapa;
	private ArrayList< String > provinciasCargadas;
	private JButton btnEliminar;
	private MapPolygonImpl _poligono;
	private JButton btnDibujarPolgono ;
	private Coordinate buenosaires = new Coordinate( -36.2331652,-61.2025998);
	private Coordinate CiudadAutónomadeBuenosAires = new Coordinate(-34.6156548,-58.515699);
	private Coordinate Catamarca= new Coordinate(-27.6622483,-67.0747852);
	private Coordinate Chaco= new Coordinate(-26.7908932,-60.4776989);
	private Coordinate Chubut = new Coordinate(-43.7211752,-67.2917382);
	private Coordinate Córdoba= new Coordinate(-31.3990547,-64.3590203);
	private Coordinate Corrientes= new Coordinate(-28.5357841,-57.1849197);
	private Coordinate EntreRíos= new Coordinate(-31.8587125,-59.0735443);
	private Coordinate Formosa= new Coordinate(-24.7055219,-60.6170254);
	private Coordinate Jujuy= new Coordinate(-22.9851704,-66.0530247);
	private Coordinate LaPampa= new Coordinate(-37.413803, -64.683144);
	private Coordinate LaRioja= new Coordinate(-29.506552, -66.880410);
	private Coordinate Mendoza= new Coordinate(-34.912965, -68.220742);
	private Coordinate Misiones= new Coordinate(-26.987006,-54.5237688);
	private Coordinate Neuquén= new Coordinate(-39.104491, -69.978554);
	private Coordinate RíoNegro= new Coordinate(-40.688971, -68.110878);
	private Coordinate Salta= new Coordinate(-24.856537, -64.001992);
	private Coordinate SanJuan= new Coordinate(-31.287943, -69.275429);
	private Coordinate SanLuis= new Coordinate(-34.298071, -65.913613);
	private Coordinate SantaCruz= new Coordinate(-48.480207, -69.297402);
	private Coordinate SantaFe= new Coordinate(-30.855082, -61.013711);
	private Coordinate SantiagodelEstero= new Coordinate(-27.556985, -63.298867);
	private Coordinate TierradelFuego= new Coordinate(-54.335746, -67.836221);
	private Coordinate Tucumán= new Coordinate(-27.166698, -65.408242);
	private JTextField Provincia;
	private JButton btnNewButton;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	private void botonAgregar() {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {	
					if (Provincia.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Debe colocar un nombre");
					}else if(!provinciasCargadas.contains(Provincia.getText())) {
						provinciasCargadas.add(Provincia.getText());
						Provincia.setText("");
						;}
	
					} catch (Exception e1) {JOptionPane.showMessageDialog(null, "Provincia ya agregadas");}		
						
			}});
	}
	
	
	
	

	/**
	 * Create the application.
	 */
	public Inicio() 
	{
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 1376, 744);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	    frame.setExtendedState(frame.MAXIMIZED_BOTH);
		panelMapa = new JPanel();
		panelMapa.setBounds(10, 11, 521, 679);
		frame.getContentPane().add(panelMapa);
		
		panelControles = new JPanel();
		panelControles.setBounds(559, 11, 677, 446);
		frame.getContentPane().add(panelControles);		
		panelControles.setLayout(null);
		
		Provincia = new JTextField();
		Provincia.setBounds(84, 150, 223, 33);
		panelControles.add(Provincia);
		Provincia.setColumns(10);
		
		 btnNewButton = new JButton("Agregar proviancia");
		
		
	
		
		btnNewButton.setBounds(407, 155, 185, 23);
		panelControles.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Agrege una por una las provincias que quiren utilizar ,para luego relacionarlas ");
		lblNewLabel.setBounds(41, 61, 506, 23);
		panelControles.add(lblNewLabel);
		
		
		_mapa = new JMapViewer();
		_mapa.setBounds(10, 5, 501, 669);
		_mapa.setDisplayPosition(new Coordinate( -38.416097 ,-63.616672),4);
		panelMapa.setLayout(null);
		panelMapa.setEnabled(false);
		panelMapa.add(_mapa);
		
		botonAgregar();
		
		//dibujarpuntosprovincias();
		//relaciones();
	
		
		
	
	}
	
	public void dibujarpuntosprovincias() {
		//buenos aires0
		_mapa.addMapMarker(new MapMarkerDot("",buenosaires));
		//Ciudad Autónoma de Buenos Aires1
		_mapa.addMapMarker(new MapMarkerDot("", CiudadAutónomadeBuenosAires));
		//Catamarca2
		_mapa.addMapMarker(new MapMarkerDot("", Catamarca));
		//Chaco3
		_mapa.addMapMarker(new MapMarkerDot("", Chaco));  
		//Chubut4
		_mapa.addMapMarker(new MapMarkerDot("", Chubut ));
		//Córdoba5
		_mapa.addMapMarker(new MapMarkerDot("",Córdoba ));
		//Corrientes6
		_mapa.addMapMarker(new MapMarkerDot("", Corrientes ));
		//Entre Ríos7
		_mapa.addMapMarker(new MapMarkerDot("", EntreRíos ));
		//Formosa8
		_mapa.addMapMarker(new MapMarkerDot("", Formosa ));
		//Jujuy9
		_mapa.addMapMarker(new MapMarkerDot("", Jujuy ));
		//La Pampa10
		_mapa.addMapMarker(new MapMarkerDot("", LaPampa));
		//La Rioja11
		_mapa.addMapMarker(new MapMarkerDot("", LaRioja));
		//Mendoza12
		_mapa.addMapMarker(new MapMarkerDot("", Mendoza));
		//Misiones13
		_mapa.addMapMarker(new MapMarkerDot("", Misiones));
		//Neuquén14
		_mapa.addMapMarker(new MapMarkerDot("",Neuquén));
		//Río Negro15
		_mapa.addMapMarker(new MapMarkerDot("",RíoNegro));
		//Salta16
		_mapa.addMapMarker(new MapMarkerDot("", Salta));
		//San Juan17
		_mapa.addMapMarker(new MapMarkerDot("", SanJuan));
		//San Luis18
		_mapa.addMapMarker(new MapMarkerDot("", SanLuis));
		//Santa Cruz19
		_mapa.addMapMarker(new MapMarkerDot("", SantaCruz));
		//Santa Fe20
		_mapa.addMapMarker(new MapMarkerDot("",SantaFe));
		//Santiago del Estero21
		_mapa.addMapMarker(new MapMarkerDot("", SantiagodelEstero));
		//Tierra del Fuego, Antártida e Islas del Atlántico Sur
		_mapa.addMapMarker(new MapMarkerDot("", TierradelFuego));
		//Tucumán22
		_mapa.addMapMarker(new MapMarkerDot("", Tucumán));
		
		
		
		
	}

	public void relaciones() {
		MapPolygonImpl bsasciudadautonoma = new MapPolygonImpl(buenosaires,CiudadAutónomadeBuenosAires,CiudadAutónomadeBuenosAires);
		_mapa.addMapPolygon(bsasciudadautonoma);
//		MapPolygonImpl bsascordoba=new MapPolygonImpl(buenosaires,Córdoba,Córdoba);
//		_mapa.addMapPolygon(bsascordoba);
	}
}
