package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import logica.BFS;
import logica.Grafo;

import java.util.List;

public class BfsTest {

    private Grafo grafo;

    @Before
    public void setUp() {
        grafo = new Grafo(5); // Crear un grafo con 5 vértices para las pruebas
        grafo.agregarAristaConPeso(0, 1, 10);
        grafo.agregarAristaConPeso(0, 2, 15);
        grafo.agregarAristaConPeso(1, 3, 20);
        grafo.agregarAristaConPeso(2, 4, 25);
    }

    @Test
    public void testEsConexo() {
        assertTrue(BFS.esConexo(grafo));
    }

    @Test
    public void testAlcanzables() {
        List<Integer> alcanzables = BFS.alcanzables(grafo, 0);
        assertEquals(5, alcanzables.size());
        assertTrue(alcanzables.contains(0));
        assertTrue(alcanzables.contains(1));
        assertTrue(alcanzables.contains(2));
        assertTrue(alcanzables.contains(3));
        assertTrue(alcanzables.contains(4));
    }

    // Agrega más pruebas según sea necesario para otros métodos

}
