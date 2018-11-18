package eus.ehu.ikasle.eda;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Graph g = new Graph();
        carga(g);
        int opcion = 0;
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
        }
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
        conectados = g.estanConectados("0086k.com","007carteblanche.co.uk");
        System.out.println("Esta conectado\n la web **0086k.com** cuyo id es 1 a \nla web **007carteblanche.co.uk** cuyo id es 7?" +
                "la respuesta deberia ser False y es: "+conectados);
        conectados = g.estanConectados("012design.com","007-taxi.ru");
        System.out.println("Esta conectado\n la web **012design.com** cuyo id es 2 a \nla web **007-taxi.ru** cuyo id es 5?" +
                "la respuesta deberia ser False y es: "+conectados);
        conectados = g.estanConectados()
    }

    private static void pruebaBackPointer(Graph g){

    }
}
