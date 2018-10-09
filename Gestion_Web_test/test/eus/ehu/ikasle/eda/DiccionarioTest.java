package eus.ehu.ikasle.eda;

import java.util.ArrayList;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DiccionarioTest {
    Palabra p0, p1;
    private Web w0, w1, w2, w4, w5;

    @org.junit.Before
    public void setUp() throws Exception {
        Fichero.getInstance().cargarDiccionario(GestionWeb.WORDS_FILE_PATH);
        Fichero.getInstance().cargarWebsPruebas();
        p0 = Diccionario.getInstance().getPalabraByString("a");
        p1 = Diccionario.getInstance().getPalabraByString("o");
        w0 = Webs.getInstance().getWebById(0);
        w1 = Webs.getInstance().getWebById(1);
        w2 = Webs.getInstance().getWebById(2);
        w4 = Webs.getInstance().getWebById(4);
        w5 = Webs.getInstance().getWebById(5);
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void getInstance() {
        assertNotNull(Diccionario.getInstance());
    }

    @org.junit.Test
    public void cargarWebsRelacionadas() {
        p0.addWebConPalabra(w0);
        List<Web> w = p0.getWebs();
        List<Web> wp0 = new ArrayList(){{
            add(Webs.getInstance().getWebById(0));
        }};
        assertThat(w, is(wp0));

        p1.addWebConPalabra(w0);
        p1.addWebConPalabra(w1);
        p1.addWebConPalabra(w2);
        List<Web> wp = p1.getWebs();
        List<Web> wp1 = new ArrayList(){{
            add(Webs.getInstance().getWebById(0));
            add(Webs.getInstance().getWebById(1));
            add(Webs.getInstance().getWebById(2));
        }};
        assertThat(wp, is(wp1));
    }

    @org.junit.Test
    public void addPalabra() {
        assertEquals(Diccionario.getInstance().getCantidad(), 354983);
        Palabra p = new Palabra("poiu");
        Diccionario.getInstance().addPalabra(p);
        assertEquals (Diccionario.getInstance().getCantidad(), 354984);
    }

    @org.junit.Test
    public void getPalabraByString() {
        assertEquals(Diccionario.getInstance().getPalabraByString("a"), p0);
        assertEquals(Diccionario.getInstance().getPalabraByString("o"), p1);
    }

    @org.junit.Test
    public void fillPalabrasDeWeb(){assertEquals(w5.getPalabras().size(), 0 );
        w5.fillPalabras();
        assertEquals(w5.getPalabras().size(), 11);
        List<Palabra> pa5 = w5.getPalabras();
        List<Palabra> w5Pa = new ArrayList(){{
            add(Diccionario.getInstance().getPalabraByString("a"));
            add(Diccionario.getInstance().getPalabraByString("ax"));
            add(Diccionario.getInstance().getPalabraByString("i"));
            add(Diccionario.getInstance().getPalabraByString("r"));
            add(Diccionario.getInstance().getPalabraByString("t"));
            add(Diccionario.getInstance().getPalabraByString("ta"));
            add(Diccionario.getInstance().getPalabraByString("tax"));
            add(Diccionario.getInstance().getPalabraByString("taxi"));
            add(Diccionario.getInstance().getPalabraByString("u"));
            add(Diccionario.getInstance().getPalabraByString("x"));
            add(Diccionario.getInstance().getPalabraByString("xi"));
        }};
        Main.esIgualPalabras(pa5,w5Pa);
        assertThat(w5Pa,is(pa5));
    }
}