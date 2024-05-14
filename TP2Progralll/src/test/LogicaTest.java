package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import logica.Logica;

public class LogicaTest {

    private Logica logica;

    @Before
    public void setUp() {
        logica = new Logica();
        Logica.CargarProvincia("Provincia1");
        Logica.CargarProvincia("Provincia2");
        Logica.CargarProvincia("Provincia3");
        Logica.CargarProvincia("Provincia4");
        Logica.conexiones(0, 1, 10);
        Logica.conexiones(0, 2, 15);
        Logica.conexiones(1, 3, 20);
        Logica.conexiones(2, 3, 25);
    }

    @Test
    public void testCrearGrafo() {
        logica.crearGrafo();
        assertNotNull(logica.getGrafoG());
        assertTrue(logica.getGrafoG().existeArista(0, 1));
        assertTrue(logica.getGrafoG().existeArista(0, 2));
        assertTrue(logica.getGrafoG().existeArista(1, 3));
        assertTrue(logica.getGrafoG().existeArista(2, 3));
    }

    @Test
    public void testMostrarVecinos() {
        logica.crearGrafo();
        logica.mostrarVecinos();
        
    }

    @Test
    public void testArbolGeneradorMinimo() {
        logica.crearGrafo();
        logica.ArbolGeneradorMinimo();
        
    }

    

}
