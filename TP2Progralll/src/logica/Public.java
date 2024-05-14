package logica;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Public {

	public static void main(String[] args) {
		// Crear instancia de prueba
		System.out.println("HOLA");
	    Logica prueba = new Logica();

	    // Cargar nodos (provincias)
	    prueba.CargarNodo(1); // Buenos Aires
	    prueba.CargarNodo(2); // Córdoba
	    prueba.CargarNodo(3); // Santa Fe
	    prueba.CargarNodo(4); // Mendoza
	    prueba.CargarNodo(5); // Tucumán
	    prueba.CargarNodo(6); // Salta
	    prueba.CargarNodo(7); // Chubut

	    // Establecer relaciones con pesos entre provincias
	    Set<ProvinciasRelacionadas> relaciones = new HashSet<>();
	    relaciones.add(new ProvinciasRelacionadas(1, 2, 500)); // Buenos Aires - Córdoba
	    relaciones.add(new ProvinciasRelacionadas(1, 3, 300)); // Buenos Aires - Santa Fe
	    relaciones.add(new ProvinciasRelacionadas(2, 4, 700)); // Córdoba - Mendoza
	    relaciones.add(new ProvinciasRelacionadas(2, 7, 900)); // Salta - Chubut
	    relaciones.add(new ProvinciasRelacionadas(3, 5, 400)); // Santa Fe - Tucumán
	    relaciones.add(new ProvinciasRelacionadas(3, 2, 900)); // Salta - Chubut
	    relaciones.add(new ProvinciasRelacionadas(4, 6, 600)); // Mendoza - Salta
	    relaciones.add(new ProvinciasRelacionadas(5, 7, 800)); // Tucumán - Chubut
	    relaciones.add(new ProvinciasRelacionadas(6, 7, 900)); // Salta - Chubut


	    // Crear el grafo
	    prueba.crearGrafo();
	   // prueba.agregarRelaciones(relaciones);

	    prueba.ArbolGeneradorMinimo();
	    System.out.println("ESTOY ACA");
	    // Crear el árbol generador mínimo
	   // prueba.nodosArbolGeneradorMinimo();
	 
	    // Dividir el grafo en dos regiones
	   prueba.dividirGrafo();

	    // Calcular componentes conexas
	    List<List<Integer>> componentes = prueba.componentesConexas();

	    // Imprimir las componentes conexas
	    for (int i = 0; i < componentes.size(); i++) {
	        System.out.println("Componente conexa " + (i + 1) + ": " + componentes.get(i));
	    	}
		}
	}


