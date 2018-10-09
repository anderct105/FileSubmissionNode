package eus.ehu.ikasle.eda;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GestionWebTest {

    private Web w0, w1, w2, w3;

    @org.junit.Before
    public void setUp() throws Exception {
        Fichero.getInstance().cargarWebsPruebas();
        Fichero.getInstance().cargarDiccionario(GestionWeb.WORDS_FILE_PATH);
        w0 = Webs.getInstance().getWebById(0);
        w1 = Webs.getInstance().getWebById(1);
        w2 = Webs.getInstance().getWebById(2);
        w3 = Webs.getInstance().getWebById(3);
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void getInstance() {
        assertNotNull(GestionWeb.getInstance());
    }

    @org.junit.Test
    public void cargarDatos() {
        Fichero.getInstance().cargarWebsPruebas();
        assertEquals(Webs.getInstance().getCantidad(), 10);

        assertEquals(Diccionario.getInstance().getCantidad(), 354983);

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

        List<Web> we3 = w3.getWebsEnlazadas();
        List<Web> wr3 = new ArrayList() {{
            add(Webs.getInstance().getWebById(1));
            add(Webs.getInstance().getWebById(2));
            add(Webs.getInstance().getWebById(4));
            add(Webs.getInstance().getWebById(5));
            add(Webs.getInstance().getWebById(6));
            add(Webs.getInstance().getWebById(7));
            add(Webs.getInstance().getWebById(8));
            add(Webs.getInstance().getWebById(9));
        }};
        assertThat(we3, is(wr3));
    }

    @org.junit.Test
    public void getWebByFullName() {
        assertEquals(Webs.getInstance().getWebByFullName("0-3ani.ro"), w0);
        assertEquals(Webs.getInstance().getWebByFullName("0086k.com"), w1);
        assertEquals(Webs.getInstance().getWebByFullName("012design.com"), w2);
    }

    @org.junit.Test
    public void buscarWebsByPalabras() {
        List<String> palabras = new ArrayList();
        palabras.add("a");
        palabras.add("o");
        List<Web> resultado = new ArrayList<>();
        resultado = GestionWeb.getInstance().buscarWebsByPalabras(palabras);
        assertEquals(resultado.size(), 2);
    }

   /* @org.junit.Test
    public void buscarWebsByPalabrasRetainAll() {
    } */

    @org.junit.Test
    public void getWebsOrdenadas() {
        List<Web> wo = GestionWeb.getInstance().getWebsOrdenadas();
        List<Web> gwo = new ArrayList() {{
            add(Webs.getInstance().getWebById(0));
            add(Webs.getInstance().getWebById(3));
            add(Webs.getInstance().getWebById(4));
            add(Webs.getInstance().getWebById(9));
            add(Webs.getInstance().getWebById(5));
            add(Webs.getInstance().getWebById(7));
            add(Webs.getInstance().getWebById(6));
            add(Webs.getInstance().getWebById(1));
            add(Webs.getInstance().getWebById(2));
            add(Webs.getInstance().getWebById(8));
        }};
        assertThat(wo, is(gwo));
    }


}