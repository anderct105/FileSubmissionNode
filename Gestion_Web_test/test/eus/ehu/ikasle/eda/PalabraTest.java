package eus.ehu.ikasle.eda;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PalabraTest {

    private Web w0, w1, w2, w4;
    private Palabra p1, p2;

    @org.junit.Before
    public void setUp() throws Exception {
        Fichero.getInstance().cargarWebs();
        Fichero.getInstance().cargarDiccionario();
        Fichero.getInstance().cargarPalabrasRelacionadasConWebs();
        Fichero.getInstance().cargarRelaciones();
        w0 = Webs.getInstance().getWebById(0);
        w1 = Webs.getInstance().getWebById(1);
        w2 = Webs.getInstance().getWebById(2);
        w4 = Webs.getInstance().getWebById(4);
        Palabra p1 = new Palabra("poker");
        Palabra p2 = new Palabra("ander");
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void addWebConPalabra() {

    }

    @org.junit.Test
    public void getWebs() {
        List<Web> ls = new ArrayList();
        ls.add(w4);
        assertThat(p1.getWebs(), is(ls));
    }
}