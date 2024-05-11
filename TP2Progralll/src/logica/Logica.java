package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
	//	agregarConexiones(relaciones);
	}
	public void agregarRelaciones(Set<ProvinciasRelacionadas> relaciones) {
	    for (ProvinciasRelacionadas relacion : relaciones) {
	        int provincia1 = relacion.getProv1();
	        int provincia2 = relacion.getProv2();
	        int peso = relacion.getPeso();
	     //   System.out.println("Provincia 1 : " + provincia1 + " Provincia 2: " + provincia2);
	        Grafo_G.agregarAristaConPeso(provincia1 -1, provincia2-1, peso);
	    }
	}

	private static void agregarConexiones(Set<ProvinciasRelacionadas> p) {
		for (ProvinciasRelacionadas provincias : p) {
			agregarConexiones(provincias.getProv1(),provincias.getProv2(), provincias.getPeso());
		}
	}
	private static void agregarConexiones(int provincia1, int provincia2, int peso) {
		Grafo_G.agregarAristaConPeso(provincia1, provincia2, peso);
	}
	public void mostrarVecinos() {
	    if (Grafo_G != null) {
	        for (int i = 0; i < listaDeProvincias.size(); i++) {
	            int provincia = listaDeProvincias.get(i);
	            System.out.print("Vecinos de la provincia " + provincia + ": ");
	            Set<Integer> vecinos = Grafo_G.vecinos(i);
	            for (int vecino : vecinos) {
	                System.out.print(vecino + " ");
	            }
	            System.out.println();
	        }
	    } else {
	        System.out.println("El grafo no ha sido inicializado correctamente.");
	    }
	}

	/*void crearArbol() {
		Arbol=new Agm(relaciones, listaDeProvincias);
		Arbol.relaciones();
		ArbolGenerador = Arbol.ArbolGeneradorMinimo();
		System.out.println("ARBOL GENERADOR: " + ArbolGenerador);
	
	}*/
	public void nodosArbolGeneradorMinimo() {
	    for (int i = 0; i < ArbolGenerador.tamano(); i++) {
	        for (int j = i + 1; j < ArbolGenerador.tamano(); j++) {
	            if (ArbolGenerador.existeArista(i, j)) {
	                System.out.println("Existe arista: " + i + "J: " + j + "Peso: " + ArbolGenerador.obtenerPeso(i,j));
	            }
	        }
	    }
	   
	}
	public Grafo ArbolGeneradorMinimo() {
	    Grafo grafo = Grafo_G; // Utiliza el grafo creado en la clase Logica
	    if (grafo != null) {
	        ArbolGenerador = new Grafo(grafo.tamano()); // Crear un nuevo grafo para el árbol generador mínimo
	        List<Integer> verticesVisitados = new ArrayList<>();
	        verticesVisitados.add(0); // Comenzamos desde el vértice 0

	        int cont = 0;
	        while (verticesVisitados.size() < grafo.tamano()) {
	            int minArista = Integer.MAX_VALUE;
	            int verticeMin = -1;
	            cont++;

	            // Buscar la arista mínima conectada a los vértices visitados
	            for (Integer vertice : verticesVisitados) {
	                Set<Integer> vecinos = grafo.vecinos(vertice);
	                vecinos.removeAll(verticesVisitados); // Remover los vértices ya visitados
	                for (Integer vecino : vecinos) {
	                    int peso = grafo.obtenerPeso(vertice, vecino);
	                    if (peso < minArista) {
	                        minArista = peso;
	                        verticeMin = vecino;
	                    }
	                }
	            }

	            // Agregar el vértice y la arista mínima al árbol generador mínimo
	            if (verticeMin != -1) {
	                verticesVisitados.add(verticeMin);
	                ArbolGenerador.agregarAristaConPeso(verticesVisitados.get(verticesVisitados.size() - 2), verticeMin, minArista);
	            }

	            // Condición para salir del bucle si se realizan demasiadas iteraciones
	            if (cont == 40) {
	                System.out.println("Se excedió el número máximo de iteraciones.");
	                break;
	            }
	        }
	        return ArbolGenerador;
	    } else {
	        System.out.println("El grafo no ha sido inicializado correctamente.");
	        return null;
	    }
	}
	public void dividirGrafo(int k) {
	    if (ArbolGenerador != null) {
	        for (int i = 0; i < k - 1; i++) {
	            int valor1 = 0;
	            int valor2 = 0;
	            int max = Integer.MIN_VALUE;
	            // Buscar la arista de mayor peso en el árbol generador mínimo
	            for (int x = 0; x < ArbolGenerador.tamano(); x++) {
	                for (int y = 0; y < ArbolGenerador.tamano(); y++) {
	                    if (max < ArbolGenerador.retornarArista(x, y)) {
	                        max = ArbolGenerador.retornarArista(x, y);
	                        valor1 = x;
	                        valor2 = y;
	                    }
	                }
	            }
	            // Eliminar la arista de mayor peso
	            ArbolGenerador.eliminarArista(valor1, valor2);
	        }
	    } else {
	        System.out.println("ArbolGenerador no ha sido inicializado correctamente.");
	    }
	}
	public List<List<Integer>> componentesConexas(int k) {
	    List<List<Integer>> componentesConexas = new ArrayList<>();
	    boolean[] visitado = new boolean[ArbolGenerador.tamano()];

	    // Dividir el grafo en k componentes conexas
	    for (int i = 0; i < ArbolGenerador.tamano() && componentesConexas.size() < k; i++) {
	        if (!visitado[i]) {
	            List<Integer> componente = new ArrayList<>();
	            BFS(i, visitado, componente);
	            componentesConexas.add(componente);
	        }
	    }

	    return componentesConexas;
	}

    private void BFS(int inicio, boolean[] visitado, List<Integer> componente) {
        Queue<Integer> cola = new LinkedList<>();
        cola.offer(inicio);
        visitado[inicio] = true;

        while (!cola.isEmpty()) {
            int actual = cola.poll();
            componente.add(actual);

            for (int vecino : ArbolGenerador.vecinos(actual)) {
                if (!visitado[vecino]) {
                    visitado[vecino] = true;
                    cola.offer(vecino);
                }
            }
        }
    }
}

