package eus.ehu.ikasle.eda;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
     //   pruebaNp();
    }

    private static void pruebaNp() {
        String initNode,finalNode;
        Stopwatch stopwatch = new Stopwatch();
        System.out.println("Cargando fichero webs grande");
        ListaWebs webs = Fichero.getInstance().cargarWebsReales();
        graph = new Graph();
        graph.crearGrafo(webs);
        System.out.println("Prueba 10000 relaciones aleatorias:");
        ArrayList<Integer> numConectadosMinuto = new ArrayList<>();
        ArrayList<Integer> numConectadosHora = new ArrayList<>();
        File file = new File("output.log");
        try {
            if (file.exists()){
                file.delete();
            }
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0, iHoras = 0 , minutos = 0 , horas = 0; horas <24 ; i++, iHoras++){
            initNode = graph.getRandomNode();
            finalNode = graph.getRandomNode();
            graph.estanConectados(initNode,finalNode);
           // System.out.println( "\t" + initNode + " --> " + finalNode + ": " + ((conectados)?"Conectado":"No conectado"));
            if ((int)(stopwatch.elapsedTime()) >= 60){
                minutos++;
                numConectadosMinuto.add(i);
                int finalMinutos = minutos;
                int finalI = i;
                new Thread(() -> {
                    BufferedWriter out = null;
                    try {
                        out = new BufferedWriter(new FileWriter(file,true));
                        out.write("- " + finalMinutos + " minuto : " + finalI + " ejecuciones\n");
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
                if (minutos % 60 == 0){
                    minutos = 0;
                    horas++;
                    numConectadosHora.add(iHoras);
                    int finalHoras = horas;
                    int finalIHoras = iHoras;
                    new Thread(() -> {
                        BufferedWriter out = null;
                        try {
                            out = new BufferedWriter(new FileWriter(file,true));
                            out.write("-- " + finalHoras + " hora : " + finalIHoras + " ejecuciones\n");
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                    iHoras = 0;
                }
                i = 0;
                stopwatch = new Stopwatch();
            }
        }
        int sumMinutos = 0;
        for (int i : numConectadosMinuto) {
            sumMinutos += i;
        }
        int sumHoras = 0;
        for (int i : numConectadosHora){
            sumHoras += i;
        }

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(file,true));
            out.write("Conectados por minuto (Datos): " + numConectadosMinuto);
            out.write("Conectados por hora (Datos) : " + numConectadosHora);
            out.write("C/m :" + (sumMinutos/numConectadosMinuto.size()) );
            out.write("C/h :" + (sumHoras/numConectadosMinuto.size()) );
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
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

