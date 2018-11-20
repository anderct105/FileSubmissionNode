package eus.ehu.ikasle.eda;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final int MAX_EXECUTIONS = 10000;

    public static Graph graph;
    public static int lastId;
    public static void main(String[] args){
        carga();
        pruebaEstanConectados();
        pruebaBackPointer();
        pruebaNp();
    }

    private static void pruebaNp() {
        String initNode,finalNode;
        Stopwatch stopwatch = new Stopwatch();
        System.out.println("Cargando fichero webs grande");
        ListaWebs webs = Fichero.getInstance().cargarWebsReales();
        graph = new Graph();
        graph.crearGrafo(webs);
        System.out.println("Prueba 10000 relaciones aleatorias:");
        for (int i = 0 , numConectados = 0;; i++){
            initNode = graph.getRandomNode();
            finalNode = graph.getRandomNode();
            if (graph.estanConectados(initNode,finalNode)){
                ++numConectados;
            }

           // System.out.println( "\t" + initNode + " --> " + finalNode + ": " + ((conectados)?"Conectado":"No conectado"));
            if (stopwatch.elapsedTime() % 60 == 0){
                System.out.println("Tiempo : " + stopwatch.elapsedTime()  + "s : " + i + " conexiones analizadas --> " + i + " --> conectadas -->" + numConectados);
                i = 0;
                numConectados = 0;
                stopwatch = new Stopwatch();
            }
        }
    }

    private static void carga(){
        graph = new Graph();
        System.out.println("Leyendo Ficheros...");
        Stopwatch sw = new Stopwatch();
        ListaWebs webs = Fichero.getInstance().cargarWebs();
        System.out.println("Tiempo de carga: "+sw.elapsedTime()+"s");
        lastId = webs.size();
        sw = new Stopwatch();
        System.out.println("Generando Grafo...");
        graph.crearGrafo(webs);
        System.out.println("Tiempo de carga: "+sw.elapsedTime()+"s");
    }

    private static void pruebaEstanConectados(){
        //No estan conectados
        boolean conectados;
        System.out.println("----------------------------Prueba estanConectados()----------------------------");
        conectados = graph.estanConectados("1","7");
        System.out.println("Prueba1:");
        System.out.println("Web1: **1** ID1: 1\nWeb2: **7** ID2: 7");
        System.out.println("Respuesta teorica: false");
        System.out.println("Respuesta practica: "+conectados);
        conectados = graph.estanConectados("2","5");
        System.out.println("Prueba2:");
        System.out.println("Web1: **2** ID1: 2\nWeb2: **5** ID2: 5");
        System.out.println("Respuesta teorica: false");
        System.out.println("Respuesta practica: "+conectados);
        //estan conectados
        conectados = graph.estanConectados("1","2");
        System.out.println("Prueba3:");
        System.out.println("Web1: **1** ID1: 1\nWeb2: **2** ID2: 2");
        System.out.println("Respuesta teorica: true");
        System.out.println("Respuesta practica: "+conectados);
        conectados = graph.estanConectados("0","6");
        System.out.println("Prueba4:");
        System.out.println("Web1: **0** ID1: 0\nWeb2: **6** ID2: 6");
        System.out.println("Respuesta teorica: true");
        System.out.println("Respuesta practica: "+conectados);
    }

    private static void pruebaBackPointer(){
        System.out.println("----------------------------Prueba backPointer()----------------------------");
         System.out.println("Prueba1:");
        System.out.println("Web1: **1** ID1: 1\nWeb2: **7** ID2: 7");
        System.out.println("El camino deberia ser: []");
        System.out.println(graph.backPointer("1","7"));
        System.out.println("Prueba2:");
        System.out.println("Web1: **2** ID1: 2\nWeb2: **5** ID2: 5");
        System.out.println("El camino deberia ser: []");
        System.out.println(graph.backPointer("2","5"));
        //estan conectados
        System.out.println("Prueba3:");
        System.out.println("Web1: **1** ID1: 1\nWeb2: **2** ID2: 2");
        System.out.println("El camino deberia ser: [1,2]");
        System.out.println(graph.backPointer("1","2"));
        System.out.println("Prueba4:");
        System.out.println("Web1: **0** ID1: 0\nWeb2: **6** ID2: 6");
        System.out.println("El camino es: [0,3,4,6]");
        System.out.println(graph.backPointer("0","6"));
    }
}

