package eus.ehu.ikasle.eda;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PalabraTest {

    private Web w0, w1, w2, w4, w10;
    private Palabra p1, p2, p3;

    @org.junit.Before
    public void setUp() throws Exception {
        Fichero.getInstance().cargarWebsPruebas();
        Fichero.getInstance().cargarRelacionesPruebas();
        Fichero.getInstance().cargarDiccionario(GestionWeb.WORDS_FILE_PATH);
        w0 = Webs.getInstance().getWebById(0);
        w1 = Webs.getInstance().getWebById(1);
        w2 = Webs.getInstance().getWebById(2);
        w4 = Webs.getInstance().getWebById(4);
        w10 = new Web(10, "an");
        p1 = new Palabra("poker");
        p2 = new Palabra("a");
        p3 = new Palabra ("o");
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void addWebConPalabra() {
        assertEquals (p2.getWebs().size(), 0);
        p2.addWebConPalabra(w10);
        assertEquals(p2.getWebs().size(), 1);
    }

    @org.junit.Test
    public void getWebs() {
        List<Web> wp = p1.getWebs();
        List<Web> wp1 = new ArrayList(){{
            add(Webs.getInstance().getWebById(4));
        }};
        assertThat(wp, is(wp1));
    }
}