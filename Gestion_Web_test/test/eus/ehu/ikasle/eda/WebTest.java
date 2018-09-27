package eus.ehu.ikasle.eda;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WebTest {

    private Web w1;
    private Web w2;
    private Web w3;
    private Palabra p1;
    private Palabra p2;
    private Palabra p3;
    private List<Palabra> palabras;
    private List<Web> websEnlazadas;

    @org.junit.Before
    public void setUp() throws Exception {

        w1 = new Web (1, "a");
        w2 = new Web (2, "b");
        w3 = new Web (3, "c");
        p1 = new Palabra("Hola");
        p2 = new Palabra("Adios");
        p3 = new Palabra("Bien");
        palabras = new ArrayList<Palabra>();
        websEnlazadas = new ArrayList<Web>();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void getId() {
        assertEquals(w1.getId(), 1);
        assertEquals(w2.getId(), 2);
        assertEquals(w3.getId(), 3);
    }

    @org.junit.Test
    public void getWeb() {
        assertEquals(w1.getWeb(), "a");
        assertEquals(w2.getWeb(), "b");
        assertEquals(w3.getWeb(), "c");
    }

    @org.junit.Test
    public void getWebsEnlazadas() {
        websEnlazadas.add(w1);
        assertNotNull(websEnlazadas);

    }

    @org.junit.Test
    public void getPalabras() {
        palabras.add(p1);
        assertNotNull(palabras);
    }

    @org.junit.Test
    public void addWebRelacionada() {

    }

    @org.junit.Test
    public void constains() {

    }

    @org.junit.Test
    public void addPalabra() {
        assertEquals(palabras.size(),0);
        palabras.add(p1);
        assertEquals(palabras.size(),1);
        palabras.add(p2);
        assertEquals(palabras.size(),2);
        palabras.add(p3);
        assertEquals(palabras.size(),3);
    }

    @org.junit.Test
    public void estaEnListaPalabras() {
        assertFalse(palabras.contains("p"));
        palabras.add(p1);
        assertTrue(palabras.contains(p1));
        palabras.add(p2);
        assertTrue(palabras.contains(p2));
        palabras.add(p3);
        assertTrue(palabras.contains(p3));
    }

    /*@org.junit.Test -- No es lo mismo que el metodo "getWeb"?? --
    public void toString() {
    }*/
}