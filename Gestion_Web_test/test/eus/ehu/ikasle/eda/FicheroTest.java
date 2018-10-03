package eus.ehu.ikasle.eda;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FicheroTest {
    private Web w1, w2, w3;

    @org.junit.Before
    public void setUp() throws Exception {
        w1 = Webs.getInstance().getWebById(1);
        w2 = Webs.getInstance().getWebById(2);
        w3 = Webs.getInstance().getWebById(3);
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void getInstance() {
        assertNotNull(Fichero.getInstance());
    }

    @org.junit.Test
    public void cargarRelacionesPruebas() {
        Fichero.getInstance().cargarWebsPruebas();
        Fichero.getInstance().cargarRelacionesPruebas();
        w1 = Webs.getInstance().getWebById(1);
        w2 = Webs.getInstance().getWebById(2);
        w3 = Webs.getInstance().getWebById(3);

        List<Web> we1 = w1.getWebsEnlazadas();
        List<Web> wr1 = new ArrayList() {{
            add(Webs.getInstance().getWebById(0));
            add(Webs.getInstance().getWebById(2));
        }};
        assertThat(we1, is(wr1));

        List<Web> we2 = w2.getWebsEnlazadas();
        List<Web> wr2 = new ArrayList() {{
        }};
        assertThat(we2, is(wr2));

        List<Web> we1 = w1.getWebsEnlazadas();
        List<Web> wr1 = new ArrayList() {{
            add(Webs.getInstance().getWebById(0));
            add(Webs.getInstance().getWebById(2));
        }};
        assertThat(we1, is(wr1));
    }

    @org.junit.Test
    public void cargarWebsPruebas() {
        Fichero.getInstance().cargarWebsPruebas();


        List<Web> ws = new ArrayList() {{

        }};
    }

    @org.junit.Test
    public void cargarDiccionario() {
    }

    @org.junit.Test
    public void cargarPalabrasRelacionadasConWebs() {
    }
/*
    @org.junit.Test
    public void escribirWebs() {
    }
    */
}