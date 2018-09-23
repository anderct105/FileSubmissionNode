package eus.ehu.ikasle.eda;

import eus.ehu.ikasle.eda.utils.Stopwatch;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        for (int i = 0 ; i < 20; i++) {
            Webs.getInstance().limpiar();
            Diccionario.getInstance().limpiar();
            Stopwatch stopwatch = new Stopwatch();
            Fichero.getInstance().cargarWebs();
            Fichero.getInstance().cargarRelaciones();
            Fichero.getInstance().cargarDiccionario();
            Fichero.getInstance().cargarPalabrasRelacionadasConWebs();
            System.out.println("Cargar  : " + stopwatch.elapsedTime());
        }

    }

}
