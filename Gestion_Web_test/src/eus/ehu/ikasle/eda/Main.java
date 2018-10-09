package eus.ehu.ikasle.eda;

import eus.ehu.ikasle.eda.utils.Stopwatch;

import java.util.*;

public class Main {

    private static Diccionario dic = Diccionario.getInstance();
    private static Webs webs  = Webs.getInstance();
    private static Fichero fichero = Fichero.getInstance();
    private static GestionWeb gestionWeb = GestionWeb.getInstance();
    private static Stopwatch stopwatch;


    public static void main(String[] args) {
        pruebaCargaTotal();
        pruebaOrdenacion();
        pruebaBusqueda();
        //pruebaAnadirWeb();
    }

    private static void pruebaOrdenacion() {
        System.out.println("- Prueba ordenación (merge manual)");
        stopwatch = new Stopwatch();
        List<Web> web = GestionWeb.getInstance().getWebsOrdenadasMergeSort();
        System.out.println("Tiempo ordenación de " + web.size() +" webs :" + stopwatch.elapsedTime());
        System.out.println("\t- Comprobación");
        boolean correcto = true;
        for (int i = 0; i < web.size() -1 && correcto; i++){
            if (web.get(i).compareTo(web.get(i+1)) > 0 ){
                correcto = false;
            }
        }
        System.out.println("Ordenado : " + correcto);
        System.out.println("- Prueba ordenación (sort java)");
        //System.out.println(Arrays.toString(web.toArray()));
        stopwatch = new Stopwatch();
         web = GestionWeb.getInstance().getWebsOrdenadas();
        System.out.println("Tiempo ordenación de " + web.size() +" webs :" + stopwatch.elapsedTime());
        System.out.println("\t- Comprobación");
        correcto = true;
        for (int i = 0; i < web.size() -1 && correcto; i++){
            if (web.get(i).compareTo(web.get(i+1)) > 0 ){
                correcto = false;
            }
        }
        System.out.println("Ordenado : " + correcto);
        System.out.println("- Prueba ordenación (merge sort manual)");
        stopwatch = new Stopwatch();
        //System.out.println(Arrays.toString(web.toArray()));

    }

    private static void pruebaCargaTotal() {
        System.out.println("- Prueba Carga total");
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
        fichero.cargarWebs(GestionWeb.INDEX_FILE_PATH);
        System.out.println("Tiempo carga Webs : " + stopwatch.elapsedTime());
        stopwatch = new Stopwatch();
        fichero.cargarRelaciones(GestionWeb.RELATIONS_FILE_PATH);
        System.out.println("Tiempo carga Relaciones : " +   stopwatch.elapsedTime());
        stopwatch = new Stopwatch();
        fichero.cargarDiccionario(GestionWeb.WORDS_FILE_PATH);
        System.out.println("Tiempo carga Diccionario : " + stopwatch.elapsedTime());
    }

    public static void pruebaBusqueda(){
        System.out.println("- Prueba busqueda");
        List<Web> websNoRetain;
        List<String> entrada;
        entrada = new ArrayList<>();
        entrada.add("a");
        stopwatch = new Stopwatch();
        websNoRetain = gestionWeb.buscarWebsPorPalabras(entrada);
        System.out.println("Tiempo busqueda <'a'>: " + stopwatch.elapsedTime());
        System.out.println("Nº webs : " + websNoRetain.size());
        entrada = new ArrayList<>();
        entrada.add("com");
        stopwatch = new Stopwatch();
        websNoRetain = gestionWeb.buscarWebsPorPalabras(entrada);
        System.out.println("Tiempo busqueda <'com'>: " + stopwatch.elapsedTime());
        System.out.println("Nº webs : " + websNoRetain.size());
        stopwatch = new Stopwatch();
        entrada = new ArrayList<>();
        entrada.add("a");
        entrada.add("e");
        websNoRetain = gestionWeb.buscarWebsPorPalabras(entrada);
        System.out.println("Tiempo busqueda <'a','e'>: " + stopwatch.elapsedTime());
        System.out.println("Nº webs : " + websNoRetain.size());
        entrada = new ArrayList<>();
        entrada.add("com");
        entrada.add("e");
        stopwatch = new Stopwatch();
        websNoRetain = gestionWeb.buscarWebsPorPalabras(entrada);
        System.out.println("Tiempo busqueda dos palabras <'com','e'>: " + stopwatch.elapsedTime());
        System.out.println("Nº webs : " + websNoRetain.size());
        entrada = new ArrayList<>();
        stopwatch = new Stopwatch();
        websNoRetain = gestionWeb.buscarWebsPorPalabras(entrada);
        System.out.println("Tiempo busqueda vacia : " + stopwatch.elapsedTime());
        System.out.println("Nº webs : " + websNoRetain.size());
        entrada = new ArrayList<>();
        entrada.add("dkfjglsdkfg");
        stopwatch = new Stopwatch();
        websNoRetain = gestionWeb.buscarWebsPorPalabras(entrada);
        System.out.println("Tiempo busqueda no existe :" + stopwatch.elapsedTime());
        System.out.println("Nº webs : " + websNoRetain.size());
        entrada = new ArrayList<>();
        entrada.add("a");
        entrada.add("dkfjglsdkfg");
        stopwatch = new Stopwatch();
        websNoRetain = gestionWeb.buscarWebsPorPalabras(entrada);
        System.out.println("Tiempo busqueda no existe el segundo <'a','sdfs'>: " + stopwatch.elapsedTime());
        System.out.println("Nº webs : " + websNoRetain.size());
        entrada = new ArrayList<>();
        entrada.add("o");
        entrada.add("u");
        stopwatch = new Stopwatch();
        websNoRetain = gestionWeb.buscarWebsPorPalabras(entrada);
        System.out.println("Tiempo busqueda <'o','u'>: " + stopwatch.elapsedTime());
        System.out.println("Nº webs : " + websNoRetain.size());
        System.out.println("----------");
    }


    public static void pruebaAnadirWeb(){
        System.out.println("Prueba añadir webs");
        stopwatch = new Stopwatch();
        Web w=new Web("afh.com");
        Webs.getInstance().addWebNueva(w);
        w=new Web("chinchilla2.com");
        Webs.getInstance().addWebNueva(w);
        GestionWeb.getInstance().guardarWebsAnadidas();
        System.out.println("2 webs : " + stopwatch.elapsedTime());
    }


    public static void esIgual(List<Web> listOne, List<Web> listTwo){
        Collection<Web> similar = new HashSet<Web>( listOne );
        Collection<Web> different = new HashSet<Web>();
        different.addAll( listOne );
        different.addAll( listTwo );

        similar.retainAll( listTwo );
        different.removeAll( similar );

        //System.out.printf("Similar:%s%nDifferent:%s%n",similar, different);
        System.out.printf("Different:%s%n",different);
    }

    public static void esIgualPalabras(List<Palabra> listOne, List<Palabra> listTwo){
        Collection<Palabra> similar = new HashSet<Palabra>( listOne );
        Collection<Palabra> different = new HashSet<Palabra>();
        different.addAll( listOne );
        different.addAll( listTwo );

        similar.retainAll( listTwo );
        different.removeAll( similar );

        //System.out.printf("Similar:%s%nDifferent:%s%n",similar, different);
        System.out.printf("Different:%s%n",different);
    }

}
