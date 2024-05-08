package logica;

import java.util.ArrayList;
import java.util.List;

public class Main {
	private static List<Integer> listaDeProvincias = new ArrayList<>();
	private static Grafo Grafo_G;
	private static Grafo Arbol;
	public Main() {
	    listaDeProvincias = new ArrayList<>();
	    Grafo_G = null;
	    Arbol = null;
	}
	
	public static void CargarNodo(int p) {
			listaDeProvincias.add(p);
	}
	
	public static void crearGrafo() {
		Grafo_G = new Grafo(listaDeProvincias.size());
	}

	private static void agregarConexiones(int provincia1, int provincia2, int peso) {
		Grafo_G.agregarAristaConPeso(provincia1, provincia2, peso);
	}

	private static void crearArbol() {
		Arbol=new Grafo(Grafo_G.tamano());
		Arbol.cargarMismos(); //hay que seguir
	}

}

