package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import logica.Grafo;

import java.util.Set;

public class GrafoTest {

    private Grafo grafo;

    @Before
    public void setUp() {
        grafo = new Grafo(5); // Crear un grafo con 5 vértices para las pruebas
    }

    @Test
    public void testAgregarYEliminarArista() {
        // Agregar una arista
        grafo.agregarAristaConPeso(0, 1, 10);
        
        // Verificar que la arista se agregó correctamente
        assertTrue(grafo.existeArista(0, 1));
        assertEquals(10, grafo.obtenerPeso(0, 1));

        // Eliminar la arista
        grafo.eliminarArista(0, 1);

        // Verificar que la arista se eliminó correctamente
        assertFalse(grafo.existeArista(0, 1));
        // Al verificar el peso después de eliminar la arista, se lanzará una excepción ya que la arista no existe
        // Puedes manejar este caso con un bloque try-catch o ajustando tu lógica de prueba.
        try {
            grafo.obtenerPeso(0, 1);
            fail("Debería lanzar una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Excepción esperada, no es necesario hacer nada
        }
    }



    @Test
    public void testVecinos() {
        grafo.agregarAristaConPeso(0, 1, 10);
        grafo.agregarAristaConPeso(0, 2, 20);
        Set<Integer> vecinos = grafo.vecinos(0);
        assertEquals(2, vecinos.size());
        assertTrue(vecinos.contains(1));
        assertTrue(vecinos.contains(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAgregarLoop() {
        grafo.agregarAristaConPeso(0, 0, 5); // Debería lanzar una excepción
    }

    

}
