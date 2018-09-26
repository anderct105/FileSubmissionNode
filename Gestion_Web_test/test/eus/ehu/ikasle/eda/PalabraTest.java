package eus.ehu.ikasle.eda;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PalabraTest {

    private Palabra p1;
    private Palabra p2;
    private Palabra p3;
    private Web w1;
    private Web w2;
    private Web w3;
    private List<Web> websEnlazadas;

    @org.junit.Before
    public void setUp() throws Exception {
        p1 = new Palabra ("a");
        p1 = new Palabra ("b");
        p1 = new Palabra ("c");
        w1 = new Web (1, "a");
        w2 = new Web (2, "b");
        w3 = new Web (3, "c");
        websEnlazadas = new ArrayList<Web>();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void addWebConPalabra() {

    }

    @org.junit.Test
    public void toString() {
        assertEquals(p1.toString(), "a");
        assertEquals(p2.toString(), "b");
        assertEquals(p3.toString(), "c");
    }

    @org.junit.Test
    public void getWebs() {

    }

    @org.junit.Test
    public void isRelacionado() {
    }

    @org.junit.Test
    public void setRelacionado() {

    }
}