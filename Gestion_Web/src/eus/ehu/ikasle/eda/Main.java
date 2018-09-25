package eus.ehu.ikasle.eda;

import com.sun.deploy.util.ArrayUtil;
import eus.ehu.ikasle.eda.utils.Stopwatch;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        GestionWeb g = GestionWeb.getInstance();
        Stopwatch stopwatch = new Stopwatch();
        g.cargarDatos();
        System.out.println(stopwatch.elapsedTime());
        stopwatch = new Stopwatch();
        Web w=new Web(1000000,"chinchilla1.com");
        Webs.getInstance().anadirIdNuevo(1000001,w);
        Fichero.getInstance().escribirWebs();
        /*List<Web> webs = Webs.getInstance().getWebsOrdenadas();
        System.out.println("Tiempo " +
                stopwatch.elapsedTime());
        System.out.println(Arrays.toString(webs.toArray()));*/
    }

}
