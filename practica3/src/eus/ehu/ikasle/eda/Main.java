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
        conectados = g.estanConectados("0086k.com","007carteblanche.co.uk");
        System.out.println("Prueba1:");
        System.out.println("Web1: **0086k.com** ID1: 1\nWeb2: **007carteblanche.co.uk** ID2: 7");
        System.out.println("Respuesta teorica: false");
        System.out.println("Respuesta practica: "+conectados);
        conectados = g.estanConectados("012design.com","007-taxi.ru");
        System.out.println("Prueba2:");
        System.out.println("Web1: **012design.com** ID1: 2\nWeb2: **007-taxi.ru** ID2: 5");
        System.out.println("Respuesta teorica: false");
        System.out.println("Respuesta practica: "+conectados);
        //estan conectados
        conectados = g.estanConectados("0086k.com","012design.com");
        System.out.println("Prueba3:");
        System.out.println("Web1: **0086k.com** ID1: 1\nWeb2: **012design.com** ID2: 2");
        System.out.println("Respuesta teorica: true");
        System.out.println("Respuesta practica: "+conectados);
        conectados = g.estanConectados("0-3ani.ro","007hebergement.com");
        System.out.println("Prueba4:");
        System.out.println("Web1: **0-3ani.ro** ID1: 0\nWeb2: **007hebergement.com** ID2: 6");
        System.out.println("Respuesta teorica: true");
        System.out.println("Respuesta practica: "+conectados);
    }

    private static void pruebaBackPointer(Graph g){
        System.out.println("----------------------------Prueba backPointer()----------------------------");
        ArrayList<Integer> camino = new ArrayList<>();
        System.out.println("Prueba1:");
        System.out.println("Web1: **0086k.com** ID1: 1\nWeb2: **007carteblanche.co.uk** ID2: 7");
        System.out.println("El camino deberia ser: []");
        g.backPointer("0086k.com","007carteblanche.co.uk");
        System.out.println("Prueba2:");
        System.out.println("Web1: **012design.com** ID1: 2\nWeb2: **007-taxi.ru** ID2: 5");
        System.out.println("El camino deberia ser: []");
        g.backPointer("012design.com","007-taxi.ru");
        //estan conectados
        System.out.println("Prueba3:");
        System.out.println("Web1: **0086k.com** ID1: 1\nWeb2: **012design.com** ID2: 2");
        System.out.println("Respuesta teorica: true");
        g.backPointer("0086k.com","012design.com");
        System.out.println("Prueba4:");
        System.out.println("Web1: **0-3ani.ro** ID1: 0\nWeb2: **007hebergement.com** ID2: 6");
        System.out.println("Respuesta teorica: true");
        g.backPointer("0-3ani.ro","007hebergement.com");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
    }
}

