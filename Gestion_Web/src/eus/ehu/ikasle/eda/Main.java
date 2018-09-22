package eus.ehu.ikasle.eda;

import eus.ehu.ikasle.eda.utils.Stopwatch;

public class Main {

    public static void main(String[] args) {
        GestionWeb g = GestionWeb.getInstance();
        Stopwatch stopwatch = new Stopwatch();
        g.cargarDatos();
        System.out.println(stopwatch.elapsedTime());
    }

}
