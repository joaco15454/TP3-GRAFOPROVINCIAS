package logica;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creamos un grafo con 5 vértices
        Grafo grafo = new Grafo(5);

        // Agregamos algunas aristas con pesos
        grafo.agregarAristaConPeso(0, 1, 4);
        grafo.agregarAristaConPeso(0, 2, 8);
        grafo.agregarAristaConPeso(1, 2, 11);
        grafo.agregarAristaConPeso(1, 3, 8);
        grafo.agregarAristaConPeso(2, 4, 7);
        grafo.agregarAristaConPeso(3, 4, 2);

        // Mostramos los pesos de las aristas agregadas
        System.out.println("Pesos de las aristas:");
        for (int i = 0; i < grafo.tamano(); i++) {
            for (int j : grafo.vecinos(i)) {
                System.out.println("Peso de la arista (" + i + ", " + j + "): " + grafo.obtenerPeso(i, j));
            }
        }

        // Recorremos el grafo utilizando BFS
        System.out.println("\nRecorrido BFS:");
        System.out.println(BFS.esConexo(grafo));;
    }
}


