package eus.ehu.ikasle.eda;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class WebTest {

    private Web w0,w1,w2,w3,w9, w5;

    @org.junit.Before
    public void setUp() throws Exception {
        Fichero.getInstance().cargarWebsPruebas();
        Fichero.getInstance().cargarDiccionario(GestionWeb.WORDS_FILE_PATH);
        w0 = Webs.getInstance().getWebById(0);
        w1 = Webs.getInstance().getWebById(1);
        w2 = Webs.getInstance().getWebById(2);
        w3 = Webs.getInstance().getWebById(3);
        w5 = Webs.getInstance().getWebById(5);
        w9 = Webs.getInstance().getWebById(9);
        w0.fillPalabras();
        w1.fillPalabras();
        w2.fillPalabras();
        w3.fillPalabras();
        w9.fillPalabras();
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
        assertEquals(w1.getWeb(), "0086k.com");
        assertEquals(w2.getWeb(), "012design.com");
        assertEquals(w3.getWeb(), "0-adult.net");
    }

    @org.junit.Test
    public void getWebsEnlazadas() {
        Fichero.getInstance().cargarRelacionesPruebas();
        List<Web> we1 = w1.getWebsEnlazadas();
        List<Web> w1En = new ArrayList(){{
            add(Webs.getInstance().getWebById(0));
            add(Webs.getInstance().getWebById(2));
        }};
        assertThat(we1,is(w1En));

        /*List<Web> we2 = w2.getWebsEnlazadas();
        List<Web> w2En = new ArrayList();
        assertThat(w2.getWebsEnlazadas(),is(w2En));

        List<Web> we3 = w3.getWebsEnlazadas();
        List<Web> w3En = new ArrayList(){{
            add(Webs.getInstance().getWebById(6));
            add(Webs.getInstance().getWebById(5));
        }};
        assertThat(w3.getWebsEnlazadas(),is(w3En));*/
    }

    @org.junit.Test
    public void getPalabras() {
        List<Palabra> pa0 = w0.getPalabras();
        List<Palabra> w0Pa = new ArrayList(){{
            add(Diccionario.getInstance().getPalabraByString("a"));
            add(Diccionario.getInstance().getPalabraByString("an"));
            add(Diccionario.getInstance().getPalabraByString("ani"));
            add(Diccionario.getInstance().getPalabraByString("i"));
            add(Diccionario.getInstance().getPalabraByString("n"));
            add(Diccionario.getInstance().getPalabraByString("ni"));
            add(Diccionario.getInstance().getPalabraByString("o"));
            add(Diccionario.getInstance().getPalabraByString("r"));
            add(Diccionario.getInstance().getPalabraByString("ro"));
        }};
        assertThat(pa0,is(w0Pa));

        List<Palabra> pa1 = w1.getPalabras();
        List<Palabra> w1Pa = new ArrayList(){{
            add(Diccionario.getInstance().getPalabraByString("c"));
            add(Diccionario.getInstance().getPalabraByString("co"));
            add(Diccionario.getInstance().getPalabraByString("com"));
            add(Diccionario.getInstance().getPalabraByString("k"));
            add(Diccionario.getInstance().getPalabraByString("m"));
            add(Diccionario.getInstance().getPalabraByString("o"));
            add(Diccionario.getInstance().getPalabraByString("om"));
        }};
        assertThat(pa1,is(w1Pa));

        List<Palabra> pa2 = w2.getPalabras();
        List<Palabra> w2Pa = new ArrayList(){{
            add(Diccionario.getInstance().getPalabraByString("2"));
            add(Diccionario.getInstance().getPalabraByString("c"));
            add(Diccionario.getInstance().getPalabraByString("co"));
            add(Diccionario.getInstance().getPalabraByString("com"));
            add(Diccionario.getInstance().getPalabraByString("d"));
            add(Diccionario.getInstance().getPalabraByString("de"));
            add(Diccionario.getInstance().getPalabraByString("des"));
            add(Diccionario.getInstance().getPalabraByString("desi"));
            add(Diccionario.getInstance().getPalabraByString("design"));
            add(Diccionario.getInstance().getPalabraByString("e"));
            add(Diccionario.getInstance().getPalabraByString("es"));
            add(Diccionario.getInstance().getPalabraByString("g"));
            add(Diccionario.getInstance().getPalabraByString("gn"));
            add(Diccionario.getInstance().getPalabraByString("i"));
            add(Diccionario.getInstance().getPalabraByString("ign"));
            add(Diccionario.getInstance().getPalabraByString("m"));
            add(Diccionario.getInstance().getPalabraByString("n"));
            add(Diccionario.getInstance().getPalabraByString("o"));
            add(Diccionario.getInstance().getPalabraByString("om"));
            add(Diccionario.getInstance().getPalabraByString("s"));
            add(Diccionario.getInstance().getPalabraByString("si"));
            add(Diccionario.getInstance().getPalabraByString("sig"));
            add(Diccionario.getInstance().getPalabraByString("sign"));
        }};
        assertThat(pa2,is(w2Pa));

        List<Palabra> pa9 = w9.getPalabras();
        List<Palabra> w9Pa = new ArrayList(){{
            add(Diccionario.getInstance().getPalabraByString("f"));
            add(Diccionario.getInstance().getPalabraByString("ff"));
            add(Diccionario.getInstance().getPalabraByString("g"));
            add(Diccionario.getInstance().getPalabraByString("o"));
            add(Diccionario.getInstance().getPalabraByString("or"));
            add(Diccionario.getInstance().getPalabraByString("org"));
            add(Diccionario.getInstance().getPalabraByString("r"));
            add(Diccionario.getInstance().getPalabraByString("rg"));
        }};
        assertThat(pa9,is(w9Pa));
    }

    @org.junit.Test
    public void addWebRelacionada() {
        assertEquals (w1.getWebsEnlazadas().size(), 0);
        w1.addWebRelacionada(w2);
        assertEquals (w1.getWebsEnlazadas().size(), 1);
    }

    @org.junit.Test
    public void contains() {
        assertTrue(w1.contains(new Palabra("k")));
        assertFalse(w1.contains(new Palabra("l")));
    }

    @org.junit.Test
    public void addPalabra() {
        assertEquals (w1.getPalabras().size(), 7);
        w1.addPalabra(new Palabra("q"));
        assertEquals (w1.getPalabras().size(), 8);
    }

    @org.junit.Test
    public void estaEnListaPalabras() {
        assertTrue(w1.estaEnListaPalabras(new Palabra("k")));
        assertFalse(w1.estaEnListaPalabras(new Palabra("l")));
    }

    @org.junit.Test
    public void fillPalabras() {
        assertEquals(w5.getPalabras().size(), 0 );
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