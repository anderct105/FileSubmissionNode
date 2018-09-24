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
    }
}