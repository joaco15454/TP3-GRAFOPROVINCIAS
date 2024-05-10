package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Logica {
	private static List<Integer> listaDeProvincias = new ArrayList<>();
	private static Set<ProvinciasRelacionadas> relaciones = new HashSet<>();

	private static Grafo Grafo_G;
	private static Agm Arbol;
	private static Grafo ArbolGenerador;
	public Logica() {
	    listaDeProvincias = new ArrayList<>();
	    Grafo_G = null;
	    Arbol = null;
	}
	
	public void CargarNodo(int p) {
			listaDeProvincias.add(p);
	}
	
	public void crearGrafo() {
		Grafo_G = new Grafo(listaDeProvincias.size());
		agregarConexiones(relaciones);
	}

	private static void agregarConexiones(Set<ProvinciasRelacionadas> p) {
		for (ProvinciasRelacionadas provincias : p) {
			agregarConexiones(provincias.getProv1(),provincias.getProv2(), provincias.getPeso());
		}
	}
	private static void agregarConexiones(int provincia1, int provincia2, int peso) {
		Grafo_G.agregarAristaConPeso(provincia1, provincia2, peso);
	}

	void crearArbol() {
		Arbol=new Agm(relaciones, listaDeProvincias);
		Arbol.relaciones();
		ArbolGenerador = Arbol.ArbolGeneradorMinimo();
		System.out.println("ARBOL GENERADOR: " + ArbolGenerador);
	
	}
	public boolean tieneAristas() {
	    if (ArbolGenerador != null) {
	        for (int i = 0; i < ArbolGenerador.tamano(); i++) {
	            for (int j = 0; j < ArbolGenerador.tamano(); j++) {
	                if (ArbolGenerador.existeArista(i, j)) {
	                    return true; // Si encuentra al menos una arista, devuelve true
	                }
	            }
	        }
	    }
	    return false; // Si no se encontraron aristas, devuelve false
	}
	public void dividirGrafo(){
		  if (ArbolGenerador != null) {
		        int valor1 = 0;
		        int valor2 = 0;
		        int max= Integer.MIN_VALUE;
		        for(int x=0;x<ArbolGenerador.tamano();x++) {
		            for(int y=0;y<ArbolGenerador.tamano();y++) {
		                if(max<ArbolGenerador.retornarArista(x, y)) {
		                    max=ArbolGenerador.retornarArista(x, y);
		                    valor1=x;
		                    valor2=y;
		                }
		            }
		        }
		        ArbolGenerador.eliminarArista(valor1, valor2);
		    } else {
		        System.out.println("ArbolGenerador no ha sido inicializado correctamente.");
		    }
	}
	public List<List<Integer>> componentesConexas() {
        boolean[] visitado = new boolean[ArbolGenerador.tamano()];
        List<List<Integer>> componentesConexas = new ArrayList<>();
        for (int i = 0; i < ArbolGenerador.tamano(); i++) {
            if (!visitado[i]) {
                BFS.inicializarRecorrido(ArbolGenerador, i);
                componentesConexas.add(BFS.alcanzables(ArbolGenerador, i));
            }
        }
        return componentesConexas;
    }
}
