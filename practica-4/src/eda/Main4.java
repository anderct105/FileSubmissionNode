package eda;

import eda.GestionWeb;
import eda.Webs;
import eda.utils.Stopwatch;

import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.HashMap;

public class Main4 {
    
    private static GestionWeb gestionWeb = GestionWeb.getInstance();
    
    public static void main(String[] args){
        Stopwatch s = new Stopwatch();
        System.out.println("Cargando datos");
        Fichero.getInstance().cargarWebs(GestionWeb.INDEX_TEST_FILE_PATH);
        Fichero.getInstance().cargarRelaciones(GestionWeb.RELATIONS_TEST_FILE_PATH);
        System.out.println("Carga de datos "+s.elapsedTime()+"s");
        s = new Stopwatch();
        HashMap<String,Double> a = gestionWeb.pageRank();
        System.out.println(a.toString());
        System.out.println("Carga de pageRank "+s.elapsedTime()+"s");
        System.out.println("Búsqueda 'a': ");
        s = new Stopwatch();
        ArrayList<Web> l = Webs.getInstance().buscar("a");
        System.out.println("Tiempo búsqueda: " + s.elapsedTime());
        System.out.println("Búsqueda 'credit' : ");
        s = new Stopwatch();
        l = Webs.getInstance().buscar("credit");
        System.out.println("Tiempo búsqueda: " + s.elapsedTime());
        System.out.println("Búsqueda 2 palabras : ");
        s = new Stopwatch();
        l = Webs.getInstance().buscar("a","credit");
        System.out.println("Tiempo búsqueda: " + s.elapsedTime());
        Fichero.getInstance().cargarWebs(GestionWeb.INDEX_FILE_PATH);
        Fichero.getInstance().cargarRelaciones(GestionWeb.RELATIONS_FILE_PATH);
        System.out.println("Carga de datos "+s.elapsedTime()+"s");
        s = new Stopwatch();
        a = gestionWeb.pageRank();
        System.out.println("Carga de pageRank "+s.elapsedTime()+"s");
        System.out.println("Búsqueda 'a': ");
        s = new Stopwatch();
        l = Webs.getInstance().buscar("a");
        System.out.println("Tiempo búsqueda: " + s.elapsedTime());
        System.out.println("Búsqueda 'credit' : ");
        s = new Stopwatch();
        l = Webs.getInstance().buscar("credit");
        System.out.println("Tiempo búsqueda: " + s.elapsedTime());
        System.out.println("Búsqueda 2 palabras : ");
        s = new Stopwatch();
        l = Webs.getInstance().buscar("a","credit");
        System.out.println("Tiempo búsqueda: " + s.elapsedTime());
    }
    
    
    
}
