package eus.ehu.ikasle.eda;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Graph g = new Graph();
        carga(g);
        pruebaEstanConectados(g);
        pruebaBackPointer(g);
        /*int opcion = 0;
        while(opcion != 3) {
            opcion = menu();
            switch (opcion) {
                case 1:
                    pruebaEstanConectados(g);
                    break;
                case 2:
                    pruebaBackPointer(g);
                    break;
            }
        }*/
    }

    private static void carga(Graph g){
        System.out.println("Cargando...");
        Stopwatch sw = new Stopwatch();
        g.crearGrafo(Fichero.getInstance().cargarWebs());
        System.out.println("Tiempo de carga: "+sw.elapsedTime()+"s");
    }

    private static int menu(){
        System.out.println("\t\t----------Menu----------");
        System.out.println("1.Prueba estanConcectados()");
        System.out.println("2.Prueba backPointer() ");
        System.out.println("3.Salir ");
        System.out.println("Introduce una opcion: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static void pruebaEstanConectados(Graph g){
        //No estan conectados
        boolean conectados;
        System.out.println("----------------------------Prueba estanConectados()----------------------------");
        conectados = g.estanConectados("1","7");
        System.out.println("Prueba1:");
        System.out.println("Web1: **1** ID1: 1\nWeb2: **7** ID2: 7");
        System.out.println("Respuesta teorica: false");
        System.out.println("Respuesta practica: "+conectados);
        conectados = g.estanConectados("2","5");
        System.out.println("Prueba2:");
        System.out.println("Web1: **2** ID1: 2\nWeb2: **5** ID2: 5");
        System.out.println("Respuesta teorica: false");
        System.out.println("Respuesta practica: "+conectados);
        //estan conectados
        conectados = g.estanConectados("1","2");
        System.out.println("Prueba3:");
        System.out.println("Web1: **1** ID1: 1\nWeb2: **2** ID2: 2");
        System.out.println("Respuesta teorica: true");
        System.out.println("Respuesta practica: "+conectados);
        conectados = g.estanConectados("0","6");
        System.out.println("Prueba4:");
        System.out.println("Web1: **0** ID1: 0\nWeb2: **6** ID2: 6");
        System.out.println("Respuesta teorica: true");
        System.out.println("Respuesta practica: "+conectados);
    }

    private static void pruebaBackPointer(Graph g){
        System.out.println("----------------------------Prueba backPointer()----------------------------");
         System.out.println("Prueba1:");
        System.out.println("Web1: **1** ID1: 1\nWeb2: **7** ID2: 7");
        System.out.println("El camino deberia ser: []");
        g.backPointer("1","7");
        System.out.println("Prueba2:");
        System.out.println("Web1: **2** ID1: 2\nWeb2: **5** ID2: 5");
        System.out.println("El camino deberia ser: []");
        g.backPointer("2","5");
        //estan conectados
        System.out.println("Prueba3:");
        System.out.println("Web1: **1** ID1: 1\nWeb2: **2** ID2: 2");
        System.out.println("El camino deberia ser: [1,2]");
        g.backPointer("1","2");
        System.out.println("Prueba4:");
        System.out.println("Web1: **0** ID1: 0\nWeb2: **6** ID2: 6");
        System.out.println("El camino es: [0,3,4,6]");
        g.backPointer("0","6");
    }
}

