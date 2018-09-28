package eus.ehu.ikasle.eda;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PalabraTest {

    private Web w0,w1,w2;

    @org.junit.Before
    public void setUp() throws Exception {
        Fichero.getInstance().cargarWebs();
        Fichero.getInstance().cargarDiccionario();
        Fichero.getInstance().cargarPalabrasRelacionadasConWebs();
        Fichero.getInstance().cargarRelaciones();
        w0 = Webs.getInstance().getWebById(0);
        w1 = Webs.getInstance().getWebById(1);
        w2 = Webs.getInstance().getWebById(2);

    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void addWebConPalabra() {

    }

    @org.junit.Test
    public void getWebs() {
        List<Web> we0 = GestionWeb.getInstance().buscarWebsByPalabras(new ArrayList<String>(){{
            add("0-3ani.ro");
        }});
        assertEquals(we0.size(), 1);
    }
}