package eus.ehu.ikasle.eda;

import com.sun.xml.internal.ws.util.StringUtils;
import eus.ehu.ikasle.eda.utils.Stopwatch;
import javafx.scene.paint.Stop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    private static Diccionario dic = Diccionario.getInstance();
    private static Webs webs  = Webs.getInstance();
    private static Fichero fichero = Fichero.getInstance();
    private static GestionWeb gestionWeb = GestionWeb.getInstance();
    private static Stopwatch stopwatch;


    public static void main(String[] args) {
        pruebaCarga();
       // pruebaCargaTotal();
       // pruebaBusqueda();
    }

    private static void pruebaCargaTotal() {
        dic.limpiar();
        webs.limpiar();
        stopwatch = new Stopwatch();
        gestionWeb.cargarDatos();
        System.out.println("Tiempo total de carga de datos: " + stopwatch.elapsedTime());
        System.out.println("----------");
    }

    public static void pruebaCarga(){
        dic.limpiar();
        webs.limpiar();
        stopwatch = new Stopwatch();
        fichero.cargarWebs();
        System.out.println("Tiempo carga Webs : " + stopwatch.elapsedTime());
        stopwatch = new Stopwatch();
        fichero.cargarRelaciones();
        System.out.println("Tiempo carga Relaciones : " +   stopwatch.elapsedTime());
        stopwatch = new Stopwatch();
        fichero.cargarDiccionario();
        System.out.println("Tiempo carga Diccionario : " + stopwatch.elapsedTime());
        stopwatch = new Stopwatch();
        fichero.cargarPalabrasRelacionadasConWebs();
        System.out.println("Tiempo carga Palabras de cada web y webs de cada palabra : " + stopwatch.elapsedTime());
        System.out.println("----------");
    }

    public static void pruebaBusqueda(){
        List<Web> websNoRetain,websRetain;
        List<String> entrada;
        entrada = new ArrayList<>();
        entrada.add("a");
        stopwatch = new Stopwatch();
        websNoRetain = gestionWeb.buscarWebsByPalabras(entrada);
        System.out.println("Tiempo busqueda una palabra (No retain): " + stopwatch.elapsedTime());
        stopwatch = new Stopwatch();
        websRetain = gestionWeb.buscarWebsByPalabrasRetainAll(entrada);
        System.out.println("Tiempo busqueda una palabra (Retain) : " + stopwatch.elapsedTime() );
        System.out.println("Busqueda correcta : " + (websRetain.containsAll(websNoRetain) && websRetain.size() == websNoRetain.size()));
        System.out.println("----------");
        entrada = new ArrayList<>();
        entrada.add("com");
        stopwatch = new Stopwatch();
        websNoRetain = gestionWeb.buscarWebsByPalabras(entrada);
        System.out.println("Tiempo busqueda (com)(No retain): " + stopwatch.elapsedTime());
        stopwatch = new Stopwatch();
        websRetain = gestionWeb.buscarWebsByPalabrasRetainAll(entrada);
        System.out.println("Tiempo busqueda (com)(Retain) : " + stopwatch.elapsedTime() );
        System.out.println("Busqueda correcta : " + (websRetain.containsAll(websNoRetain) && websRetain.size() == websNoRetain.size()));
        System.out.println("----------");
        stopwatch = new Stopwatch();
        entrada = new ArrayList<>();
        entrada.add("a");
        entrada.add("e");
        websNoRetain = gestionWeb.buscarWebsByPalabras(entrada);
        System.out.println("Tiempo busqueda dos palabras (a,e)(No retain): " + stopwatch.elapsedTime());
        stopwatch = new Stopwatch();
        websRetain = gestionWeb.buscarWebsByPalabrasRetainAll(entrada);
        System.out.println("Tiempo busqueda dos palabras (a, e)(Retain) : " + stopwatch.elapsedTime() );
        System.out.println("Busqueda correcta : " + (websRetain.containsAll(websNoRetain) && websRetain.size() == websNoRetain.size()));
        System.out.println("----------");
        entrada = new ArrayList<>();
        entrada.add("com");
        entrada.add("e");
        stopwatch = new Stopwatch();
        websNoRetain = gestionWeb.buscarWebsByPalabras(entrada);
        System.out.println("Tiempo busqueda dos palabras (e,com)(No retain): " + stopwatch.elapsedTime());
        stopwatch = new Stopwatch();
        websRetain = gestionWeb.buscarWebsByPalabrasRetainAll(entrada);
        System.out.println("Tiempo busqueda dos palabras (e,com)(Retain) : " + stopwatch.elapsedTime() );
        System.out.println("Busqueda correcta : " + (websRetain.containsAll(websNoRetain) && websRetain.size() == websNoRetain.size()));
        System.out.println("----------");
        entrada = new ArrayList<>();
        stopwatch = new Stopwatch();
        websNoRetain = gestionWeb.buscarWebsByPalabras(entrada);
        System.out.println("Tiempo busqueda vacia (No retain): " + stopwatch.elapsedTime());
        stopwatch = new Stopwatch();
        websRetain = gestionWeb.buscarWebsByPalabrasRetainAll(entrada);
        System.out.println("Tiempo busqueda vacia (Retain) : " + stopwatch.elapsedTime() );
        System.out.println("Busqueda correcta : " + (websRetain.containsAll(websNoRetain) && websRetain.size() == websNoRetain.size()));
        System.out.println("----------");
        entrada = new ArrayList<>();
        entrada.add("dkfjglsdkfg");
        stopwatch = new Stopwatch();
        websNoRetain = gestionWeb.buscarWebsByPalabras(entrada);
        System.out.println("Tiempo busqueda no existe (No retain): " + stopwatch.elapsedTime());
        stopwatch = new Stopwatch();
        websRetain = gestionWeb.buscarWebsByPalabrasRetainAll(entrada);
        System.out.println("Tiempo busqueda no existe (Retain) : " + stopwatch.elapsedTime() );
        System.out.println("Busqueda correcta : " + (websRetain.containsAll(websNoRetain) && websRetain.size() == websNoRetain.size()));
        System.out.println("----------");
        entrada = new ArrayList<>();
        entrada.add("a");
        entrada.add("dkfjglsdkfg");
        stopwatch = new Stopwatch();
        websNoRetain = gestionWeb.buscarWebsByPalabras(entrada);
        System.out.println("Tiempo busqueda no existe el segundo (No retain): " + stopwatch.elapsedTime());
        stopwatch = new Stopwatch();
        websRetain = gestionWeb.buscarWebsByPalabrasRetainAll(entrada);
        System.out.println("Tiempo busqueda no existe el segundo (Retain) : " + stopwatch.elapsedTime() );
        System.out.println("Busqueda correcta : " + (websRetain.containsAll(websNoRetain) && websRetain.size() == websNoRetain.size()));
        System.out.println("----------");
    }


}
