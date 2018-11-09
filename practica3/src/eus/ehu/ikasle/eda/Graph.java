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
        th = new HashMap<>();
        keys = new String[lista.size()];
        int count = 0;
        for (String web: lista) {
            th.put(web,count++);
        }
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
        int act = 0;
        int i = 0;
        int relacion = 0;
        boolean[] examinados = new boolean[th.size()];
        porExaminar.add(pos1);
        examinados[i] = true;
        while (!enc && !porExaminar.isEmpty()) {
            act = porExaminar.removeFirst();
            if (act == pos2) {
                enc = true;
            }else {
                    for (int k = 0; k < adjList[act].size(); k++) {
                        relacion = adjList[act].get(k);
                        if (!examinados[relacion]) {
                            porExaminar.add(relacion);
                            examinados[relacion] = true;
                        }
                    }
            }
        }
        return enc;
    }
}

