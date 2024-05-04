package logica;
import java.util.HashSet;
import java.util.Set;

public class Grafo {
    // Representamos el grafo por su matriz de adyacencia
    private boolean[][] A;
    private int[][] pesos; // Matriz para almacenar los pesos de las aristas
    
    // La cantidad de vertices esta predeterminada desde el constructor
    public Grafo(int vertices) {
        A = new boolean[vertices][vertices];
        pesos = new int[vertices][vertices]; // Inicializamos la matriz de pesos
    }

    // Agregado de aristas con peso
    public void agregarAristaConPeso(int i, int j, int peso) {
        verificarVertice(i);
        verificarVertice(j);
        verificarDistintos(i, j);

        A[i][j] = true;
        A[j][i] = true;
        pesos[i][j] = peso; // Asignamos el peso a la arista
        pesos[j][i] = peso; // Peso simétrico en el grafo no dirigido
    }

    // Eliminacion de aristas
    public void eliminarArista(int i, int j) {
        verificarVertice(i);
        verificarVertice(j);
        verificarDistintos(i, j);

        A[i][j] = false;
        A[j][i] = false;
        pesos[i][j] = 0; // Eliminamos el peso de la arista
        pesos[j][i] = 0; // Peso simétrico en el grafo no dirigido
    }

    // Informa si existe la arista especificada
    public boolean existeArista(int i, int j) {
        verificarVertice(i);
        verificarVertice(j);
        verificarDistintos(i, j);

        return A[i][j];
    }

    // Obtener peso de una arista
    public int obtenerPeso(int i, int j) {
        verificarVertice(i);
        verificarVertice(j);
        verificarDistintos(i, j);
        if (!existeArista(i, j)) {
            throw new IllegalArgumentException("La arista (" + i + ", " + j + ") no existe.");
        }

        return pesos[i][j];
    }

    // Cantidad de vertices
    public int tamano() {
        return A.length;
    }

    // Vecinos de un vertice
    public Set<Integer> vecinos(int i) {
        verificarVertice(i);

        Set<Integer> ret = new HashSet<>();
        for (int j = 0; j < this.tamano(); ++j) {
            if (i != j && this.existeArista(i, j)) {
                ret.add(j);
            }
        }

        return ret;
    }

    // Verifica que sea un vertice valido
    private void verificarVertice(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
        }

        if (i >= A.length) {
            throw new IllegalArgumentException("Los vertices deben estar entre 0 y |V|-1: " + i);
        }
    }

    // Verifica que i y j sean distintos
    private void verificarDistintos(int i, int j) {
        if (i == j) {
            throw new IllegalArgumentException("No se permiten loops: (" + i + ", " + j + ")");
        }
    }
}