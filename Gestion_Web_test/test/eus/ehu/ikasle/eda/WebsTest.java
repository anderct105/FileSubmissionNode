package eus.ehu.ikasle.eda;

import static org.junit.Assert.*;

public class WebsTest {

    private Web w0, w1, w10;

    @org.junit.Before
    public void setUp() throws Exception {

        Fichero.getInstance().cargarWebsPruebas();
        w0 = Webs.getInstance().getWebById(0);
        w1 = Webs.getInstance().getWebById(1);
        w10 = new Web(10, "abc");
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void getInstance() {
    }

    @org.junit.Test
    public void addWeb() {

    }

    @org.junit.Test
    public void addWebNueva() {
        assertEquals(Webs.getInstance().getListaAnadidas().size(), 0);
        Webs.getInstance().addWebNueva(w10);
        assertEquals(Webs.getInstance().getListaAnadidas().size(), 1);
    }

    @org.junit.Test
    public void getWebById() {
        assertEquals(Webs.getInstance().getWebById(0), w0);
        assertEquals(Webs.getInstance().getWebById(1), w1);
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
        assertEquals(Webs.getInstance().getListaAnadidas().size(), 0);
        Webs.getInstance().addWebNueva(w10);
        assertEquals(Webs.getInstance().getListaAnadidas().size(), 1);
    }

    @org.junit.Test
    public void getWebsOrdenadasQuickSort() {
    }
}