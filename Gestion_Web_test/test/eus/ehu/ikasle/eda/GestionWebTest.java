package eus.ehu.ikasle.eda;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GestionWebTest {

    private Web w0, w1, w2;

    @org.junit.Before
    public void setUp() throws Exception {
        Fichero.getInstance().cargarWebsPruebas();
        Fichero.getInstance().cargarDiccionario(GestionWeb.WORDS_FILE_PATH);
        w0 = Webs.getInstance().getWebById(0);
        w1 = Webs.getInstance().getWebById(1);
        w2 = Webs.getInstance().getWebById(2);
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
    public void getWebOrdenada() {
    }

    @org.junit.Test
    public void getWebsOrdenadasQuickSort() {
    }
}