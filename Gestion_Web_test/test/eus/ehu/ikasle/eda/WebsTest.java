package eus.ehu.ikasle.eda;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.Assert.*;

public class WebsTest {

    private Web w1;
    private Web w2;
    private Web w3;
    private LinkedHashMap<Integer,Web> webs;
    private List<Integer> listaAnadidas;

    @org.junit.Before
    public void setUp() throws Exception {

        w1 = new Web (1, "a");
        w2 = new Web (2, "b");
        w3 = new Web (3, "c");
        webs = new LinkedHashMap<>();
        listaAnadidas = new ArrayList<>();

    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void getInstance() {
    }

    @org.junit.Test
    public void addWeb() {
        /*assertEquals(webs.size(), 0);
        webs.put(1, w1);
        assertEquals(webs.size(), 1);
        webs.put(2, w2);
        assertEquals(webs.size(), 2);
        webs.put(3, w3);
        assertEquals(webs.size(), 3);*/
    }

    @org.junit.Test
    public void anadirIdNuevo() {

    }

    @org.junit.Test
    public void getWebById() {
    }

    @org.junit.Test
    public void limpiar() {
    }

    @org.junit.Test
    public void websQueContienen() {
    }

    @org.junit.Test
    public void getWebByFullName() {
    }

    @org.junit.Test
    public void getWebsOrdenadas() {
    }

    @org.junit.Test
    public void getListaAnadidas() {
    }

    @org.junit.Test
    public void getWebsOrdenadasQuickSort() {
    }
}