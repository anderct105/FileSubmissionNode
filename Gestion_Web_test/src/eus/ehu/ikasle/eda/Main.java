package eus.ehu.ikasle.eda;

import eus.ehu.ikasle.eda.utils.Stopwatch;

import java.util.*;

public class Main {

    private static Diccionario dic = Diccionario.getInstance();
    private static Webs webs = Webs.getInstance();
    private static Fichero fichero = Fichero.getInstance();
    private static GestionWeb gestionWeb = GestionWeb.getInstance();
    private static Stopwatch stopwatch;


    public static void main(String[] args) {
        //Pruebas con el fichero grande
        System.out.println("Pruebas Fichero grande");
        pruebaCargaTotal();
        pruebaOrdenacion();
        pruebaBusquedaWebsConPalabras();
        pruebaAnadirWeb();

        //Pruebas con el fichero pequeño
        System.out.println("Pruebas Fichero pequeño");
        pruebaCargaPequeño();
        pruebaOrdenacion();
        pruebaBusquedaWebsConPalabras();
    }

    private static void pruebaOrdenacion() {
        System.out.println("\t Prueba ordenación (merge manual)");
        stopwatch = new Stopwatch();
        List<Web> web = GestionWeb.getInstance().getWebsOrdenadasMergeSort();
        System.out.println("\t\tTiempo ordenación de " + web.size() + " webs :" + stopwatch.elapsedTime());
        System.out.print("\t\t Comprobación : ");
        boolean correcto = true;
        for (int i = 0; i < web.size() - 1 && correcto; i++) {
            if (web.get(i).compareTo(web.get(i + 1)) > 0) {
                correcto = false;
            }
        }
        System.out.println(correcto ? "Correcto" : "Incorrecto");
    }

    private static void pruebaCargaTotal() {
        dic.limpiar();
        webs.limpiar();
        stopwatch = new Stopwatch();
        gestionWeb.cargarDatos();
        System.out.println("\t Tiempo total de carga de datos: " + stopwatch.elapsedTime());
        System.out.println("\n");
    }

    public static void pruebaCargaPequeño() {
        dic.limpiar();
        webs.limpiar();
        stopwatch = new Stopwatch();
        fichero.cargarWebs(GestionWeb.SMALL_INDEX_FILE_PATH);
        fichero.cargarRelaciones(GestionWeb.SMALL_RELATIONS_FILE_PATH);
        fichero.cargarDiccionario(GestionWeb.WORDS_FILE_PATH);
        System.out.println("\t Tiempo carga Total : " + stopwatch.elapsedTime());
        System.out.println("\n");
    }

    private static void pruebaBusquedaIndividual(List<String> entrada){
        String salida = "\t Prueba búsqueda <";
        String valores = "";
        for (String entr:entrada) {
            valores += entr + ", ";
        }
        if (valores.length()-2 >0){
            salida += valores.substring(0,valores.length()-2);
        }
        salida += "> :";
        System.out.println(salida);
        stopwatch = new Stopwatch();
        List<Web> webs= gestionWeb.buscarWebsPorPalabras(entrada);
        System.out.println("\t\t Tiempo : " + stopwatch.elapsedTime());
        System.out.println("\t\t Nº resultados : " + webs.size());
        System.out.print("\t\t Comprobacion: ");
        boolean correcto = true;
        for (int i = 0; i < webs.size() && correcto; i++){
            for (int j = 0; j < entrada.size() && correcto; j++){
                if (!webs.get(i).getWeb().toLowerCase().contains(entrada.get(j).toLowerCase())){
                    correcto = false;
                }
            }
        }
        System.out.println(correcto ? "Correcto":"Incorrecto");
    }

    public static void pruebaBusquedaWebsConPalabras() {
        System.out.println("\t Prueba Búsqueda de webs que contienen palabras");
        List<String> entrada;
        entrada = new ArrayList<>();
        entrada.clear();
        pruebaBusquedaIndividual(entrada);
        entrada.clear();
        entrada.add("a");
        pruebaBusquedaIndividual(entrada);
        entrada.clear();
        entrada.add("a");
        pruebaBusquedaIndividual(entrada);
        entrada.clear();
        entrada.add("dkjsdfl");
        pruebaBusquedaIndividual(entrada);
        entrada.clear();
        entrada.add("card");
        entrada.add("credit");
        pruebaBusquedaIndividual(entrada);
        entrada.clear();
        entrada.add("a");
        entrada.add("es");
        entrada.add("com");
        pruebaBusquedaIndividual(entrada);
        entrada.clear();
        entrada.add("a");
        entrada.add("asdkfsdlf");
        entrada.add("com");
        pruebaBusquedaIndividual(entrada);
        entrada.clear();
        entrada.add("asfgs");
        entrada.add("asdfsifdfa");
        entrada.add("wqerqwergfgf");
        pruebaBusquedaIndividual(entrada);
        System.out.println("\n");
    }


    public static void pruebaAnadirWeb() {
        System.out.println("Prueba añadir webs");
        pruebaAnadirWebIndividual("chinchilla.com");
        pruebaAnadirWebIndividual("");
        pruebaAnadirWebIndividual("0-00.pl");
        pruebaAnadirWebIndividual("chinchilla 2");
    }


    private static void pruebaAnadirWebIndividual(String webName){
        System.out.println("\t Prueba añadir");
        stopwatch = new Stopwatch();
        boolean insertado = gestionWeb.nuevaWeb(webName);
        System.out.println("\t\t Tiempo añadido : " + stopwatch.elapsedTime());
        System.out.println("\t\t Añadido " + webName + " : " + insertado);
    }

    public static void esIgual(List<Web> listOne, List<Web> listTwo) {
        Collection<Web> similar = new HashSet<Web>(listOne);
        Collection<Web> different = new HashSet<Web>();
        different.addAll(listOne);
        different.addAll(listTwo);

        similar.retainAll(listTwo);
        different.removeAll(similar);

        //System.out.printf("Similar:%s%nDifferent:%s%n",similar, different);
        System.out.printf("Different:%s%n", different);
    }

    public static void esIgualPalabras(List<Palabra> listOne, List<Palabra> listTwo) {
        Collection<Palabra> similar = new HashSet<Palabra>(listOne);
        Collection<Palabra> different = new HashSet<Palabra>();
        different.addAll(listOne);
        different.addAll(listTwo);

        similar.retainAll(listTwo);
        different.removeAll(similar);

        //System.out.printf("Similar:%s%nDifferent:%s%n",similar, different);
        System.out.printf("Different:%s%n", different);
    }

}
