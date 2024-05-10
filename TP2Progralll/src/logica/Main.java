package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	private static List<Integer> listaDeProvincias = new ArrayList<>();
	private static Set<ProvinciasRelacionadas> relaciones = new HashSet<>();

	private static Grafo Grafo_G;
	private static Agm Arbol;
	private static Grafo ArbolGenerador;
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

	private static void crearArbol() {
		Arbol=new Agm(relaciones, listaDeProvincias);
		Arbol.relaciones();
		ArbolGenerador = Arbol.ArbolGeneradorMinimo();
	
	}
	public static void dividirGrafo(){
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
	}
	public static List<List<Integer>> componentesConexas() {
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


	 public static void main(String[] args) {
	        // Crear instancia de Main


	        // Cargar nodos (provincias)
	        CargarNodo(1); // Buenos Aires
	        CargarNodo(2); // Córdoba
	        CargarNodo(3); // Santa Fe
	        CargarNodo(4); // Mendoza
	        CargarNodo(5); // Tucumán
	        CargarNodo(6); // Salta
	        CargarNodo(7); // Chubut

	        // Establecer relaciones con pesos entre provincias
	        Set<ProvinciasRelacionadas> relaciones = new HashSet<>();
	        relaciones.add(new ProvinciasRelacionadas(1, 2, 500)); // Buenos Aires - Córdoba
	        relaciones.add(new ProvinciasRelacionadas(1, 3, 300)); // Buenos Aires - Santa Fe
	        relaciones.add(new ProvinciasRelacionadas(2, 4, 700)); // Córdoba - Mendoza
	        relaciones.add(new ProvinciasRelacionadas(3, 5, 400)); // Santa Fe - Tucumán
	        relaciones.add(new ProvinciasRelacionadas(4, 6, 600)); // Mendoza - Salta
	        relaciones.add(new ProvinciasRelacionadas(5, 7, 800)); // Tucumán - Chubut
	        relaciones.add(new ProvinciasRelacionadas(6, 7, 900)); // Salta - Chubut

	        // Crear el grafo
	        crearGrafo();

	        // Crear el árbol generador mínimo
	        crearArbol();

	        // Dividir el grafo en dos regiones
	        dividirGrafo();
	        // Calcular componentes conexas
	        List<List<Integer>> componentes = componentesConexas();

	        // Imprimir las componentes conexas
	        for (int i = 0; i < componentes.size(); i++) {
	            System.out.println("Componente conexa " + (i + 1) + ": " + componentes.get(i));
	        }
	    }
	
}

