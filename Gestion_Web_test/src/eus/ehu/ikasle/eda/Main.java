package eus.ehu.ikasle.eda;

import com.sun.xml.internal.ws.util.StringUtils;
import eus.ehu.ikasle.eda.utils.Stopwatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Webs.getInstance().limpiar();
        Diccionario.getInstance().limpiar();
        Stopwatch stopwatch = new Stopwatch();
        GestionWeb.getInstance().cargarDatos();
        System.out.println("Cargar  : " + stopwatch.elapsedTime());
        stopwatch = new Stopwatch();
        GestionWeb.getInstance().getWebByFullName("0-3ani.ro");
        System.out.println("Busqueda 0-3ani.ro  : " + stopwatch.elapsedTime());
        stopwatch = new Stopwatch();
        GestionWeb.getInstance().getWebByFullName("005tourdial.com");
        System.out.println("Busqueda 005tourdial.com  : " + stopwatch.elapsedTime());
        stopwatch = new Stopwatch();
        List<Web> webs = GestionWeb.getInstance().buscarWebsByPalabras(new String[]{"interest", "credit", "cards"}); // 0-interest-credit-cards.com 696
        System.out.println("Busqueda interes, cards,credit  : " + stopwatch.elapsedTime());
        System.out.println(Arrays.toString(webs.toArray()));
        stopwatch = new Stopwatch();
        webs = GestionWeb.getInstance().buscarWebsByPalabras(new String[]{"a", "c", "e"}); // 0-interest-credit-cards.com 696
        System.out.println("Busqueda a,c,e  : " + stopwatch.elapsedTime());
        System.out.println(Arrays.toString(webs.toArray()));
        stopwatch = new Stopwatch();
        webs = GestionWeb.getInstance().buscarWebsByPalabras(new String[]{"a"}); // 0-interest-credit-cards.com 696
        System.out.println("Busqueda a  : " + stopwatch.elapsedTime());
        System.out.println(Arrays.toString(webs.toArray()));
        webs = GestionWeb.getInstance().buscarWebsByPalabrasRetainAll(new String[]{"interest", "credit", "cards"}); // 0-interest-credit-cards.com 696
        System.out.println("Busqueda interes, cards,credit (Retain all) : " + stopwatch.elapsedTime());
        //System.out.println(Arrays.toString(webs.toArray()));
        stopwatch = new Stopwatch();
        webs = GestionWeb.getInstance().buscarWebsByPalabrasRetainAll(new String[]{"a", "c", "e"}); // 0-interest-credit-cards.com 696
        System.out.println("Busqueda a,c,e (retain all) : " + stopwatch.elapsedTime());
        System.out.println(Arrays.toString(webs.toArray()));
        stopwatch = new Stopwatch();
        webs = GestionWeb.getInstance().buscarWebsByPalabrasRetainAll(new String[]{"a"}); // 0-interest-credit-cards.com 696
        System.out.println("Busqueda a  : (retain all)" + stopwatch.elapsedTime());
        //System.out.println(Arrays.toString(webs.toArray()));
    }

}
