package eus.ehu.ikasle.eda;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class DiccionarioTest {
    Palabra p0, p1;

    @org.junit.Before
    public void setUp() throws Exception {
        Fichero.getInstance().cargarDiccionario(GestionWeb.WORDS_FILE_PATH);
        p0 = Diccionario.getInstance().getPalabraByString("a");
        p1 = Diccionario.getInstance().getPalabraByString("o");
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
    }

/*    @org.junit.Test
    public void cargarWebsRelacionadas1() {
    }*/

    @org.junit.Test
    public void addPalabra() {
        /*Palabra p = new Palabra("poiu");
        Diccionario.getInstance().addPalabra(p);*/

    }
/*
    @org.junit.Test
    public void limpiar() {
    }
*/
    @org.junit.Test
    public void getPalabraByString() {
        assertEquals(Diccionario.getInstance().getPalabraByString("a"), p0);
        assertEquals(Diccionario.getInstance().getPalabraByString("o"), p1);
    }
}