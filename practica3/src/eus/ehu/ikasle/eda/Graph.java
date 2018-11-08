package eus.ehu.ikasle.eda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
    HashMap<String, Integer> th;
    String[] keys;
    ArrayList<Integer>[] adjList;

    public void crearGrafo(ListaWebs lista){
        // Post: crea el grafo desde la lista de webs
        //       Los nodos son nombres de webs


        // Paso 1: llenar “th”
        // COMPLETAR CÓDIGO

        // Paso 2: llenar “keys”
        keys = new String[th.size()];
        for (String k: th.keySet()) keys[th.get(k)] = k;

        // Paso 3: llenar “adjList”
        // COMPLETAR CÓDIGO
    }

    public void print(){
        for (int i = 0; i < adjList.length; i++){
            System.out.print("Element: " + i + " " + keys[i] + " --> ");
            for (int k: adjList[i])  System.out.print(keys[k] + " ### ");

            System.out.println();
        }
    }

    public boolean estanConectados(String a1, String a2){
        LinkedList<Integer> porExaminar = new LinkedList<Integer>();
        int pos1 = th.get(a1);
        int pos2 = th.get(a2);
        boolean enc = false;
        int act, i, relacion, k = 0;
        boolean[] examinados = new boolean[th.size()];
        porExaminar.add(pos1);
        examinados[i] = true;
        while (!enc && !porExaminar.isEmpty()) {
            act = porExaminar.removeFirst();
            if (act == pos2) {
                enc = true;
            }
            else {
                for (int j = 0; j < adjList.length; i++){
                    while () { // No se como ponerlo para que pare cuando no haya más enlaces que mirar de la web en la que estamos
                        relacion = adjList[j].get(k);
                        if (examinados[relacion] == false) {
                            porExaminar.add(relacion);
                            examinados[relacion] = true;
                        }
                    }
                }
            }
        }


        return enc;
    }
    }
}

}
