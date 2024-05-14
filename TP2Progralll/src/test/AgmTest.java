package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import logica.Agm;
import logica.Grafo;
import logica.ProvinciasRelacionadas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AgmTest {

    private Agm agm;

    @Before
    public void setUp() {
        Set<ProvinciasRelacionadas> listaInicial = new HashSet<>();
        listaInicial.add(new ProvinciasRelacionadas(0, 1, 10));
        listaInicial.add(new ProvinciasRelacionadas(1, 2, 15));
        List<Integer> listaProvInicial = new ArrayList<>();
        listaProvInicial.add(0);
        listaProvInicial.add(1);
        listaProvInicial.add(2);
        agm = new Agm(listaInicial, listaProvInicial);
    }

    @Test
    public void testCargarProvincia() {
        agm.cargarprovincia(new ProvinciasRelacionadas(2, 3, 20));
        assertEquals(4, agm.getGrafo().tamano());
    }

    @Test
    public void testRelaciones() {
        agm.relaciones();
        assertTrue(agm.getGrafo().existeArista(0, 1));
        assertTrue(agm.getGrafo().existeArista(1, 2));
        assertFalse(agm.getGrafo().existeArista(0, 2));
    }

    @Test
    public void testArbolGeneradorMinimo() {
        agm.relaciones();
        Grafo arbolGenerador = agm.ArbolGeneradorMinimo();
        assertNotNull(arbolGenerador);
        assertTrue(arbolGenerador.existeArista(0, 1));
        assertFalse(arbolGenerador.existeArista(1, 2)); // El arbol generador mínimo solo debe tener una arista
    }

    // Agrega más pruebas según sea necesario para otros métodos

}
