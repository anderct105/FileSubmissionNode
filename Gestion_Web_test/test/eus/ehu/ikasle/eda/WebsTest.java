package eus.ehu.ikasle.eda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class WebsTest {

    private Web w0, w1, w10;

    @org.junit.Before
    public void setUp() throws Exception {

        Fichero.getInstance().cargarWebsPruebas();
        w0 = Webs.getInstance().getWebById(0);
        w1 = Webs.getInstance().getWebById(1);
        //w10 = new Web(10, "abc");
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void getInstance() {
        assertNotNull(Webs.getInstance());
    }

    @org.junit.Test
    public void getWebById() {
        assertEquals(Webs.getInstance().getWebById(0), w0);
        assertEquals(Webs.getInstance().getWebById(1), w1);
    }

    @org.junit.Test
    public void limpiar() {
        assertEquals(Webs.getInstance().getWebById(0), w0);
        Webs.getInstance().limpiar();
        assertNull(Webs.getInstance().getWebById(0));
    }

    @Test
    public void websQueContienen() {
        Palabra p0 = new Palabra("a");
        Webs.getInstance().websQueContienen(p0);

        List<Web> lw = p0.getWebs();
        List<Web> lw0 = new ArrayList(){{
            add(Webs.getInstance().getWebById(0));
            add(Webs.getInstance().getWebById(3));
            add(Webs.getInstance().getWebById(5));
            add(Webs.getInstance().getWebById(7));
            add(w10);
        }};
        assertThat(lw, is(lw0));
    }

    @org.junit.Test
    public void getWebByFullName() {
        assertEquals(Webs.getInstance().getWebByFullName("0-3ani.ro"), w0);
        assertEquals(Webs.getInstance().getWebByFullName("0086k.com"), w1);
    }

    @org.junit.Test
    public void getListaAnadidas() {
        assertEquals(Webs.getInstance().getListaAnadidas().size(), 0);
        Webs.getInstance().addWebNueva(w10);
        assertEquals(Webs.getInstance().getListaAnadidas().size(), 1);
    }
}