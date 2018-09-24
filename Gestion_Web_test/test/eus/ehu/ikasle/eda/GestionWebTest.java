package eus.ehu.ikasle.eda;

import eus.ehu.ikasle.eda.utils.Stopwatch;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GestionWebTest {

    @Before
    public void setUp() throws Exception {
        GestionWeb.getInstance().cargarDatos();
    }

    @Test
    public void buscarWebsByPalabras() {
    }

    @Test
    public void buscarWebsByPalabrasRetainAll() {
        List<Web> webs,webs2;
        Stopwatch stopwatch = new Stopwatch();
        webs = GestionWeb.getInstance().buscarWebsByPalabrasRetainAll(new String[]{"a", "c", "e"}); // 0-interest-credit-cards.com 696
        System.out.println("Busqueda a,c,e (retain all) : " + stopwatch.elapsedTime());
        System.out.println(Arrays.toString(webs.toArray()));
        stopwatch = new Stopwatch();
        webs2 = GestionWeb.getInstance().buscarWebsByPalabras(new String[]{"a", "c", "e"}); // 0-interest-credit-cards.com 696
        System.out.println("Busqueda a,c,e (retain all) : " + stopwatch.elapsedTime());
        System.out.println(Arrays.toString(webs.toArray()));
        assertEquals(webs,webs2);
    }
}