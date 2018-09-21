package eus.ehu.ikasle.eda;

import eus.ehu.ikasle.eda.utils.Stopwatch;

public class Main {

    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        Fichero.getInstance().cargarWebs();
        System.out.println(stopwatch.elapsedTime());
    }

}
