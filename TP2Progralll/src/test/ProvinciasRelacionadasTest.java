package test;

import org.junit.Test;

import logica.ProvinciasRelacionadas;

import static org.junit.Assert.*;

public class ProvinciasRelacionadasTest {

    @Test
    public void testGetProv1() {
        // Crear instancia de ProvinciasRelacionadas
        ProvinciasRelacionadas relacion = new ProvinciasRelacionadas(1, 2, 500);

        // Verificar el valor de prov1
        assertEquals(1, relacion.getProv1());
    }

    @Test
    public void testGetProv2() {
        // Crear instancia de ProvinciasRelacionadas
        ProvinciasRelacionadas relacion = new ProvinciasRelacionadas(1, 2, 500);

        // Verificar el valor de prov2
        assertEquals(2, relacion.getProv2());
    }

    @Test
    public void testGetPeso() {
        // Crear instancia de ProvinciasRelacionadas
        ProvinciasRelacionadas relacion = new ProvinciasRelacionadas(1, 2, 500);

        // Verificar el valor de peso
        assertEquals(500, relacion.getPeso());
    }

   
}
