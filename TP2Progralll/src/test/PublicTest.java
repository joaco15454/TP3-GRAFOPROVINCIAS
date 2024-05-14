package test;

import org.junit.Test;

import logica.Grafo;
import logica.Logica;
import logica.ProvinciasRelacionadas;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

public class PublicTest {

    @Test
    public void testCrearGrafo() {
        // Crear instancia de Logica
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

        // Verificar que el grafo se ha creado correctamente
        assertNotNull(prueba.getGrafoG());
    }

    @Test
    public void testArbolGeneradorMinimo() {
        // Crear instancia de Logica
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

        // Obtener el árbol generador mínimo
        Grafo arbolGenerador = prueba.ArbolGeneradorMinimo();

        // Verificar que el árbol generador mínimo no sea nulo
        assertNotNull(arbolGenerador);

        // Verificar propiedades del árbol generador mínimo
        assertTrue(arbolGenerador.existeArista(0, 1));
        assertFalse(arbolGenerador.existeArista(1, 2)); // El árbol generador mínimo solo debe tener una arista
    }

    // Otros casos de prueba se pueden agregar para los métodos restantes de Logica
}
