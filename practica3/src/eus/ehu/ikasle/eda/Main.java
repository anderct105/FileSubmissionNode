package eus.ehu.ikasle.eda;

import javafx.scene.paint.Stop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Graph graph;
    public static int lastId;
    public static void main(String[] args){
        carga();
        pruebaEstanConectados();
        pruebaBackPointer();
        pruebaNp();
    }

    private static void pruebaNp() {
        Stopwatch stopwatch = new Stopwatch();
        System.out.println("Cargando fichero webs grande");
        ListaWebs webs = Fichero.getInstance().cargarWebsReales();
        System.out.println("Tiempo de carga : " + stopwatch.elapsedTime());
        System.out.println("Creando grafo");
        stopwatch = new Stopwatch();
        graph = new Graph();
        graph.crearGrafo(webs);
        System.out.println("Tiempo de creacion : " + stopwatch.elapsedTime());
        ejecucionesPorTiempo(60,10);
        ejecucionesPorTiempo(3600,10);
    }

    private static void ejecucionesPorTiempo(int segundosDeEjecucion, int intentos){
        Stopwatch stopwatch;
        ArrayList<Integer> ejecuciones = new ArrayList<>();
        System.out.println("Prueba de " + segundosDeEjecucion + "s y " + intentos + " intentos");
        for (int i = 0 ; i < intentos; i++){
            int numEjecuciones = 0;
            stopwatch = new Stopwatch();
            while(stopwatch.elapsedTime() < segundosDeEjecucion){
                graph.estanConectados(graph.getRandomNode(),graph.getRandomNode());
                numEjecuciones++;
            }
            System.out.println("Ejecuciones : " + numEjecuciones);
            ejecuciones.add(numEjecuciones);
        }
        int total = 0;
        for (Integer i: ejecuciones) {
            total += i;
        }
        System.out.println("Media de ejecuciones :" + (total/intentos));
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
        System.out.println("Prueba5:");
        System.out.println("Web1: **0** ID1: 0\nWeb2: **0** ID2: 0");
        System.out.println("Respuesta teorica: true");
        conectados = graph.estanConectados("0","0");
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
        System.out.println("Prueba3:");
        System.out.println("Web1: **1** ID1: 1\nWeb2: **2** ID2: 2");
        System.out.println("El camino deberia ser: [1,2]");
        System.out.println(graph.backPointer("1","2"));
        System.out.println("Prueba4:");
        System.out.println("Web1: **0** ID1: 0\nWeb2: **6** ID2: 6");
        System.out.println("El camino es: [0,3,4,6]");
        System.out.println(graph.backPointer("0","6"));
        System.out.println("Prueba5:");
        System.out.println("Web1: **0** ID1: 0\nWeb2: **0** ID2: 0");
        System.out.println("El camino es: [0]");
        System.out.println(graph.backPointer("0","0"));
    }
}

